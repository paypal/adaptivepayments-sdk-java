package com.paypal.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.SSLConfigurationException;

/**
 * Wrapper class used for HttpsURLConnection
 * 
 * 
 */
public class HttpConnection {
	private SSLContext sslContext;
	private HttpConfiguration config;
	private HttpsURLConnection connection;
	private boolean DefaultSSL = true;

	/**
	 * Executes HTTP request
	 * 
	 * @param url
	 * @param payload
	 * @param headers
	 * @return String response
	 * @throws InvalidResponseDataException
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws HttpErrorException
	 * @throws ClientActionRequiredException
	 */
	public final String execute(String url, String payload,
			Map<String, String> headers) throws InvalidResponseDataException,
			IOException, InterruptedException, HttpErrorException,
			ClientActionRequiredException {
		String successResponse = Constants.EMPTY_STRING;
		String errorResponse = Constants.EMPTY_STRING;
		BufferedReader reader = null;
		OutputStreamWriter writer = null;
		connection.setRequestProperty("Content-Length", "" + payload.length());
		if(headers != null){
			setHttpHeaders(this.connection, headers);
		}
		try {
			for (int retry = 0; retry < this.config.getMaxRetry(); retry++) {

				if (retry > 0) {
					LoggingManager.debug(HttpConnection.class, " Retry  No : "
							+ retry + "...");
					try {
						Thread.sleep(this.config.getRetryDelay());
					} catch (InterruptedException ie) {
						throw ie;
					}
				}

				try {
					writer = new OutputStreamWriter(
							this.connection.getOutputStream());
					writer.write(payload.toString());
					writer.flush();
					writer.close();
					int responsecode = connection.getResponseCode();
					reader = new BufferedReader(new InputStreamReader(
							connection.getInputStream(),
							Constants.ENCODING_FORMAT));
					if (responsecode == 200) {
						successResponse = read(reader);
						reader.close();
						LoggingManager.debug(HttpConnection.class,
								"Response : " + successResponse);
						if (successResponse.length() <= 0) {
							throw new InvalidResponseDataException(
									successResponse);
						}
						break;
					} else {
						successResponse = read(reader);
						reader.close();
						throw new ClientActionRequiredException(
								"Response Code : " + responsecode
										+ " with response : " + successResponse);
					}

				} catch (IOException e) {
					try {
						int responsecode = connection.getResponseCode();
						if (connection.getErrorStream() != null) {
							reader = new BufferedReader(new InputStreamReader(
									connection.getErrorStream(),
									Constants.ENCODING_FORMAT));
							errorResponse = read(reader);
							reader.close();
							LoggingManager.severe(HttpConnection.class,
									"Error code : " + responsecode
											+ " with response : "
											+ errorResponse);
						}
						if (responsecode < 500) {
							throw new HttpErrorException("Error code : "
									+ responsecode + " with response : "
									+ errorResponse);
						}
					} catch (IOException io) {
						throw io;
					}
				}
			}

			if (successResponse.length() <= 0) {
				throw new HttpErrorException(
						"retry fails..  check log for more information");
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
		return successResponse;
	}

	private String read(BufferedReader reader) throws IOException {
		String inputLine = Constants.EMPTY_STRING;
		StringBuilder response = new StringBuilder();
		while ((inputLine = reader.readLine()) != null) {
			response.append(inputLine);
		}
		return response.toString();
	}

	/**
	 * Set headers for HttpsURLConnection object
	 * 
	 * @param conn
	 * @param headers
	 */
	private void setHttpHeaders(HttpsURLConnection conn,
			Map<String, String> headers) {
		Iterator<Map.Entry<String, String>> itr = headers.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, String> pairs = itr.next();
			String key = pairs.getKey();
			String value = pairs.getValue();
			conn.addRequestProperty(key, value);
		}
	}

	/**
	 * Set ssl parameters for client authentication
	 * 
	 * @param certPath
	 * @param certKey
	 * @param trustAll
	 * @throws SSLConfigurationException
	 */
	public void setupClientSSL(String certPath, String certKey, boolean trustAll)
			throws SSLConfigurationException {
		try {
			if (isDefaultSSL()) {
				this.sslContext = SSLUtil.getDefaultSSLContext(trustAll);
			} else {
				this.sslContext = SSLUtil.setupClientSSL(certPath, certKey,
						trustAll);
			}
		} catch (Exception e) {
			throw new SSLConfigurationException(e.getMessage(), e);
		}
	}

	/**
	 * Create and configure HttpsURLConnection object
	 * 
	 * @param clientConfiguration
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void CreateAndconfigureHttpConnection(
			HttpConfiguration clientConfiguration)
			throws MalformedURLException, UnknownHostException, IOException {
		this.config = clientConfiguration;
		try {

			URL url = new URL(this.config.getEndPointUrl());

			Proxy proxy = null;
			String proxyHost = this.config.getProxyHost();
			int proxyPort = this.config.getProxyPort();
			if ((proxyHost != null) && (proxyPort > 0)) {
				SocketAddress addr = new InetSocketAddress(proxyHost, proxyPort);
				proxy = new Proxy(Proxy.Type.HTTP, addr);
			}
			if (proxy != null) {
				this.connection = (HttpsURLConnection) url
						.openConnection(proxy);
			} else {
				this.connection = (HttpsURLConnection) url
						.openConnection(Proxy.NO_PROXY);
			}

			this.connection.setSSLSocketFactory(this.sslContext
					.getSocketFactory());
			if (isDefaultSSL()) {
				this.connection.setHostnameVerifier(hv);
			}

			if (this.config.getProxyUserName() != null
					&& this.config.getProxyPassword() != null) {
				final String username = this.config.getProxyUserName();
				final String password = this.config.getProxyPassword();
				Authenticator authenticator = new Authenticator() {
					public PasswordAuthentication getPasswordAuthentication() {
						return (new PasswordAuthentication(username,
								password.toCharArray()));
					}
				};
				Authenticator.setDefault(authenticator);
			}

			System.setProperty("http.maxConnections",
					String.valueOf(this.config.getMaxHttpConnection()));
			System.setProperty("sun.net.http.errorstream.enableBuffering",
					"true");

			this.connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			this.connection.setDoInput(true);
			this.connection.setDoOutput(true);
			this.connection.setRequestMethod("POST");
			this.connection.setConnectTimeout(this.config
					.getConnectionTimeout());
			this.connection.setReadTimeout(this.config.getReadTimeout());

		} catch (MalformedURLException me) {
			throw me;
		} catch (UnknownHostException uhe) {
			throw uhe;
		} catch (IOException ioe) {
			throw ioe;
		}
	}

	/**
	 * Class used to relax host name verification.
	 */
	private HostnameVerifier hv = new HostnameVerifier() {
		public boolean verify(String urlHostname, SSLSession session) {
			return true;
		}
	};

	public boolean isDefaultSSL() {
		return DefaultSSL;
	}

	public void setDefaultSSL(boolean defaultSSL) {
		DefaultSSL = defaultSSL;
	}

}