package com.paypal.exception;

public class HttpErrorException extends BaseException{

private static final long serialVersionUID = -4312358746964758546L;
	
	public HttpErrorException(String msg){
		super(msg);
	}
	
	public HttpErrorException(String msg,Throwable exception){
		super(msg, exception);
	}
}
