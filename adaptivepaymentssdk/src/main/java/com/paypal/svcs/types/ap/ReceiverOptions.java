package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.ap.InvoiceData;
import com.paypal.svcs.types.ap.ReceiverIdentifier;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * Options that apply to the receiver of a payment, allows
 * setting additional details for payment using invoice. 
 */
public class ReceiverOptions{


	/**
	 * 	 
	 */ 
	private String description;

	/**
	 * 	 
	 */ 
	private String customId;

	/**
	 * 	 
	 */ 
	private InvoiceData invoiceData;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private ReceiverIdentifier receiver;

	/**
	 * 	 
	 */ 
	private String referrerCode;

	

	/**
	 * Constructor with arguments
	 */
	public ReceiverOptions (ReceiverIdentifier receiver){
		this.receiver = receiver;
	}	

	/**
	 * Default Constructor
	 */
	public ReceiverOptions (){
	}	

	/**
	 * Getter for description
	 */
	 public String getDescription() {
	 	return description;
	 }
	 
	/**
	 * Setter for description
	 */
	 public void setDescription(String description) {
	 	this.description = description;
	 }
	 
	/**
	 * Getter for customId
	 */
	 public String getCustomId() {
	 	return customId;
	 }
	 
	/**
	 * Setter for customId
	 */
	 public void setCustomId(String customId) {
	 	this.customId = customId;
	 }
	 
	/**
	 * Getter for invoiceData
	 */
	 public InvoiceData getInvoiceData() {
	 	return invoiceData;
	 }
	 
	/**
	 * Setter for invoiceData
	 */
	 public void setInvoiceData(InvoiceData invoiceData) {
	 	this.invoiceData = invoiceData;
	 }
	 
	/**
	 * Getter for receiver
	 */
	 public ReceiverIdentifier getReceiver() {
	 	return receiver;
	 }
	 
	/**
	 * Setter for receiver
	 */
	 public void setReceiver(ReceiverIdentifier receiver) {
	 	this.receiver = receiver;
	 }
	 
	/**
	 * Getter for referrerCode
	 */
	 public String getReferrerCode() {
	 	return referrerCode;
	 }
	 
	/**
	 * Setter for referrerCode
	 */
	 public void setReferrerCode(String referrerCode) {
	 	this.referrerCode = referrerCode;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.description != null) {
			sb.append(prefix).append("description=").append(NVPUtil.encodeUrl(this.description));
			sb.append("&");
		}
		if (this.customId != null) {
			sb.append(prefix).append("customId=").append(NVPUtil.encodeUrl(this.customId));
			sb.append("&");
		}
		if (this.invoiceData != null) {
			String newPrefix = prefix + "invoiceData.";
			sb.append(this.invoiceData.toNVPString(newPrefix));
		}
		if (this.receiver != null) {
			String newPrefix = prefix + "receiver.";
			sb.append(this.receiver.toNVPString(newPrefix));
		}
		if (this.referrerCode != null) {
			sb.append(prefix).append("referrerCode=").append(NVPUtil.encodeUrl(this.referrerCode));
			sb.append("&");
		}
		return sb.toString();
	}
	
	public static ReceiverOptions createInstance(Map<String, String> map, String prefix, int index) {
		ReceiverOptions receiverOptions = null;
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
			
		if (map.containsKey(prefix + "description")) {
				receiverOptions = (receiverOptions == null) ? new ReceiverOptions() : receiverOptions;
				receiverOptions.setDescription(map.get(prefix + "description"));
		}
		if (map.containsKey(prefix + "customId")) {
				receiverOptions = (receiverOptions == null) ? new ReceiverOptions() : receiverOptions;
				receiverOptions.setCustomId(map.get(prefix + "customId"));
		}
		InvoiceData invoiceData =  InvoiceData.createInstance(map, prefix + "invoiceData", -1);
		if (invoiceData != null) {
			receiverOptions = (receiverOptions == null) ? new ReceiverOptions() : receiverOptions;
			receiverOptions.setInvoiceData(invoiceData);
		}
		ReceiverIdentifier receiver =  ReceiverIdentifier.createInstance(map, prefix + "receiver", -1);
		if (receiver != null) {
			receiverOptions = (receiverOptions == null) ? new ReceiverOptions() : receiverOptions;
			receiverOptions.setReceiver(receiver);
		}
		if (map.containsKey(prefix + "referrerCode")) {
				receiverOptions = (receiverOptions == null) ? new ReceiverOptions() : receiverOptions;
				receiverOptions.setReferrerCode(map.get(prefix + "referrerCode"));
		}
		return receiverOptions;
	}
 
}