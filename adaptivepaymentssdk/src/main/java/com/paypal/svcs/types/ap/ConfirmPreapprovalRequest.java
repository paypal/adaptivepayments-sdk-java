package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * The request to confirm a Preapproval. 
 */
public class ConfirmPreapprovalRequest{

	private static final String nameSpace="com.paypal.svcs.types.ap";
	private static final String preferredPrefix="";

	/**
	 * 	  
	 *@Required	 
	 */ 
	private RequestEnvelope requestEnvelope;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String preapprovalKey;

	/**
	 * 	 
	 */ 
	private String fundingSourceId;

	/**
	 * 	 
	 */ 
	private String pin;

	

	/**
	 * Constructor with arguments
	 */
	public ConfirmPreapprovalRequest (RequestEnvelope requestEnvelope, String preapprovalKey){
		this.requestEnvelope = requestEnvelope;
		this.preapprovalKey = preapprovalKey;
	}	

	/**
	 * Default Constructor
	 */
	public ConfirmPreapprovalRequest (){
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
	 * Getter for preapprovalKey
	 */
	 public String getPreapprovalKey() {
	 	return preapprovalKey;
	 }
	 
	/**
	 * Setter for preapprovalKey
	 */
	 public void setPreapprovalKey(String preapprovalKey) {
	 	this.preapprovalKey = preapprovalKey;
	 }
	 
	/**
	 * Getter for fundingSourceId
	 */
	 public String getFundingSourceId() {
	 	return fundingSourceId;
	 }
	 
	/**
	 * Setter for fundingSourceId
	 */
	 public void setFundingSourceId(String fundingSourceId) {
	 	this.fundingSourceId = fundingSourceId;
	 }
	 
	/**
	 * Getter for pin
	 */
	 public String getPin() {
	 	return pin;
	 }
	 
	/**
	 * Setter for pin
	 */
	 public void setPin(String pin) {
	 	this.pin = pin;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (requestEnvelope != null) {
			String newPrefix = prefix + "requestEnvelope.";
			sb.append(requestEnvelope.toNVPString(newPrefix));
		}
		if (preapprovalKey != null) {
			sb.append(prefix).append("preapprovalKey=").append(NVPUtil.encodeUrl(preapprovalKey));
			sb.append("&");
		}
		if (fundingSourceId != null) {
			sb.append(prefix).append("fundingSourceId=").append(NVPUtil.encodeUrl(fundingSourceId));
			sb.append("&");
		}
		if (pin != null) {
			sb.append(prefix).append("pin=").append(NVPUtil.encodeUrl(pin));
			sb.append("&");
		}
		return sb.toString();
	}

}