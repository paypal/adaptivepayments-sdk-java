
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;


/**
 * The request to look up the details of a
 * PayRequest. The PaymentDetailsRequest can be
 * made with either a payKey, trackingId, or a
 * transactionId of the PayRequest.
 */
public class PaymentDetailsRequest {

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
	 */
	private String payKey;
	public String getPayKey() {
		return payKey;
	}
	public void setPayKey(String value) {
		this.payKey = value;
	}

	/**
	 */
	private String transactionId;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String value) {
		this.transactionId = value;
	}

	/**
	 */
	private String trackingId;
	public String getTrackingId() {
		return trackingId;
	}
	public void setTrackingId(String value) {
		this.trackingId = value;
	}


	public PaymentDetailsRequest(RequestEnvelope requestEnvelope) {
		this.requestEnvelope = requestEnvelope;
	}
	public PaymentDetailsRequest() {
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
		if( payKey != null ) {
			sb.append(prefix).append("payKey=").append(NVPUtil.encodeUrl(payKey));
			sb.append('&');
		}
		if( transactionId != null ) {
			sb.append(prefix).append("transactionId=").append(NVPUtil.encodeUrl(transactionId));
			sb.append('&');
		}
		if( trackingId != null ) {
			sb.append(prefix).append("trackingId=").append(NVPUtil.encodeUrl(trackingId));
			sb.append('&');
		}
		return sb.toString();
	}

}
