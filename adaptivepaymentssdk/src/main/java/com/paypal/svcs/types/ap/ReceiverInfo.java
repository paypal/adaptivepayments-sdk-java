package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.AccountIdentifier;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * ReceiverInfo needs to be populate for the receiver who
 * doesn't have paypal account. 
 */
public class ReceiverInfo extends AccountIdentifier {


	/**
	 * The two-character ISO country code of the home country of
	 * the Receiver 	 
	 */ 
	private String countryCode;

	/**
	 * 	 
	 */ 
	private String firstName;

	/**
	 * 	 
	 */ 
	private String lastName;

	

	/**
	 * Default Constructor
	 */
	public ReceiverInfo (){
	}	

	/**
	 * Getter for countryCode
	 */
	 public String getCountryCode() {
	 	return countryCode;
	 }
	 
	/**
	 * Setter for countryCode
	 */
	 public void setCountryCode(String countryCode) {
	 	this.countryCode = countryCode;
	 }
	 
	/**
	 * Getter for firstName
	 */
	 public String getFirstName() {
	 	return firstName;
	 }
	 
	/**
	 * Setter for firstName
	 */
	 public void setFirstName(String firstName) {
	 	this.firstName = firstName;
	 }
	 
	/**
	 * Getter for lastName
	 */
	 public String getLastName() {
	 	return lastName;
	 }
	 
	/**
	 * Setter for lastName
	 */
	 public void setLastName(String lastName) {
	 	this.lastName = lastName;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toNVPString(prefix));
		if (this.countryCode != null) {
			sb.append(prefix).append("countryCode=").append(NVPUtil.encodeUrl(this.countryCode));
			sb.append("&");
		}
		if (this.firstName != null) {
			sb.append(prefix).append("firstName=").append(NVPUtil.encodeUrl(this.firstName));
			sb.append("&");
		}
		if (this.lastName != null) {
			sb.append(prefix).append("lastName=").append(NVPUtil.encodeUrl(this.lastName));
			sb.append("&");
		}
		return sb.toString();
	}

}