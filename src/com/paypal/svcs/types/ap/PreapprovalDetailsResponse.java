
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.AddressList;
import com.paypal.svcs.types.common.DayOfWeek;
import com.paypal.svcs.types.common.ErrorData;
import com.paypal.svcs.types.common.ResponseEnvelope;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * The details of the Preapproval as specified in
 * the Preapproval operation.
 */
public class PreapprovalDetailsResponse {

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
	private Boolean approved;
	public Boolean getApproved() {
		return approved;
	}
	public void setApproved(Boolean value) {
		this.approved = value;
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
	private Integer curPayments;
	public Integer getCurPayments() {
		return curPayments;
	}
	public void setCurPayments(Integer value) {
		this.curPayments = value;
	}

	/**
	 *
	 * @Required
	 */
	private Double curPaymentsAmount;
	public Double getCurPaymentsAmount() {
		return curPaymentsAmount;
	}
	public void setCurPaymentsAmount(Double value) {
		this.curPaymentsAmount = value;
	}

	/**
	 */
	private Integer curPeriodAttempts;
	public Integer getCurPeriodAttempts() {
		return curPeriodAttempts;
	}
	public void setCurPeriodAttempts(Integer value) {
		this.curPeriodAttempts = value;
	}

	/**
	 */
	private String curPeriodEndingDate;
	public String getCurPeriodEndingDate() {
		return curPeriodEndingDate;
	}
	public void setCurPeriodEndingDate(String value) {
		this.curPeriodEndingDate = value;
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
	 */
	private String pinType;
	public String getPinType() {
		return pinType;
	}
	public void setPinType(String value) {
		this.pinType = value;
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
	private String startingDate;
	public String getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(String value) {
		this.startingDate = value;
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
	private String ipnNotificationUrl;
	public String getIpnNotificationUrl() {
		return ipnNotificationUrl;
	}
	public void setIpnNotificationUrl(String value) {
		this.ipnNotificationUrl = value;
	}

	/**
	 */
	private AddressList addressList;
	public AddressList getAddressList() {
		return addressList;
	}
	public void setAddressList(AddressList value) {
		this.addressList = value;
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

	/**
	 */
	private List<ErrorData> error = new ArrayList<ErrorData>();
	public List<ErrorData> getError() {
		return error;
	}
	public void setError(List<ErrorData> value) {
		this.error = value;
	}


	public PreapprovalDetailsResponse() {
	}
	public PreapprovalDetailsResponse(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "responseEnvelope" + ".timestamp") ) {
			String newPrefix = prefix + "responseEnvelope" + '.';
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		if( map.containsKey(prefix + "approved") ) {
			this.approved = Boolean.valueOf(map.get(prefix + "approved"));
		}
		if( map.containsKey(prefix + "cancelUrl") ) {
			this.cancelUrl = map.get(prefix + "cancelUrl");
		}
		if( map.containsKey(prefix + "curPayments") ) {
			this.curPayments = Integer.valueOf(map.get(prefix + "curPayments"));
		}
		if( map.containsKey(prefix + "curPaymentsAmount") ) {
			this.curPaymentsAmount = Double.valueOf(map.get(prefix + "curPaymentsAmount"));
		}
		if( map.containsKey(prefix + "curPeriodAttempts") ) {
			this.curPeriodAttempts = Integer.valueOf(map.get(prefix + "curPeriodAttempts"));
		}
		if( map.containsKey(prefix + "curPeriodEndingDate") ) {
			this.curPeriodEndingDate = map.get(prefix + "curPeriodEndingDate");
		}
		if( map.containsKey(prefix + "currencyCode") ) {
			this.currencyCode = map.get(prefix + "currencyCode");
		}
		if( map.containsKey(prefix + "dateOfMonth") ) {
			this.dateOfMonth = Integer.valueOf(map.get(prefix + "dateOfMonth"));
		}
		if( map.containsKey(prefix + "dayOfWeek") ) {
			this.dayOfWeek = DayOfWeek.fromValue( map.get(prefix + "dayOfWeek") );
		}
		if( map.containsKey(prefix + "endingDate") ) {
			this.endingDate = map.get(prefix + "endingDate");
		}
		if( map.containsKey(prefix + "maxAmountPerPayment") ) {
			this.maxAmountPerPayment = Double.valueOf(map.get(prefix + "maxAmountPerPayment"));
		}
		if( map.containsKey(prefix + "maxNumberOfPayments") ) {
			this.maxNumberOfPayments = Integer.valueOf(map.get(prefix + "maxNumberOfPayments"));
		}
		if( map.containsKey(prefix + "maxNumberOfPaymentsPerPeriod") ) {
			this.maxNumberOfPaymentsPerPeriod = Integer.valueOf(map.get(prefix + "maxNumberOfPaymentsPerPeriod"));
		}
		if( map.containsKey(prefix + "maxTotalAmountOfAllPayments") ) {
			this.maxTotalAmountOfAllPayments = Double.valueOf(map.get(prefix + "maxTotalAmountOfAllPayments"));
		}
		if( map.containsKey(prefix + "paymentPeriod") ) {
			this.paymentPeriod = map.get(prefix + "paymentPeriod");
		}
		if( map.containsKey(prefix + "pinType") ) {
			this.pinType = map.get(prefix + "pinType");
		}
		if( map.containsKey(prefix + "returnUrl") ) {
			this.returnUrl = map.get(prefix + "returnUrl");
		}
		if( map.containsKey(prefix + "senderEmail") ) {
			this.senderEmail = map.get(prefix + "senderEmail");
		}
		if( map.containsKey(prefix + "memo") ) {
			this.memo = map.get(prefix + "memo");
		}
		if( map.containsKey(prefix + "startingDate") ) {
			this.startingDate = map.get(prefix + "startingDate");
		}
		if( map.containsKey(prefix + "status") ) {
			this.status = map.get(prefix + "status");
		}
		if( map.containsKey(prefix + "ipnNotificationUrl") ) {
			this.ipnNotificationUrl = map.get(prefix + "ipnNotificationUrl");
		}
		if( map.containsKey(prefix + "addressList" + ".address(0).addresseeName") ) {
			String newPrefix = prefix + "addressList" + '.';
			this.addressList =  new AddressList(map, newPrefix);
		}
		if( map.containsKey(prefix + "feesPayer") ) {
			this.feesPayer = map.get(prefix + "feesPayer");
		}
		if( map.containsKey(prefix + "displayMaxTotalAmount") ) {
			this.displayMaxTotalAmount = Boolean.valueOf(map.get(prefix + "displayMaxTotalAmount"));
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
