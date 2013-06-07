package com.paypal.svcs.types.common;
import com.paypal.svcs.types.common.DetailLevelCode;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * This specifies the list of parameters with every request to
 * the service. 
 */
public class RequestEnvelope{


	/**
	 * This specifies the required detail level that is needed by a
	 * client application pertaining to a particular data component
	 * (e.g., Item, Transaction, etc.). The detail level is
	 * specified in the DetailLevelCodeType which has all the
	 * enumerated values of the detail level for each component. 	 
	 */ 
	private DetailLevelCode detailLevel;

	/**
	 * This should be the standard RFC 3066 language identification
	 * tag, e.g., en_US. 	  
	 *@Required	 
	 */ 
	private String errorLanguage;

	

	/**
	 * Constructor with arguments
	 */
	public RequestEnvelope (String errorLanguage){
		this.errorLanguage = errorLanguage;
	}	

	/**
	 * Default Constructor
	 */
	public RequestEnvelope (){
	}	

	/**
	 * Getter for detailLevel
	 */
	 public DetailLevelCode getDetailLevel() {
	 	return detailLevel;
	 }
	 
	/**
	 * Setter for detailLevel
	 */
	 public void setDetailLevel(DetailLevelCode detailLevel) {
	 	this.detailLevel = detailLevel;
	 }
	 
	/**
	 * Getter for errorLanguage
	 */
	 public String getErrorLanguage() {
	 	return errorLanguage;
	 }
	 
	/**
	 * Setter for errorLanguage
	 */
	 public void setErrorLanguage(String errorLanguage) {
	 	this.errorLanguage = errorLanguage;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.detailLevel != null) {
			sb.append(prefix).append("detailLevel=").append(this.detailLevel.getValue());
			sb.append("&");
		}
		if (this.errorLanguage != null) {
			sb.append(prefix).append("errorLanguage=").append(NVPUtil.encodeUrl(this.errorLanguage));
			sb.append("&");
		}
		return sb.toString();
	}

}