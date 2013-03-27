package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.CurrencyType;
import com.paypal.svcs.types.ap.FeeDisclosure;
import java.util.Map;

/**
 *  SenderDisclosure contains the disclosure related to Sender 
 */
public class SenderDisclosure{


	/**
	*  	  
	 *@Required	 
	 */ 
	private CurrencyType amountToTransfer;

	/**
	*  	 
	 */ 
	private FeeDisclosure feeDisclosure;

	/**
	*  	  
	 *@Required	 
	 */ 
	private CurrencyType totalAmountToTransfer;

	

	/**
	 * Default Constructor
	 */
	public SenderDisclosure (){
	}	

	/**
	 * Getter for amountToTransfer
	 */
	 public CurrencyType getAmountToTransfer() {
	 	return amountToTransfer;
	 }
	 
	/**
	 * Setter for amountToTransfer
	 */
	 public void setAmountToTransfer(CurrencyType amountToTransfer) {
	 	this.amountToTransfer = amountToTransfer;
	 }
	 
	/**
	 * Getter for feeDisclosure
	 */
	 public FeeDisclosure getFeeDisclosure() {
	 	return feeDisclosure;
	 }
	 
	/**
	 * Setter for feeDisclosure
	 */
	 public void setFeeDisclosure(FeeDisclosure feeDisclosure) {
	 	this.feeDisclosure = feeDisclosure;
	 }
	 
	/**
	 * Getter for totalAmountToTransfer
	 */
	 public CurrencyType getTotalAmountToTransfer() {
	 	return totalAmountToTransfer;
	 }
	 
	/**
	 * Setter for totalAmountToTransfer
	 */
	 public void setTotalAmountToTransfer(CurrencyType totalAmountToTransfer) {
	 	this.totalAmountToTransfer = totalAmountToTransfer;
	 }
	 


	
	public static SenderDisclosure createInstance(Map<String, String> map, String prefix, int index) {
		SenderDisclosure senderDisclosure = null;
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
			
		CurrencyType amountToTransfer =  CurrencyType.createInstance(map, prefix + "amountToTransfer", -1);
		if (amountToTransfer != null) {
			senderDisclosure = (senderDisclosure == null) ? new SenderDisclosure() : senderDisclosure;
			senderDisclosure.setAmountToTransfer(amountToTransfer);
		}
		FeeDisclosure feeDisclosure =  FeeDisclosure.createInstance(map, prefix + "feeDisclosure", -1);
		if (feeDisclosure != null) {
			senderDisclosure = (senderDisclosure == null) ? new SenderDisclosure() : senderDisclosure;
			senderDisclosure.setFeeDisclosure(feeDisclosure);
		}
		CurrencyType totalAmountToTransfer =  CurrencyType.createInstance(map, prefix + "totalAmountToTransfer", -1);
		if (totalAmountToTransfer != null) {
			senderDisclosure = (senderDisclosure == null) ? new SenderDisclosure() : senderDisclosure;
			senderDisclosure.setTotalAmountToTransfer(totalAmountToTransfer);
		}
		return senderDisclosure;
	}
 
}