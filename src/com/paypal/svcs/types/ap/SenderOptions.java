package com.paypal.svcs.types.ap;
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
	 * No Document Comments	 
	 */ 
	private String referrerCode;

	

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
		if (requireShippingAddressSelection != null) {
			sb.append(prefix).append("requireShippingAddressSelection=").append(requireShippingAddressSelection);
			sb.append("&");
		}
		if (referrerCode != null) {
			sb.append(prefix).append("referrerCode=").append(NVPUtil.encodeUrl(referrerCode));
			sb.append("&");
		}
		return sb.toString();
	}
	public SenderOptions(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "requireShippingAddressSelection")){
			this.requireShippingAddressSelection = Boolean.valueOf(map.get(prefix + "requireShippingAddressSelection"));
		}
		if(map.containsKey(prefix + "referrerCode")){
			this.referrerCode = map.get(prefix + "referrerCode");
		}
	}

}