package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.BaseAddress;
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
	 * 	 
	 */ 
	private String middleName;

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
	 * 	 
	 */ 
	private String dateOfBirth;

	/**
	 * 	 
	 */ 
	private BaseAddress address;

	

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
	 * Getter for middleName
	 */
	 public String getMiddleName() {
	 	return middleName;
	 }
	 
	/**
	 * Setter for middleName
	 */
	 public void setMiddleName(String middleName) {
	 	this.middleName = middleName;
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
	 
	/**
	 * Getter for dateOfBirth
	 */
	 public String getDateOfBirth() {
	 	return dateOfBirth;
	 }
	 
	/**
	 * Setter for dateOfBirth
	 */
	 public void setDateOfBirth(String dateOfBirth) {
	 	this.dateOfBirth = dateOfBirth;
	 }
	 
	/**
	 * Getter for address
	 */
	 public BaseAddress getAddress() {
	 	return address;
	 }
	 
	/**
	 * Setter for address
	 */
	 public void setAddress(BaseAddress address) {
	 	this.address = address;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.institutionId != null) {
			sb.append(prefix).append("institutionId=").append(NVPUtil.encodeUrl(this.institutionId));
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
		if (this.middleName != null) {
			sb.append(prefix).append("middleName=").append(NVPUtil.encodeUrl(this.middleName));
			sb.append("&");
		}
		if (this.displayName != null) {
			sb.append(prefix).append("displayName=").append(NVPUtil.encodeUrl(this.displayName));
			sb.append("&");
		}
		if (this.institutionCustomerId != null) {
			sb.append(prefix).append("institutionCustomerId=").append(NVPUtil.encodeUrl(this.institutionCustomerId));
			sb.append("&");
		}
		if (this.countryCode != null) {
			sb.append(prefix).append("countryCode=").append(NVPUtil.encodeUrl(this.countryCode));
			sb.append("&");
		}
		if (this.email != null) {
			sb.append(prefix).append("email=").append(NVPUtil.encodeUrl(this.email));
			sb.append("&");
		}
		if (this.dateOfBirth != null) {
			sb.append(prefix).append("dateOfBirth=").append(NVPUtil.encodeUrl(this.dateOfBirth));
			sb.append("&");
		}
		if (this.address != null) {
			String newPrefix = prefix + "address.";
			sb.append(this.address.toNVPString(newPrefix));
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
		if (map.containsKey(prefix + "middleName")) {
				institutionCustomer = (institutionCustomer == null) ? new InstitutionCustomer() : institutionCustomer;
				institutionCustomer.setMiddleName(map.get(prefix + "middleName"));
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
		if (map.containsKey(prefix + "dateOfBirth")) {
				institutionCustomer = (institutionCustomer == null) ? new InstitutionCustomer() : institutionCustomer;
				institutionCustomer.setDateOfBirth(map.get(prefix + "dateOfBirth"));
		}
		BaseAddress address =  BaseAddress.createInstance(map, prefix + "address", -1);
		if (address != null) {
			institutionCustomer = (institutionCustomer == null) ? new InstitutionCustomer() : institutionCustomer;
			institutionCustomer.setAddress(address);
		}
		return institutionCustomer;
	}
 
}