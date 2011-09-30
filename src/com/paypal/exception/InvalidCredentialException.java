package com.paypal.exception;

public class InvalidCredentialException extends BaseException {
	
	private static final long serialVersionUID = -4321565982347658546L;
	
	public InvalidCredentialException(String msg){
		super(msg);
	}
	
	public InvalidCredentialException(String msg,Throwable exception){
		super(msg, exception);
	}
}
