package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.paypal.svcs.types.ap.InitiatingEntity;
import com.paypal.svcs.types.ap.DisplayOptions;
import com.paypal.svcs.types.ap.SenderOptions;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.ReceiverOptions;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * The request to set the options of a payment request. 
 */
public class SetPaymentOptionsRequest{


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
	private InitiatingEntity initiatingEntity;

	/**
	 * 	 
	 */ 
	private DisplayOptions displayOptions;

	/**
	 * 	 
	 */ 
	private String shippingAddressId;

	/**
	 * 	 
	 */ 
	private SenderOptions senderOptions;

	/**
	 * 	 
	 */ 
	private List<ReceiverOptions> receiverOptions = new ArrayList<ReceiverOptions>();

	

	/**
	 * Constructor with arguments
	 */
	public SetPaymentOptionsRequest (RequestEnvelope requestEnvelope, String payKey){
		this.requestEnvelope = requestEnvelope;
		this.payKey = payKey;
	}	

	/**
	 * Default Constructor
	 */
	public SetPaymentOptionsRequest (){
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
	 * Getter for initiatingEntity
	 */
	 public InitiatingEntity getInitiatingEntity() {
	 	return initiatingEntity;
	 }
	 
	/**
	 * Setter for initiatingEntity
	 */
	 public void setInitiatingEntity(InitiatingEntity initiatingEntity) {
	 	this.initiatingEntity = initiatingEntity;
	 }
	 
	/**
	 * Getter for displayOptions
	 */
	 public DisplayOptions getDisplayOptions() {
	 	return displayOptions;
	 }
	 
	/**
	 * Setter for displayOptions
	 */
	 public void setDisplayOptions(DisplayOptions displayOptions) {
	 	this.displayOptions = displayOptions;
	 }
	 
	/**
	 * Getter for shippingAddressId
	 */
	 public String getShippingAddressId() {
	 	return shippingAddressId;
	 }
	 
	/**
	 * Setter for shippingAddressId
	 */
	 public void setShippingAddressId(String shippingAddressId) {
	 	this.shippingAddressId = shippingAddressId;
	 }
	 
	/**
	 * Getter for senderOptions
	 */
	 public SenderOptions getSenderOptions() {
	 	return senderOptions;
	 }
	 
	/**
	 * Setter for senderOptions
	 */
	 public void setSenderOptions(SenderOptions senderOptions) {
	 	this.senderOptions = senderOptions;
	 }
	 
	/**
	 * Getter for receiverOptions
	 */
	 public List<ReceiverOptions> getReceiverOptions() {
	 	return receiverOptions;
	 }
	 
	/**
	 * Setter for receiverOptions
	 */
	 public void setReceiverOptions(List<ReceiverOptions> receiverOptions) {
	 	this.receiverOptions = receiverOptions;
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
		if (this.initiatingEntity != null) {
			String newPrefix = prefix + "initiatingEntity.";
			sb.append(this.initiatingEntity.toNVPString(newPrefix));
		}
		if (this.displayOptions != null) {
			String newPrefix = prefix + "displayOptions.";
			sb.append(this.displayOptions.toNVPString(newPrefix));
		}
		if (this.shippingAddressId != null) {
			sb.append(prefix).append("shippingAddressId=").append(NVPUtil.encodeUrl(this.shippingAddressId));
			sb.append("&");
		}
		if (this.senderOptions != null) {
			String newPrefix = prefix + "senderOptions.";
			sb.append(this.senderOptions.toNVPString(newPrefix));
		}
		if (this.receiverOptions != null) {
			for(int i=0; i < this.receiverOptions.size(); i++) {
				String newPrefix = prefix + "receiverOptions" + "(" + i + ").";
				sb.append(this.receiverOptions.get(i).toNVPString(newPrefix));
			}
		}
		return sb.toString();
	}

}