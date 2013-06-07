package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.AccountIdentifier;
import java.util.Map;

/**
 * Contains information related to Post Payment Disclosure
 * Details This contains 1.Receivers information 2.Funds
 * Avalibility Date 
 */
public class PostPaymentDisclosure{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private AccountIdentifier accountIdentifier;

	/**
	 * 	 
	 */ 
	private String fundsAvailabilityDate;

	/**
	 * 	 
	 */ 
	private String fundsAvailabilityDateDisclaimerText;

	

	/**
	 * Default Constructor
	 */
	public PostPaymentDisclosure (){
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
	 * Getter for fundsAvailabilityDate
	 */
	 public String getFundsAvailabilityDate() {
	 	return fundsAvailabilityDate;
	 }
	 
	/**
	 * Setter for fundsAvailabilityDate
	 */
	 public void setFundsAvailabilityDate(String fundsAvailabilityDate) {
	 	this.fundsAvailabilityDate = fundsAvailabilityDate;
	 }
	 
	/**
	 * Getter for fundsAvailabilityDateDisclaimerText
	 */
	 public String getFundsAvailabilityDateDisclaimerText() {
	 	return fundsAvailabilityDateDisclaimerText;
	 }
	 
	/**
	 * Setter for fundsAvailabilityDateDisclaimerText
	 */
	 public void setFundsAvailabilityDateDisclaimerText(String fundsAvailabilityDateDisclaimerText) {
	 	this.fundsAvailabilityDateDisclaimerText = fundsAvailabilityDateDisclaimerText;
	 }
	 


	
	public static PostPaymentDisclosure createInstance(Map<String, String> map, String prefix, int index) {
		PostPaymentDisclosure postPaymentDisclosure = null;
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
			postPaymentDisclosure = (postPaymentDisclosure == null) ? new PostPaymentDisclosure() : postPaymentDisclosure;
			postPaymentDisclosure.setAccountIdentifier(accountIdentifier);
		}
		if (map.containsKey(prefix + "fundsAvailabilityDate")) {
				postPaymentDisclosure = (postPaymentDisclosure == null) ? new PostPaymentDisclosure() : postPaymentDisclosure;
				postPaymentDisclosure.setFundsAvailabilityDate(map.get(prefix + "fundsAvailabilityDate"));
		}
		if (map.containsKey(prefix + "fundsAvailabilityDateDisclaimerText")) {
				postPaymentDisclosure = (postPaymentDisclosure == null) ? new PostPaymentDisclosure() : postPaymentDisclosure;
				postPaymentDisclosure.setFundsAvailabilityDateDisclaimerText(map.get(prefix + "fundsAvailabilityDateDisclaimerText"));
		}
		return postPaymentDisclosure;
	}
 
}