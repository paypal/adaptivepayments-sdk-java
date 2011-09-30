
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.ap.ReceiverList;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;


/**
 * A request to make a refund based on various
 * criteria. A refund can be made against the
 * entire payKey, an individual transaction
 * belonging to a payKey, a tracking id, or a
 * specific receiver of a payKey.
 */
public class RefundRequest {

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
	private String currencyCode;
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String value) {
		this.currencyCode = value;
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

	/**
	 */
	private ReceiverList receiverList;
	public ReceiverList getReceiverList() {
		return receiverList;
	}
	public void setReceiverList(ReceiverList value) {
		this.receiverList = value;
	}


	public RefundRequest(RequestEnvelope requestEnvelope) {
		this.requestEnvelope = requestEnvelope;
	}
	public RefundRequest() {
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
		if( currencyCode != null ) {
			sb.append(prefix).append("currencyCode=").append(NVPUtil.encodeUrl(currencyCode));
			sb.append('&');
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
		if( receiverList != null ) {
			String newPrefix = prefix + "receiverList.";
			sb.append(receiverList.toNVPString(newPrefix));
		}
		return sb.toString();
	}

}
