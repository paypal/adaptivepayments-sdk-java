package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.ap.Receiver;
import com.paypal.svcs.types.ap.ErrorList;
import java.util.Map;

/**
 * RefundInfo represents the refund attempt made to a Receiver
 * of a PayRequest. 
 */
public class RefundInfo{


	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private Receiver receiver;

	/**
	 * No Document Comments	 
	 */ 
	private String refundStatus;

	/**
	 * No Document Comments	 
	 */ 
	private Double refundNetAmount;

	/**
	 * No Document Comments	 
	 */ 
	private Double refundFeeAmount;

	/**
	 * No Document Comments	 
	 */ 
	private Double refundGrossAmount;

	/**
	 * No Document Comments	 
	 */ 
	private Double totalOfAllRefunds;

	/**
	 * No Document Comments	 
	 */ 
	private Boolean refundHasBecomeFull;

	/**
	 * No Document Comments	 
	 */ 
	private String encryptedRefundTransactionId;

	/**
	 * No Document Comments	 
	 */ 
	private String refundTransactionStatus;

	/**
	 * No Document Comments	 
	 */ 
	private ErrorList errorList;

	

	/**
	 * Default Constructor
	 */
	public RefundInfo (){
	}	

	/**
	 * Getter for receiver
	 */
	 public Receiver getReceiver() {
	 	return receiver;
	 }
	 
	/**
	 * Setter for receiver
	 */
	 public void setReceiver(Receiver receiver) {
	 	this.receiver = receiver;
	 }
	 
	/**
	 * Getter for refundStatus
	 */
	 public String getRefundStatus() {
	 	return refundStatus;
	 }
	 
	/**
	 * Setter for refundStatus
	 */
	 public void setRefundStatus(String refundStatus) {
	 	this.refundStatus = refundStatus;
	 }
	 
	/**
	 * Getter for refundNetAmount
	 */
	 public Double getRefundNetAmount() {
	 	return refundNetAmount;
	 }
	 
	/**
	 * Setter for refundNetAmount
	 */
	 public void setRefundNetAmount(Double refundNetAmount) {
	 	this.refundNetAmount = refundNetAmount;
	 }
	 
	/**
	 * Getter for refundFeeAmount
	 */
	 public Double getRefundFeeAmount() {
	 	return refundFeeAmount;
	 }
	 
	/**
	 * Setter for refundFeeAmount
	 */
	 public void setRefundFeeAmount(Double refundFeeAmount) {
	 	this.refundFeeAmount = refundFeeAmount;
	 }
	 
	/**
	 * Getter for refundGrossAmount
	 */
	 public Double getRefundGrossAmount() {
	 	return refundGrossAmount;
	 }
	 
	/**
	 * Setter for refundGrossAmount
	 */
	 public void setRefundGrossAmount(Double refundGrossAmount) {
	 	this.refundGrossAmount = refundGrossAmount;
	 }
	 
	/**
	 * Getter for totalOfAllRefunds
	 */
	 public Double getTotalOfAllRefunds() {
	 	return totalOfAllRefunds;
	 }
	 
	/**
	 * Setter for totalOfAllRefunds
	 */
	 public void setTotalOfAllRefunds(Double totalOfAllRefunds) {
	 	this.totalOfAllRefunds = totalOfAllRefunds;
	 }
	 
	/**
	 * Getter for refundHasBecomeFull
	 */
	 public Boolean getRefundHasBecomeFull() {
	 	return refundHasBecomeFull;
	 }
	 
	/**
	 * Setter for refundHasBecomeFull
	 */
	 public void setRefundHasBecomeFull(Boolean refundHasBecomeFull) {
	 	this.refundHasBecomeFull = refundHasBecomeFull;
	 }
	 
	/**
	 * Getter for encryptedRefundTransactionId
	 */
	 public String getEncryptedRefundTransactionId() {
	 	return encryptedRefundTransactionId;
	 }
	 
	/**
	 * Setter for encryptedRefundTransactionId
	 */
	 public void setEncryptedRefundTransactionId(String encryptedRefundTransactionId) {
	 	this.encryptedRefundTransactionId = encryptedRefundTransactionId;
	 }
	 
	/**
	 * Getter for refundTransactionStatus
	 */
	 public String getRefundTransactionStatus() {
	 	return refundTransactionStatus;
	 }
	 
	/**
	 * Setter for refundTransactionStatus
	 */
	 public void setRefundTransactionStatus(String refundTransactionStatus) {
	 	this.refundTransactionStatus = refundTransactionStatus;
	 }
	 
	/**
	 * Getter for errorList
	 */
	 public ErrorList getErrorList() {
	 	return errorList;
	 }
	 
	/**
	 * Setter for errorList
	 */
	 public void setErrorList(ErrorList errorList) {
	 	this.errorList = errorList;
	 }
	 


	public RefundInfo(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "receiver" + ".amount")){
			String newPrefix = prefix + "receiver" + ".";
			this.receiver =  new Receiver(map, newPrefix);
		}
		if(map.containsKey(prefix + "refundStatus")){
			this.refundStatus = map.get(prefix + "refundStatus");
		}
		if(map.containsKey(prefix + "refundNetAmount")){
			this.refundNetAmount = Double.valueOf(map.get(prefix + "refundNetAmount"));
		}
		if(map.containsKey(prefix + "refundFeeAmount")){
			this.refundFeeAmount = Double.valueOf(map.get(prefix + "refundFeeAmount"));
		}
		if(map.containsKey(prefix + "refundGrossAmount")){
			this.refundGrossAmount = Double.valueOf(map.get(prefix + "refundGrossAmount"));
		}
		if(map.containsKey(prefix + "totalOfAllRefunds")){
			this.totalOfAllRefunds = Double.valueOf(map.get(prefix + "totalOfAllRefunds"));
		}
		if(map.containsKey(prefix + "refundHasBecomeFull")){
			this.refundHasBecomeFull = Boolean.valueOf(map.get(prefix + "refundHasBecomeFull"));
		}
		if(map.containsKey(prefix + "encryptedRefundTransactionId")){
			this.encryptedRefundTransactionId = map.get(prefix + "encryptedRefundTransactionId");
		}
		if(map.containsKey(prefix + "refundTransactionStatus")){
			this.refundTransactionStatus = map.get(prefix + "refundTransactionStatus");
		}
		if(map.containsKey(prefix + "errorList" + ".error(0).parameter(0)")){
			String newPrefix = prefix + "errorList" + ".";
			this.errorList =  new ErrorList(map, newPrefix);
		}
	}

}