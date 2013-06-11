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
	 * 	  
	 *@Required	 
	 */ 
	private String fundingPlanId;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private CurrencyType fundingAmount;

	/**
	 * 	 
	 */ 
	private FundingSource backupFundingSource;

	/**
	 * 	 
	 */ 
	private CurrencyType senderFees;

	/**
	 * 	 
	 */ 
	private CurrencyConversion currencyConversion;

	/**
	 * 	  
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
	 


	
	public static FundingPlan createInstance(Map<String, String> map, String prefix, int index) {
		FundingPlan fundingPlan = null;
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
			
		if (map.containsKey(prefix + "fundingPlanId")) {
				fundingPlan = (fundingPlan == null) ? new FundingPlan() : fundingPlan;
				fundingPlan.setFundingPlanId(map.get(prefix + "fundingPlanId"));
		}
		CurrencyType fundingAmount =  CurrencyType.createInstance(map, prefix + "fundingAmount", -1);
		if (fundingAmount != null) {
			fundingPlan = (fundingPlan == null) ? new FundingPlan() : fundingPlan;
			fundingPlan.setFundingAmount(fundingAmount);
		}
		FundingSource backupFundingSource =  FundingSource.createInstance(map, prefix + "backupFundingSource", -1);
		if (backupFundingSource != null) {
			fundingPlan = (fundingPlan == null) ? new FundingPlan() : fundingPlan;
			fundingPlan.setBackupFundingSource(backupFundingSource);
		}
		CurrencyType senderFees =  CurrencyType.createInstance(map, prefix + "senderFees", -1);
		if (senderFees != null) {
			fundingPlan = (fundingPlan == null) ? new FundingPlan() : fundingPlan;
			fundingPlan.setSenderFees(senderFees);
		}
		CurrencyConversion currencyConversion =  CurrencyConversion.createInstance(map, prefix + "currencyConversion", -1);
		if (currencyConversion != null) {
			fundingPlan = (fundingPlan == null) ? new FundingPlan() : fundingPlan;
			fundingPlan.setCurrencyConversion(currencyConversion);
		}
		i = 0;
		while(true) {
			FundingPlanCharge charge =  FundingPlanCharge.createInstance(map, prefix + "charge", i);
			if (charge != null) {
				fundingPlan = (fundingPlan == null) ? new FundingPlan() : fundingPlan;
				fundingPlan.getCharge().add(charge);
				i++;
			} else {
				break;
			}
		}
		return fundingPlan;
	}
 
}