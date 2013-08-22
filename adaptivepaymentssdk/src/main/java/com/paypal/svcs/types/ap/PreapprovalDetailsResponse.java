package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.ResponseEnvelope;
import com.paypal.svcs.types.common.DayOfWeek;
import com.paypal.svcs.types.ap.AddressList;
import com.paypal.svcs.types.ap.SenderIdentifier;
import com.paypal.svcs.types.ap.AgreementType;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * The details of the Preapproval as specified in the
 * Preapproval operation. 
 */
public class PreapprovalDetailsResponse{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private Boolean approved;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String cancelUrl;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private Integer curPayments;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private Double curPaymentsAmount;

	/**
	 * 	 
	 */ 
	private Integer curPeriodAttempts;

	/**
	 * 	 
	 */ 
	private String curPeriodEndingDate;

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
	 */ 
	private String pinType;

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
	 */ 
	private String memo;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String startingDate;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String status;

	/**
	 * 	 
	 */ 
	private String ipnNotificationUrl;

	/**
	 * 	 
	 */ 
	private AddressList addressList;

	/**
	 * 	 
	 */ 
	private String feesPayer;

	/**
	 * 	 
	 */ 
	private Boolean displayMaxTotalAmount;

	/**
	 * 	 
	 */ 
	private SenderIdentifier sender;

	/**
	 * 	 
	 */ 
	private AgreementType agreementType;

	/**
	 * 	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public PreapprovalDetailsResponse (){
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
	 * Getter for approved
	 */
	 public Boolean getApproved() {
	 	return approved;
	 }
	 
