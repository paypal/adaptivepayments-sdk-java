
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import java.util.Map;


/**
 * Funding source information.
 */
public class FundingSource {

	/**
	 */
	private String lastFourOfAccountNumber;
	public String getLastFourOfAccountNumber() {
		return lastFourOfAccountNumber;
	}
	public void setLastFourOfAccountNumber(String value) {
		this.lastFourOfAccountNumber = value;
	}

	/**
	 *
	 * @Required
	 */
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String value) {
		this.type = value;
	}

	/**
	 */
	private String displayName;
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String value) {
		this.displayName = value;
	}

	/**
	 */
	private String fundingSourceId;
	public String getFundingSourceId() {
		return fundingSourceId;
	}
	public void setFundingSourceId(String value) {
		this.fundingSourceId = value;
	}

	/**
	 */
	private Boolean allowed;
	public Boolean getAllowed() {
		return allowed;
	}
	public void setAllowed(Boolean value) {
		this.allowed = value;
	}


	public FundingSource() {
	}
	public FundingSource(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "lastFourOfAccountNumber") ) {
			this.lastFourOfAccountNumber = map.get(prefix + "lastFourOfAccountNumber");
		}
		if( map.containsKey(prefix + "type") ) {
			this.type = map.get(prefix + "type");
		}
		if( map.containsKey(prefix + "displayName") ) {
			this.displayName = map.get(prefix + "displayName");
		}
		if( map.containsKey(prefix + "fundingSourceId") ) {
			this.fundingSourceId = map.get(prefix + "fundingSourceId");
		}
		if( map.containsKey(prefix + "allowed") ) {
			this.allowed = Boolean.valueOf(map.get(prefix + "allowed"));
		}
	}
}
