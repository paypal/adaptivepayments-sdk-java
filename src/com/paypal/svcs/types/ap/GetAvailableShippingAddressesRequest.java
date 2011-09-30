
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;


/**
 * The request to get the addresses available for a
 * payment.
 */
public class GetAvailableShippingAddressesRequest {

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
	 * The key for which to provide the
	 * available addresses. Key can be an
	 * AdaptivePayments key such as payKey or
	 * preapprovalKey
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


	public GetAvailableShippingAddressesRequest(RequestEnvelope requestEnvelope, String key) {
		this.requestEnvelope = requestEnvelope;
		this.key = key;
	}
	public GetAvailableShippingAddressesRequest() {
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
