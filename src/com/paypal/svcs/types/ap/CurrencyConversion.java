package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.CurrencyType;
import java.util.Map;

/**
 * Describes the conversion between 2 currencies. 
 */
public class CurrencyConversion{


	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private CurrencyType from;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private CurrencyType to;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private Double exchangeRate;

	

	/**
	 * Default Constructor
	 */
	public CurrencyConversion (){
	}	

	/**
	 * Getter for from
	 */
	 public CurrencyType getFrom() {
	 	return from;
	 }
	 
	/**
	 * Setter for from
	 */
	 public void setFrom(CurrencyType from) {
	 	this.from = from;
	 }
	 
	/**
	 * Getter for to
	 */
	 public CurrencyType getTo() {
	 	return to;
	 }
	 
	/**
	 * Setter for to
	 */
	 public void setTo(CurrencyType to) {
	 	this.to = to;
	 }
	 
	/**
	 * Getter for exchangeRate
	 */
	 public Double getExchangeRate() {
	 	return exchangeRate;
	 }
	 
	/**
	 * Setter for exchangeRate
	 */
	 public void setExchangeRate(Double exchangeRate) {
	 	this.exchangeRate = exchangeRate;
	 }
	 


	public CurrencyConversion(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "from" + ".code")){
			String newPrefix = prefix + "from" + ".";
			this.from =  new CurrencyType(map, newPrefix);
		}
		if(map.containsKey(prefix + "to" + ".code")){
			String newPrefix = prefix + "to" + ".";
			this.to =  new CurrencyType(map, newPrefix);
		}
		if(map.containsKey(prefix + "exchangeRate")){
			this.exchangeRate = Double.valueOf(map.get(prefix + "exchangeRate"));
		}
	}

}