package com.paypal.svcs.types.ap;
import java.util.Map;

/**
 * This type contains the detailed warning information
 * resulting from the service operation. 
 */
public class WarningData{


	/**
	 * 	 
	 */ 
	private Integer warningId;

	/**
	 * 	 
	 */ 
	private String message;

	

	/**
	 * Default Constructor
	 */
	public WarningData (){
	}	

	/**
	 * Getter for warningId
	 */
	 public Integer getWarningId() {
	 	return warningId;
	 }
	 
	/**
	 * Setter for warningId
	 */
	 public void setWarningId(Integer warningId) {
	 	this.warningId = warningId;
	 }
	 
	/**
	 * Getter for message
	 */
	 public String getMessage() {
	 	return message;
	 }
	 
	/**
	 * Setter for message
	 */
	 public void setMessage(String message) {
	 	this.message = message;
	 }
	 


	
	public static WarningData createInstance(Map<String, String> map, String prefix, int index) {
		WarningData warningData = null;
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
			
		if (map.containsKey(prefix + "warningId")) {
				warningData = (warningData == null) ? new WarningData() : warningData;
				warningData.setWarningId(Integer.valueOf(map.get(prefix + "warningId")));
		}
		if (map.containsKey(prefix + "message")) {
				warningData = (warningData == null) ? new WarningData() : warningData;
				warningData.setMessage(map.get(prefix + "message"));
		}
		return warningData;
	}
 
}