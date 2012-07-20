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
	 * No Document Comments	 
	 */ 
	private String transactionId;

	/**
	 * No Document Comments	 
	 */ 
	private String transactionStatus;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private Receiver receiver;

	/**
	 * No Document Comments	 
	 */ 
	private Double refundedAmount;

	/**
	 * No Document Comments	 
	 */ 
	private Boolean pendingRefund;

	/**
	 * No Document Comments	 
	 */ 
	private String senderTransactionId;

	/**
	 * No Document Comments	 
	 */ 
	private String senderTransactionStatus;

	/**
	 * No Document Comments	 
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
	 


	public PaymentInfo(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "transactionId")){
			this.transactionId = map.get(prefix + "transactionId");
		}
		if(map.containsKey(prefix + "transactionStatus")){
			this.transactionStatus = map.get(prefix + "transactionStatus");
		}
		if(map.containsKey(prefix + "receiver" + ".amount")){
			String newPrefix = prefix + "receiver" + ".";
			this.receiver =  new Receiver(map, newPrefix);
		}
		if(map.containsKey(prefix + "refundedAmount")){
			this.refundedAmount = Double.valueOf(map.get(prefix + "refundedAmount"));
		}
		if(map.containsKey(prefix + "pendingRefund")){
			this.pendingRefund = Boolean.valueOf(map.get(prefix + "pendingRefund"));
		}
		if(map.containsKey(prefix + "senderTransactionId")){
			this.senderTransactionId = map.get(prefix + "senderTransactionId");
		}
		if(map.containsKey(prefix + "senderTransactionStatus")){
			this.senderTransactionStatus = map.get(prefix + "senderTransactionStatus");
		}
		if(map.containsKey(prefix + "pendingReason")){
			this.pendingReason = map.get(prefix + "pendingReason");
		}
	}

}