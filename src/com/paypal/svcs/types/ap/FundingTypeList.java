
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.ap.FundingTypeInfo;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 */
public class FundingTypeList {

	/**
	 *
	 * @Required
	 */
	private List<FundingTypeInfo> fundingTypeInfo = new ArrayList<FundingTypeInfo>();
	public List<FundingTypeInfo> getFundingTypeInfo() {
		return fundingTypeInfo;
	}
	public void setFundingTypeInfo(List<FundingTypeInfo> value) {
		this.fundingTypeInfo = value;
	}


	public FundingTypeList(List<FundingTypeInfo> fundingTypeInfo) {
		this.fundingTypeInfo = fundingTypeInfo;
	}
	public FundingTypeList() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( fundingTypeInfo != null ) {
			for(int i=0; i<fundingTypeInfo.size(); i++) {
				String newPrefix = prefix + "fundingTypeInfo" + '(' + i + ").";
				sb.append(fundingTypeInfo.get(i).toNVPString(newPrefix));
			}
		}
		return sb.toString();
	}

	public FundingTypeList(Map<String, String> map, String prefix) {
		int i=0; 
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "fundingTypeInfo" + '(' + i + ')') ) {
				String newPrefix = prefix + "fundingTypeInfo" + '(' + i + ')' + '.';
				this.fundingTypeInfo.add(new FundingTypeInfo(map, newPrefix));
			}
			else break;
			i++;
		}
	}
}
