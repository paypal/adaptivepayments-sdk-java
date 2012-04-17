/**
 * Auto generated code
 * DetailLevelCodeType
 */
package com.paypal.svcs.types.common;

public enum DetailLevelCode {

 		RETURNALL("ReturnAll"),
		;
		private String value;
		DetailLevelCode(String val){
			value=val;
		}		public String getValue(){
			return value;
		}
		public static DetailLevelCode fromValue(String v) {
			for (DetailLevelCode c : values())
				if (c.value.equals(v))
					return c;
			throw new IllegalArgumentException(v);
		}
}
