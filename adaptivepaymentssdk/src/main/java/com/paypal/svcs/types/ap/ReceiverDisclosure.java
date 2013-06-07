package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.AccountIdentifier;
import com.paypal.svcs.types.common.CurrencyType;
import com.paypal.svcs.types.ap.ConversionRate;
import com.paypal.svcs.types.ap.FeeDisclosure;
import java.util.Map;

/**
 * ReceiverDisclosure contains the disclosure related to
 * Receiver/Receivers. 
 */
public class ReceiverDisclosure{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private AccountIdentifier accountIdentifier;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private CurrencyType amountReceivedFromSender;

	/**
	 * The two-character ISO country code of the home country of
	 * the Receiver 	  
	 *@Required	 
	 */ 
	private String countryCode;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private ConversionRate conversionRate;

	/**
	 * 	 
	 */ 
	private FeeDisclosure feeDisclosure;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private CurrencyType totalAmountReceived;

	

	/**
	 * Default Constructor
	 */
	public ReceiverDisclosure (){
	}	

	/**
	 * Getter for accountIdentifier
	 */
	 public AccountIdentifier getAccountIdentifier() {
	 	return accountIdentifier;
	 }
	 
	/**
	 * Setter for accountIdentifier
	 */
	 public void setAccountIdentifier(AccountIdentifier accountIdentifier) {
	 	this.accountIdentifier = accountIdentifier;
	 }
	 
	/**
	 * Getter for amountReceivedFromSender
	 */
	 public CurrencyType getAmountReceivedFromSender() {
	 	return amountReceivedFromSender;
	 }
	 
	/**
	 * Setter for amountReceivedFromSender
	 */
	 public void setAmountReceivedFromSender(CurrencyType amountReceivedFromSender) {
	 	this.amountReceivedFromSender = amountReceivedFromSender;
	 }
	 
	/**
	 * Getter for countryCode
	 */
	 public String getCountryCode() {
	 	return countryCode;
	 }
	 
	/**
	 * Setter for countryCode
	 */
	 public void setCountryCode(String countryCode) {
	 	this.countryCode = countryCode;
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
	 * Getter for totalAmountReceived
	 */
	 public CurrencyType getTotalAmountReceived() {
	 	return totalAmountReceived;
	 }
	 
	/**
	 * Setter for totalAmountReceived
	 */
	 public void setTotalAmountReceived(CurrencyType totalAmountReceived) {
	 	this.totalAmountReceived = totalAmountReceived;
	 }
	 


	
	public static ReceiverDisclosure createInstance(Map<String, String> map, String prefix, int index) {
		ReceiverDisclosure receiverDisclosure = null;
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
			
		AccountIdentifier accountIdentifier =  AccountIdentifier.createInstance(map, prefix + "accountIdentifier", -1);
		if (accountIdentifier != null) {
			receiverDisclosure = (receiverDisclosure == null) ? new ReceiverDisclosure() : receiverDisclosure;
			receiverDisclosure.setAccountIdentifier(accountIdentifier);
		}
		CurrencyType amountReceivedFromSender =  CurrencyType.createInstance(map, prefix + "amountReceivedFromSender", -1);
		if (amountReceivedFromSender != null) {
			receiverDisclosure = (receiverDisclosure == null) ? new ReceiverDisclosure() : receiverDisclosure;
			receiverDisclosure.setAmountReceivedFromSender(amountReceivedFromSender);
		}
		if (map.containsKey(prefix + "countryCode")) {
				receiverDisclosure = (receiverDisclosure == null) ? new ReceiverDisclosure() : receiverDisclosure;
				receiverDisclosure.setCountryCode(map.get(prefix + "countryCode"));
		}
		ConversionRate conversionRate =  ConversionRate.createInstance(map, prefix + "conversionRate", -1);
		if (conversionRate != null) {
			receiverDisclosure = (receiverDisclosure == null) ? new ReceiverDisclosure() : receiverDisclosure;
			receiverDisclosure.setConversionRate(conversionRate);
		}
		FeeDisclosure feeDisclosure =  FeeDisclosure.createInstance(map, prefix + "feeDisclosure", -1);
		if (feeDisclosure != null) {
			receiverDisclosure = (receiverDisclosure == null) ? new ReceiverDisclosure() : receiverDisclosure;
			receiverDisclosure.setFeeDisclosure(feeDisclosure);
		}
		CurrencyType totalAmountReceived =  CurrencyType.createInstance(map, prefix + "totalAmountReceived", -1);
		if (totalAmountReceived != null) {
			receiverDisclosure = (receiverDisclosure == null) ? new ReceiverDisclosure() : receiverDisclosure;
			receiverDisclosure.setTotalAmountReceived(totalAmountReceived);
		}
		return receiverDisclosure;
	}
 
}