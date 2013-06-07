package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.CurrencyType;
import java.util.Map;

/**
 * Describes the conversion between 2 currencies. 
 */
public class CurrencyConversion{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private CurrencyType from;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private CurrencyType to;

	/**
	 * 	  
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
	 


	
	public static CurrencyConversion createInstance(Map<String, String> map, String prefix, int index) {
		CurrencyConversion currencyConversion = null;
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
			
		CurrencyType from =  CurrencyType.createInstance(map, prefix + "from", -1);
		if (from != null) {
			currencyConversion = (currencyConversion == null) ? new CurrencyConversion() : currencyConversion;
			currencyConversion.setFrom(from);
		}
		CurrencyType to =  CurrencyType.createInstance(map, prefix + "to", -1);
		if (to != null) {
			currencyConversion = (currencyConversion == null) ? new CurrencyConversion() : currencyConversion;
			currencyConversion.setTo(to);
		}
		if (map.containsKey(prefix + "exchangeRate")) {
				currencyConversion = (currencyConversion == null) ? new CurrencyConversion() : currencyConversion;
				currencyConversion.setExchangeRate(Double.valueOf(map.get(prefix + "exchangeRate")));
		}
		return currencyConversion;
	}
 
}