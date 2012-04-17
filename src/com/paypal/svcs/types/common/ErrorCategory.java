/**
 * Auto generated code
 */
package com.paypal.svcs.types.common;

public enum ErrorCategory {

 		SYSTEM("System"),
 		APPLICATION("Application"),
 		REQUEST("Request"),
		;
		private String value;
		ErrorCategory(String val){
			value=val;
		}		public String getValue(){
			return value;
		}
		public static ErrorCategory fromValue(String v) {
			for (ErrorCategory c : values())
				if (c.value.equals(v))
					return c;
			throw new IllegalArgumentException(v);
		}
}
