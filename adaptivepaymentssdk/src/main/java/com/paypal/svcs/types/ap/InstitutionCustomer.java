package com.paypal.svcs.types.ap;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * The customer of the initiating institution 
 */
public class InstitutionCustomer{


	/**
	 * The unique identifier as assigned to the institution. 	  
	 *@Required	 
	 */ 
	private String institutionId;

	/**
	 * The first (given) name of the end consumer as known by the
	 * institution. 	  
	 *@Required	 
	 */ 
	private String firstName;

	/**
	 * The last (family) name of the end consumer as known by the
	 * institution. 	  
	 *@Required	 
	 */ 
	private String lastName;

	/**
	 * The full name of the end consumer as known by the
	 * institution. 	  
	 *@Required	 
	 */ 
	private String displayName;

	/**
	 * The unique identifier as assigned to the end consumer by the
	 * institution. 	  
	 *@Required	 
	 */ 
	private String institutionCustomerId;

	/**
	 * The two-character ISO country code of the home country of
	 * the end consumer 	  
	 *@Required	 
	 */ 
	private String countryCode;

	/**
	 * 	 
	 */ 
	private String email;

	

	/**
	 * Constructor with arguments
	 */
	public InstitutionCustomer (String institutionId, String firstName, String lastName, String displayName, String institutionCustomerId, String countryCode){
		this.institutionId = institutionId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.displayName = displayName;
		this.institutionCustomerId = institutionCustomerId;
		this.countryCode = countryCode;
	}	

	/**
	 * Default Constructor
	 */
	public InstitutionCustomer (){
	}	

	/**
	 * Getter for institutionId
	 */
	 public String getInstitutionId() {
	 	return institutionId;
	 }
	 
	/**
	 * Setter for institutionId
	 */
	 public void setInstitutionId(String institutionId) {
	 	this.institutionId = institutionId;
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
	 
	/**
	 * Getter for displayName
	 */
	 public String getDisplayName() {
	 	return displayName;
	 }
	 
	/**
	 * Setter for displayName
	 */
	 public void setDisplayName(String displayName) {
	 	this.displayName = displayName;
	 }
	 
	/**
	 * Getter for institutionCustomerId
	 */
	 public String getInstitutionCustomerId() {
	 	return institutionCustomerId;
	 }
	 
	/**
	 * Setter for institutionCustomerId
	 */
	 public void setInstitutionCustomerId(String institutionCustomerId) {
	 	this.institutionCustomerId = institutionCustomerId;
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
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (institutionId != null) {
			sb.append(prefix).append("institutionId=").append(NVPUtil.encodeUrl(institutionId));
			sb.append("&");
		}
		if (firstName != null) {
			sb.append(prefix).append("firstName=").append(NVPUtil.encodeUrl(firstName));
			sb.append("&");
		}
		if (lastName != null) {
			sb.append(prefix).append("lastName=").append(NVPUtil.encodeUrl(lastName));
			sb.append("&");
		}
		if (displayName != null) {
			sb.append(prefix).append("displayName=").append(NVPUtil.encodeUrl(displayName));
			sb.append("&");
		}
		if (institutionCustomerId != null) {
			sb.append(prefix).append("institutionCustomerId=").append(NVPUtil.encodeUrl(institutionCustomerId));
			sb.append("&");
		}
		if (countryCode != null) {
			sb.append(prefix).append("countryCode=").append(NVPUtil.encodeUrl(countryCode));
			sb.append("&");
		}
		if (email != null) {
			sb.append(prefix).append("email=").append(NVPUtil.encodeUrl(email));
			sb.append("&");
		}
		return sb.toString();
	}
	
	public static InstitutionCustomer createInstance(Map<String, String> map, String prefix, int index) {
		InstitutionCustomer institutionCustomer = null;
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
			
		if (map.containsKey(prefix + "institutionId")) {
				institutionCustomer = (institutionCustomer == null) ? new InstitutionCustomer() : institutionCustomer;
				institutionCustomer.setInstitutionId(map.get(prefix + "institutionId"));
		}
		if (map.containsKey(prefix + "firstName")) {
				institutionCustomer = (institutionCustomer == null) ? new InstitutionCustomer() : institutionCustomer;
				institutionCustomer.setFirstName(map.get(prefix + "firstName"));
		}
		if (map.containsKey(prefix + "lastName")) {
				institutionCustomer = (institutionCustomer == null) ? new InstitutionCustomer() : institutionCustomer;
				institutionCustomer.setLastName(map.get(prefix + "lastName"));
		}
		if (map.containsKey(prefix + "displayName")) {
				institutionCustomer = (institutionCustomer == null) ? new InstitutionCustomer() : institutionCustomer;
				institutionCustomer.setDisplayName(map.get(prefix + "displayName"));
		}
		if (map.containsKey(prefix + "institutionCustomerId")) {
				institutionCustomer = (institutionCustomer == null) ? new InstitutionCustomer() : institutionCustomer;
				institutionCustomer.setInstitutionCustomerId(map.get(prefix + "institutionCustomerId"));
		}
		if (map.containsKey(prefix + "countryCode")) {
				institutionCustomer = (institutionCustomer == null) ? new InstitutionCustomer() : institutionCustomer;
				institutionCustomer.setCountryCode(map.get(prefix + "countryCode"));
		}
		if (map.containsKey(prefix + "email")) {
				institutionCustomer = (institutionCustomer == null) ? new InstitutionCustomer() : institutionCustomer;
				institutionCustomer.setEmail(map.get(prefix + "email"));
		}
		return institutionCustomer;
	}
 
}