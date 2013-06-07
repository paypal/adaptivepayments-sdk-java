package com.paypal.svcs.types.common;
import java.util.Map;

/**
 * 
 */
public class ErrorParameter{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private String name;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String value;

	

	/**
	 * Default Constructor
	 */
	public ErrorParameter (){
	}	

	/**
	 * Getter for name
	 */
	 public String getName() {
	 	return name;
	 }
	 
	/**
	 * Setter for name
	 */
	 public void setName(String name) {
	 	this.name = name;
	 }
	 
	/**
	 * Getter for value
	 */
	 public String getValue() {
	 	return value;
	 }
	 
	/**
	 * Setter for value
	 */
	 public void setValue(String value) {
	 	this.value = value;
	 }
	 


	
	public static ErrorParameter createInstance(Map<String, String> map, String prefix, int index) {
		ErrorParameter errorParameter = null;
		int i = 0;
		if (index != -1) {
				if (prefix != null && prefix.length() != 0 && !prefix.endsWith(".")) {
					prefix = prefix + "(" + index + ").";
				}
		} else {
			if (prefix != null && prefix.length() != 0 && !prefix.endsWith(".")) {
				prefix = prefix + ".";
			}
		}
			
		if (map.containsKey(prefix + "name")) {
				errorParameter = (errorParameter == null) ? new ErrorParameter() : errorParameter;
				errorParameter.setName(map.get(prefix + "name"));
		}
		if (map.containsKey(prefix.substring(0, prefix.length() - 1))) {
				errorParameter = (errorParameter == null) ? new ErrorParameter() : errorParameter;
				errorParameter.setValue(map.get(prefix.substring(0, prefix.length() - 1)));
		}
		return errorParameter;
	}
 
}