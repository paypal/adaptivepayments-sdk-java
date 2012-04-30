
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.common.CurrencyType;
import java.util.Map;


/**
 * Describes the conversion between 2 currencies.
 */
public class CurrencyConversion {

	/**
	 *
	 * @Required
	 */
	private CurrencyType from;
	public CurrencyType getFrom() {
		return from;
	}
	public void setFrom(CurrencyType value) {
		this.from = value;
	}

	/**
	 *
	 * @Required
	 */
	private CurrencyType to;
	public CurrencyType getTo() {
		return to;
	}
	public void setTo(CurrencyType value) {
		this.to = value;
	}

	/**
	 *
	 * @Required
	 */
	private Double exchangeRate;
	public Double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(Double value) {
		this.exchangeRate = value;
	}


	public CurrencyConversion() {
	}
	public CurrencyConversion(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "from" + ".code") ) {
			String newPrefix = prefix + "from" + '.';
			this.from =  new CurrencyType(map, newPrefix);
		}
		if( map.containsKey(prefix + "to" + ".code") ) {
			String newPrefix = prefix + "to" + '.';
			this.to =  new CurrencyType(map, newPrefix);
		}
		if( map.containsKey(prefix + "exchangeRate") ) {
			this.exchangeRate = Double.valueOf(map.get(prefix + "exchangeRate"));
		}
	}
}
