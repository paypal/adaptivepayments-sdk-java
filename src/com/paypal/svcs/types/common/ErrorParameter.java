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
	 


	public ErrorParameter(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + ".name")){
			this.name = map.get(prefix + ".name");
		}
		if(map.containsKey(prefix)){
			this.value = map.get(prefix);
		}
	}

}