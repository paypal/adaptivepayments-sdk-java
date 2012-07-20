package com.paypal.svcs.types.common;
import java.util.Map;

/**
 * No Document Comments
 */
public class BaseAddress{


	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String line1;

	/**
	 * No Document Comments	 
	 */ 
	private String line2;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String city;

	/**
	 * No Document Comments	 
	 */ 
	private String state;

	/**
	 * No Document Comments	 
	 */ 
	private String postalCode;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String countryCode;

	/**
	 * No Document Comments	 
	 */ 
	private String type;

	

	/**
	 * Default Constructor
	 */
	public BaseAddress (){
	}	

	/**
	 * Getter for line1
	 */
	 public String getLine1() {
	 	return line1;
	 }
	 
	/**
	 * Setter for line1
	 */
	 public void setLine1(String line1) {
	 	this.line1 = line1;
	 }
	 
	/**
	 * Getter for line2
	 */
	 public String getLine2() {
	 	return line2;
	 }
	 
	/**
	 * Setter for line2
	 */
	 public void setLine2(String line2) {
	 	this.line2 = line2;
	 }
	 
	/**
	 * Getter for city
	 */
	 public String getCity() {
	 	return city;
	 }
	 
	/**
	 * Setter for city
	 */
	 public void setCity(String city) {
	 	this.city = city;
	 }
	 
	/**
	 * Getter for state
	 */
	 public String getState() {
	 	return state;
	 }
	 
	/**
	 * Setter for state
	 */
	 public void setState(String state) {
	 	this.state = state;
	 }
	 
	/**
	 * Getter for postalCode
	 */
	 public String getPostalCode() {
	 	return postalCode;
	 }
	 
	/**
	 * Setter for postalCode
	 */
	 public void setPostalCode(String postalCode) {
	 	this.postalCode = postalCode;
	 }
	 
	/**
	 * Getter for countryCode
	 */
	 public String getCountryCode() {
	 	return countryCode;
	 }
	 
	/**
	 * Setter for countryCode
	 */
	 public void setCountryCode(String countryCode) {
	 	this.countryCode = countryCode;
	 }
	 
	/**
	 * Getter for type
	 */
	 public String getType() {
	 	return type;
	 }
	 
	/**
	 * Setter for type
	 */
	 public void setType(String type) {
	 	this.type = type;
	 }
	 


	public BaseAddress(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "line1")){
			this.line1 = map.get(prefix + "line1");
		}
		if(map.containsKey(prefix + "line2")){
			this.line2 = map.get(prefix + "line2");
		}
		if(map.containsKey(prefix + "city")){
			this.city = map.get(prefix + "city");
		}
		if(map.containsKey(prefix + "state")){
			this.state = map.get(prefix + "state");
		}
		if(map.containsKey(prefix + "postalCode")){
			this.postalCode = map.get(prefix + "postalCode");
		}
		if(map.containsKey(prefix + "countryCode")){
			this.countryCode = map.get(prefix + "countryCode");
		}
		if(map.containsKey(prefix + "type")){
			this.type = map.get(prefix + "type");
		}
	}

}