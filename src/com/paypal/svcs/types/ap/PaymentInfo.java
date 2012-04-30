
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.Receiver;
import java.util.Map;


/**
 * PaymentInfo represents the payment attempt made
 * to a Receiver of a PayRequest. If the execution
 * of the payment has not yet completed, there will
 * not be any transaction details.
 */
public class PaymentInfo {

	/**
	 */
	private String transactionId;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String value) {
		this.transactionId = value;
	}

	/**
	 */
	private String transactionStatus;
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String value) {
		this.transactionStatus = value;
	}

	/**
	 *
	 * @Required
	 */
	private Receiver receiver;
	public Receiver getReceiver() {
		return receiver;
	}
	public void setReceiver(Receiver value) {
		this.receiver = value;
	}

	/**
	 */
	private Double refundedAmount;
	public Double getRefundedAmount() {
		return refundedAmount;
	}
	public void setRefundedAmount(Double value) {
		this.refundedAmount = value;
	}

	/**
	 */
	private Boolean pendingRefund;
	public Boolean getPendingRefund() {
		return pendingRefund;
	}
	public void setPendingRefund(Boolean value) {
		this.pendingRefund = value;
	}

	/**
	 */
	private String senderTransactionId;
	public String getSenderTransactionId() {
		return senderTransactionId;
	}
	public void setSenderTransactionId(String value) {
		this.senderTransactionId = value;
	}

	/**
	 */
	private String senderTransactionStatus;
	public String getSenderTransactionStatus() {
		return senderTransactionStatus;
	}
	public void setSenderTransactionStatus(String value) {
		this.senderTransactionStatus = value;
	}

	/**
	 */
	private String pendingReason;
	public String getPendingReason() {
		return pendingReason;
	}
	public void setPendingReason(String value) {
		this.pendingReason = value;
	}


	public PaymentInfo() {
	}
	public PaymentInfo(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "transactionId") ) {
			this.transactionId = map.get(prefix + "transactionId");
		}
		if( map.containsKey(prefix + "transactionStatus") ) {
			this.transactionStatus = map.get(prefix + "transactionStatus");
		}
		if( map.containsKey(prefix + "receiver" + ".amount") ) {
			String newPrefix = prefix + "receiver" + '.';
			this.receiver =  new Receiver(map, newPrefix);
		}
		if( map.containsKey(prefix + "refundedAmount") ) {
			this.refundedAmount = Double.valueOf(map.get(prefix + "refundedAmount"));
		}
		if( map.containsKey(prefix + "pendingRefund") ) {
			this.pendingRefund = Boolean.valueOf(map.get(prefix + "pendingRefund"));
		}
		if( map.containsKey(prefix + "senderTransactionId") ) {
			this.senderTransactionId = map.get(prefix + "senderTransactionId");
		}
		if( map.containsKey(prefix + "senderTransactionStatus") ) {
			this.senderTransactionStatus = map.get(prefix + "senderTransactionStatus");
		}
		if( map.containsKey(prefix + "pendingReason") ) {
			this.pendingReason = map.get(prefix + "pendingReason");
		}
	}
}
