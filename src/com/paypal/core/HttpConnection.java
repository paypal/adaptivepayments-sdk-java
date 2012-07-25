package com.paypal.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;

import java.net.HttpURLConnection;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.SSLConfigurationException;

public abstract class HttpConnection {
	
	protected boolean defaultSSL = true;
	
	/**
	 * Subclasses must set the http configuration in the CreateAndconfigureHttpConnection() method.
	 */
	protected HttpConfiguration config;
	
	/**
	 * Subclasses must create and set the connection in the CreateAndconfigureHttpConnection() method.
	 */
	protected HttpURLConnection connection;

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
	public String execute(String url, String payload, Map<String, String> headers)
			throws InvalidResponseDataException, IOException,
			InterruptedException, HttpErrorException,
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

	/**
	 * Set ssl parameters for client authentication
	 * 
	 * @param certPath
	 * @param certKey
	 * @param trustAll
	 * @throws SSLConfigurationException
	 */
	public abstract void setupClientSSL(String certPath, String certKey, boolean trustAll)
			throws SSLConfigurationException;

	/**
	 * Create and configure HttpsURLConnection object
	 * 
	 * @param clientConfiguration
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public abstract void CreateAndconfigureHttpConnection(HttpConfiguration clientConfiguration)
			throws MalformedURLException, UnknownHostException, IOException;

	public boolean isDefaultSSL(){
		return defaultSSL;
	}

	public void setDefaultSSL(boolean defaultSSL){
		this.defaultSSL = defaultSSL;
	}
	
	protected String read(BufferedReader reader) throws IOException {
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
	protected void setHttpHeaders(HttpURLConnection conn,
			Map<String, String> headers) {
		Iterator<Map.Entry<String, String>> itr = headers.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, String> pairs = itr.next();
			String key = pairs.getKey();
			String value = pairs.getValue();
			conn.addRequestProperty(key, value);
		}
	}

}