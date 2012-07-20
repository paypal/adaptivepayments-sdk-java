package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.CurrencyType;
import com.paypal.svcs.types.ap.FundingSource;
import java.util.Map;

/**
 * Amount to be charged to a particular funding source. 
 */
public class FundingPlanCharge{


	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private CurrencyType charge;

	/**
	 * No Document Comments	  
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
	 


	public FundingPlanCharge(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "charge" + ".code")){
			String newPrefix = prefix + "charge" + ".";
			this.charge =  new CurrencyType(map, newPrefix);
		}
		if(map.containsKey(prefix + "fundingSource" + ".type")){
			String newPrefix = prefix + "fundingSource" + ".";
			this.fundingSource =  new FundingSource(map, newPrefix);
		}
	}

}