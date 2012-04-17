/**
 * Auto generated code
 */
package com.paypal.svcs.types.common;

public enum ErrorSeverity {

 		ERROR("Error"),
 		WARNING("Warning"),
		;
		private String value;
		ErrorSeverity(String val){
			value=val;
		}		public String getValue(){
			return value;
		}
		public static ErrorSeverity fromValue(String v) {
			for (ErrorSeverity c : values())
				if (c.value.equals(v))
					return c;
			throw new IllegalArgumentException(v);
		}
}
