
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;


/**
 * The request to confirm a Preapproval.
 */
public class ConfirmPreapprovalRequest {

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
	private String fundingSourceId;
	public String getFundingSourceId() {
		return fundingSourceId;
	}
	public void setFundingSourceId(String value) {
		this.fundingSourceId = value;
	}

	/**
	 */
	private String pin;
	public String getPin() {
		return pin;
	}
	public void setPin(String value) {
		this.pin = value;
	}


	public ConfirmPreapprovalRequest(RequestEnvelope requestEnvelope, String preapprovalKey) {
		this.requestEnvelope = requestEnvelope;
		this.preapprovalKey = preapprovalKey;
	}
	public ConfirmPreapprovalRequest() {
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
		if( fundingSourceId != null ) {
			sb.append(prefix).append("fundingSourceId=").append(NVPUtil.encodeUrl(fundingSourceId));
			sb.append('&');
		}
		if( pin != null ) {
			sb.append(prefix).append("pin=").append(NVPUtil.encodeUrl(pin));
			sb.append('&');
		}
		return sb.toString();
	}

}
