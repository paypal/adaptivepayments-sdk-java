
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * A list of ISO currency codes.
 */
public class CurrencyCodeList {

	/**
	 *
	 * @Required
	 */
	private List<String> currencyCode = new ArrayList<String>();
	public List<String> getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(List<String> value) {
		this.currencyCode = value;
	}


	public CurrencyCodeList(List<String> currencyCode) {
		this.currencyCode = currencyCode;
	}
	public CurrencyCodeList() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( currencyCode != null ) {
			for(int i=0; i<currencyCode.size(); i++) {
				sb.append(prefix).append("currencyCode(").append(i).append(")=").append(NVPUtil.encodeUrl(currencyCode.get(i)));
				sb.append('&');
			}
		}
		return sb.toString();
	}

}
