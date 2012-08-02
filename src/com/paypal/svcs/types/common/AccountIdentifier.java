package com.paypal.svcs.types.common;
import com.paypal.svcs.types.common.PhoneNumberType;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * 
 */
public class AccountIdentifier{


	/**
	 * 	 
	 */ 
	private String email;

	/**
	 * 	 
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
	
	public static AccountIdentifier createInstance(Map<String, String> map, String prefix, int index) {
		AccountIdentifier accountIdentifier = null;
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
			
		if (map.containsKey(prefix + "email")) {
				accountIdentifier = (accountIdentifier == null) ? new AccountIdentifier() : accountIdentifier;
				accountIdentifier.setEmail(map.get(prefix + "email"));
		}
		PhoneNumberType phone =  PhoneNumberType.createInstance(map, prefix + "phone", -1);
		if (phone != null) {
			accountIdentifier = (accountIdentifier == null) ? new AccountIdentifier() : accountIdentifier;
			accountIdentifier.setPhone(phone);
		}
		return accountIdentifier;
	}
 
}