package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.paypal.svcs.types.ap.ReceiverList;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * A request to make a refund based on various criteria. A
 * refund can be made against the entire payKey, an individual
 * transaction belonging to a payKey, a tracking id, or a
 * specific receiver of a payKey. 
 */
public class RefundRequest{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private RequestEnvelope requestEnvelope;

	/**
	 * 	 
	 */ 
	private String currencyCode;

	/**
	 * 	 
	 */ 
	private String payKey;

	/**
	 * 	 
	 */ 
	private String transactionId;

	/**
	 * 	 
	 */ 
	private String trackingId;

	/**
	 * 	 
	 */ 
	private ReceiverList receiverList;

	

	/**
	 * Constructor with arguments
	 */
	public RefundRequest (RequestEnvelope requestEnvelope){
		this.requestEnvelope = requestEnvelope;
	}	

	/**
	 * Default Constructor
	 */
	public RefundRequest (){
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
	 
	/**
	 * Getter for receiverList
	 */
	 public ReceiverList getReceiverList() {
	 	return receiverList;
	 }
	 
	/**
	 * Setter for receiverList
	 */
	 public void setReceiverList(ReceiverList receiverList) {
	 	this.receiverList = receiverList;
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
		if (this.currencyCode != null) {
			sb.append(prefix).append("currencyCode=").append(NVPUtil.encodeUrl(this.currencyCode));
			sb.append("&");
		}
		if (this.payKey != null) {
			sb.append(prefix).append("payKey=").append(NVPUtil.encodeUrl(this.payKey));
			sb.append("&");
		}
		if (this.transactionId != null) {
			sb.append(prefix).append("transactionId=").append(NVPUtil.encodeUrl(this.transactionId));
			sb.append("&");
		}
		if (this.trackingId != null) {
			sb.append(prefix).append("trackingId=").append(NVPUtil.encodeUrl(this.trackingId));
			sb.append("&");
		}
		if (this.receiverList != null) {
			String newPrefix = prefix + "receiverList.";
			sb.append(this.receiverList.toNVPString(newPrefix));
		}
		return sb.toString();
	}

}