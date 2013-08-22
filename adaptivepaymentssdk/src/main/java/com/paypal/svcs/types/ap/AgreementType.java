package com.paypal.svcs.types.ap;

/**
 * 
 */
public enum  AgreementType {

	OFFLINE("OFFLINE"),

	ONLINE("ONLINE");

	private String value;

	private AgreementType (String value) {
		this.value = value;
	}

	public String getValue(){
		return value;
	}
	
	public static AgreementType fromValue(String v) {
		for (AgreementType c : values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}