
/**
 * Auto generated code
 */

package com.paypal.svcs.types.common;

import com.paypal.core.NVPUtil;
import java.io.UnsupportedEncodingException;
import java.util.Map;


/**
 */
public class CurrencyType {

	/**
	 *
	 * @Required
	 */
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String value) {
		this.code = value;
	}

	/**
	 *
	 * @Required
	 */
	private Double amount;
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double value) {
		this.amount = value;
	}


	public CurrencyType(String code, Double amount) {
		this.code = code;
		this.amount = amount;
	}
	public CurrencyType() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( code != null ) {
			sb.append(prefix).append("code=").append(NVPUtil.encodeUrl(code));
			sb.append('&');
		}
		if( amount != null ) {
			sb.append(prefix).append("amount=").append(amount);
			sb.append('&');
		}
		return sb.toString();
	}

	public CurrencyType(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "code") ) {
			this.code = map.get(prefix + "code");
		}
		if( map.containsKey(prefix + "amount") ) {
			this.amount = Double.valueOf(map.get(prefix + "amount"));
		}
	}
}
