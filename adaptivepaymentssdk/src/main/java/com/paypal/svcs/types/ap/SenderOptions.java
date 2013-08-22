package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.ap.ShippingAddressInfo;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * Options that apply to the sender of a payment. 
 */
public class SenderOptions{


	/**
	 * Require the user to select a shipping address during the web
	 * flow. 	 
	 */ 
	private Boolean requireShippingAddressSelection;

	/**
	 * Determines whether or not the UI pages should display the
	 * shipping address set by user in this SetPaymentOptions
	 * request. 	 
	 */ 
	private Boolean addressOverride;

	/**
	 * 	 
	 */ 
	private String referrerCode;

	/**
	 * 	 
	 */ 
	private ShippingAddressInfo shippingAddress;

	

	/**
	 * Default Constructor
	 */
	public SenderOptions (){
	}	

	/**
	 * Getter for requireShippingAddressSelection
	 */
	 public Boolean getRequireShippingAddressSelection() {
	 	return requireShippingAddressSelection;
	 }
	 
	/**
	 * Setter for requireShippingAddressSelection
	 */
	 public void setRequireShippingAddressSelection(Boolean requireShippingAddressSelection) {
	 	this.requireShippingAddressSelection = requireShippingAddressSelection;
	 }
	 
	/**
	 * Getter for addressOverride
	 */
	 public Boolean getAddressOverride() {
	 	return addressOverride;
	 }
	 
	/**
	 * Setter for addressOverride
	 */
	 public void setAddressOverride(Boolean addressOverride) {
	 	this.addressOverride = addressOverride;
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
	 
	/**
	 * Getter for shippingAddress
	 */
	 public ShippingAddressInfo getShippingAddress() {
	 	return shippingAddress;
	 }
	 
	/**
	 * Setter for shippingAddress
	 */
	 public void setShippingAddress(ShippingAddressInfo shippingAddress) {
	 	this.shippingAddress = shippingAddress;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.requireShippingAddressSelection != null) {
			sb.append(prefix).append("requireShippingAddressSelection=").append(this.requireShippingAddressSelection);
			sb.append("&");
		}
		if (this.addressOverride != null) {
			sb.append(prefix).append("addressOverride=").append(this.addressOverride);
			sb.append("&");
		}
		if (this.referrerCode != null) {
			sb.append(prefix).append("referrerCode=").append(NVPUtil.encodeUrl(this.referrerCode));
			sb.append("&");
		}
		if (this.shippingAddress != null) {
			String newPrefix = prefix + "shippingAddress.";
			sb.append(this.shippingAddress.toNVPString(newPrefix));
		}
		return sb.toString();
	}
	
	public static SenderOptions createInstance(Map<String, String> map, String prefix, int index) {
		SenderOptions senderOptions = null;
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
			
		if (map.containsKey(prefix + "requireShippingAddressSelection")) {
				senderOptions = (senderOptions == null) ? new SenderOptions() : senderOptions;
				senderOptions.setRequireShippingAddressSelection(Boolean.valueOf(map.get(prefix + "requireShippingAddressSelection")));
		}
		if (map.containsKey(prefix + "addressOverride")) {
				senderOptions = (senderOptions == null) ? new SenderOptions() : senderOptions;
				senderOptions.setAddressOverride(Boolean.valueOf(map.get(prefix + "addressOverride")));
		}
		if (map.containsKey(prefix + "referrerCode")) {
				senderOptions = (senderOptions == null) ? new SenderOptions() : senderOptions;
				senderOptions.setReferrerCode(map.get(prefix + "referrerCode"));
		}
		ShippingAddressInfo shippingAddress =  ShippingAddressInfo.createInstance(map, prefix + "shippingAddress", -1);
		if (shippingAddress != null) {
			senderOptions = (senderOptions == null) ? new SenderOptions() : senderOptions;
			senderOptions.setShippingAddress(shippingAddress);
		}
		return senderOptions;
	}
 
}