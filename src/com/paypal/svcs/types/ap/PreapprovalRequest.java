
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.ClientDetailsType;
import com.paypal.svcs.types.common.DayOfWeek;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;


/**
 * A request to create a Preapproval. A Preapproval
 * is an agreement between a Paypal account holder
 * (the sender) and the API caller (the service
 * invoker) to make payment(s) on the the sender's
 * behalf with various limitations defined.
 */
public class PreapprovalRequest {

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
	private Integer dateOfMonth;
	public Integer getDateOfMonth() {
		return dateOfMonth;
	}
	public void setDateOfMonth(Integer value) {
		this.dateOfMonth = value;
	}

	/**
	 */
	private DayOfWeek dayOfWeek;
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(DayOfWeek value) {
		this.dayOfWeek = value;
	}

	/**
	 */
	private String endingDate;
	public String getEndingDate() {
		return endingDate;
	}
	public void setEndingDate(String value) {
		this.endingDate = value;
	}

	/**
	 */
	private Double maxAmountPerPayment;
	public Double getMaxAmountPerPayment() {
		return maxAmountPerPayment;
	}
	public void setMaxAmountPerPayment(Double value) {
		this.maxAmountPerPayment = value;
	}

	/**
	 */
	private Integer maxNumberOfPayments;
	public Integer getMaxNumberOfPayments() {
		return maxNumberOfPayments;
	}
	public void setMaxNumberOfPayments(Integer value) {
		this.maxNumberOfPayments = value;
	}

	/**
	 */
	private Integer maxNumberOfPaymentsPerPeriod;
	public Integer getMaxNumberOfPaymentsPerPeriod() {
		return maxNumberOfPaymentsPerPeriod;
	}
	public void setMaxNumberOfPaymentsPerPeriod(Integer value) {
		this.maxNumberOfPaymentsPerPeriod = value;
	}

	/**
	 */
	private Double maxTotalAmountOfAllPayments;
	public Double getMaxTotalAmountOfAllPayments() {
		return maxTotalAmountOfAllPayments;
	}
	public void setMaxTotalAmountOfAllPayments(Double value) {
		this.maxTotalAmountOfAllPayments = value;
	}

	/**
	 */
	private String paymentPeriod;
	public String getPaymentPeriod() {
		return paymentPeriod;
	}
	public void setPaymentPeriod(String value) {
		this.paymentPeriod = value;
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
	private String memo;
	public String getMemo() {
		return memo;
	}
	public void setMemo(String value) {
		this.memo = value;
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
	private String startingDate;
	public String getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(String value) {
		this.startingDate = value;
	}

	/**
	 */
	private String pinType;
	public String getPinType() {
		return pinType;
	}
	public void setPinType(String value) {
		this.pinType = value;
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
	private Boolean displayMaxTotalAmount;
	public Boolean getDisplayMaxTotalAmount() {
		return displayMaxTotalAmount;
	}
	public void setDisplayMaxTotalAmount(Boolean value) {
		this.displayMaxTotalAmount = value;
	}


	public PreapprovalRequest(RequestEnvelope requestEnvelope, String cancelUrl, String currencyCode, String returnUrl, String startingDate) {
		this.requestEnvelope = requestEnvelope;
		this.cancelUrl = cancelUrl;
		this.currencyCode = currencyCode;
		this.returnUrl = returnUrl;
		this.startingDate = startingDate;
	}
	public PreapprovalRequest() {
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
		if( cancelUrl != null ) {
			sb.append(prefix).append("cancelUrl=").append(NVPUtil.encodeUrl(cancelUrl));
			sb.append('&');
		}
		if( currencyCode != null ) {
			sb.append(prefix).append("currencyCode=").append(NVPUtil.encodeUrl(currencyCode));
			sb.append('&');
		}
		if( dateOfMonth != null ) {
			sb.append(prefix).append("dateOfMonth=").append(dateOfMonth);
			sb.append('&');
		}
		if( dayOfWeek != null ) {
			sb.append(prefix).append("dayOfWeek=").append(dayOfWeek.getValue());
			sb.append('&');
		}
		if( endingDate != null ) {
			sb.append(prefix).append("endingDate=").append(NVPUtil.encodeUrl(endingDate));
			sb.append('&');
		}
		if( maxAmountPerPayment != null ) {
			sb.append(prefix).append("maxAmountPerPayment=").append(maxAmountPerPayment);
			sb.append('&');
		}
		if( maxNumberOfPayments != null ) {
			sb.append(prefix).append("maxNumberOfPayments=").append(maxNumberOfPayments);
			sb.append('&');
		}
		if( maxNumberOfPaymentsPerPeriod != null ) {
			sb.append(prefix).append("maxNumberOfPaymentsPerPeriod=").append(maxNumberOfPaymentsPerPeriod);
			sb.append('&');
		}
		if( maxTotalAmountOfAllPayments != null ) {
			sb.append(prefix).append("maxTotalAmountOfAllPayments=").append(maxTotalAmountOfAllPayments);
			sb.append('&');
		}
		if( paymentPeriod != null ) {
			sb.append(prefix).append("paymentPeriod=").append(NVPUtil.encodeUrl(paymentPeriod));
			sb.append('&');
		}
		if( returnUrl != null ) {
			sb.append(prefix).append("returnUrl=").append(NVPUtil.encodeUrl(returnUrl));
			sb.append('&');
		}
		if( memo != null ) {
			sb.append(prefix).append("memo=").append(NVPUtil.encodeUrl(memo));
			sb.append('&');
		}
		if( ipnNotificationUrl != null ) {
			sb.append(prefix).append("ipnNotificationUrl=").append(NVPUtil.encodeUrl(ipnNotificationUrl));
			sb.append('&');
		}
		if( senderEmail != null ) {
			sb.append(prefix).append("senderEmail=").append(NVPUtil.encodeUrl(senderEmail));
			sb.append('&');
		}
		if( startingDate != null ) {
			sb.append(prefix).append("startingDate=").append(NVPUtil.encodeUrl(startingDate));
			sb.append('&');
		}
		if( pinType != null ) {
			sb.append(prefix).append("pinType=").append(NVPUtil.encodeUrl(pinType));
			sb.append('&');
		}
		if( feesPayer != null ) {
			sb.append(prefix).append("feesPayer=").append(NVPUtil.encodeUrl(feesPayer));
			sb.append('&');
		}
		if( displayMaxTotalAmount != null ) {
			sb.append(prefix).append("displayMaxTotalAmount=").append(displayMaxTotalAmount);
			sb.append('&');
		}
		return sb.toString();
	}

}
