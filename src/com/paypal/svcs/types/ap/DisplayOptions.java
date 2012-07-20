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
	 * No Document Comments	 
	 */ 
	private String emailHeaderImageUrl;

	/**
	 * No Document Comments	 
	 */ 
	private String emailMarketingImageUrl;

	/**
	 * No Document Comments	 
	 */ 
	private String headerImageUrl;

	/**
	 * No Document Comments	 
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
	public DisplayOptions(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "emailHeaderImageUrl")){
			this.emailHeaderImageUrl = map.get(prefix + "emailHeaderImageUrl");
		}
		if(map.containsKey(prefix + "emailMarketingImageUrl")){
			this.emailMarketingImageUrl = map.get(prefix + "emailMarketingImageUrl");
		}
		if(map.containsKey(prefix + "headerImageUrl")){
			this.headerImageUrl = map.get(prefix + "headerImageUrl");
		}
		if(map.containsKey(prefix + "businessName")){
			this.businessName = map.get(prefix + "businessName");
		}
	}

}