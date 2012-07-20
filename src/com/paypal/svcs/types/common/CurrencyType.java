package com.paypal.svcs.types.common;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * No Document Comments
 */
public class CurrencyType{


	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String code;

	/**
	 * No Document Comments	  
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
		if (code != null) {
			sb.append(prefix).append("code=").append(NVPUtil.encodeUrl(code));
			sb.append("&");
		}
		if (amount != null) {
			sb.append(prefix).append("amount=").append(amount);
			sb.append("&");
		}
		return sb.toString();
	}
	public CurrencyType(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "code")){
			this.code = map.get(prefix + "code");
		}
		if(map.containsKey(prefix + "amount")){
			this.amount = Double.valueOf(map.get(prefix + "amount"));
		}
	}

}