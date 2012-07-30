package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.CurrencyType;
import com.paypal.svcs.types.ap.CurrencyList;
import java.util.Map;

/**
 * A list of estimated currency conversions for a base
 * currency. 
 */
public class CurrencyConversionList{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private CurrencyType baseAmount;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private CurrencyList currencyList;

	

	/**
	 * Default Constructor
	 */
	public CurrencyConversionList (){
	}	

	/**
	 * Getter for baseAmount
	 */
	 public CurrencyType getBaseAmount() {
	 	return baseAmount;
	 }
	 
	/**
	 * Setter for baseAmount
	 */
	 public void setBaseAmount(CurrencyType baseAmount) {
	 	this.baseAmount = baseAmount;
	 }
	 
	/**
	 * Getter for currencyList
	 */
	 public CurrencyList getCurrencyList() {
	 	return currencyList;
	 }
	 
	/**
	 * Setter for currencyList
	 */
	 public void setCurrencyList(CurrencyList currencyList) {
	 	this.currencyList = currencyList;
	 }
	 


	public CurrencyConversionList(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "baseAmount" + ".code")){
			String newPrefix = prefix + "baseAmount" + ".";
			this.baseAmount =  new CurrencyType(map, newPrefix);
		}
		if(map.containsKey(prefix + "currencyList" + ".currency(0).code")){
			String newPrefix = prefix + "currencyList" + ".";
			this.currencyList =  new CurrencyList(map, newPrefix);
		}
	}

}