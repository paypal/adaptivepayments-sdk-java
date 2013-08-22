package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.paypal.svcs.types.ap.AgreementType;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * The request to confirm a Preapproval. 
 */
public class ConfirmPreapprovalRequest{


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
	 * 	 
	 */ 
	private AgreementType agreementType;

	

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
	 
	/**
	 * Getter for agreementType
	 */
	 public AgreementType getAgreementType() {
	 	return agreementType;
	 }
	 
	/**
	 * Setter for agreementType
	 */
	 public void setAgreementType(AgreementType agreementType) {
	 	this.agreementType = agreementType;
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
		if (this.preapprovalKey != null) {
			sb.append(prefix).append("preapprovalKey=").append(NVPUtil.encodeUrl(this.preapprovalKey));
			sb.append("&");
		}
		if (this.fundingSourceId != null) {
			sb.append(prefix).append("fundingSourceId=").append(NVPUtil.encodeUrl(this.fundingSourceId));
			sb.append("&");
		}
		if (this.pin != null) {
			sb.append(prefix).append("pin=").append(NVPUtil.encodeUrl(this.pin));
			sb.append("&");
		}
		if (this.agreementType != null) {
			sb.append(prefix).append("agreementType=").append(this.agreementType.getValue());
			sb.append("&");
		}
		return sb.toString();
	}

}