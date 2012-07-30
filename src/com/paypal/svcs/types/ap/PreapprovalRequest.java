package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.paypal.svcs.types.common.ClientDetailsType;
import com.paypal.svcs.types.common.DayOfWeek;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * A request to create a Preapproval. A Preapproval is an
 * agreement between a Paypal account holder (the sender) and
 * the API caller (the service invoker) to make payment(s) on
 * the the sender's behalf with various limitations defined. 
 */
public class PreapprovalRequest{


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
	private String cancelUrl;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String currencyCode;

	/**
	 * 	 
	 */ 
	private Integer dateOfMonth;

	/**
	 * 	 
	 */ 
	private DayOfWeek dayOfWeek;

	/**
	 * 	 
	 */ 
	private String endingDate;

	/**
	 * 	 
	 */ 
	private Double maxAmountPerPayment;

	/**
	 * 	 
	 */ 
	private Integer maxNumberOfPayments;

	/**
	 * 	 
	 */ 
	private Integer maxNumberOfPaymentsPerPeriod;

	/**
	 * 	 
	 */ 
	private Double maxTotalAmountOfAllPayments;

	/**
	 * 	 
	 */ 
	private String paymentPeriod;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String returnUrl;

	/**
	 * 	 
	 */ 
	private String memo;

	/**
	 * 	 
	 */ 
	private String ipnNotificationUrl;

	/**
	 * 	 
	 */ 
	private String senderEmail;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String startingDate;

	/**
	 * 	 
	 */ 
	private String pinType;

	/**
	 * 	 
	 */ 
	private String feesPayer;

	/**
	 * 	 
	 */ 
	private Boolean displayMaxTotalAmount;

	

	/**
	 * Constructor with arguments
	 */
	public PreapprovalRequest (RequestEnvelope requestEnvelope, String cancelUrl, String currencyCode, String returnUrl, String startingDate){
		this.requestEnvelope = requestEnvelope;
		this.cancelUrl = cancelUrl;
		this.currencyCode = currencyCode;
		this.returnUrl = returnUrl;
		this.startingDate = startingDate;
	}	

