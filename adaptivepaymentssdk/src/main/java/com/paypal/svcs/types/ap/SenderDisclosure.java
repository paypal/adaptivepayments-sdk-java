package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.CurrencyType;
import com.paypal.svcs.types.ap.FeeDisclosure;
import com.paypal.svcs.types.ap.ConversionRate;
import java.util.Map;

/**
 * SenderDisclosure contains the disclosure related to Sender 
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
	 * 	  
	 *@Required	 
	 */ 
	private ConversionRate conversionRate;

	

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
	 
	/**
	 * Getter for conversionRate
	 */
	 public ConversionRate getConversionRate() {
	 	return conversionRate;
	 }
	 
	/**
	 * Setter for conversionRate
	 */
	 public void setConversionRate(ConversionRate conversionRate) {
	 	this.conversionRate = conversionRate;
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
		ConversionRate conversionRate =  ConversionRate.createInstance(map, prefix + "conversionRate", -1);
		if (conversionRate != null) {
			senderDisclosure = (senderDisclosure == null) ? new SenderDisclosure() : senderDisclosure;
			senderDisclosure.setConversionRate(conversionRate);
		}
		return senderDisclosure;
	}
 
}