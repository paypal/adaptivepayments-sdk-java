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
	 * 	  
	 *@Required	 
	 */ 
	private Receiver receiver;

	/**
	 * 	 
	 */ 
	private String refundStatus;

	/**
	 * 	 
	 */ 
	private Double refundNetAmount;

	/**
	 * 	 
	 */ 
	private Double refundFeeAmount;

	/**
	 * 	 
	 */ 
	private Double refundGrossAmount;

	/**
	 * 	 
	 */ 
	private Double totalOfAllRefunds;

	/**
	 * 	 
	 */ 
	private Boolean refundHasBecomeFull;

	/**
	 * 	 
	 */ 
	private String encryptedRefundTransactionId;

	/**
	 * 	 
	 */ 
	private String refundTransactionStatus;

	/**
	 * 	 
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
	 


	
	public static RefundInfo createInstance(Map<String, String> map, String prefix, int index) {
		RefundInfo refundInfo = null;
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
			
		Receiver receiver =  Receiver.createInstance(map, prefix + "receiver", -1);
		if (receiver != null) {
			refundInfo = (refundInfo == null) ? new RefundInfo() : refundInfo;
			refundInfo.setReceiver(receiver);
		}
		if (map.containsKey(prefix + "refundStatus")) {
				refundInfo = (refundInfo == null) ? new RefundInfo() : refundInfo;
				refundInfo.setRefundStatus(map.get(prefix + "refundStatus"));
		}
		if (map.containsKey(prefix + "refundNetAmount")) {
				refundInfo = (refundInfo == null) ? new RefundInfo() : refundInfo;
				refundInfo.setRefundNetAmount(Double.valueOf(map.get(prefix + "refundNetAmount")));
		}
		if (map.containsKey(prefix + "refundFeeAmount")) {
				refundInfo = (refundInfo == null) ? new RefundInfo() : refundInfo;
				refundInfo.setRefundFeeAmount(Double.valueOf(map.get(prefix + "refundFeeAmount")));
		}
		if (map.containsKey(prefix + "refundGrossAmount")) {
				refundInfo = (refundInfo == null) ? new RefundInfo() : refundInfo;
				refundInfo.setRefundGrossAmount(Double.valueOf(map.get(prefix + "refundGrossAmount")));
		}
		if (map.containsKey(prefix + "totalOfAllRefunds")) {
				refundInfo = (refundInfo == null) ? new RefundInfo() : refundInfo;
				refundInfo.setTotalOfAllRefunds(Double.valueOf(map.get(prefix + "totalOfAllRefunds")));
		}
		if (map.containsKey(prefix + "refundHasBecomeFull")) {
				refundInfo = (refundInfo == null) ? new RefundInfo() : refundInfo;
				refundInfo.setRefundHasBecomeFull(Boolean.valueOf(map.get(prefix + "refundHasBecomeFull")));
		}
		if (map.containsKey(prefix + "encryptedRefundTransactionId")) {
				refundInfo = (refundInfo == null) ? new RefundInfo() : refundInfo;
				refundInfo.setEncryptedRefundTransactionId(map.get(prefix + "encryptedRefundTransactionId"));
		}
		if (map.containsKey(prefix + "refundTransactionStatus")) {
				refundInfo = (refundInfo == null) ? new RefundInfo() : refundInfo;
				refundInfo.setRefundTransactionStatus(map.get(prefix + "refundTransactionStatus"));
		}
		ErrorList errorList =  ErrorList.createInstance(map, prefix + "errorList", -1);
		if (errorList != null) {
			refundInfo = (refundInfo == null) ? new RefundInfo() : refundInfo;
			refundInfo.setErrorList(errorList);
		}
		return refundInfo;
	}
 
}