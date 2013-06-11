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
	 * 	 
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
		if (this.institutionCustomer != null) {
			String newPrefix = prefix + "institutionCustomer.";
			sb.append(this.institutionCustomer.toNVPString(newPrefix));
		}
		return sb.toString();
	}
	
	public static InitiatingEntity createInstance(Map<String, String> map, String prefix, int index) {
		InitiatingEntity initiatingEntity = null;
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
			
		InstitutionCustomer institutionCustomer =  InstitutionCustomer.createInstance(map, prefix + "institutionCustomer", -1);
		if (institutionCustomer != null) {
			initiatingEntity = (initiatingEntity == null) ? new InitiatingEntity() : initiatingEntity;
			initiatingEntity.setInstitutionCustomer(institutionCustomer);
		}
		return initiatingEntity;
	}
 
}