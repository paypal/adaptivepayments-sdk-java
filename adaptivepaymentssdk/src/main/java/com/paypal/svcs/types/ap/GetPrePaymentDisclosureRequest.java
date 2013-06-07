package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.paypal.svcs.types.ap.ReceiverInfoList;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * GetPrePaymentDisclosureRequest is used to get the PrePayment
 * Disclosure.; GetPrePaymentDisclosureRequest contains
 * following parameters payKey :The pay key that identifies the
 * payment for which you want to retrieve details. this is the
 * pay key returned in the PayResponse message.
 * receiverInfoList : This is an optional.This needs to be
 * provided in case of Unilateral scenario. receiverInfoList
 * has a list of ReceiverInfo type. List is provided here to
 * support in future for Parallel/Chained Payemnts. Each
 * ReceiverInfo has following variables firstName : firstName
 * of recipient.  lastName : lastName of recipient. 
 * countryCode : CountryCode of Recipient. 
 */
public class GetPrePaymentDisclosureRequest{


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
	 * 	 
	 */ 
	private ReceiverInfoList receiverInfoList;

	

	/**
	 * Constructor with arguments
	 */
	public GetPrePaymentDisclosureRequest (RequestEnvelope requestEnvelope, String payKey){
		this.requestEnvelope = requestEnvelope;
		this.payKey = payKey;
	}	

	/**
	 * Default Constructor
	 */
	public GetPrePaymentDisclosureRequest (){
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
	 * Getter for receiverInfoList
	 */
	 public ReceiverInfoList getReceiverInfoList() {
	 	return receiverInfoList;
	 }
	 
	/**
	 * Setter for receiverInfoList
	 */
	 public void setReceiverInfoList(ReceiverInfoList receiverInfoList) {
	 	this.receiverInfoList = receiverInfoList;
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
		if (this.receiverInfoList != null) {
			String newPrefix = prefix + "receiverInfoList.";
			sb.append(this.receiverInfoList.toNVPString(newPrefix));
		}
		return sb.toString();
	}

}