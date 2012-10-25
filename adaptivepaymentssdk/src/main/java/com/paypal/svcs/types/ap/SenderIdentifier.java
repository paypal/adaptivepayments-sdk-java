package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.ap.TaxIdDetails;
import com.paypal.svcs.types.common.AccountIdentifier;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * The sender identifier type contains information to identify
 * a PayPal account. 
 */
public class SenderIdentifier extends AccountIdentifier {

	private static final String nameSpace="com.paypal.svcs.types.ap";
	private static final String preferredPrefix="";

	/**
	 * 	 
	 */ 
	private Boolean useCredentials;

	/**
	 * 	 
	 */ 
	private TaxIdDetails taxIdDetails;

	

	/**
	 * Default Constructor
	 */
	public SenderIdentifier (){
	}	

	/**
	 * Getter for useCredentials
	 */
	 public Boolean getUseCredentials() {
	 	return useCredentials;
	 }
	 
	/**
	 * Setter for useCredentials
	 */
	 public void setUseCredentials(Boolean useCredentials) {
	 	this.useCredentials = useCredentials;
	 }
	 
	/**
	 * Getter for taxIdDetails
	 */
	 public TaxIdDetails getTaxIdDetails() {
	 	return taxIdDetails;
	 }
	 
	/**
	 * Setter for taxIdDetails
	 */
	 public void setTaxIdDetails(TaxIdDetails taxIdDetails) {
	 	this.taxIdDetails = taxIdDetails;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toNVPString(prefix));
		if (useCredentials != null) {
			sb.append(prefix).append("useCredentials=").append(useCredentials);
			sb.append("&");
		}
		if (taxIdDetails != null) {
			String newPrefix = prefix + "taxIdDetails.";
			sb.append(taxIdDetails.toNVPString(newPrefix));
		}
		return sb.toString();
	}
	
	public static SenderIdentifier createInstance(Map<String, String> map, String prefix, int index) {
		SenderIdentifier senderIdentifier = null;
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
		AccountIdentifier accountIdentifier = AccountIdentifier.createInstance(map, prefix, -1);
		if (accountIdentifier != null) {
			senderIdentifier = (senderIdentifier == null) ? new SenderIdentifier() : senderIdentifier;
			senderIdentifier.setEmail(accountIdentifier.getEmail());
			senderIdentifier.setPhone(accountIdentifier.getPhone());
		}
			
		if (map.containsKey(prefix + "useCredentials")) {
				senderIdentifier = (senderIdentifier == null) ? new SenderIdentifier() : senderIdentifier;
				senderIdentifier.setUseCredentials(Boolean.valueOf(map.get(prefix + "useCredentials")));
		}
		TaxIdDetails taxIdDetails =  TaxIdDetails.createInstance(map, prefix + "taxIdDetails", -1);
		if (taxIdDetails != null) {
			senderIdentifier = (senderIdentifier == null) ? new SenderIdentifier() : senderIdentifier;
			senderIdentifier.setTaxIdDetails(taxIdDetails);
		}
		return senderIdentifier;
	}
 
}