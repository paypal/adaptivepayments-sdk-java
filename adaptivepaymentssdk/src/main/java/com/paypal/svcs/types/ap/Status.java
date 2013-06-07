package com.paypal.svcs.types.ap;

/**
 * 
 */
public enum  Status {

	RTR("RTR"),

	NONRTR("NON_RTR"),

	MISSINGRECEIVERCOUNTRYINFORMATION("MISSING_RECEIVER_COUNTRY_INFORMATION");

	private String value;

	private Status (String value) {
		this.value = value;
	}

	public String getValue(){
		return value;
	}
	
	public static Status fromValue(String v) {
		for (Status c : values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}