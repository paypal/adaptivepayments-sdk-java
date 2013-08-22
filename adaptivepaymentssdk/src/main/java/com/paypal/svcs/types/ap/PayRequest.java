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
	 * 	  
	 *@Required	 
	 */ 
	private RequestEnvelope requestEnvelope;

	/**
	 * 	 
	 */ 
	private ClientDetailsType clientDetails;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String actionType;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String cancelUrl;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String currencyCode;

	/**
	 * 	 
	 */ 
	private String feesPayer;

	/**
	 * 	 
	 */ 
	private String ipnNotificationUrl;

	/**
	 * 	 
	 */ 
	private String memo;

	/**
	 * 	 
	 */ 
	private String pin;

	/**
	 * 	 
	 */ 
	private String preapprovalKey;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private ReceiverList receiverList;

	/**
	 * 	 
	 */ 
	private Boolean reverseAllParallelPaymentsOnError;

	/**
	 * 	 
	 */ 
	private String senderEmail;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String returnUrl;

	/**
	 * 	 
	 */ 
	private String trackingId;

	/**
	 * 	 
	 */ 
	private FundingConstraint fundingConstraint;

	/**
	 * 	 
	 */ 
	private SenderIdentifier sender;

	/**
	 * The pay key expires after the duration specified in this
	 * column. If not provided, it defaults to normal expiration
	 * behavior. Valid values are 5 minutes to 30 days. 	 
	 */ 
	private String payKeyDuration;

	

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
	 
	/**
	 * Getter for payKeyDuration
	 */
	 public String getPayKeyDuration() {
	 	return payKeyDuration;
	 }
	 
	/**
	 * Setter for payKeyDuration
	 */
	 public void setPayKeyDuration(String payKeyDuration) {
	 	this.payKeyDuration = payKeyDuration;
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
		if (this.clientDetails != null) {
			String newPrefix = prefix + "clientDetails.";
			sb.append(this.clientDetails.toNVPString(newPrefix));
		}
		if (this.actionType != null) {
			sb.append(prefix).append("actionType=").append(NVPUtil.encodeUrl(this.actionType));
			sb.append("&");
		}
		if (this.cancelUrl != null) {
			sb.append(prefix).append("cancelUrl=").append(NVPUtil.encodeUrl(this.cancelUrl));
			sb.append("&");
		}
		if (this.currencyCode != null) {
			sb.append(prefix).append("currencyCode=").append(NVPUtil.encodeUrl(this.currencyCode));
			sb.append("&");
		}
		if (this.feesPayer != null) {
			sb.append(prefix).append("feesPayer=").append(NVPUtil.encodeUrl(this.feesPayer));
			sb.append("&");
		}
		if (this.ipnNotificationUrl != null) {
			sb.append(prefix).append("ipnNotificationUrl=").append(NVPUtil.encodeUrl(this.ipnNotificationUrl));
			sb.append("&");
		}
		if (this.memo != null) {
			sb.append(prefix).append("memo=").append(NVPUtil.encodeUrl(this.memo));
			sb.append("&");
		}
		if (this.pin != null) {
			sb.append(prefix).append("pin=").append(NVPUtil.encodeUrl(this.pin));
			sb.append("&");
		}
		if (this.preapprovalKey != null) {
			sb.append(prefix).append("preapprovalKey=").append(NVPUtil.encodeUrl(this.preapprovalKey));
			sb.append("&");
		}
		if (this.receiverList != null) {
			String newPrefix = prefix + "receiverList.";
			sb.append(this.receiverList.toNVPString(newPrefix));
		}
		if (this.reverseAllParallelPaymentsOnError != null) {
			sb.append(prefix).append("reverseAllParallelPaymentsOnError=").append(this.reverseAllParallelPaymentsOnError);
			sb.append("&");
		}
		if (this.senderEmail != null) {
			sb.append(prefix).append("senderEmail=").append(NVPUtil.encodeUrl(this.senderEmail));
			sb.append("&");
		}
		if (this.returnUrl != null) {
			sb.append(prefix).append("returnUrl=").append(NVPUtil.encodeUrl(this.returnUrl));
			sb.append("&");
		}
		if (this.trackingId != null) {
			sb.append(prefix).append("trackingId=").append(NVPUtil.encodeUrl(this.trackingId));
			sb.append("&");
		}
		if (this.fundingConstraint != null) {
			String newPrefix = prefix + "fundingConstraint.";
			sb.append(this.fundingConstraint.toNVPString(newPrefix));
		}
		if (this.sender != null) {
			String newPrefix = prefix + "sender.";
			sb.append(this.sender.toNVPString(newPrefix));
		}
		if (this.payKeyDuration != null) {
			sb.append(prefix).append("payKeyDuration=").append(NVPUtil.encodeUrl(this.payKeyDuration));
			sb.append("&");
		}
		return sb.toString();
	}

}