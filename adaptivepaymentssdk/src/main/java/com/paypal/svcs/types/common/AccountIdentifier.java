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
	 * 	 
	 */ 
	private String accountId;

	

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
	 
	/**
	 * Getter for accountId
	 */
	 public String getAccountId() {
	 	return accountId;
	 }
	 
	/**
	 * Setter for accountId
	 */
	 public void setAccountId(String accountId) {
	 	this.accountId = accountId;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.email != null) {
			sb.append(prefix).append("email=").append(NVPUtil.encodeUrl(this.email));
			sb.append("&");
		}
		if (this.phone != null) {
			String newPrefix = prefix + "phone.";
			sb.append(this.phone.toNVPString(newPrefix));
		}
		if (this.accountId != null) {
			sb.append(prefix).append("accountId=").append(NVPUtil.encodeUrl(this.accountId));
			sb.append("&");
		}
		return sb.toString();
	}
	
	public static AccountIdentifier createInstance(Map<String, String> map, String prefix, int index) {
		AccountIdentifier accountIdentifier = null;
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
			
		if (map.containsKey(prefix + "email")) {
				accountIdentifier = (accountIdentifier == null) ? new AccountIdentifier() : accountIdentifier;
				accountIdentifier.setEmail(map.get(prefix + "email"));
		}
		PhoneNumberType phone =  PhoneNumberType.createInstance(map, prefix + "phone", -1);
		if (phone != null) {
			accountIdentifier = (accountIdentifier == null) ? new AccountIdentifier() : accountIdentifier;
			accountIdentifier.setPhone(phone);
		}
		if (map.containsKey(prefix + "accountId")) {
				accountIdentifier = (accountIdentifier == null) ? new AccountIdentifier() : accountIdentifier;
				accountIdentifier.setAccountId(map.get(prefix + "accountId"));
		}
		return accountIdentifier;
	}
 
}