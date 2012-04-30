
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.CurrencyType;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * A list of ISO currencies.
 */
public class CurrencyList {

	/**
	 *
	 * @Required
	 */
	private List<CurrencyType> currency = new ArrayList<CurrencyType>();
	public List<CurrencyType> getCurrency() {
		return currency;
	}
	public void setCurrency(List<CurrencyType> value) {
		this.currency = value;
	}


	public CurrencyList(List<CurrencyType> currency) {
		this.currency = currency;
	}
	public CurrencyList() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( currency != null ) {
			for(int i=0; i<currency.size(); i++) {
				String newPrefix = prefix + "currency" + '(' + i + ").";
				sb.append(currency.get(i).toNVPString(newPrefix));
			}
		}
		return sb.toString();
	}

	public CurrencyList(Map<String, String> map, String prefix) {
		int i=0; 
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "currency" + '(' + i + ')'+ ".code") ) {
				String newPrefix = prefix + "currency" + '(' + i + ')' + '.';
				this.currency.add(new CurrencyType(map, newPrefix));
			}
			else break;
			i++;
		}
	}
}
