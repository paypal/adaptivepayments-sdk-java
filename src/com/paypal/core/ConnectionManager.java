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
		HttpConnection httpConnection = new DefaultHttpConnection();
		return httpConnection;
	}
	
	public HttpConnection getConnection(HttpConfiguration httpConfig){
		
		if( httpConfig.isGoogleAppEngine() )
			return new GoogleAppEngineHttpConnection();
		else
			return new DefaultHttpConnection();
	}
}
