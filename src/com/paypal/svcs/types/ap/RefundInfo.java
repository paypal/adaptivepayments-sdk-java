
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.ErrorList;
import com.paypal.svcs.types.ap.Receiver;
import java.util.Map;


/**
 * RefundInfo represents the refund attempt made to
 * a Receiver of a PayRequest.
 */
public class RefundInfo {

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
	private String refundStatus;
	public String getRefundStatus() {
		return refundStatus;
	}
	public void setRefundStatus(String value) {
		this.refundStatus = value;
	}

	/**
	 */
	private Double refundNetAmount;
	public Double getRefundNetAmount() {
		return refundNetAmount;
	}
	public void setRefundNetAmount(Double value) {
		this.refundNetAmount = value;
	}

	/**
	 */
	private Double refundFeeAmount;
	public Double getRefundFeeAmount() {
		return refundFeeAmount;
	}
	public void setRefundFeeAmount(Double value) {
		this.refundFeeAmount = value;
	}

	/**
	 */
	private Double refundGrossAmount;
	public Double getRefundGrossAmount() {
		return refundGrossAmount;
	}
	public void setRefundGrossAmount(Double value) {
		this.refundGrossAmount = value;
	}

	/**
	 */
	private Double totalOfAllRefunds;
	public Double getTotalOfAllRefunds() {
		return totalOfAllRefunds;
	}
	public void setTotalOfAllRefunds(Double value) {
		this.totalOfAllRefunds = value;
	}

	/**
	 */
	private Boolean refundHasBecomeFull;
	public Boolean getRefundHasBecomeFull() {
		return refundHasBecomeFull;
	}
	public void setRefundHasBecomeFull(Boolean value) {
		this.refundHasBecomeFull = value;
	}

	/**
	 */
	private String encryptedRefundTransactionId;
	public String getEncryptedRefundTransactionId() {
		return encryptedRefundTransactionId;
	}
	public void setEncryptedRefundTransactionId(String value) {
		this.encryptedRefundTransactionId = value;
	}

	/**
	 */
	private String refundTransactionStatus;
	public String getRefundTransactionStatus() {
		return refundTransactionStatus;
	}
	public void setRefundTransactionStatus(String value) {
		this.refundTransactionStatus = value;
	}

	/**
	 */
	private ErrorList errorList;
	public ErrorList getErrorList() {
		return errorList;
	}
	public void setErrorList(ErrorList value) {
		this.errorList = value;
	}


	public RefundInfo() {
	}
	public RefundInfo(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "receiver" + ".amount") ) {
			String newPrefix = prefix + "receiver" + '.';
			this.receiver =  new Receiver(map, newPrefix);
		}
		if( map.containsKey(prefix + "refundStatus") ) {
			this.refundStatus = map.get(prefix + "refundStatus");
		}
		if( map.containsKey(prefix + "refundNetAmount") ) {
			this.refundNetAmount = Double.valueOf(map.get(prefix + "refundNetAmount"));
		}
		if( map.containsKey(prefix + "refundFeeAmount") ) {
			this.refundFeeAmount = Double.valueOf(map.get(prefix + "refundFeeAmount"));
		}
		if( map.containsKey(prefix + "refundGrossAmount") ) {
			this.refundGrossAmount = Double.valueOf(map.get(prefix + "refundGrossAmount"));
		}
		if( map.containsKey(prefix + "totalOfAllRefunds") ) {
			this.totalOfAllRefunds = Double.valueOf(map.get(prefix + "totalOfAllRefunds"));
		}
		if( map.containsKey(prefix + "refundHasBecomeFull") ) {
			this.refundHasBecomeFull = Boolean.valueOf(map.get(prefix + "refundHasBecomeFull"));
		}
		if( map.containsKey(prefix + "encryptedRefundTransactionId") ) {
			this.encryptedRefundTransactionId = map.get(prefix + "encryptedRefundTransactionId");
		}
		if( map.containsKey(prefix + "refundTransactionStatus") ) {
			this.refundTransactionStatus = map.get(prefix + "refundTransactionStatus");
		}
		if( map.containsKey(prefix + "errorList" + ".error(0).errorId") ) {
			String newPrefix = prefix + "errorList" + '.';
			this.errorList =  new ErrorList(map, newPrefix);
		}
	}
}
