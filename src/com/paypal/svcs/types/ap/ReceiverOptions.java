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
	 * No Document Comments	 
	 */ 
	private String description;

	/**
	 * No Document Comments	 
	 */ 
	private String customId;

	/**
	 * No Document Comments	 
	 */ 
	private InvoiceData invoiceData;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private ReceiverIdentifier receiver;

	/**
	 * No Document Comments	 
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
		if (description != null) {
			sb.append(prefix).append("description=").append(NVPUtil.encodeUrl(description));
			sb.append("&");
		}
		if (customId != null) {
			sb.append(prefix).append("customId=").append(NVPUtil.encodeUrl(customId));
			sb.append("&");
		}
		if (invoiceData != null) {
			String newPrefix = prefix + "invoiceData.";
			sb.append(invoiceData.toNVPString(newPrefix));
		}
		if (receiver != null) {
			String newPrefix = prefix + "receiver.";
			sb.append(receiver.toNVPString(newPrefix));
		}
		if (referrerCode != null) {
			sb.append(prefix).append("referrerCode=").append(NVPUtil.encodeUrl(referrerCode));
			sb.append("&");
		}
		return sb.toString();
	}
	public ReceiverOptions(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "description")){
			this.description = map.get(prefix + "description");
		}
		if(map.containsKey(prefix + "customId")){
			this.customId = map.get(prefix + "customId");
		}
		if(map.containsKey(prefix + "invoiceData")){
			String newPrefix = prefix + "invoiceData" + ".";
			this.invoiceData =  new InvoiceData(map, newPrefix);
		}
		if(map.containsKey(prefix + "receiver")){
			String newPrefix = prefix + "receiver" + ".";
			this.receiver =  new ReceiverIdentifier(map, newPrefix);
		}
		if(map.containsKey(prefix + "referrerCode")){
			this.referrerCode = map.get(prefix + "referrerCode");
		}
	}

}