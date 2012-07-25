package com.paypal.core;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.net.UnknownHostException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

import com.paypal.exception.SSLConfigurationException;

/**
 * Wrapper class used for HttpsURLConnection
 * 
 * 
 */
public class DefaultHttpConnection extends HttpConnection {
	
	private SSLContext sslContext;

	@Override
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

	@Override
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

			((HttpsURLConnection)this.connection).setSSLSocketFactory(this.sslContext
					.getSocketFactory());
			if (isDefaultSSL()) {
				((HttpsURLConnection)this.connection).setHostnameVerifier(hv);
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

}