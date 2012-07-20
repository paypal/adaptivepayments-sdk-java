package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.paypal.svcs.types.common.ClientDetailsType;
import com.paypal.svcs.types.ap.ReceiverList;
import com.paypal.svcs.types.ap.FundingConstraint;
import com.paypal.svcs.types.ap.SenderIdentifier;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * The PayRequest contains the payment instructions to make
 * from sender to receivers. 
 */
public class PayRequest{


	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private RequestEnvelope requestEnvelope;

	/**
	 * No Document Comments	 
	 */ 
	private ClientDetailsType clientDetails;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String actionType;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String cancelUrl;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String currencyCode;

	/**
	 * No Document Comments	 
	 */ 
	private String feesPayer;

	/**
	 * No Document Comments	 
	 */ 
	private String ipnNotificationUrl;

	/**
	 * No Document Comments	 
	 */ 
	private String memo;

	/**
	 * No Document Comments	 
	 */ 
	private String pin;

	/**
	 * No Document Comments	 
	 */ 
	private String preapprovalKey;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private ReceiverList receiverList;

	/**
	 * No Document Comments	 
	 */ 
	private Boolean reverseAllParallelPaymentsOnError;

	/**
	 * No Document Comments	 
	 */ 
	private String senderEmail;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String returnUrl;

	/**
	 * No Document Comments	 
	 */ 
	private String trackingId;

	/**
	 * No Document Comments	 
	 */ 
	private FundingConstraint fundingConstraint;

	/**
	 * No Document Comments	 
	 */ 
	private SenderIdentifier sender;

	

	/**
	 * Constructor with arguments
	 */
	public PayRequest (RequestEnvelope requestEnvelope, String actionType, String cancelUrl, String currencyCode, ReceiverList receiverList, String returnUrl){
		this.requestEnvelope = requestEnvelope;
		this.actionType = actionType;
		this.cancelUrl = cancelUrl;
		this.currencyCode = currencyCode;
		this.receiverList = receiverList;
		this.returnUrl = returnUrl;
	}	

