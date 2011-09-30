
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import java.io.UnsupportedEncodingException;
import java.util.Map;


/**
 * FundingTypeInfo represents one allowed funding
 * type.
 */
public class FundingTypeInfo {

	/**
	 *
	 * @Required
	 */
	private String fundingType;
	public String getFundingType() {
		return fundingType;
	}
	public void setFundingType(String value) {
		this.fundingType = value;
	}


	public FundingTypeInfo(String fundingType) {
		this.fundingType = fundingType;
	}
	public FundingTypeInfo() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( fundingType != null ) {
			sb.append(prefix).append("fundingType=").append(NVPUtil.encodeUrl(fundingType));
			sb.append('&');
		}
		return sb.toString();
	}

	public FundingTypeInfo(Map<String, String> map, String prefix) {
		prefix = prefix.substring( 0, prefix.length()-1 );
		this.fundingType =map.get(prefix + "fundingType(i)");
	}
}
