
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.ap.InstitutionCustomer;
import java.io.UnsupportedEncodingException;
import java.util.Map;


/**
 * Details about the party that initiated this
 * payment. The API user is making this payment on
 * behalf of the initiator. The initiator can
 * simply be an institution or a customer of the
 * institution.
 */
public class InitiatingEntity {

	/**
	 */
	private InstitutionCustomer institutionCustomer;
	public InstitutionCustomer getInstitutionCustomer() {
		return institutionCustomer;
	}
	public void setInstitutionCustomer(InstitutionCustomer value) {
		this.institutionCustomer = value;
	}


	public InitiatingEntity() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( institutionCustomer != null ) {
			String newPrefix = prefix + "institutionCustomer.";
			sb.append(institutionCustomer.toNVPString(newPrefix));
		}
		return sb.toString();
	}

	public InitiatingEntity(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "institutionCustomer" + ".institutionId") ) {
			String newPrefix = prefix + "institutionCustomer" + '.';
			this.institutionCustomer =  new InstitutionCustomer(map, newPrefix);
		}
	}
}
