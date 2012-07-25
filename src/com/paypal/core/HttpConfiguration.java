package com.paypal.core;

/**
 * 
 * Class contains http specific configuration parameters
 * 
 */

public class HttpConfiguration {

	private int maxRetry;
	private boolean proxySet;
	private String proxyHost;
	private int proxyPort;
	private String proxyUserName;
	private String proxyPassword;
	private int readTimeout;
	private int connectionTimeout;
	private int maxHttpConnection;
	private String endPointUrl;
	private boolean googleAppEngine;

	private boolean trustAll;
	private int retryDelay;
	private String ipAddress;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public HttpConfiguration() {

		this.maxRetry = 2;

		this.proxySet = false;

		this.proxyHost = null;

		this.proxyPort = -1;

		this.proxyUserName = null;

		this.proxyPassword = null;

		this.readTimeout = 0;

		this.connectionTimeout = 0;

		this.maxHttpConnection = 10;

		this.endPointUrl = null;

		this.trustAll = true;

		this.retryDelay = 1000;
		this.ipAddress = "127.0.0.1";
	}

	public String getProxyUserName() {
		return proxyUserName;
	}

	public void setProxyUserName(String proxyUserName) {
		this.proxyUserName = proxyUserName;
	}

	public String getProxyPassword() {
		return proxyPassword;
	}

	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword;
	}

	public int getMaxHttpConnection() {
		return maxHttpConnection;
	}

	public void setMaxHttpConnection(int maxHttpConnection) {
		this.maxHttpConnection = maxHttpConnection;
	}

	public int getRetryDelay() {
		return retryDelay;
	}

	public void setRetryDelay(int retryDelay) {
		this.retryDelay = retryDelay;
	}

	public boolean isTrustAll() {
		return trustAll;
	}

	public void setTrustAll(boolean trustAll) {
		this.trustAll = trustAll;
	}

	public String getEndPointUrl() {
		return endPointUrl;
	}

	public void setEndPointUrl(String endPointUrl) {
		this.endPointUrl = endPointUrl;
	}

	public int getMaxRetry() {
		return maxRetry;
	}

	public void setMaxRetry(int maxRetry) {
		this.maxRetry = maxRetry;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public int getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	public int getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public boolean isProxySet() {
		return proxySet;
	}

	public void setProxySet(boolean proxySet) {
		this.proxySet = proxySet;
	}
	
	public boolean isGoogleAppEngine() {
		return googleAppEngine;
	}
	
	public void setGoogleAppEngine(boolean googleAppEngine) {
		this.googleAppEngine = googleAppEngine;
	}

}
