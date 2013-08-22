package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.ResponseEnvelope;
import com.paypal.svcs.types.ap.PaymentInfoList;
import com.paypal.svcs.types.ap.FundingConstraint;
import com.paypal.svcs.types.ap.SenderIdentifier;
import com.paypal.svcs.types.ap.ShippingAddressInfo;
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
	 * 	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

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
	private String ipnNotificationUrl;

	/**
	 * 	 
	 */ 
	private String memo;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private PaymentInfoList paymentInfoList;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String returnUrl;

	/**
	 * 	 
	 */ 
	private String senderEmail;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String status;

	/**
	 * 	 
	 */ 
	private String trackingId;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String payKey;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String actionType;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String feesPayer;

	/**
	 * 	 
	 */ 
	private Boolean reverseAllParallelPaymentsOnError;

	/**
	 * 	 
	 */ 
	private String preapprovalKey;

	/**
	 * 	 
	 */ 
	private FundingConstraint fundingConstraint;

	/**
	 * 	 
	 */ 
	private SenderIdentifier sender;

	/**
	 * 	 
	 */ 
	private ShippingAddressInfo shippingAddress;

	/**
	 * 	 
	 */ 
	private String payKeyExpirationDate;

	/**
	 * 	 
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
	 * Getter for shippingAddress
	 */
	 public ShippingAddressInfo getShippingAddress() {
	 	return shippingAddress;
	 }
	 
	/**
	 * Setter for shippingAddress
	 */
	 public void setShippingAddress(ShippingAddressInfo shippingAddress) {
	 	this.shippingAddress = shippingAddress;
	 }
	 
	/**
	 * Getter for payKeyExpirationDate
	 */
	 public String getPayKeyExpirationDate() {
	 	return payKeyExpirationDate;
	 }
	 
	/**
	 * Setter for payKeyExpirationDate
	 */
	 public void setPayKeyExpirationDate(String payKeyExpirationDate) {
	 	this.payKeyExpirationDate = payKeyExpirationDate;
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
	 


	
	public static PaymentDetailsResponse createInstance(Map<String, String> map, String prefix, int index) {
		PaymentDetailsResponse paymentDetailsResponse = null;
		int i = 0;
		if (index != -1) {
				if (prefix != null && prefix.length() != 0 && !prefix.endsWith(".")) {
					prefix = prefix + "(" + index + ").";
				}
		} else {
			if (prefix != null && prefix.length() != 0 && !prefix.endsWith(".")) {
				prefix = prefix + ".";
			}
		}
			
		ResponseEnvelope responseEnvelope =  ResponseEnvelope.createInstance(map, prefix + "responseEnvelope", -1);
		if (responseEnvelope != null) {
			paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
			paymentDetailsResponse.setResponseEnvelope(responseEnvelope);
		}
		if (map.containsKey(prefix + "cancelUrl")) {
				paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
				paymentDetailsResponse.setCancelUrl(map.get(prefix + "cancelUrl"));
		}
		if (map.containsKey(prefix + "currencyCode")) {
				paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
				paymentDetailsResponse.setCurrencyCode(map.get(prefix + "currencyCode"));
		}
		if (map.containsKey(prefix + "ipnNotificationUrl")) {
				paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
				paymentDetailsResponse.setIpnNotificationUrl(map.get(prefix + "ipnNotificationUrl"));
		}
		if (map.containsKey(prefix + "memo")) {
				paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
				paymentDetailsResponse.setMemo(map.get(prefix + "memo"));
		}
		PaymentInfoList paymentInfoList =  PaymentInfoList.createInstance(map, prefix + "paymentInfoList", -1);
		if (paymentInfoList != null) {
			paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
			paymentDetailsResponse.setPaymentInfoList(paymentInfoList);
		}
		if (map.containsKey(prefix + "returnUrl")) {
				paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
				paymentDetailsResponse.setReturnUrl(map.get(prefix + "returnUrl"));
		}
		if (map.containsKey(prefix + "senderEmail")) {
				paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
				paymentDetailsResponse.setSenderEmail(map.get(prefix + "senderEmail"));
		}
		if (map.containsKey(prefix + "status")) {
				paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
				paymentDetailsResponse.setStatus(map.get(prefix + "status"));
		}
		if (map.containsKey(prefix + "trackingId")) {
				paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
				paymentDetailsResponse.setTrackingId(map.get(prefix + "trackingId"));
		}
		if (map.containsKey(prefix + "payKey")) {
				paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
				paymentDetailsResponse.setPayKey(map.get(prefix + "payKey"));
		}
		if (map.containsKey(prefix + "actionType")) {
				paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
				paymentDetailsResponse.setActionType(map.get(prefix + "actionType"));
		}
		if (map.containsKey(prefix + "feesPayer")) {
				paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
				paymentDetailsResponse.setFeesPayer(map.get(prefix + "feesPayer"));
		}
		if (map.containsKey(prefix + "reverseAllParallelPaymentsOnError")) {
				paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
				paymentDetailsResponse.setReverseAllParallelPaymentsOnError(Boolean.valueOf(map.get(prefix + "reverseAllParallelPaymentsOnError")));
		}
		if (map.containsKey(prefix + "preapprovalKey")) {
				paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
				paymentDetailsResponse.setPreapprovalKey(map.get(prefix + "preapprovalKey"));
		}
		FundingConstraint fundingConstraint =  FundingConstraint.createInstance(map, prefix + "fundingConstraint", -1);
		if (fundingConstraint != null) {
			paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
			paymentDetailsResponse.setFundingConstraint(fundingConstraint);
		}
		SenderIdentifier sender =  SenderIdentifier.createInstance(map, prefix + "sender", -1);
		if (sender != null) {
			paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
			paymentDetailsResponse.setSender(sender);
		}
		ShippingAddressInfo shippingAddress =  ShippingAddressInfo.createInstance(map, prefix + "shippingAddress", -1);
		if (shippingAddress != null) {
			paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
			paymentDetailsResponse.setShippingAddress(shippingAddress);
		}
		if (map.containsKey(prefix + "payKeyExpirationDate")) {
				paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
				paymentDetailsResponse.setPayKeyExpirationDate(map.get(prefix + "payKeyExpirationDate"));
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				paymentDetailsResponse = (paymentDetailsResponse == null) ? new PaymentDetailsResponse() : paymentDetailsResponse;
				paymentDetailsResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return paymentDetailsResponse;
	}
 
}