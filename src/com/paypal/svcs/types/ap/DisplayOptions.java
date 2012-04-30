
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import java.io.UnsupportedEncodingException;
import java.util.Map;


/**
 * Customizable options that a client application
 * can specify for display purposes.
 */
public class DisplayOptions {

	/**
	 */
	private String emailHeaderImageUrl;
	public String getEmailHeaderImageUrl() {
		return emailHeaderImageUrl;
	}
	public void setEmailHeaderImageUrl(String value) {
		this.emailHeaderImageUrl = value;
	}

	/**
	 */
	private String emailMarketingImageUrl;
	public String getEmailMarketingImageUrl() {
		return emailMarketingImageUrl;
	}
	public void setEmailMarketingImageUrl(String value) {
		this.emailMarketingImageUrl = value;
	}

	/**
	 */
	private String headerImageUrl;
	public String getHeaderImageUrl() {
		return headerImageUrl;
	}
	public void setHeaderImageUrl(String value) {
		this.headerImageUrl = value;
	}

	/**
	 */
	private String businessName;
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String value) {
		this.businessName = value;
	}


	public DisplayOptions() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( emailHeaderImageUrl != null ) {
			sb.append(prefix).append("emailHeaderImageUrl=").append(NVPUtil.encodeUrl(emailHeaderImageUrl));
			sb.append('&');
		}
		if( emailMarketingImageUrl != null ) {
			sb.append(prefix).append("emailMarketingImageUrl=").append(NVPUtil.encodeUrl(emailMarketingImageUrl));
			sb.append('&');
		}
		if( headerImageUrl != null ) {
			sb.append(prefix).append("headerImageUrl=").append(NVPUtil.encodeUrl(headerImageUrl));
			sb.append('&');
		}
		if( businessName != null ) {
			sb.append(prefix).append("businessName=").append(NVPUtil.encodeUrl(businessName));
			sb.append('&');
		}
		return sb.toString();
	}

	public DisplayOptions(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "emailHeaderImageUrl") ) {
			this.emailHeaderImageUrl = map.get(prefix + "emailHeaderImageUrl");
		}
		if( map.containsKey(prefix + "emailMarketingImageUrl") ) {
			this.emailMarketingImageUrl = map.get(prefix + "emailMarketingImageUrl");
		}
		if( map.containsKey(prefix + "headerImageUrl") ) {
			this.headerImageUrl = map.get(prefix + "headerImageUrl");
		}
		if( map.containsKey(prefix + "businessName") ) {
			this.businessName = map.get(prefix + "businessName");
		}
	}
}
