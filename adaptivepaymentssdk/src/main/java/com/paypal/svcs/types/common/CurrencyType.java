package com.paypal.svcs.types.common;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * 
 */
public class CurrencyType{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private String code;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private Double amount;

	

	/**
	 * Constructor with arguments
	 */
	public CurrencyType (String code, Double amount){
		this.code = code;
		this.amount = amount;
	}	

	/**
	 * Default Constructor
	 */
	public CurrencyType (){
	}	

	/**
	 * Getter for code
	 */
	 public String getCode() {
	 	return code;
	 }
	 
	/**
	 * Setter for code
	 */
	 public void setCode(String code) {
	 	this.code = code;
	 }
	 
	/**
	 * Getter for amount
	 */
	 public Double getAmount() {
	 	return amount;
	 }
	 
	/**
	 * Setter for amount
	 */
	 public void setAmount(Double amount) {
	 	this.amount = amount;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.code != null) {
			sb.append(prefix).append("code=").append(NVPUtil.encodeUrl(this.code));
			sb.append("&");
		}
		if (this.amount != null) {
			sb.append(prefix).append("amount=").append(this.amount);
			sb.append("&");
		}
		return sb.toString();
	}
	
	public static CurrencyType createInstance(Map<String, String> map, String prefix, int index) {
		CurrencyType currencyType = null;
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
			
		if (map.containsKey(prefix + "code")) {
				currencyType = (currencyType == null) ? new CurrencyType() : currencyType;
				currencyType.setCode(map.get(prefix + "code"));
		}
		if (map.containsKey(prefix + "amount")) {
				currencyType = (currencyType == null) ? new CurrencyType() : currencyType;
				currencyType.setAmount(Double.valueOf(map.get(prefix + "amount")));
		}
		return currencyType;
	}
 
}