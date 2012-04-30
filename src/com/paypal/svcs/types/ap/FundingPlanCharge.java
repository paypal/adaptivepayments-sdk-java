
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.FundingSource;
import com.paypal.svcs.types.common.CurrencyType;
import java.util.Map;


/**
 * Amount to be charged to a particular funding
 * source.
 */
public class FundingPlanCharge {

	/**
	 *
	 * @Required
	 */
	private CurrencyType charge;
	public CurrencyType getCharge() {
		return charge;
	}
	public void setCharge(CurrencyType value) {
		this.charge = value;
	}

	/**
	 *
	 * @Required
	 */
	private FundingSource fundingSource;
	public FundingSource getFundingSource() {
		return fundingSource;
	}
	public void setFundingSource(FundingSource value) {
		this.fundingSource = value;
	}


	public FundingPlanCharge() {
	}
	public FundingPlanCharge(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "charge" + ".code") ) {
			String newPrefix = prefix + "charge" + '.';
			this.charge =  new CurrencyType(map, newPrefix);
		}
		if( map.containsKey(prefix + "fundingSource" + ".lastFourOfAccountNumber") ) {
			String newPrefix = prefix + "fundingSource" + '.';
			this.fundingSource =  new FundingSource(map, newPrefix);
		}
	}
}
