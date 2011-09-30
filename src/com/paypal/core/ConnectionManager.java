package com.paypal.core;

public class ConnectionManager {

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
		HttpConnection httpConnection = new HttpConnection();
		return httpConnection;
	}
}
