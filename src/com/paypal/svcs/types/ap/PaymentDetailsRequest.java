package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * The request to look up the details of a PayRequest. The
 * PaymentDetailsRequest can be made with either a payKey,
 * trackingId, or a transactionId of the PayRequest. 
 */
public class PaymentDetailsRequest{


	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private RequestEnvelope requestEnvelope;

	/**
	 * No Document Comments	 
	 */ 
	private String payKey;

	/**
	 * No Document Comments	 
	 */ 
	private String transactionId;

	/**
	 * No Document Comments	 
	 */ 
	private String trackingId;

	

	/**
	 * Constructor with arguments
	 */
	public PaymentDetailsRequest (RequestEnvelope requestEnvelope){
		this.requestEnvelope = requestEnvelope;
	}	

	/**
	 * Default Constructor
	 */
	public PaymentDetailsRequest (){
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
	 * Getter for transactionId
	 */
	 public String getTransactionId() {
	 	return transactionId;
	 }
	 
	/**
	 * Setter for transactionId
	 */
	 public void setTransactionId(String transactionId) {
	 	this.transactionId = transactionId;
	 }
	 
	/**
	 * Getter for trackingId
	 */
	 public String getTrackingId() {
	 	return trackingId;
	 }
	 
	/**
	 * Setter for trackingId
	 */
	 public void setTrackingId(String trackingId) {
	 	this.trackingId = trackingId;
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
		if (payKey != null) {
			sb.append(prefix).append("payKey=").append(NVPUtil.encodeUrl(payKey));
			sb.append("&");
		}
		if (transactionId != null) {
			sb.append(prefix).append("transactionId=").append(NVPUtil.encodeUrl(transactionId));
			sb.append("&");
		}
		if (trackingId != null) {
			sb.append(prefix).append("trackingId=").append(NVPUtil.encodeUrl(trackingId));
			sb.append("&");
		}
		return sb.toString();
	}

}