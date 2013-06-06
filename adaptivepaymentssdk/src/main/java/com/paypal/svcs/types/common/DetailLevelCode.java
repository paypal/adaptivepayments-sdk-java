package com.paypal.svcs.types.common;

/**
 * DetailLevelCodeType
 *  
 */
public enum  DetailLevelCode {

	RETURNALL("ReturnAll");

	private String value;

	private DetailLevelCode (String value) {
		this.value = value;
	}

	public String getValue(){
		return value;
	}
	
	public static DetailLevelCode fromValue(String v) {
		for (DetailLevelCode c : values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}