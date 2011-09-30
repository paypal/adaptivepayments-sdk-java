
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.ap.FundingConstraint;
import com.paypal.svcs.types.ap.ReceiverList;
import com.paypal.svcs.types.ap.SenderIdentifier;
import com.paypal.svcs.types.common.ClientDetailsType;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;


/**
 * The PayRequest contains the payment instructions
 * to make from sender to receivers.
 */
public class PayRequest {

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
	private ClientDetailsType clientDetails;
	public ClientDetailsType getClientDetails() {
		return clientDetails;
	}
	public void setClientDetails(ClientDetailsType value) {
		this.clientDetails = value;
	}

	/**
	 *
	 * @Required
	 */
	private String actionType;
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String value) {
		this.actionType = value;
	}

	/**
	 *
	 * @Required
	 */
	private String cancelUrl;
	public String getCancelUrl() {
		return cancelUrl;
	}
	public void setCancelUrl(String value) {
		this.cancelUrl = value;
	}

	/**
	 *
	 * @Required
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
	private String feesPayer;
	public String getFeesPayer() {
		return feesPayer;
	}
	public void setFeesPayer(String value) {
		this.feesPayer = value;
	}

	/**
	 */
	private String ipnNotificationUrl;
	public String getIpnNotificationUrl() {
		return ipnNotificationUrl;
	}
	public void setIpnNotificationUrl(String value) {
		this.ipnNotificationUrl = value;
	}

	/**
	 */
	private String memo;
	public String getMemo() {
		return memo;
	}
	public void setMemo(String value) {
		this.memo = value;
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

	/**
	 */
	private String preapprovalKey;
	public String getPreapprovalKey() {
		return preapprovalKey;
	}
	public void setPreapprovalKey(String value) {
		this.preapprovalKey = value;
	}

	/**
	 *
	 * @Required
	 */
	private ReceiverList receiverList;
	public ReceiverList getReceiverList() {
		return receiverList;
	}
	public void setReceiverList(ReceiverList value) {
		this.receiverList = value;
	}

	/**
	 */
	private Boolean reverseAllParallelPaymentsOnError;
	public Boolean getReverseAllParallelPaymentsOnError() {
		return reverseAllParallelPaymentsOnError;
	}
	public void setReverseAllParallelPaymentsOnError(Boolean value) {
		this.reverseAllParallelPaymentsOnError = value;
	}

	/**
	 */
	private String senderEmail;
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String value) {
		this.senderEmail = value;
	}

	/**
	 *
	 * @Required
	 */
	private String returnUrl;
	public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String value) {
		this.returnUrl = value;
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
	private FundingConstraint fundingConstraint;
	public FundingConstraint getFundingConstraint() {
		return fundingConstraint;
	}
	public void setFundingConstraint(FundingConstraint value) {
		this.fundingConstraint = value;
	}

	/**
	 */
	private SenderIdentifier sender;
	public SenderIdentifier getSender() {
		return sender;
	}
	public void setSender(SenderIdentifier value) {
		this.sender = value;
	}


	public PayRequest(RequestEnvelope requestEnvelope, String actionType, String cancelUrl, String currencyCode, ReceiverList receiverList, String returnUrl) {
		this.requestEnvelope = requestEnvelope;
		this.actionType = actionType;
		this.cancelUrl = cancelUrl;
		this.currencyCode = currencyCode;
		this.receiverList = receiverList;
		this.returnUrl = returnUrl;
	}
	public PayRequest() {
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
		if( clientDetails != null ) {
			String newPrefix = prefix + "clientDetails.";
			sb.append(clientDetails.toNVPString(newPrefix));
		}
		if( actionType != null ) {
			sb.append(prefix).append("actionType=").append(NVPUtil.encodeUrl(actionType));
			sb.append('&');
		}
		if( cancelUrl != null ) {
			sb.append(prefix).append("cancelUrl=").append(NVPUtil.encodeUrl(cancelUrl));
			sb.append('&');
		}
		if( currencyCode != null ) {
			sb.append(prefix).append("currencyCode=").append(NVPUtil.encodeUrl(currencyCode));
			sb.append('&');
		}
		if( feesPayer != null ) {
			sb.append(prefix).append("feesPayer=").append(NVPUtil.encodeUrl(feesPayer));
			sb.append('&');
		}
		if( ipnNotificationUrl != null ) {
			sb.append(prefix).append("ipnNotificationUrl=").append(NVPUtil.encodeUrl(ipnNotificationUrl));
			sb.append('&');
		}
		if( memo != null ) {
			sb.append(prefix).append("memo=").append(NVPUtil.encodeUrl(memo));
			sb.append('&');
		}
		if( pin != null ) {
			sb.append(prefix).append("pin=").append(NVPUtil.encodeUrl(pin));
			sb.append('&');
		}
		if( preapprovalKey != null ) {
			sb.append(prefix).append("preapprovalKey=").append(NVPUtil.encodeUrl(preapprovalKey));
			sb.append('&');
		}
		if( receiverList != null ) {
			String newPrefix = prefix + "receiverList.";
			sb.append(receiverList.toNVPString(newPrefix));
		}
		if( reverseAllParallelPaymentsOnError != null ) {
			sb.append(prefix).append("reverseAllParallelPaymentsOnError=").append(reverseAllParallelPaymentsOnError);
			sb.append('&');
		}
		if( senderEmail != null ) {
			sb.append(prefix).append("senderEmail=").append(NVPUtil.encodeUrl(senderEmail));
			sb.append('&');
		}
		if( returnUrl != null ) {
			sb.append(prefix).append("returnUrl=").append(NVPUtil.encodeUrl(returnUrl));
			sb.append('&');
		}
		if( trackingId != null ) {
			sb.append(prefix).append("trackingId=").append(NVPUtil.encodeUrl(trackingId));
			sb.append('&');
		}
		if( fundingConstraint != null ) {
			String newPrefix = prefix + "fundingConstraint.";
			sb.append(fundingConstraint.toNVPString(newPrefix));
		}
		if( sender != null ) {
			String newPrefix = prefix + "sender.";
			sb.append(sender.toNVPString(newPrefix));
		}
		return sb.toString();
	}

}