	/**
	 * Default Constructor
	 */
	public PayRequest (){
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
	 * Getter for clientDetails
	 */
	 public ClientDetailsType getClientDetails() {
	 	return clientDetails;
	 }
	 
	/**
	 * Setter for clientDetails
	 */
	 public void setClientDetails(ClientDetailsType clientDetails) {
	 	this.clientDetails = clientDetails;
	 }
	 
	/**
	 * Getter for actionType
	 */
	 public String getActionType() {
	 	return actionType;
	 }
	 
	/**
	 * Setter for actionType
	 */
	 public void setActionType(String actionType) {
	 	this.actionType = actionType;
	 }
	 
	/**
	 * Getter for cancelUrl
	 */
	 public String getCancelUrl() {
	 	return cancelUrl;
	 }
	 
	/**
	 * Setter for cancelUrl
	 */
	 public void setCancelUrl(String cancelUrl) {
	 	this.cancelUrl = cancelUrl;
	 }
	 
	/**
	 * Getter for currencyCode
	 */
	 public String getCurrencyCode() {
	 	return currencyCode;
	 }
	 
	/**
	 * Setter for currencyCode
	 */
	 public void setCurrencyCode(String currencyCode) {
	 	this.currencyCode = currencyCode;
	 }
	 
	/**
	 * Getter for feesPayer
	 */
	 public String getFeesPayer() {
	 	return feesPayer;
	 }
	 
	/**
	 * Setter for feesPayer
	 */
	 public void setFeesPayer(String feesPayer) {
	 	this.feesPayer = feesPayer;
	 }
	 
	/**
	 * Getter for ipnNotificationUrl
	 */
	 public String getIpnNotificationUrl() {
	 	return ipnNotificationUrl;
	 }
	 
	/**
	 * Setter for ipnNotificationUrl
	 */
	 public void setIpnNotificationUrl(String ipnNotificationUrl) {
	 	this.ipnNotificationUrl = ipnNotificationUrl;
	 }
	 
	/**
	 * Getter for memo
	 */
	 public String getMemo() {
	 	return memo;
	 }
	 
	/**
	 * Setter for memo
	 */
	 public void setMemo(String memo) {
	 	this.memo = memo;
	 }
	 
	/**
	 * Getter for pin
	 */
	 public String getPin() {
	 	return pin;
	 }
	 
	/**
	 * Setter for pin
	 */
	 public void setPin(String pin) {
	 	this.pin = pin;
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
	 
	/**
	 * Getter for receiverList
	 */
	 public ReceiverList getReceiverList() {
	 	return receiverList;
	 }
	 
	/**
	 * Setter for receiverList
	 */
	 public void setReceiverList(ReceiverList receiverList) {
	 	this.receiverList = receiverList;
	 }
	 
	/**
	 * Getter for reverseAllParallelPaymentsOnError
	 */
	 public Boolean getReverseAllParallelPaymentsOnError() {
	 	return reverseAllParallelPaymentsOnError;
	 }
	 
	/**
	 * Setter for reverseAllParallelPaymentsOnError
	 */
	 public void setReverseAllParallelPaymentsOnError(Boolean reverseAllParallelPaymentsOnError) {
	 	this.reverseAllParallelPaymentsOnError = reverseAllParallelPaymentsOnError;
	 }
	 
	/**
	 * Getter for senderEmail
	 */
	 public String getSenderEmail() {
	 	return senderEmail;
	 }
	 
	/**
	 * Setter for senderEmail
	 */
	 public void setSenderEmail(String senderEmail) {
	 	this.senderEmail = senderEmail;
	 }
	 
	/**
	 * Getter for returnUrl
	 */
	 public String getReturnUrl() {
	 	return returnUrl;
	 }
	 
	/**
	 * Setter for returnUrl
	 */
	 public void setReturnUrl(String returnUrl) {
	 	this.returnUrl = returnUrl;
	 }
	 
	/**
	 * Getter for trackingId
	 */
	 public String getTrackingId() {
	 	return trackingId;
	 }
	 
	/**
	 * Setter for trackingId
	 */
	 public void setTrackingId(String trackingId) {
	 	this.trackingId = trackingId;
	 }
	 
	/**
	 * Getter for fundingConstraint
	 */
	 public FundingConstraint getFundingConstraint() {
	 	return fundingConstraint;
	 }
	 
	/**
	 * Setter for fundingConstraint
	 */
	 public void setFundingConstraint(FundingConstraint fundingConstraint) {
	 	this.fundingConstraint = fundingConstraint;
	 }
	 
	/**
	 * Getter for sender
	 */
	 public SenderIdentifier getSender() {
	 	return sender;
	 }
	 
	/**
	 * Setter for sender
	 */
	 public void setSender(SenderIdentifier sender) {
	 	this.sender = sender;
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
		if (clientDetails != null) {
			String newPrefix = prefix + "clientDetails.";
			sb.append(clientDetails.toNVPString(newPrefix));
		}
		if (actionType != null) {
			sb.append(prefix).append("actionType=").append(NVPUtil.encodeUrl(actionType));
			sb.append("&");
		}
		if (cancelUrl != null) {
			sb.append(prefix).append("cancelUrl=").append(NVPUtil.encodeUrl(cancelUrl));
			sb.append("&");
		}
		if (currencyCode != null) {
			sb.append(prefix).append("currencyCode=").append(NVPUtil.encodeUrl(currencyCode));
			sb.append("&");
		}
		if (feesPayer != null) {
			sb.append(prefix).append("feesPayer=").append(NVPUtil.encodeUrl(feesPayer));
			sb.append("&");
		}
		if (ipnNotificationUrl != null) {
			sb.append(prefix).append("ipnNotificationUrl=").append(NVPUtil.encodeUrl(ipnNotificationUrl));
			sb.append("&");
		}
		if (memo != null) {
			sb.append(prefix).append("memo=").append(NVPUtil.encodeUrl(memo));
			sb.append("&");
		}
		if (pin != null) {
			sb.append(prefix).append("pin=").append(NVPUtil.encodeUrl(pin));
			sb.append("&");
		}
		if (preapprovalKey != null) {
			sb.append(prefix).append("preapprovalKey=").append(NVPUtil.encodeUrl(preapprovalKey));
			sb.append("&");
		}
		if (receiverList != null) {
			String newPrefix = prefix + "receiverList.";
			sb.append(receiverList.toNVPString(newPrefix));
		}
		if (reverseAllParallelPaymentsOnError != null) {
			sb.append(prefix).append("reverseAllParallelPaymentsOnError=").append(reverseAllParallelPaymentsOnError);
			sb.append("&");
		}
		if (senderEmail != null) {
			sb.append(prefix).append("senderEmail=").append(NVPUtil.encodeUrl(senderEmail));
			sb.append("&");
		}
		if (returnUrl != null) {
			sb.append(prefix).append("returnUrl=").append(NVPUtil.encodeUrl(returnUrl));
			sb.append("&");
		}
		if (trackingId != null) {
			sb.append(prefix).append("trackingId=").append(NVPUtil.encodeUrl(trackingId));
			sb.append("&");
		}
		if (fundingConstraint != null) {
			String newPrefix = prefix + "fundingConstraint.";
			sb.append(fundingConstraint.toNVPString(newPrefix));
		}
		if (sender != null) {
			String newPrefix = prefix + "sender.";
			sb.append(sender.toNVPString(newPrefix));
		}
		return sb.toString();
	}

}