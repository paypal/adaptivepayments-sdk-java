package com.paypal.svcs.types.common;

/**
 * AckCodeType This code identifies the
 *  acknowledgment code types that could be used to
 *  communicate the status of processing a (request)
 *  message to an application. This code would be
 *  used as part of a response message that contains
 *  an application level acknowledgment element.
 *  
 */
public enum  AckCode {

	SUCCESS("Success"),

	FAILURE("Failure"),

	WARNING("Warning"),

	SUCCESSWITHWARNING("SuccessWithWarning"),

	FAILUREWITHWARNING("FailureWithWarning");

	private String value;

	private AckCode (String value) {
		this.value = value;
	}

	public String getValue(){
		return value;
	}
	
	public static AckCode fromValue(String v) {
		for (AckCode c : values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}