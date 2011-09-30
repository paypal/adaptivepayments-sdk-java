
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;


/**
 * The request to get the allowed funding sources
 * available for a preapproval.
 */
public class GetAllowedFundingSourcesRequest {

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
	private String key;
	public String getKey() {
		return key;
	}
	public void setKey(String value) {
		this.key = value;
	}


	public GetAllowedFundingSourcesRequest(RequestEnvelope requestEnvelope, String key) {
		this.requestEnvelope = requestEnvelope;
		this.key = key;
	}
	public GetAllowedFundingSourcesRequest() {
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
		if( key != null ) {
			sb.append(prefix).append("key=").append(NVPUtil.encodeUrl(key));
			sb.append('&');
		}
		return sb.toString();
	}

}