	/**
	 * Setter for approved
	 */
	 public void setApproved(Boolean approved) {
	 	this.approved = approved;
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
	 * Getter for curPayments
	 */
	 public Integer getCurPayments() {
	 	return curPayments;
	 }
	 
	/**
	 * Setter for curPayments
	 */
	 public void setCurPayments(Integer curPayments) {
	 	this.curPayments = curPayments;
	 }
	 
	/**
	 * Getter for curPaymentsAmount
	 */
	 public Double getCurPaymentsAmount() {
	 	return curPaymentsAmount;
	 }
	 
	/**
	 * Setter for curPaymentsAmount
	 */
	 public void setCurPaymentsAmount(Double curPaymentsAmount) {
	 	this.curPaymentsAmount = curPaymentsAmount;
	 }
	 
	/**
	 * Getter for curPeriodAttempts
	 */
	 public Integer getCurPeriodAttempts() {
	 	return curPeriodAttempts;
	 }
	 
	/**
	 * Setter for curPeriodAttempts
	 */
	 public void setCurPeriodAttempts(Integer curPeriodAttempts) {
	 	this.curPeriodAttempts = curPeriodAttempts;
	 }
	 
	/**
	 * Getter for curPeriodEndingDate
	 */
	 public String getCurPeriodEndingDate() {
	 	return curPeriodEndingDate;
	 }
	 
	/**
	 * Setter for curPeriodEndingDate
	 */
	 public void setCurPeriodEndingDate(String curPeriodEndingDate) {
	 	this.curPeriodEndingDate = curPeriodEndingDate;
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
	 * Getter for addressList
	 */
	 public AddressList getAddressList() {
	 	return addressList;
	 }
	 
	/**
	 * Setter for addressList
	 */
	 public void setAddressList(AddressList addressList) {
	 	this.addressList = addressList;
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
	 * Getter for agreementType
	 */
	 public AgreementType getAgreementType() {
	 	return agreementType;
	 }
	 
	/**
	 * Setter for agreementType
	 */
	 public void setAgreementType(AgreementType agreementType) {
	 	this.agreementType = agreementType;
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
	 


	
	public static PreapprovalDetailsResponse createInstance(Map<String, String> map, String prefix, int index) {
		PreapprovalDetailsResponse preapprovalDetailsResponse = null;
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
			preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
			preapprovalDetailsResponse.setResponseEnvelope(responseEnvelope);
		}
		if (map.containsKey(prefix + "approved")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setApproved(Boolean.valueOf(map.get(prefix + "approved")));
		}
		if (map.containsKey(prefix + "cancelUrl")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setCancelUrl(map.get(prefix + "cancelUrl"));
		}
		if (map.containsKey(prefix + "curPayments")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setCurPayments(Integer.valueOf(map.get(prefix + "curPayments")));
		}
		if (map.containsKey(prefix + "curPaymentsAmount")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setCurPaymentsAmount(Double.valueOf(map.get(prefix + "curPaymentsAmount")));
		}
		if (map.containsKey(prefix + "curPeriodAttempts")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setCurPeriodAttempts(Integer.valueOf(map.get(prefix + "curPeriodAttempts")));
		}
		if (map.containsKey(prefix + "curPeriodEndingDate")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setCurPeriodEndingDate(map.get(prefix + "curPeriodEndingDate"));
		}
		if (map.containsKey(prefix + "currencyCode")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setCurrencyCode(map.get(prefix + "currencyCode"));
		}
		if (map.containsKey(prefix + "dateOfMonth")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setDateOfMonth(Integer.valueOf(map.get(prefix + "dateOfMonth")));
		}
		if (map.containsKey(prefix + "dayOfWeek")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setDayOfWeek(DayOfWeek.fromValue(map.get(prefix + "dayOfWeek")));
		}
		if (map.containsKey(prefix + "endingDate")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setEndingDate(map.get(prefix + "endingDate"));
		}
		if (map.containsKey(prefix + "maxAmountPerPayment")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setMaxAmountPerPayment(Double.valueOf(map.get(prefix + "maxAmountPerPayment")));
		}
		if (map.containsKey(prefix + "maxNumberOfPayments")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setMaxNumberOfPayments(Integer.valueOf(map.get(prefix + "maxNumberOfPayments")));
		}
		if (map.containsKey(prefix + "maxNumberOfPaymentsPerPeriod")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setMaxNumberOfPaymentsPerPeriod(Integer.valueOf(map.get(prefix + "maxNumberOfPaymentsPerPeriod")));
		}
		if (map.containsKey(prefix + "maxTotalAmountOfAllPayments")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setMaxTotalAmountOfAllPayments(Double.valueOf(map.get(prefix + "maxTotalAmountOfAllPayments")));
		}
		if (map.containsKey(prefix + "paymentPeriod")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setPaymentPeriod(map.get(prefix + "paymentPeriod"));
		}
		if (map.containsKey(prefix + "pinType")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setPinType(map.get(prefix + "pinType"));
		}
		if (map.containsKey(prefix + "returnUrl")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setReturnUrl(map.get(prefix + "returnUrl"));
		}
		if (map.containsKey(prefix + "senderEmail")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setSenderEmail(map.get(prefix + "senderEmail"));
		}
		if (map.containsKey(prefix + "memo")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setMemo(map.get(prefix + "memo"));
		}
		if (map.containsKey(prefix + "startingDate")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setStartingDate(map.get(prefix + "startingDate"));
		}
		if (map.containsKey(prefix + "status")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setStatus(map.get(prefix + "status"));
		}
		if (map.containsKey(prefix + "ipnNotificationUrl")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setIpnNotificationUrl(map.get(prefix + "ipnNotificationUrl"));
		}
		AddressList addressList =  AddressList.createInstance(map, prefix + "addressList", -1);
		if (addressList != null) {
			preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
			preapprovalDetailsResponse.setAddressList(addressList);
		}
		if (map.containsKey(prefix + "feesPayer")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setFeesPayer(map.get(prefix + "feesPayer"));
		}
		if (map.containsKey(prefix + "displayMaxTotalAmount")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setDisplayMaxTotalAmount(Boolean.valueOf(map.get(prefix + "displayMaxTotalAmount")));
		}
		SenderIdentifier sender =  SenderIdentifier.createInstance(map, prefix + "sender", -1);
		if (sender != null) {
			preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
			preapprovalDetailsResponse.setSender(sender);
		}
		if (map.containsKey(prefix + "agreementType")) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.setAgreementType(AgreementType.fromValue(map.get(prefix + "agreementType")));
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				preapprovalDetailsResponse = (preapprovalDetailsResponse == null) ? new PreapprovalDetailsResponse() : preapprovalDetailsResponse;
				preapprovalDetailsResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return preapprovalDetailsResponse;
	}
 
}