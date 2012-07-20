package com.paypal.svcs.types.common;
import com.paypal.svcs.types.common.PhoneNumberType;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * No Document Comments
 */
public class AccountIdentifier{


	/**
	 * No Document Comments	 
	 */ 
	private String email;

	/**
	 * No Document Comments	 
	 */ 
	private PhoneNumberType phone;

	

	/**
	 * Default Constructor
	 */
	public AccountIdentifier (){
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
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (email != null) {
			sb.append(prefix).append("email=").append(NVPUtil.encodeUrl(email));
			sb.append("&");
		}
		if (phone != null) {
			String newPrefix = prefix + "phone.";
			sb.append(phone.toNVPString(newPrefix));
		}
		return sb.toString();
	}
	public AccountIdentifier(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "email")){
			this.email = map.get(prefix + "email");
		}
		if(map.containsKey(prefix + "phone" + ".countryCode")){
			String newPrefix = prefix + "phone" + ".";
			this.phone =  new PhoneNumberType(map, newPrefix);
		}
	}

}