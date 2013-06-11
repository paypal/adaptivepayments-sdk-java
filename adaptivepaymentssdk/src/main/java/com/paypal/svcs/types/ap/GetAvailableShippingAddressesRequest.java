package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * The request to get the addresses available for a payment. 
 */
public class GetAvailableShippingAddressesRequest{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private RequestEnvelope requestEnvelope;

	/**
	 * The key for which to provide the available addresses. Key
	 * can be an AdaptivePayments key such as payKey or
	 * preapprovalKey 	  
	 *@Required	 
	 */ 
	private String key;

	

	/**
	 * Constructor with arguments
	 */
	public GetAvailableShippingAddressesRequest (RequestEnvelope requestEnvelope, String key){
		this.requestEnvelope = requestEnvelope;
		this.key = key;
	}	

	/**
	 * Default Constructor
	 */
	public GetAvailableShippingAddressesRequest (){
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
	 * Getter for key
	 */
	 public String getKey() {
	 	return key;
	 }
	 
	/**
	 * Setter for key
	 */
	 public void setKey(String key) {
	 	this.key = key;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.requestEnvelope != null) {
			String newPrefix = prefix + "requestEnvelope.";
			sb.append(this.requestEnvelope.toNVPString(newPrefix));
		}
		if (this.key != null) {
			sb.append(prefix).append("key=").append(NVPUtil.encodeUrl(this.key));
			sb.append("&");
		}
		return sb.toString();
	}

}