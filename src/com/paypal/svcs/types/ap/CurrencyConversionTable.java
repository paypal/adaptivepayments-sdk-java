
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.CurrencyConversionList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * A table that contains a list of estimated
 * currency conversions for a base currency in each
 * row.
 */
public class CurrencyConversionTable {

	/**
	 *
	 * @Required
	 */
	private List<CurrencyConversionList> currencyConversionList = new ArrayList<CurrencyConversionList>();
	public List<CurrencyConversionList> getCurrencyConversionList() {
		return currencyConversionList;
	}
	public void setCurrencyConversionList(List<CurrencyConversionList> value) {
		this.currencyConversionList = value;
	}


	public CurrencyConversionTable() {
	}
	public CurrencyConversionTable(Map<String, String> map, String prefix) {
		int i=0; 
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "currencyConversionList" + '(' + i + ')'+ ".baseAmount.code") ) {
				String newPrefix = prefix + "currencyConversionList" + '(' + i + ')' + '.';
				this.currencyConversionList.add(new CurrencyConversionList(map, newPrefix));
			}
			else break;
			i++;
		}
	}
}
