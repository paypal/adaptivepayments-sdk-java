package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.ap.Receiver;
import java.util.Map;

/**
 * PaymentInfo represents the payment attempt made to a
 * Receiver of a PayRequest. If the execution of the payment
 * has not yet completed, there will not be any transaction
 * details. 
 */
public class PaymentInfo{


	/**
	 * 	 
	 */ 
	private String transactionId;

	/**
	 * 	 
	 */ 
	private String transactionStatus;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private Receiver receiver;

	/**
	 * 	 
	 */ 
	private Double refundedAmount;

	/**
	 * 	 
	 */ 
	private Boolean pendingRefund;

	/**
	 * 	 
	 */ 
	private String senderTransactionId;

	/**
	 * 	 
	 */ 
	private String senderTransactionStatus;

	/**
	 * 	 
	 */ 
	private String pendingReason;

	

	/**
	 * Default Constructor
	 */
	public PaymentInfo (){
	}	

	/**
	 * Getter for transactionId
	 */
	 public String getTransactionId() {
	 	return transactionId;
	 }
	 
	/**
	 * Setter for transactionId
	 */
	 public void setTransactionId(String transactionId) {
	 	this.transactionId = transactionId;
	 }
	 
	/**
	 * Getter for transactionStatus
	 */
	 public String getTransactionStatus() {
	 	return transactionStatus;
	 }
	 
	/**
	 * Setter for transactionStatus
	 */
	 public void setTransactionStatus(String transactionStatus) {
	 	this.transactionStatus = transactionStatus;
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
	 * Getter for refundedAmount
	 */
	 public Double getRefundedAmount() {
	 	return refundedAmount;
	 }
	 
	/**
	 * Setter for refundedAmount
	 */
	 public void setRefundedAmount(Double refundedAmount) {
	 	this.refundedAmount = refundedAmount;
	 }
	 
	/**
	 * Getter for pendingRefund
	 */
	 public Boolean getPendingRefund() {
	 	return pendingRefund;
	 }
	 
	/**
	 * Setter for pendingRefund
	 */
	 public void setPendingRefund(Boolean pendingRefund) {
	 	this.pendingRefund = pendingRefund;
	 }
	 
	/**
	 * Getter for senderTransactionId
	 */
	 public String getSenderTransactionId() {
	 	return senderTransactionId;
	 }
	 
	/**
	 * Setter for senderTransactionId
	 */
	 public void setSenderTransactionId(String senderTransactionId) {
	 	this.senderTransactionId = senderTransactionId;
	 }
	 
	/**
	 * Getter for senderTransactionStatus
	 */
	 public String getSenderTransactionStatus() {
	 	return senderTransactionStatus;
	 }
	 
	/**
	 * Setter for senderTransactionStatus
	 */
	 public void setSenderTransactionStatus(String senderTransactionStatus) {
	 	this.senderTransactionStatus = senderTransactionStatus;
	 }
	 
	/**
	 * Getter for pendingReason
	 */
	 public String getPendingReason() {
	 	return pendingReason;
	 }
	 
	/**
	 * Setter for pendingReason
	 */
	 public void setPendingReason(String pendingReason) {
	 	this.pendingReason = pendingReason;
	 }
	 


	
	public static PaymentInfo createInstance(Map<String, String> map, String prefix, int index) {
		PaymentInfo paymentInfo = null;
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
			
		if (map.containsKey(prefix + "transactionId")) {
				paymentInfo = (paymentInfo == null) ? new PaymentInfo() : paymentInfo;
				paymentInfo.setTransactionId(map.get(prefix + "transactionId"));
		}
		if (map.containsKey(prefix + "transactionStatus")) {
				paymentInfo = (paymentInfo == null) ? new PaymentInfo() : paymentInfo;
				paymentInfo.setTransactionStatus(map.get(prefix + "transactionStatus"));
		}
		Receiver receiver =  Receiver.createInstance(map, prefix + "receiver", -1);
		if (receiver != null) {
			paymentInfo = (paymentInfo == null) ? new PaymentInfo() : paymentInfo;
			paymentInfo.setReceiver(receiver);
		}
		if (map.containsKey(prefix + "refundedAmount")) {
				paymentInfo = (paymentInfo == null) ? new PaymentInfo() : paymentInfo;
				paymentInfo.setRefundedAmount(Double.valueOf(map.get(prefix + "refundedAmount")));
		}
		if (map.containsKey(prefix + "pendingRefund")) {
				paymentInfo = (paymentInfo == null) ? new PaymentInfo() : paymentInfo;
				paymentInfo.setPendingRefund(Boolean.valueOf(map.get(prefix + "pendingRefund")));
		}
		if (map.containsKey(prefix + "senderTransactionId")) {
				paymentInfo = (paymentInfo == null) ? new PaymentInfo() : paymentInfo;
				paymentInfo.setSenderTransactionId(map.get(prefix + "senderTransactionId"));
		}
		if (map.containsKey(prefix + "senderTransactionStatus")) {
				paymentInfo = (paymentInfo == null) ? new PaymentInfo() : paymentInfo;
				paymentInfo.setSenderTransactionStatus(map.get(prefix + "senderTransactionStatus"));
		}
		if (map.containsKey(prefix + "pendingReason")) {
				paymentInfo = (paymentInfo == null) ? new PaymentInfo() : paymentInfo;
				paymentInfo.setPendingReason(map.get(prefix + "pendingReason"));
		}
		return paymentInfo;
	}
 
}