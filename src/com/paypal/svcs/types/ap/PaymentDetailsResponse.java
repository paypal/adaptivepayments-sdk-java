
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.FundingConstraint;
import com.paypal.svcs.types.ap.PaymentInfoList;
import com.paypal.svcs.types.ap.SenderIdentifier;
import com.paypal.svcs.types.common.ErrorData;
import com.paypal.svcs.types.common.ResponseEnvelope;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * The details of the PayRequest as specified in
 * the Pay operation.
 */
public class PaymentDetailsResponse {

	/**
	 *
	 * @Required
	 */
	private ResponseEnvelope responseEnvelope;
	public ResponseEnvelope getResponseEnvelope() {
		return responseEnvelope;
	}
	public void setResponseEnvelope(ResponseEnvelope value) {
		this.responseEnvelope = value;
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
	 *
	 * @Required
	 */
	private PaymentInfoList paymentInfoList;
	public PaymentInfoList getPaymentInfoList() {
		return paymentInfoList;
	}
	public void setPaymentInfoList(PaymentInfoList value) {
		this.paymentInfoList = value;
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
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String value) {
		this.status = value;
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
	private String feesPayer;
	public String getFeesPayer() {
		return feesPayer;
	}
	public void setFeesPayer(String value) {
		this.feesPayer = value;
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
	private String preapprovalKey;
	public String getPreapprovalKey() {
		return preapprovalKey;
	}
	public void setPreapprovalKey(String value) {
		this.preapprovalKey = value;
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

	/**
	 */
	private List<ErrorData> error = new ArrayList<ErrorData>();
	public List<ErrorData> getError() {
		return error;
	}
	public void setError(List<ErrorData> value) {
		this.error = value;
	}


	public PaymentDetailsResponse() {
	}
	public PaymentDetailsResponse(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "responseEnvelope" + ".timestamp") ) {
			String newPrefix = prefix + "responseEnvelope" + '.';
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		if( map.containsKey(prefix + "cancelUrl") ) {
			this.cancelUrl = map.get(prefix + "cancelUrl");
		}
		if( map.containsKey(prefix + "currencyCode") ) {
			this.currencyCode = map.get(prefix + "currencyCode");
		}
		if( map.containsKey(prefix + "ipnNotificationUrl") ) {
			this.ipnNotificationUrl = map.get(prefix + "ipnNotificationUrl");
		}
		if( map.containsKey(prefix + "memo") ) {
			this.memo = map.get(prefix + "memo");
		}
		if( map.containsKey(prefix + "paymentInfoList" + ".paymentInfo(0).transactionId") ) {
			String newPrefix = prefix + "paymentInfoList" + '.';
			this.paymentInfoList =  new PaymentInfoList(map, newPrefix);
		}
		if( map.containsKey(prefix + "returnUrl") ) {
			this.returnUrl = map.get(prefix + "returnUrl");
		}
		if( map.containsKey(prefix + "senderEmail") ) {
			this.senderEmail = map.get(prefix + "senderEmail");
		}
		if( map.containsKey(prefix + "status") ) {
			this.status = map.get(prefix + "status");
		}
		if( map.containsKey(prefix + "trackingId") ) {
			this.trackingId = map.get(prefix + "trackingId");
		}
		if( map.containsKey(prefix + "payKey") ) {
			this.payKey = map.get(prefix + "payKey");
		}
		if( map.containsKey(prefix + "actionType") ) {
			this.actionType = map.get(prefix + "actionType");
		}
		if( map.containsKey(prefix + "feesPayer") ) {
			this.feesPayer = map.get(prefix + "feesPayer");
		}
		if( map.containsKey(prefix + "reverseAllParallelPaymentsOnError") ) {
			this.reverseAllParallelPaymentsOnError = Boolean.valueOf(map.get(prefix + "reverseAllParallelPaymentsOnError"));
		}
		if( map.containsKey(prefix + "preapprovalKey") ) {
			this.preapprovalKey = map.get(prefix + "preapprovalKey");
		}
		if( map.containsKey(prefix + "fundingConstraint" + ".") ) {
			String newPrefix = prefix + "fundingConstraint" + '.';
			this.fundingConstraint =  new FundingConstraint(map, newPrefix);
		}
		if( map.containsKey(prefix + "sender" + ".") ) {
			String newPrefix = prefix + "sender" + '.';
			this.sender =  new SenderIdentifier(map, newPrefix);
		}
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "error" + '(' + i + ')'+ ".errorId") ) {
				String newPrefix = prefix + "error" + '(' + i + ')' + '.';
				this.error.add(new ErrorData(map, newPrefix));
			}
			else break;
			i++;
		}
	}
}
