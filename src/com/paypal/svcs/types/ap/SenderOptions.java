
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
		return sb.toString();
	}

	public SenderOptions(Map<String, String> map, String prefix) {
		prefix = prefix.substring( 0, prefix.length()-1 );
		this.requireShippingAddressSelection =Boolean.valueOf(map.get(prefix + "requireShippingAddressSelection(i)"));
	}
}
