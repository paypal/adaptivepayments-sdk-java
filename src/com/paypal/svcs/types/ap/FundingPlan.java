
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.CurrencyConversion;
import com.paypal.svcs.types.ap.FundingPlanCharge;
import com.paypal.svcs.types.ap.FundingSource;
import com.paypal.svcs.types.common.CurrencyType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * FundingPlan describes the funding sources to be
 * used for a specific payment.
 */
public class FundingPlan {

	/**
	 *
	 * @Required
	 */
	private String fundingPlanId;
	public String getFundingPlanId() {
		return fundingPlanId;
	}
	public void setFundingPlanId(String value) {
		this.fundingPlanId = value;
	}

	/**
	 *
	 * @Required
	 */
	private CurrencyType fundingAmount;
	public CurrencyType getFundingAmount() {
		return fundingAmount;
	}
	public void setFundingAmount(CurrencyType value) {
		this.fundingAmount = value;
	}

	/**
	 */
	private FundingSource backupFundingSource;
	public FundingSource getBackupFundingSource() {
		return backupFundingSource;
	}
	public void setBackupFundingSource(FundingSource value) {
		this.backupFundingSource = value;
	}

	/**
	 */
	private CurrencyType senderFees;
	public CurrencyType getSenderFees() {
		return senderFees;
	}
	public void setSenderFees(CurrencyType value) {
		this.senderFees = value;
	}

	/**
	 */
	private CurrencyConversion currencyConversion;
	public CurrencyConversion getCurrencyConversion() {
		return currencyConversion;
	}
	public void setCurrencyConversion(CurrencyConversion value) {
		this.currencyConversion = value;
	}

	/**
	 *
	 * @Required
	 */
	private List<FundingPlanCharge> charge = new ArrayList<FundingPlanCharge>();
	public List<FundingPlanCharge> getCharge() {
		return charge;
	}
	public void setCharge(List<FundingPlanCharge> value) {
		this.charge = value;
	}


	public FundingPlan() {
	}
	public FundingPlan(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "fundingPlanId") ) {
			this.fundingPlanId = map.get(prefix + "fundingPlanId");
		}
		if( map.containsKey(prefix + "fundingAmount" + ".code") ) {
			String newPrefix = prefix + "fundingAmount" + '.';
			this.fundingAmount =  new CurrencyType(map, newPrefix);
		}
		if( map.containsKey(prefix + "backupFundingSource" + ".lastFourOfAccountNumber") ) {
			String newPrefix = prefix + "backupFundingSource" + '.';
			this.backupFundingSource =  new FundingSource(map, newPrefix);
		}
		if( map.containsKey(prefix + "senderFees" + ".code") ) {
			String newPrefix = prefix + "senderFees" + '.';
			this.senderFees =  new CurrencyType(map, newPrefix);
		}
		if( map.containsKey(prefix + "currencyConversion" + ".exchangeRate") ) {
			String newPrefix = prefix + "currencyConversion" + '.';
			this.currencyConversion =  new CurrencyConversion(map, newPrefix);
		}
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "charge" + '(' + i + ')'+ ".fundingSource.lastFourOfAccountNumber") ) {
				String newPrefix = prefix + "charge" + '(' + i + ')' + '.';
				this.charge.add(new FundingPlanCharge(map, newPrefix));
			}
			else break;
			i++;
		}
	}
}
