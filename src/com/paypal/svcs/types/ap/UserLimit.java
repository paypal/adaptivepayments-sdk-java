
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.common.CurrencyType;
import java.util.Map;


/**
 */
public class UserLimit {

	/**
	 *
	 * @Required
	 */
	private String limitType;
	public String getLimitType() {
		return limitType;
	}
	public void setLimitType(String value) {
		this.limitType = value;
	}

	/**
	 *
	 * @Required
	 */
	private CurrencyType limitAmount;
	public CurrencyType getLimitAmount() {
		return limitAmount;
	}
	public void setLimitAmount(CurrencyType value) {
		this.limitAmount = value;
	}


	public UserLimit() {
	}
	public UserLimit(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "limitType") ) {
			this.limitType = map.get(prefix + "limitType");
		}
		if( map.containsKey(prefix + "limitAmount" + ".code") ) {
			String newPrefix = prefix + "limitAmount" + '.';
			this.limitAmount =  new CurrencyType(map, newPrefix);
		}
	}
}
