package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * The request to execute the payment request. 
 */
public class ExecutePaymentRequest{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private RequestEnvelope requestEnvelope;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String payKey;

	/**
	 * Describes the action that is performed by this API 	 
	 */ 
	private String actionType;

	/**
	 * 	 
	 */ 
	private String fundingPlanId;

	

	/**
	 * Constructor with arguments
	 */
	public ExecutePaymentRequest (RequestEnvelope requestEnvelope, String payKey){
		this.requestEnvelope = requestEnvelope;
		this.payKey = payKey;
	}	

	/**
	 * Default Constructor
	 */
	public ExecutePaymentRequest (){
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
	 * Getter for payKey
	 */
	 public String getPayKey() {
	 	return payKey;
	 }
	 
	/**
	 * Setter for payKey
	 */
	 public void setPayKey(String payKey) {
	 	this.payKey = payKey;
	 }
	 
	/**
	 * Getter for actionType
	 */
	 public String getActionType() {
	 	return actionType;
	 }
	 
	/**
	 * Setter for actionType
	 */
	 public void setActionType(String actionType) {
	 	this.actionType = actionType;
	 }
	 
	/**
	 * Getter for fundingPlanId
	 */
	 public String getFundingPlanId() {
	 	return fundingPlanId;
	 }
	 
	/**
	 * Setter for fundingPlanId
	 */
	 public void setFundingPlanId(String fundingPlanId) {
	 	this.fundingPlanId = fundingPlanId;
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
		if (this.payKey != null) {
			sb.append(prefix).append("payKey=").append(NVPUtil.encodeUrl(this.payKey));
			sb.append("&");
		}
		if (this.actionType != null) {
			sb.append(prefix).append("actionType=").append(NVPUtil.encodeUrl(this.actionType));
			sb.append("&");
		}
		if (this.fundingPlanId != null) {
			sb.append(prefix).append("fundingPlanId=").append(NVPUtil.encodeUrl(this.fundingPlanId));
			sb.append("&");
		}
		return sb.toString();
	}

}