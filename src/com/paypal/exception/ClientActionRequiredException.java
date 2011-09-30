package com.paypal.exception;

public class ClientActionRequiredException extends BaseException{
	private static final long serialVersionUID = -15345584654755445L;

	public ClientActionRequiredException(String message) {
		super(message);
	}

	public ClientActionRequiredException(String message, Throwable exception) {
		super(message, exception);
	}
}
