package com.paypal.svcs.types.ap;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * Customizable options that a client application can specify
 * for display purposes. 
 */
public class DisplayOptions{


	/**
	 * 	 
	 */ 
	private String emailHeaderImageUrl;

	/**
	 * 	 
	 */ 
	private String emailMarketingImageUrl;

	/**
	 * 	 
	 */ 
	private String headerImageUrl;

	/**
	 * 	 
	 */ 
	private String businessName;

	

	/**
	 * Default Constructor
	 */
	public DisplayOptions (){
	}	

	/**
	 * Getter for emailHeaderImageUrl
	 */
	 public String getEmailHeaderImageUrl() {
	 	return emailHeaderImageUrl;
	 }
	 
	/**
	 * Setter for emailHeaderImageUrl
	 */
	 public void setEmailHeaderImageUrl(String emailHeaderImageUrl) {
	 	this.emailHeaderImageUrl = emailHeaderImageUrl;
	 }
	 
	/**
	 * Getter for emailMarketingImageUrl
	 */
	 public String getEmailMarketingImageUrl() {
	 	return emailMarketingImageUrl;
	 }
	 
	/**
	 * Setter for emailMarketingImageUrl
	 */
	 public void setEmailMarketingImageUrl(String emailMarketingImageUrl) {
	 	this.emailMarketingImageUrl = emailMarketingImageUrl;
	 }
	 
	/**
	 * Getter for headerImageUrl
	 */
	 public String getHeaderImageUrl() {
	 	return headerImageUrl;
	 }
	 
	/**
	 * Setter for headerImageUrl
	 */
	 public void setHeaderImageUrl(String headerImageUrl) {
	 	this.headerImageUrl = headerImageUrl;
	 }
	 
	/**
	 * Getter for businessName
	 */
	 public String getBusinessName() {
	 	return businessName;
	 }
	 
	/**
	 * Setter for businessName
	 */
	 public void setBusinessName(String businessName) {
	 	this.businessName = businessName;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (emailHeaderImageUrl != null) {
			sb.append(prefix).append("emailHeaderImageUrl=").append(NVPUtil.encodeUrl(emailHeaderImageUrl));
			sb.append("&");
		}
		if (emailMarketingImageUrl != null) {
			sb.append(prefix).append("emailMarketingImageUrl=").append(NVPUtil.encodeUrl(emailMarketingImageUrl));
			sb.append("&");
		}
		if (headerImageUrl != null) {
			sb.append(prefix).append("headerImageUrl=").append(NVPUtil.encodeUrl(headerImageUrl));
			sb.append("&");
		}
		if (businessName != null) {
			sb.append(prefix).append("businessName=").append(NVPUtil.encodeUrl(businessName));
			sb.append("&");
		}
		return sb.toString();
	}
	
	public static DisplayOptions createInstance(Map<String, String> map, String prefix, int index) {
		DisplayOptions displayOptions = null;
		int i = 0;
		if(index != -1) {
				if (!prefix.isEmpty() && !prefix.endsWith(".")) {
					prefix = prefix + "(" + index + ").";
				}
		} 
		else {
			if (!prefix.isEmpty() && !prefix.endsWith(".")) {
				prefix = prefix + ".";
			}
		}
			
		if (map.containsKey(prefix + "emailHeaderImageUrl")) {
				displayOptions = (displayOptions == null) ? new DisplayOptions() : displayOptions;
				displayOptions.setEmailHeaderImageUrl(map.get(prefix + "emailHeaderImageUrl"));
		}
		if (map.containsKey(prefix + "emailMarketingImageUrl")) {
				displayOptions = (displayOptions == null) ? new DisplayOptions() : displayOptions;
				displayOptions.setEmailMarketingImageUrl(map.get(prefix + "emailMarketingImageUrl"));
		}
		if (map.containsKey(prefix + "headerImageUrl")) {
				displayOptions = (displayOptions == null) ? new DisplayOptions() : displayOptions;
				displayOptions.setHeaderImageUrl(map.get(prefix + "headerImageUrl"));
		}
		if (map.containsKey(prefix + "businessName")) {
				displayOptions = (displayOptions == null) ? new DisplayOptions() : displayOptions;
				displayOptions.setBusinessName(map.get(prefix + "businessName"));
		}
		return displayOptions;
	}
 
}