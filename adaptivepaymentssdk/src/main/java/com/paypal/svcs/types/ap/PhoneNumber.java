package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.ap.PhoneType;
import com.paypal.svcs.types.common.PhoneNumberType;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * Phone number with Type of phone number 
 */
public class PhoneNumber extends PhoneNumberType {


	/**
	 * 	  
	 *@Required	 
	 */ 
	private PhoneType type;

	

	/**
	 * Constructor with arguments
	 */
	public PhoneNumber (PhoneType type){
		this.type = type;
	}	

	/**
	 * Default Constructor
	 */
	public PhoneNumber (){
	}	

	/**
	 * Getter for type
	 */
	 public PhoneType getType() {
	 	return type;
	 }
	 
	/**
	 * Setter for type
	 */
	 public void setType(PhoneType type) {
	 	this.type = type;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toNVPString(prefix));
		if (this.type != null) {
			sb.append(prefix).append("type=").append(this.type.getValue());
			sb.append("&");
		}
		return sb.toString();
	}
	
	public static PhoneNumber createInstance(Map<String, String> map, String prefix, int index) {
		PhoneNumber phoneNumber = null;
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
		PhoneNumberType phoneNumberType = PhoneNumberType.createInstance(map, prefix, -1);
		if (phoneNumberType != null) {
			phoneNumber = (phoneNumber == null) ? new PhoneNumber() : phoneNumber;
			phoneNumber.setCountryCode(phoneNumberType.getCountryCode());
			phoneNumber.setPhoneNumber(phoneNumberType.getPhoneNumber());
			phoneNumber.setExtension(phoneNumberType.getExtension());
		}
			
		if (map.containsKey(prefix + "type")) {
				phoneNumber = (phoneNumber == null) ? new PhoneNumber() : phoneNumber;
				phoneNumber.setType(PhoneType.fromValue(map.get(prefix + "type")));
		}
		return phoneNumber;
	}
 
}