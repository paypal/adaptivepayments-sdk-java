package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.ResponseEnvelope;
import com.paypal.svcs.types.common.DayOfWeek;
import com.paypal.svcs.types.ap.AddressList;
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
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private Boolean approved;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String cancelUrl;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private Integer curPayments;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private Double curPaymentsAmount;

	/**
	 * No Document Comments	 
	 */ 
	private Integer curPeriodAttempts;

	/**
	 * No Document Comments	 
	 */ 
	private String curPeriodEndingDate;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String currencyCode;

	/**
	 * No Document Comments	 
	 */ 
	private Integer dateOfMonth;

	/**
	 * No Document Comments	 
	 */ 
	private DayOfWeek dayOfWeek;

	/**
	 * No Document Comments	 
	 */ 
	private String endingDate;

	/**
	 * No Document Comments	 
	 */ 
	private Double maxAmountPerPayment;

	/**
	 * No Document Comments	 
	 */ 
	private Integer maxNumberOfPayments;

	/**
	 * No Document Comments	 
	 */ 
	private Integer maxNumberOfPaymentsPerPeriod;

	/**
	 * No Document Comments	 
	 */ 
	private Double maxTotalAmountOfAllPayments;

	/**
	 * No Document Comments	 
	 */ 
	private String paymentPeriod;

	/**
	 * No Document Comments	 
	 */ 
	private String pinType;

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
	 */ 
	private String memo;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String startingDate;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String status;

	/**
	 * No Document Comments	 
	 */ 
	private String ipnNotificationUrl;

	/**
	 * No Document Comments	 
	 */ 
	private AddressList addressList;

	/**
	 * No Document Comments	 
	 */ 
	private String feesPayer;

	/**
	 * No Document Comments	 
	 */ 
	private Boolean displayMaxTotalAmount;

	/**
	 * No Document Comments	 
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
	 


	public PreapprovalDetailsResponse(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "responseEnvelope" + ".timestamp")){
			String newPrefix = prefix + "responseEnvelope" + ".";
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		if(map.containsKey(prefix + "approved")){
			this.approved = Boolean.valueOf(map.get(prefix + "approved"));
		}
		if(map.containsKey(prefix + "cancelUrl")){
			this.cancelUrl = map.get(prefix + "cancelUrl");
		}
		if(map.containsKey(prefix + "curPayments")){
			this.curPayments = Integer.valueOf(map.get(prefix + "curPayments"));
		}
		if(map.containsKey(prefix + "curPaymentsAmount")){
			this.curPaymentsAmount = Double.valueOf(map.get(prefix + "curPaymentsAmount"));
		}
		if(map.containsKey(prefix + "curPeriodAttempts")){
			this.curPeriodAttempts = Integer.valueOf(map.get(prefix + "curPeriodAttempts"));
		}
		if(map.containsKey(prefix + "curPeriodEndingDate")){
			this.curPeriodEndingDate = map.get(prefix + "curPeriodEndingDate");
		}
		if(map.containsKey(prefix + "currencyCode")){
			this.currencyCode = map.get(prefix + "currencyCode");
		}
		if(map.containsKey(prefix + "dateOfMonth")){
			this.dateOfMonth = Integer.valueOf(map.get(prefix + "dateOfMonth"));
		}
		if(map.containsKey(prefix + "dayOfWeek")){
			this.dayOfWeek = DayOfWeek.fromValue(map.get(prefix + "dayOfWeek"));
		}
		if(map.containsKey(prefix + "endingDate")){
			this.endingDate = map.get(prefix + "endingDate");
		}
		if(map.containsKey(prefix + "maxAmountPerPayment")){
			this.maxAmountPerPayment = Double.valueOf(map.get(prefix + "maxAmountPerPayment"));
		}
		if(map.containsKey(prefix + "maxNumberOfPayments")){
			this.maxNumberOfPayments = Integer.valueOf(map.get(prefix + "maxNumberOfPayments"));
		}
		if(map.containsKey(prefix + "maxNumberOfPaymentsPerPeriod")){
			this.maxNumberOfPaymentsPerPeriod = Integer.valueOf(map.get(prefix + "maxNumberOfPaymentsPerPeriod"));
		}
		if(map.containsKey(prefix + "maxTotalAmountOfAllPayments")){
			this.maxTotalAmountOfAllPayments = Double.valueOf(map.get(prefix + "maxTotalAmountOfAllPayments"));
		}
		if(map.containsKey(prefix + "paymentPeriod")){
			this.paymentPeriod = map.get(prefix + "paymentPeriod");
		}
		if(map.containsKey(prefix + "pinType")){
			this.pinType = map.get(prefix + "pinType");
		}
		if(map.containsKey(prefix + "returnUrl")){
			this.returnUrl = map.get(prefix + "returnUrl");
		}
		if(map.containsKey(prefix + "senderEmail")){
			this.senderEmail = map.get(prefix + "senderEmail");
		}
		if(map.containsKey(prefix + "memo")){
			this.memo = map.get(prefix + "memo");
		}
		if(map.containsKey(prefix + "startingDate")){
			this.startingDate = map.get(prefix + "startingDate");
		}
		if(map.containsKey(prefix + "status")){
			this.status = map.get(prefix + "status");
		}
		if(map.containsKey(prefix + "ipnNotificationUrl")){
			this.ipnNotificationUrl = map.get(prefix + "ipnNotificationUrl");
		}
		if(map.containsKey(prefix + "addressList" + ".address(0).baseAddress.line1")){
			String newPrefix = prefix + "addressList" + ".";
			this.addressList =  new AddressList(map, newPrefix);
		}
		if(map.containsKey(prefix + "feesPayer")){
			this.feesPayer = map.get(prefix + "feesPayer");
		}
		if(map.containsKey(prefix + "displayMaxTotalAmount")){
			this.displayMaxTotalAmount = Boolean.valueOf(map.get(prefix + "displayMaxTotalAmount"));
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