package com.paypal.core;

public final class ConnectionManager {

	private static ConnectionManager instance;

	private ConnectionManager() {

	}

	public static ConnectionManager getInstance() {
		if (instance == null) {
			synchronized (ConnectionManager.class) {
				instance = new ConnectionManager();
			}
		}
		return instance;
	}

	/**
	 * @return HttpConnection object
	 */
	public HttpConnection getConnection() {
		return new DefaultHttpConnection();
	}

	public HttpConnection getConnection(HttpConfiguration httpConfig) {

		if (httpConfig.isGoogleAppEngine()) {
			return new GoogleAppEngineHttpConnection();
		} else {
			return new DefaultHttpConnection();
		}
	}
}
