/**
 * Auto generated code
 */
package com.paypal.svcs.types.common;

public enum DayOfWeek {

 		NODAYSPECIFIED("NO_DAY_SPECIFIED"),
 		SUNDAY("SUNDAY"),
 		MONDAY("MONDAY"),
 		TUESDAY("TUESDAY"),
 		WEDNESDAY("WEDNESDAY"),
 		THURSDAY("THURSDAY"),
 		FRIDAY("FRIDAY"),
 		SATURDAY("SATURDAY"),
		;
		private String value;
		DayOfWeek(String val){
			value=val;
		}		public String getValue(){
			return value;
		}
		public static DayOfWeek fromValue(String v) {
			for (DayOfWeek c : values())
				if (c.value.equals(v))
					return c;
			throw new IllegalArgumentException(v);
		}
}
