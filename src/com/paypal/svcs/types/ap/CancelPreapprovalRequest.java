package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * The request to cancel a Preapproval. 
 */
public class CancelPreapprovalRequest{


	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private RequestEnvelope requestEnvelope;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String preapprovalKey;

	

	/**
	 * Constructor with arguments
	 */
	public CancelPreapprovalRequest (RequestEnvelope requestEnvelope, String preapprovalKey){
		this.requestEnvelope = requestEnvelope;
		this.preapprovalKey = preapprovalKey;
	}	

	/**
	 * Default Constructor
	 */
	public CancelPreapprovalRequest (){
	}	

	/**
	 * Getter for requestEnvelope
	 */
	 public RequestEnvelope getRequestEnvelope() {
	 	return requestEnvelope;
	 }
	 
	/**
	 * Setter for requestEnvelope
	 */
	 public void setRequestEnvelope(RequestEnvelope requestEnvelope) {
	 	this.requestEnvelope = requestEnvelope;
	 }
	 
	/**
	 * Getter for preapprovalKey
	 */
	 public String getPreapprovalKey() {
	 	return preapprovalKey;
	 }
	 
	/**
	 * Setter for preapprovalKey
	 */
	 public void setPreapprovalKey(String preapprovalKey) {
	 	this.preapprovalKey = preapprovalKey;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (requestEnvelope != null) {
			String newPrefix = prefix + "requestEnvelope.";
			sb.append(requestEnvelope.toNVPString(newPrefix));
		}
		if (preapprovalKey != null) {
			sb.append(prefix).append("preapprovalKey=").append(NVPUtil.encodeUrl(preapprovalKey));
			sb.append("&");
		}
		return sb.toString();
	}

}