	/**
	 * Default Constructor
	 */
	public PreapprovalRequest (){
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
	 * Getter for dateOfMonth
	 */
	 public Integer getDateOfMonth() {
	 	return dateOfMonth;
	 }
	 
	/**
	 * Setter for dateOfMonth
	 */
	 public void setDateOfMonth(Integer dateOfMonth) {
	 	this.dateOfMonth = dateOfMonth;
	 }
	 
	/**
	 * Getter for dayOfWeek
	 */
	 public DayOfWeek getDayOfWeek() {
	 	return dayOfWeek;
	 }
	 
	/**
	 * Setter for dayOfWeek
	 */
	 public void setDayOfWeek(DayOfWeek dayOfWeek) {
	 	this.dayOfWeek = dayOfWeek;
	 }
	 
	/**
	 * Getter for endingDate
	 */
	 public String getEndingDate() {
	 	return endingDate;
	 }
	 
	/**
	 * Setter for endingDate
	 */
	 public void setEndingDate(String endingDate) {
	 	this.endingDate = endingDate;
	 }
	 
	/**
	 * Getter for maxAmountPerPayment
	 */
	 public Double getMaxAmountPerPayment() {
	 	return maxAmountPerPayment;
	 }
	 
	/**
	 * Setter for maxAmountPerPayment
	 */
	 public void setMaxAmountPerPayment(Double maxAmountPerPayment) {
	 	this.maxAmountPerPayment = maxAmountPerPayment;
	 }
	 
	/**
	 * Getter for maxNumberOfPayments
	 */
	 public Integer getMaxNumberOfPayments() {
	 	return maxNumberOfPayments;
	 }
	 
	/**
	 * Setter for maxNumberOfPayments
	 */
	 public void setMaxNumberOfPayments(Integer maxNumberOfPayments) {
	 	this.maxNumberOfPayments = maxNumberOfPayments;
	 }
	 
	/**
	 * Getter for maxNumberOfPaymentsPerPeriod
	 */
	 public Integer getMaxNumberOfPaymentsPerPeriod() {
	 	return maxNumberOfPaymentsPerPeriod;
	 }
	 
	/**
	 * Setter for maxNumberOfPaymentsPerPeriod
	 */
	 public void setMaxNumberOfPaymentsPerPeriod(Integer maxNumberOfPaymentsPerPeriod) {
	 	this.maxNumberOfPaymentsPerPeriod = maxNumberOfPaymentsPerPeriod;
	 }
	 
	/**
	 * Getter for maxTotalAmountOfAllPayments
	 */
	 public Double getMaxTotalAmountOfAllPayments() {
	 	return maxTotalAmountOfAllPayments;
	 }
	 
	/**
	 * Setter for maxTotalAmountOfAllPayments
	 */
	 public void setMaxTotalAmountOfAllPayments(Double maxTotalAmountOfAllPayments) {
	 	this.maxTotalAmountOfAllPayments = maxTotalAmountOfAllPayments;
	 }
	 
	/**
	 * Getter for paymentPeriod
	 */
	 public String getPaymentPeriod() {
	 	return paymentPeriod;
	 }
	 
	/**
	 * Setter for paymentPeriod
	 */
	 public void setPaymentPeriod(String paymentPeriod) {
	 	this.paymentPeriod = paymentPeriod;
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
	 * Getter for startingDate
	 */
	 public String getStartingDate() {
	 	return startingDate;
	 }
	 
	/**
	 * Setter for startingDate
	 */
	 public void setStartingDate(String startingDate) {
	 	this.startingDate = startingDate;
	 }
	 
	/**
	 * Getter for pinType
	 */
	 public String getPinType() {
	 	return pinType;
	 }
	 
	/**
	 * Setter for pinType
	 */
	 public void setPinType(String pinType) {
	 	this.pinType = pinType;
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
	 * Getter for displayMaxTotalAmount
	 */
	 public Boolean getDisplayMaxTotalAmount() {
	 	return displayMaxTotalAmount;
	 }
	 
	/**
	 * Setter for displayMaxTotalAmount
	 */
	 public void setDisplayMaxTotalAmount(Boolean displayMaxTotalAmount) {
	 	this.displayMaxTotalAmount = displayMaxTotalAmount;
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
		if (cancelUrl != null) {
			sb.append(prefix).append("cancelUrl=").append(NVPUtil.encodeUrl(cancelUrl));
			sb.append("&");
		}
		if (currencyCode != null) {
			sb.append(prefix).append("currencyCode=").append(NVPUtil.encodeUrl(currencyCode));
			sb.append("&");
		}
		if (dateOfMonth != null) {
			sb.append(prefix).append("dateOfMonth=").append(dateOfMonth);
			sb.append("&");
		}
		if (dayOfWeek != null) {
			sb.append(prefix).append("dayOfWeek=").append(dayOfWeek.getValue());
			sb.append("&");
		}
		if (endingDate != null) {
			sb.append(prefix).append("endingDate=").append(NVPUtil.encodeUrl(endingDate));
			sb.append("&");
		}
		if (maxAmountPerPayment != null) {
			sb.append(prefix).append("maxAmountPerPayment=").append(maxAmountPerPayment);
			sb.append("&");
		}
		if (maxNumberOfPayments != null) {
			sb.append(prefix).append("maxNumberOfPayments=").append(maxNumberOfPayments);
			sb.append("&");
		}
		if (maxNumberOfPaymentsPerPeriod != null) {
			sb.append(prefix).append("maxNumberOfPaymentsPerPeriod=").append(maxNumberOfPaymentsPerPeriod);
			sb.append("&");
		}
		if (maxTotalAmountOfAllPayments != null) {
			sb.append(prefix).append("maxTotalAmountOfAllPayments=").append(maxTotalAmountOfAllPayments);
			sb.append("&");
		}
		if (paymentPeriod != null) {
			sb.append(prefix).append("paymentPeriod=").append(NVPUtil.encodeUrl(paymentPeriod));
			sb.append("&");
		}
		if (returnUrl != null) {
			sb.append(prefix).append("returnUrl=").append(NVPUtil.encodeUrl(returnUrl));
			sb.append("&");
		}
		if (memo != null) {
			sb.append(prefix).append("memo=").append(NVPUtil.encodeUrl(memo));
			sb.append("&");
		}
		if (ipnNotificationUrl != null) {
			sb.append(prefix).append("ipnNotificationUrl=").append(NVPUtil.encodeUrl(ipnNotificationUrl));
			sb.append("&");
		}
		if (senderEmail != null) {
			sb.append(prefix).append("senderEmail=").append(NVPUtil.encodeUrl(senderEmail));
			sb.append("&");
		}
		if (startingDate != null) {
			sb.append(prefix).append("startingDate=").append(NVPUtil.encodeUrl(startingDate));
			sb.append("&");
		}
		if (pinType != null) {
			sb.append(prefix).append("pinType=").append(NVPUtil.encodeUrl(pinType));
			sb.append("&");
		}
		if (feesPayer != null) {
			sb.append(prefix).append("feesPayer=").append(NVPUtil.encodeUrl(feesPayer));
			sb.append("&");
		}
		if (displayMaxTotalAmount != null) {
			sb.append(prefix).append("displayMaxTotalAmount=").append(displayMaxTotalAmount);
			sb.append("&");
		}
		return sb.toString();
	}

}