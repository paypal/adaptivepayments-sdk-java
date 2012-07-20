package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.ResponseEnvelope;
import com.paypal.svcs.types.ap.PaymentInfoList;
import com.paypal.svcs.types.ap.FundingConstraint;
import com.paypal.svcs.types.ap.SenderIdentifier;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * The details of the PayRequest as specified in the Pay
 * operation. 
 */
public class PaymentDetailsResponse{


	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

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
	private String ipnNotificationUrl;

	/**
	 * No Document Comments	 
	 */ 
	private String memo;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private PaymentInfoList paymentInfoList;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String returnUrl;

	/**
	 * No Document Comments	 
	 */ 
	private String senderEmail;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String status;

	/**
	 * No Document Comments	 
	 */ 
	private String trackingId;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String payKey;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String actionType;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String feesPayer;

	/**
	 * No Document Comments	 
	 */ 
	private Boolean reverseAllParallelPaymentsOnError;

	/**
	 * No Document Comments	 
	 */ 
	private String preapprovalKey;

	/**
	 * No Document Comments	 
	 */ 
	private FundingConstraint fundingConstraint;

	/**
	 * No Document Comments	 
	 */ 
	private SenderIdentifier sender;

	/**
	 * No Document Comments	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public PaymentDetailsResponse (){
	}	

	/**
	 * Getter for responseEnvelope
	 */
	 public ResponseEnvelope getResponseEnvelope() {
	 	return responseEnvelope;
	 }
	 
	/**
	 * Setter for responseEnvelope
	 */
	 public void setResponseEnvelope(ResponseEnvelope responseEnvelope) {
	 	this.responseEnvelope = responseEnvelope;
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
	 * Getter for paymentInfoList
	 */
	 public PaymentInfoList getPaymentInfoList() {
	 	return paymentInfoList;
	 }
	 
	/**
	 * Setter for paymentInfoList
	 */
	 public void setPaymentInfoList(PaymentInfoList paymentInfoList) {
	 	this.paymentInfoList = paymentInfoList;
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
	 * Getter for status
	 */
	 public String getStatus() {
	 	return status;
	 }
	 
	/**
	 * Setter for status
	 */
	 public void setStatus(String status) {
	 	this.status = status;
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
	 * Getter for payKey
	 */
	 public String getPayKey() {
	 	return payKey;
	 }
	 
	/**
	 * Setter for payKey
	 */
	 public void setPayKey(String payKey) {
	 	this.payKey = payKey;
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
	 * Getter for error
	 */
	 public List<ErrorData> getError() {
	 	return error;
	 }
	 
	/**
	 * Setter for error
	 */
	 public void setError(List<ErrorData> error) {
	 	this.error = error;
	 }
	 


	public PaymentDetailsResponse(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "responseEnvelope" + ".timestamp")){
			String newPrefix = prefix + "responseEnvelope" + ".";
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		if(map.containsKey(prefix + "cancelUrl")){
			this.cancelUrl = map.get(prefix + "cancelUrl");
		}
		if(map.containsKey(prefix + "currencyCode")){
			this.currencyCode = map.get(prefix + "currencyCode");
		}
		if(map.containsKey(prefix + "ipnNotificationUrl")){
			this.ipnNotificationUrl = map.get(prefix + "ipnNotificationUrl");
		}
		if(map.containsKey(prefix + "memo")){
			this.memo = map.get(prefix + "memo");
		}
		if(map.containsKey(prefix + "paymentInfoList" + ".paymentInfo(0).receiver.amount")){
			String newPrefix = prefix + "paymentInfoList" + ".";
			this.paymentInfoList =  new PaymentInfoList(map, newPrefix);
		}
		if(map.containsKey(prefix + "returnUrl")){
			this.returnUrl = map.get(prefix + "returnUrl");
		}
		if(map.containsKey(prefix + "senderEmail")){
			this.senderEmail = map.get(prefix + "senderEmail");
		}
		if(map.containsKey(prefix + "status")){
			this.status = map.get(prefix + "status");
		}
		if(map.containsKey(prefix + "trackingId")){
			this.trackingId = map.get(prefix + "trackingId");
		}
		if(map.containsKey(prefix + "payKey")){
			this.payKey = map.get(prefix + "payKey");
		}
		if(map.containsKey(prefix + "actionType")){
			this.actionType = map.get(prefix + "actionType");
		}
		if(map.containsKey(prefix + "feesPayer")){
			this.feesPayer = map.get(prefix + "feesPayer");
		}
		if(map.containsKey(prefix + "reverseAllParallelPaymentsOnError")){
			this.reverseAllParallelPaymentsOnError = Boolean.valueOf(map.get(prefix + "reverseAllParallelPaymentsOnError"));
		}
		if(map.containsKey(prefix + "preapprovalKey")){
			this.preapprovalKey = map.get(prefix + "preapprovalKey");
		}
		if(map.containsKey(prefix + "fundingConstraint" + ".allowedFundingType.fundingTypeInfo(0).fundingType")){
			String newPrefix = prefix + "fundingConstraint" + ".";
			this.fundingConstraint =  new FundingConstraint(map, newPrefix);
		}
		if(map.containsKey(prefix + "sender")){
			String newPrefix = prefix + "sender" + ".";
			this.sender =  new SenderIdentifier(map, newPrefix);
		}
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "error" + "(" + i + ")" + ".parameter(0)")){
				String newPrefix = prefix + "error" + "(" + i + ")" + ".";
				this.error.add(new ErrorData(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
	}

}