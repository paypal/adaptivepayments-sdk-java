package com.paypal.svcs.types.ap;
import java.util.Map;

/**
 * This holds the conversion rate from "Sender currency for one
 * bucks to equivalent value in the receivers currency" 
 */
public class ConversionRate{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private String senderCurrency;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String receiverCurrency;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private Double exchangeRate;

	

	/**
	 * Default Constructor
	 */
	public ConversionRate (){
	}	

	/**
	 * Getter for senderCurrency
	 */
	 public String getSenderCurrency() {
	 	return senderCurrency;
	 }
	 
	/**
	 * Setter for senderCurrency
	 */
	 public void setSenderCurrency(String senderCurrency) {
	 	this.senderCurrency = senderCurrency;
	 }
	 
	/**
	 * Getter for receiverCurrency
	 */
	 public String getReceiverCurrency() {
	 	return receiverCurrency;
	 }
	 
	/**
	 * Setter for receiverCurrency
	 */
	 public void setReceiverCurrency(String receiverCurrency) {
	 	this.receiverCurrency = receiverCurrency;
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
	 


	
	public static ConversionRate createInstance(Map<String, String> map, String prefix, int index) {
		ConversionRate conversionRate = null;
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
			
		if (map.containsKey(prefix + "senderCurrency")) {
				conversionRate = (conversionRate == null) ? new ConversionRate() : conversionRate;
				conversionRate.setSenderCurrency(map.get(prefix + "senderCurrency"));
		}
		if (map.containsKey(prefix + "receiverCurrency")) {
				conversionRate = (conversionRate == null) ? new ConversionRate() : conversionRate;
				conversionRate.setReceiverCurrency(map.get(prefix + "receiverCurrency"));
		}
		if (map.containsKey(prefix + "exchangeRate")) {
				conversionRate = (conversionRate == null) ? new ConversionRate() : conversionRate;
				conversionRate.setExchangeRate(Double.valueOf(map.get(prefix + "exchangeRate")));
		}
		return conversionRate;
	}
 
}