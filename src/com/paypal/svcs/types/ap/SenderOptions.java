
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import java.io.UnsupportedEncodingException;
import java.util.Map;


/**
 * Options that apply to the sender of a payment.
 */
public class SenderOptions {

	/**
	 * Require the user to select a shipping
	 * address during the web flow.
	 */
	private Boolean requireShippingAddressSelection;
	public Boolean getRequireShippingAddressSelection() {
		return requireShippingAddressSelection;
	}
	public void setRequireShippingAddressSelection(Boolean value) {
		this.requireShippingAddressSelection = value;
	}

	/**
	 */
	private String referrerCode;
	public String getReferrerCode() {
		return referrerCode;
	}
	public void setReferrerCode(String value) {
		this.referrerCode = value;
	}


	public SenderOptions() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( requireShippingAddressSelection != null ) {
			sb.append(prefix).append("requireShippingAddressSelection=").append(requireShippingAddressSelection);
			sb.append('&');
		}
		if( referrerCode != null ) {
			sb.append(prefix).append("referrerCode=").append(NVPUtil.encodeUrl(referrerCode));
			sb.append('&');
		}
		return sb.toString();
	}

	public SenderOptions(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "requireShippingAddressSelection") ) {
			this.requireShippingAddressSelection = Boolean.valueOf(map.get(prefix + "requireShippingAddressSelection"));
		}
		if( map.containsKey(prefix + "referrerCode") ) {
			this.referrerCode = map.get(prefix + "referrerCode");
		}
	}
}
