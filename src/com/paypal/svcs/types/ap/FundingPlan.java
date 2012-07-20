package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.CurrencyType;
import com.paypal.svcs.types.ap.FundingSource;
import com.paypal.svcs.types.ap.CurrencyConversion;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.FundingPlanCharge;
import java.util.Map;

/**
 * FundingPlan describes the funding sources to be used for a
 * specific payment. 
 */
public class FundingPlan{


	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private String fundingPlanId;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private CurrencyType fundingAmount;

	/**
	 * No Document Comments	 
	 */ 
	private FundingSource backupFundingSource;

	/**
	 * No Document Comments	 
	 */ 
	private CurrencyType senderFees;

	/**
	 * No Document Comments	 
	 */ 
	private CurrencyConversion currencyConversion;

	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private List<FundingPlanCharge> charge = new ArrayList<FundingPlanCharge>();

	

	/**
	 * Default Constructor
	 */
	public FundingPlan (){
	}	

	/**
	 * Getter for fundingPlanId
	 */
	 public String getFundingPlanId() {
	 	return fundingPlanId;
	 }
	 
	/**
	 * Setter for fundingPlanId
	 */
	 public void setFundingPlanId(String fundingPlanId) {
	 	this.fundingPlanId = fundingPlanId;
	 }
	 
	/**
	 * Getter for fundingAmount
	 */
	 public CurrencyType getFundingAmount() {
	 	return fundingAmount;
	 }
	 
	/**
	 * Setter for fundingAmount
	 */
	 public void setFundingAmount(CurrencyType fundingAmount) {
	 	this.fundingAmount = fundingAmount;
	 }
	 
	/**
	 * Getter for backupFundingSource
	 */
	 public FundingSource getBackupFundingSource() {
	 	return backupFundingSource;
	 }
	 
	/**
	 * Setter for backupFundingSource
	 */
	 public void setBackupFundingSource(FundingSource backupFundingSource) {
	 	this.backupFundingSource = backupFundingSource;
	 }
	 
	/**
	 * Getter for senderFees
	 */
	 public CurrencyType getSenderFees() {
	 	return senderFees;
	 }
	 
	/**
	 * Setter for senderFees
	 */
	 public void setSenderFees(CurrencyType senderFees) {
	 	this.senderFees = senderFees;
	 }
	 
	/**
	 * Getter for currencyConversion
	 */
	 public CurrencyConversion getCurrencyConversion() {
	 	return currencyConversion;
	 }
	 
	/**
	 * Setter for currencyConversion
	 */
	 public void setCurrencyConversion(CurrencyConversion currencyConversion) {
	 	this.currencyConversion = currencyConversion;
	 }
	 
	/**
	 * Getter for charge
	 */
	 public List<FundingPlanCharge> getCharge() {
	 	return charge;
	 }
	 
	/**
	 * Setter for charge
	 */
	 public void setCharge(List<FundingPlanCharge> charge) {
	 	this.charge = charge;
	 }
	 


	public FundingPlan(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "fundingPlanId")){
			this.fundingPlanId = map.get(prefix + "fundingPlanId");
		}
		if(map.containsKey(prefix + "fundingAmount" + ".code")){
			String newPrefix = prefix + "fundingAmount" + ".";
			this.fundingAmount =  new CurrencyType(map, newPrefix);
		}
		if(map.containsKey(prefix + "backupFundingSource" + ".type")){
			String newPrefix = prefix + "backupFundingSource" + ".";
			this.backupFundingSource =  new FundingSource(map, newPrefix);
		}
		if(map.containsKey(prefix + "senderFees" + ".code")){
			String newPrefix = prefix + "senderFees" + ".";
			this.senderFees =  new CurrencyType(map, newPrefix);
		}
		if(map.containsKey(prefix + "currencyConversion" + ".from.code")){
			String newPrefix = prefix + "currencyConversion" + ".";
			this.currencyConversion =  new CurrencyConversion(map, newPrefix);
		}
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "charge" + "(" + i + ")" + ".charge.code")){
				String newPrefix = prefix + "charge" + "(" + i + ")" + ".";
				this.charge.add(new FundingPlanCharge(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
	}

}