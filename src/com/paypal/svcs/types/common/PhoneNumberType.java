
/**
 * Auto generated code
 */

package com.paypal.svcs.types.common;

import com.paypal.core.NVPUtil;
import java.io.UnsupportedEncodingException;
import java.util.Map;


/**
 */
public class PhoneNumberType {

	/**
	 *
	 * @Required
	 */
	private String countryCode;
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String value) {
		this.countryCode = value;
	}

	/**
	 *
	 * @Required
	 */
	private String phoneNumber;
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String value) {
		this.phoneNumber = value;
	}

	/**
	 */
	private String extension;
	public String getExtension() {
		return extension;
	}
	public void setExtension(String value) {
		this.extension = value;
	}


	public PhoneNumberType(String countryCode, String phoneNumber) {
		this.countryCode = countryCode;
		this.phoneNumber = phoneNumber;
	}
	public PhoneNumberType() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( countryCode != null ) {
			sb.append(prefix).append("countryCode=").append(NVPUtil.encodeUrl(countryCode));
			sb.append('&');
		}
		if( phoneNumber != null ) {
			sb.append(prefix).append("phoneNumber=").append(NVPUtil.encodeUrl(phoneNumber));
			sb.append('&');
		}
		if( extension != null ) {
			sb.append(prefix).append("extension=").append(NVPUtil.encodeUrl(extension));
			sb.append('&');
		}
		return sb.toString();
	}

	public PhoneNumberType(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "countryCode") ) {
			this.countryCode = map.get(prefix + "countryCode");
		}
		if( map.containsKey(prefix + "phoneNumber") ) {
			this.phoneNumber = map.get(prefix + "phoneNumber");
		}
		if( map.containsKey(prefix + "extension") ) {
			this.extension = map.get(prefix + "extension");
		}
	}
}
