package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.CurrencyType;
import com.paypal.svcs.types.ap.FundingSource;
import java.util.Map;

/**
 * Amount to be charged to a particular funding source. 
 */
public class FundingPlanCharge{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private CurrencyType charge;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private FundingSource fundingSource;

	

	/**
	 * Default Constructor
	 */
	public FundingPlanCharge (){
	}	

	/**
	 * Getter for charge
	 */
	 public CurrencyType getCharge() {
	 	return charge;
	 }
	 
	/**
	 * Setter for charge
	 */
	 public void setCharge(CurrencyType charge) {
	 	this.charge = charge;
	 }
	 
	/**
	 * Getter for fundingSource
	 */
	 public FundingSource getFundingSource() {
	 	return fundingSource;
	 }
	 
	/**
	 * Setter for fundingSource
	 */
	 public void setFundingSource(FundingSource fundingSource) {
	 	this.fundingSource = fundingSource;
	 }
	 


	
	public static FundingPlanCharge createInstance(Map<String, String> map, String prefix, int index) {
		FundingPlanCharge fundingPlanCharge = null;
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
			
		CurrencyType charge =  CurrencyType.createInstance(map, prefix + "charge", -1);
		if (charge != null) {
			fundingPlanCharge = (fundingPlanCharge == null) ? new FundingPlanCharge() : fundingPlanCharge;
			fundingPlanCharge.setCharge(charge);
		}
		FundingSource fundingSource =  FundingSource.createInstance(map, prefix + "fundingSource", -1);
		if (fundingSource != null) {
			fundingPlanCharge = (fundingPlanCharge == null) ? new FundingPlanCharge() : fundingPlanCharge;
			fundingPlanCharge.setFundingSource(fundingSource);
		}
		return fundingPlanCharge;
	}
 
}