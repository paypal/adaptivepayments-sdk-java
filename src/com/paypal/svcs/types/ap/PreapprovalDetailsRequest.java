
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;


/**
 * The request to look up the details of a
 * Preapproval.
 */
public class PreapprovalDetailsRequest {

	/**
	 *
	 * @Required
	 */
	private RequestEnvelope requestEnvelope;
	public RequestEnvelope getRequestEnvelope() {
		return requestEnvelope;
	}
	public void setRequestEnvelope(RequestEnvelope value) {
		this.requestEnvelope = value;
	}

	/**
	 *
	 * @Required
	 */
	private String preapprovalKey;
	public String getPreapprovalKey() {
		return preapprovalKey;
	}
	public void setPreapprovalKey(String value) {
		this.preapprovalKey = value;
	}

	/**
	 */
	private Boolean getBillingAddress;
	public Boolean getGetBillingAddress() {
		return getBillingAddress;
	}
	public void setGetBillingAddress(Boolean value) {
		this.getBillingAddress = value;
	}


	public PreapprovalDetailsRequest(RequestEnvelope requestEnvelope, String preapprovalKey) {
		this.requestEnvelope = requestEnvelope;
		this.preapprovalKey = preapprovalKey;
	}
	public PreapprovalDetailsRequest() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( requestEnvelope != null ) {
			String newPrefix = prefix + "requestEnvelope.";
			sb.append(requestEnvelope.toNVPString(newPrefix));
		}
		if( preapprovalKey != null ) {
			sb.append(prefix).append("preapprovalKey=").append(NVPUtil.encodeUrl(preapprovalKey));
			sb.append('&');
		}
		if( getBillingAddress != null ) {
			sb.append(prefix).append("getBillingAddress=").append(getBillingAddress);
			sb.append('&');
		}
		return sb.toString();
	}

}
