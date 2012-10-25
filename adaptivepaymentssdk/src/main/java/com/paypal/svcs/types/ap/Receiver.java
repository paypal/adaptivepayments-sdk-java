package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.PhoneNumberType;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * Receiver is the party where funds are transferred to. A
 * primary receiver receives a payment directly from the sender
 * in a chained split payment. A primary receiver should not be
 * specified when making a single or parallel split payment. 
 */
public class Receiver{

	private static final String nameSpace="com.paypal.svcs.types.ap";
	private static final String preferredPrefix="";

	/**
	 * 	  
	 *@Required	 
	 */ 
	private Double amount;

	/**
	 * 	 
	 */ 
	private String email;

	/**
	 * 	 
	 */ 
	private PhoneNumberType phone;

	/**
	 * 	 
	 */ 
	private Boolean primary;

	/**
	 * 	 
	 */ 
	private String invoiceId;

	/**
	 * 	 
	 */ 
	private String paymentType;

	/**
	 * 	 
	 */ 
	private String paymentSubType;

	

	/**
	 * Constructor with arguments
	 */
	public Receiver (Double amount){
		this.amount = amount;
	}	

	/**
	 * Default Constructor
	 */
	public Receiver (){
	}	

	/**
	 * Getter for amount
	 */
	 public Double getAmount() {
	 	return amount;
	 }
	 
	/**
	 * Setter for amount
	 */
	 public void setAmount(Double amount) {
	 	this.amount = amount;
	 }
	 
	/**
	 * Getter for email
	 */
	 public String getEmail() {
	 	return email;
	 }
	 
	/**
	 * Setter for email
	 */
	 public void setEmail(String email) {
	 	this.email = email;
	 }
	 
	/**
	 * Getter for phone
	 */
	 public PhoneNumberType getPhone() {
	 	return phone;
	 }
	 
	/**
	 * Setter for phone
	 */
	 public void setPhone(PhoneNumberType phone) {
	 	this.phone = phone;
	 }
	 
	/**
	 * Getter for primary
	 */
	 public Boolean getPrimary() {
	 	return primary;
	 }
	 
	/**
	 * Setter for primary
	 */
	 public void setPrimary(Boolean primary) {
	 	this.primary = primary;
	 }
	 
	/**
	 * Getter for invoiceId
	 */
	 public String getInvoiceId() {
	 	return invoiceId;
	 }
	 
	/**
	 * Setter for invoiceId
	 */
	 public void setInvoiceId(String invoiceId) {
	 	this.invoiceId = invoiceId;
	 }
	 
	/**
	 * Getter for paymentType
	 */
	 public String getPaymentType() {
	 	return paymentType;
	 }
	 
	/**
	 * Setter for paymentType
	 */
	 public void setPaymentType(String paymentType) {
	 	this.paymentType = paymentType;
	 }
	 
	/**
	 * Getter for paymentSubType
	 */
	 public String getPaymentSubType() {
	 	return paymentSubType;
	 }
	 
	/**
	 * Setter for paymentSubType
	 */
	 public void setPaymentSubType(String paymentSubType) {
	 	this.paymentSubType = paymentSubType;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (amount != null) {
			sb.append(prefix).append("amount=").append(amount);
			sb.append("&");
		}
		if (email != null) {
			sb.append(prefix).append("email=").append(NVPUtil.encodeUrl(email));
			sb.append("&");
		}
		if (phone != null) {
			String newPrefix = prefix + "phone.";
			sb.append(phone.toNVPString(newPrefix));
		}
		if (primary != null) {
			sb.append(prefix).append("primary=").append(primary);
			sb.append("&");
		}
		if (invoiceId != null) {
			sb.append(prefix).append("invoiceId=").append(NVPUtil.encodeUrl(invoiceId));
			sb.append("&");
		}
		if (paymentType != null) {
			sb.append(prefix).append("paymentType=").append(NVPUtil.encodeUrl(paymentType));
			sb.append("&");
		}
		if (paymentSubType != null) {
			sb.append(prefix).append("paymentSubType=").append(NVPUtil.encodeUrl(paymentSubType));
			sb.append("&");
		}
		return sb.toString();
	}
	
	public static Receiver createInstance(Map<String, String> map, String prefix, int index) {
		Receiver receiver = null;
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
			
		if (map.containsKey(prefix + "amount")) {
				receiver = (receiver == null) ? new Receiver() : receiver;
				receiver.setAmount(Double.valueOf(map.get(prefix + "amount")));
		}
		if (map.containsKey(prefix + "email")) {
				receiver = (receiver == null) ? new Receiver() : receiver;
				receiver.setEmail(map.get(prefix + "email"));
		}
		PhoneNumberType phone =  PhoneNumberType.createInstance(map, prefix + "phone", -1);
		if (phone != null) {
			receiver = (receiver == null) ? new Receiver() : receiver;
			receiver.setPhone(phone);
		}
		if (map.containsKey(prefix + "primary")) {
				receiver = (receiver == null) ? new Receiver() : receiver;
				receiver.setPrimary(Boolean.valueOf(map.get(prefix + "primary")));
		}
		if (map.containsKey(prefix + "invoiceId")) {
				receiver = (receiver == null) ? new Receiver() : receiver;
				receiver.setInvoiceId(map.get(prefix + "invoiceId"));
		}
		if (map.containsKey(prefix + "paymentType")) {
				receiver = (receiver == null) ? new Receiver() : receiver;
				receiver.setPaymentType(map.get(prefix + "paymentType"));
		}
		if (map.containsKey(prefix + "paymentSubType")) {
				receiver = (receiver == null) ? new Receiver() : receiver;
				receiver.setPaymentSubType(map.get(prefix + "paymentSubType"));
		}
		return receiver;
	}
 
}