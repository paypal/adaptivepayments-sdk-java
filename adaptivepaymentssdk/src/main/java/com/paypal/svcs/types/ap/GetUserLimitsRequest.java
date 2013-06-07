package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.paypal.svcs.types.common.AccountIdentifier;
import java.util.List;
import java.util.ArrayList;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * The request to get the remaining limits for a user 
 */
public class GetUserLimitsRequest{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private RequestEnvelope requestEnvelope;

	/**
	 * The account identifier for the user 	  
	 *@Required	 
	 */ 
	private AccountIdentifier user;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String country;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String currencyCode;

	/**
	 * List of limit types 	  
	 *@Required	 
	 */ 
	private List<String> limitType = new ArrayList<String>();

	

	/**
	 * Constructor with arguments
	 */
	public GetUserLimitsRequest (RequestEnvelope requestEnvelope, AccountIdentifier user, String country, String currencyCode, List<String> limitType){
		this.requestEnvelope = requestEnvelope;
		this.user = user;
		this.country = country;
		this.currencyCode = currencyCode;
		this.limitType = limitType;
	}	

	/**
	 * Default Constructor
	 */
	public GetUserLimitsRequest (){
	}	

	/**
	 * Getter for requestEnvelope
	 */
	 public RequestEnvelope getRequestEnvelope() {
	 	return requestEnvelope;
	 }
	 
	/**
	 * Setter for requestEnvelope
	 */
	 public void setRequestEnvelope(RequestEnvelope requestEnvelope) {
	 	this.requestEnvelope = requestEnvelope;
	 }
	 
	/**
	 * Getter for user
	 */
	 public AccountIdentifier getUser() {
	 	return user;
	 }
	 
	/**
	 * Setter for user
	 */
	 public void setUser(AccountIdentifier user) {
	 	this.user = user;
	 }
	 
	/**
	 * Getter for country
	 */
	 public String getCountry() {
	 	return country;
	 }
	 
	/**
	 * Setter for country
	 */
	 public void setCountry(String country) {
	 	this.country = country;
	 }
	 
	/**
	 * Getter for currencyCode
	 */
	 public String getCurrencyCode() {
	 	return currencyCode;
	 }
	 
	/**
	 * Setter for currencyCode
	 */
	 public void setCurrencyCode(String currencyCode) {
	 	this.currencyCode = currencyCode;
	 }
	 
	/**
	 * Getter for limitType
	 */
	 public List<String> getLimitType() {
	 	return limitType;
	 }
	 
	/**
	 * Setter for limitType
	 */
	 public void setLimitType(List<String> limitType) {
	 	this.limitType = limitType;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.requestEnvelope != null) {
			String newPrefix = prefix + "requestEnvelope.";
			sb.append(this.requestEnvelope.toNVPString(newPrefix));
		}
		if (this.user != null) {
			String newPrefix = prefix + "user.";
			sb.append(this.user.toNVPString(newPrefix));
		}
		if (this.country != null) {
			sb.append(prefix).append("country=").append(NVPUtil.encodeUrl(this.country));
			sb.append("&");
		}
		if (this.currencyCode != null) {
			sb.append(prefix).append("currencyCode=").append(NVPUtil.encodeUrl(this.currencyCode));
			sb.append("&");
		}
		if (this.limitType != null) {
			for(int i=0; i < this.limitType.size(); i++) {
				sb.append(prefix).append("limitType(").append(i).append(")=").append(NVPUtil.encodeUrl(this.limitType.get(i)));
				sb.append("&");
			}
		}
		return sb.toString();
	}

}