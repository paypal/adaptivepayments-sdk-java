package com.paypal.svcs.types.ap;
import java.util.Map;

/**
 * Contains information related to State Regulatory Agency
 * Information of the Sender's country for RTR transaction This
 * contains 1.Agency Name 2.Phone Number 3.Website 
 */
public class StateRegulatoryAgencyInfo{


	/**
	 * 	 
	 */ 
	private String name;

	/**
	 * 	 
	 */ 
	private String phoneNo;

	/**
	 * 	 
	 */ 
	private String website;

	

	/**
	 * Default Constructor
	 */
	public StateRegulatoryAgencyInfo (){
	}	

	/**
	 * Getter for name
	 */
	 public String getName() {
	 	return name;
	 }
	 
	/**
	 * Setter for name
	 */
	 public void setName(String name) {
	 	this.name = name;
	 }
	 
	/**
	 * Getter for phoneNo
	 */
	 public String getPhoneNo() {
	 	return phoneNo;
	 }
	 
	/**
	 * Setter for phoneNo
	 */
	 public void setPhoneNo(String phoneNo) {
	 	this.phoneNo = phoneNo;
	 }
	 
	/**
	 * Getter for website
	 */
	 public String getWebsite() {
	 	return website;
	 }
	 
	/**
	 * Setter for website
	 */
	 public void setWebsite(String website) {
	 	this.website = website;
	 }
	 


	
	public static StateRegulatoryAgencyInfo createInstance(Map<String, String> map, String prefix, int index) {
		StateRegulatoryAgencyInfo stateRegulatoryAgencyInfo = null;
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
			
		if (map.containsKey(prefix + "Name")) {
				stateRegulatoryAgencyInfo = (stateRegulatoryAgencyInfo == null) ? new StateRegulatoryAgencyInfo() : stateRegulatoryAgencyInfo;
				stateRegulatoryAgencyInfo.setName(map.get(prefix + "Name"));
		}
		if (map.containsKey(prefix + "PhoneNo")) {
				stateRegulatoryAgencyInfo = (stateRegulatoryAgencyInfo == null) ? new StateRegulatoryAgencyInfo() : stateRegulatoryAgencyInfo;
				stateRegulatoryAgencyInfo.setPhoneNo(map.get(prefix + "PhoneNo"));
		}
		if (map.containsKey(prefix + "Website")) {
				stateRegulatoryAgencyInfo = (stateRegulatoryAgencyInfo == null) ? new StateRegulatoryAgencyInfo() : stateRegulatoryAgencyInfo;
				stateRegulatoryAgencyInfo.setWebsite(map.get(prefix + "Website"));
		}
		return stateRegulatoryAgencyInfo;
	}
 
}