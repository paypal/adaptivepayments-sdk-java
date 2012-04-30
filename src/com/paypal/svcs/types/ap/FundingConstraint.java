
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.ap.FundingTypeList;
import java.io.UnsupportedEncodingException;
import java.util.Map;


/**
 */
public class FundingConstraint {

	/**
	 */
	private FundingTypeList allowedFundingType;
	public FundingTypeList getAllowedFundingType() {
		return allowedFundingType;
	}
	public void setAllowedFundingType(FundingTypeList value) {
		this.allowedFundingType = value;
	}


	public FundingConstraint() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( allowedFundingType != null ) {
			String newPrefix = prefix + "allowedFundingType.";
			sb.append(allowedFundingType.toNVPString(newPrefix));
		}
		return sb.toString();
	}

	public FundingConstraint(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "allowedFundingType" + ".") ) {
			String newPrefix = prefix + "allowedFundingType" + '.';
			this.allowedFundingType =  new FundingTypeList(map, newPrefix);
		}
	}
}
