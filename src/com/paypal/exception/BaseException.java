package com.paypal.exception;

public class BaseException extends Exception {
	private static final long serialVersionUID = -5345825923487658213L;
	
	public BaseException(String msg){
		super(msg);
	}
	
	public BaseException(String msg,Throwable exception){
		super(msg,exception);
	}
	
}
