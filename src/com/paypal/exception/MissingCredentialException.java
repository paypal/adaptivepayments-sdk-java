package com.paypal.exception;

public class MissingCredentialException extends BaseException {

	private static final long serialVersionUID = -2345825926387658303L;

	public MissingCredentialException(String message) {
		super(message);
	}

	public MissingCredentialException(String message, Throwable exception) {
		super(message, exception);
	}

}
