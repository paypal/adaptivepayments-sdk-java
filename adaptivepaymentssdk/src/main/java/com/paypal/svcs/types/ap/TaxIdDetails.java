package com.paypal.svcs.types.ap;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * Details about the payer's tax info passed in by the merchant
 * or partner. 
 */
public class TaxIdDetails{


	/**
	 * Tax id of the merchant/business. 	 
	 */ 
	private String taxId;

	/**
	 * Tax type of the Tax Id. 	 
	 */ 
	private String taxIdType;

	

	/**
	 * Default Constructor
	 */
	public TaxIdDetails (){
	}	

	/**
	 * Getter for taxId
	 */
	 public String getTaxId() {
	 	return taxId;
	 }
	 
	/**
	 * Setter for taxId
	 */
	 public void setTaxId(String taxId) {
	 	this.taxId = taxId;
	 }
	 
	/**
	 * Getter for taxIdType
	 */
	 public String getTaxIdType() {
	 	return taxIdType;
	 }
	 
	/**
	 * Setter for taxIdType
	 */
	 public void setTaxIdType(String taxIdType) {
	 	this.taxIdType = taxIdType;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.taxId != null) {
			sb.append(prefix).append("taxId=").append(NVPUtil.encodeUrl(this.taxId));
			sb.append("&");
		}
		if (this.taxIdType != null) {
			sb.append(prefix).append("taxIdType=").append(NVPUtil.encodeUrl(this.taxIdType));
			sb.append("&");
		}
		return sb.toString();
	}
	
	public static TaxIdDetails createInstance(Map<String, String> map, String prefix, int index) {
		TaxIdDetails taxIdDetails = null;
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
			
		if (map.containsKey(prefix + "taxId")) {
				taxIdDetails = (taxIdDetails == null) ? new TaxIdDetails() : taxIdDetails;
				taxIdDetails.setTaxId(map.get(prefix + "taxId"));
		}
		if (map.containsKey(prefix + "taxIdType")) {
				taxIdDetails = (taxIdDetails == null) ? new TaxIdDetails() : taxIdDetails;
				taxIdDetails.setTaxIdType(map.get(prefix + "taxIdType"));
		}
		return taxIdDetails;
	}
 
}