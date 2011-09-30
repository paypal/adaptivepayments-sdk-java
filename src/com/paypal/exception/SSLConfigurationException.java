package com.paypal.exception;

public class SSLConfigurationException extends BaseException{
	private static final long serialVersionUID = -2345834567387658303L;

	public SSLConfigurationException(String message) {
		super(message);
	}

	public SSLConfigurationException(String message, Throwable exception) {
		super(message, exception);
	}
}
