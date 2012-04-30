
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import java.io.UnsupportedEncodingException;
import java.util.Map;


/**
 * The customer of the initiating institution
 */
public class InstitutionCustomer {

	/**
	 * The unique identifier as assigned to the
	 * institution.
	 *
	 * @Required
	 */
	private String institutionId;
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String value) {
		this.institutionId = value;
	}

	/**
	 * The first (given) name of the end
	 * consumer as known by the institution.
	 *
	 * @Required
	 */
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String value) {
		this.firstName = value;
	}

	/**
	 * The last (family) name of the end
	 * consumer as known by the institution.
	 *
	 * @Required
	 */
	private String lastName;
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String value) {
		this.lastName = value;
	}

	/**
	 * The full name of the end consumer as
	 * known by the institution.
	 *
	 * @Required
	 */
	private String displayName;
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String value) {
		this.displayName = value;
	}

	/**
	 * The unique identifier as assigned to the
	 * end consumer by the institution.
	 *
	 * @Required
	 */
	private String institutionCustomerId;
	public String getInstitutionCustomerId() {
		return institutionCustomerId;
	}
	public void setInstitutionCustomerId(String value) {
		this.institutionCustomerId = value;
	}

	/**
	 * The two-character ISO country code of
	 * the home country of the end consumer
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
	 */
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String value) {
		this.email = value;
	}


	public InstitutionCustomer(String institutionId, String firstName, String lastName, String displayName, String institutionCustomerId, String countryCode) {
		this.institutionId = institutionId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.displayName = displayName;
		this.institutionCustomerId = institutionCustomerId;
		this.countryCode = countryCode;
	}
	public InstitutionCustomer() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( institutionId != null ) {
			sb.append(prefix).append("institutionId=").append(NVPUtil.encodeUrl(institutionId));
			sb.append('&');
		}
		if( firstName != null ) {
			sb.append(prefix).append("firstName=").append(NVPUtil.encodeUrl(firstName));
			sb.append('&');
		}
		if( lastName != null ) {
			sb.append(prefix).append("lastName=").append(NVPUtil.encodeUrl(lastName));
			sb.append('&');
		}
		if( displayName != null ) {
			sb.append(prefix).append("displayName=").append(NVPUtil.encodeUrl(displayName));
			sb.append('&');
		}
		if( institutionCustomerId != null ) {
			sb.append(prefix).append("institutionCustomerId=").append(NVPUtil.encodeUrl(institutionCustomerId));
			sb.append('&');
		}
		if( countryCode != null ) {
			sb.append(prefix).append("countryCode=").append(NVPUtil.encodeUrl(countryCode));
			sb.append('&');
		}
		if( email != null ) {
			sb.append(prefix).append("email=").append(NVPUtil.encodeUrl(email));
			sb.append('&');
		}
		return sb.toString();
	}

	public InstitutionCustomer(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "institutionId") ) {
			this.institutionId = map.get(prefix + "institutionId");
		}
		if( map.containsKey(prefix + "firstName") ) {
			this.firstName = map.get(prefix + "firstName");
		}
		if( map.containsKey(prefix + "lastName") ) {
			this.lastName = map.get(prefix + "lastName");
		}
		if( map.containsKey(prefix + "displayName") ) {
			this.displayName = map.get(prefix + "displayName");
		}
		if( map.containsKey(prefix + "institutionCustomerId") ) {
			this.institutionCustomerId = map.get(prefix + "institutionCustomerId");
		}
		if( map.containsKey(prefix + "countryCode") ) {
			this.countryCode = map.get(prefix + "countryCode");
		}
		if( map.containsKey(prefix + "email") ) {
			this.email = map.get(prefix + "email");
		}
	}
}
