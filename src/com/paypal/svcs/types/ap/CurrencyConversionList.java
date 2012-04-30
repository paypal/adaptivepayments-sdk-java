
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.CurrencyList;
import com.paypal.svcs.types.common.CurrencyType;
import java.util.Map;


/**
 * A list of estimated currency conversions for a
 * base currency.
 */
public class CurrencyConversionList {

	/**
	 *
	 * @Required
	 */
	private CurrencyType baseAmount;
	public CurrencyType getBaseAmount() {
		return baseAmount;
	}
	public void setBaseAmount(CurrencyType value) {
		this.baseAmount = value;
	}

	/**
	 *
	 * @Required
	 */
	private CurrencyList currencyList;
	public CurrencyList getCurrencyList() {
		return currencyList;
	}
	public void setCurrencyList(CurrencyList value) {
		this.currencyList = value;
	}


	public CurrencyConversionList() {
	}
	public CurrencyConversionList(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "baseAmount" + ".code") ) {
			String newPrefix = prefix + "baseAmount" + '.';
			this.baseAmount =  new CurrencyType(map, newPrefix);
		}
		if( map.containsKey(prefix + "currencyList" + ".currency(0).code") ) {
			String newPrefix = prefix + "currencyList" + '.';
			this.currencyList =  new CurrencyList(map, newPrefix);
		}
	}
}
