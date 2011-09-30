
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;


/**
 * The request to execute the payment request.
 */
public class ExecutePaymentRequest {

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
	private String payKey;
	public String getPayKey() {
		return payKey;
	}
	public void setPayKey(String value) {
		this.payKey = value;
	}

	/**
	 * Describes the action that is performed
	 * by this API
	 */
	private String actionType;
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String value) {
		this.actionType = value;
	}

	/**
	 */
	private String fundingPlanId;
	public String getFundingPlanId() {
		return fundingPlanId;
	}
	public void setFundingPlanId(String value) {
		this.fundingPlanId = value;
	}


	public ExecutePaymentRequest(RequestEnvelope requestEnvelope, String payKey) {
		this.requestEnvelope = requestEnvelope;
		this.payKey = payKey;
	}
	public ExecutePaymentRequest() {
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
		if( actionType != null ) {
			sb.append(prefix).append("actionType=").append(NVPUtil.encodeUrl(actionType));
			sb.append('&');
		}
		if( fundingPlanId != null ) {
			sb.append(prefix).append("fundingPlanId=").append(NVPUtil.encodeUrl(fundingPlanId));
			sb.append('&');
		}
		return sb.toString();
	}

}
