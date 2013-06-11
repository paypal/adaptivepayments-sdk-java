package com.paypal.svcs.types.ap;
import java.util.Map;

/**
 * Funding source information. 
 */
public class FundingSource{


	/**
	 * 	 
	 */ 
	private String lastFourOfAccountNumber;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String type;

	/**
	 * 	 
	 */ 
	private String displayName;

	/**
	 * 	 
	 */ 
	private String fundingSourceId;

	/**
	 * 	 
	 */ 
	private Boolean allowed;

	

	/**
	 * Default Constructor
	 */
	public FundingSource (){
	}	

	/**
	 * Getter for lastFourOfAccountNumber
	 */
	 public String getLastFourOfAccountNumber() {
	 	return lastFourOfAccountNumber;
	 }
	 
	/**
	 * Setter for lastFourOfAccountNumber
	 */
	 public void setLastFourOfAccountNumber(String lastFourOfAccountNumber) {
	 	this.lastFourOfAccountNumber = lastFourOfAccountNumber;
	 }
	 
	/**
	 * Getter for type
	 */
	 public String getType() {
	 	return type;
	 }
	 
	/**
	 * Setter for type
	 */
	 public void setType(String type) {
	 	this.type = type;
	 }
	 
	/**
	 * Getter for displayName
	 */
	 public String getDisplayName() {
	 	return displayName;
	 }
	 
	/**
	 * Setter for displayName
	 */
	 public void setDisplayName(String displayName) {
	 	this.displayName = displayName;
	 }
	 
	/**
	 * Getter for fundingSourceId
	 */
	 public String getFundingSourceId() {
	 	return fundingSourceId;
	 }
	 
	/**
	 * Setter for fundingSourceId
	 */
	 public void setFundingSourceId(String fundingSourceId) {
	 	this.fundingSourceId = fundingSourceId;
	 }
	 
	/**
	 * Getter for allowed
	 */
	 public Boolean getAllowed() {
	 	return allowed;
	 }
	 
	/**
	 * Setter for allowed
	 */
	 public void setAllowed(Boolean allowed) {
	 	this.allowed = allowed;
	 }
	 


	
	public static FundingSource createInstance(Map<String, String> map, String prefix, int index) {
		FundingSource fundingSource = null;
		int i = 0;
		if (index != -1) {
				if (prefix != null && prefix.length() != 0 && !prefix.endsWith(".")) {
					prefix = prefix + "(" + index + ").";
				}
		} else {
			if (prefix != null && prefix.length() != 0 && !prefix.endsWith(".")) {
				prefix = prefix + ".";
			}
		}
			
		if (map.containsKey(prefix + "lastFourOfAccountNumber")) {
				fundingSource = (fundingSource == null) ? new FundingSource() : fundingSource;
				fundingSource.setLastFourOfAccountNumber(map.get(prefix + "lastFourOfAccountNumber"));
		}
		if (map.containsKey(prefix + "type")) {
				fundingSource = (fundingSource == null) ? new FundingSource() : fundingSource;
				fundingSource.setType(map.get(prefix + "type"));
		}
		if (map.containsKey(prefix + "displayName")) {
				fundingSource = (fundingSource == null) ? new FundingSource() : fundingSource;
				fundingSource.setDisplayName(map.get(prefix + "displayName"));
		}
		if (map.containsKey(prefix + "fundingSourceId")) {
				fundingSource = (fundingSource == null) ? new FundingSource() : fundingSource;
				fundingSource.setFundingSourceId(map.get(prefix + "fundingSourceId"));
		}
		if (map.containsKey(prefix + "allowed")) {
				fundingSource = (fundingSource == null) ? new FundingSource() : fundingSource;
				fundingSource.setAllowed(Boolean.valueOf(map.get(prefix + "allowed")));
		}
		return fundingSource;
	}
 
}