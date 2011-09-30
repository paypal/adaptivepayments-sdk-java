package com.paypal.exception;

public class InvalidResponseDataException extends BaseException{
   private static final long serialVersionUID = -7489562847530985773L;
	
	public InvalidResponseDataException(String msg){
		super(msg);
	}
	
	public InvalidResponseDataException(String msg,Throwable exception){
		super(msg, exception);
	}
    
}
