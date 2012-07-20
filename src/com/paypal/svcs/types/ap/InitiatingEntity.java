package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.ap.InstitutionCustomer;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * Details about the party that initiated this payment. The API
 * user is making this payment on behalf of the initiator. The
 * initiator can simply be an institution or a customer of the
 * institution. 
 */
public class InitiatingEntity{


	/**
	 * No Document Comments	 
	 */ 
	private InstitutionCustomer institutionCustomer;

	

	/**
	 * Default Constructor
	 */
	public InitiatingEntity (){
	}	

	/**
	 * Getter for institutionCustomer
	 */
	 public InstitutionCustomer getInstitutionCustomer() {
	 	return institutionCustomer;
	 }
	 
	/**
	 * Setter for institutionCustomer
	 */
	 public void setInstitutionCustomer(InstitutionCustomer institutionCustomer) {
	 	this.institutionCustomer = institutionCustomer;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (institutionCustomer != null) {
			String newPrefix = prefix + "institutionCustomer.";
			sb.append(institutionCustomer.toNVPString(newPrefix));
		}
		return sb.toString();
	}
	public InitiatingEntity(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "institutionCustomer" + ".institutionId")){
			String newPrefix = prefix + "institutionCustomer" + ".";
			this.institutionCustomer =  new InstitutionCustomer(map, newPrefix);
		}
	}

}