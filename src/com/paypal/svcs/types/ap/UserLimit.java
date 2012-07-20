package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.CurrencyType;
import java.util.Map;

/**
 * No Document Comments
 */
public class UserLimit{


	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String limitType;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private CurrencyType limitAmount;

	

	/**
	 * Default Constructor
	 */
	public UserLimit (){
	}	

	/**
	 * Getter for limitType
	 */
	 public String getLimitType() {
	 	return limitType;
	 }
	 
	/**
	 * Setter for limitType
	 */
	 public void setLimitType(String limitType) {
	 	this.limitType = limitType;
	 }
	 
	/**
	 * Getter for limitAmount
	 */
	 public CurrencyType getLimitAmount() {
	 	return limitAmount;
	 }
	 
	/**
	 * Setter for limitAmount
	 */
	 public void setLimitAmount(CurrencyType limitAmount) {
	 	this.limitAmount = limitAmount;
	 }
	 


	public UserLimit(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "limitType")){
			this.limitType = map.get(prefix + "limitType");
		}
		if(map.containsKey(prefix + "limitAmount" + ".code")){
			String newPrefix = prefix + "limitAmount" + ".";
			this.limitAmount =  new CurrencyType(map, newPrefix);
		}
	}

}