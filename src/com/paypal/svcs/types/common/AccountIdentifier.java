
/**
 * Auto generated code
 */

package com.paypal.svcs.types.common;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.PhoneNumberType;
import java.io.UnsupportedEncodingException;
import java.util.Map;


/**
 */
public class AccountIdentifier {

	/**
	 */
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String value) {
		this.email = value;
	}

	/**
	 */
	private PhoneNumberType phone;
	public PhoneNumberType getPhone() {
		return phone;
	}
	public void setPhone(PhoneNumberType value) {
		this.phone = value;
	}


	public AccountIdentifier() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( email != null ) {
			sb.append(prefix).append("email=").append(NVPUtil.encodeUrl(email));
			sb.append('&');
		}
		if( phone != null ) {
			String newPrefix = prefix + "phone.";
			sb.append(phone.toNVPString(newPrefix));
		}
		return sb.toString();
	}

	public AccountIdentifier(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "email") ) {
			this.email = map.get(prefix + "email");
		}
		if( map.containsKey(prefix + "phone" + ".countryCode") ) {
			String newPrefix = prefix + "phone" + '.';
			this.phone =  new PhoneNumberType(map, newPrefix);
		}
	}
}
