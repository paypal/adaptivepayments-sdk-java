package com.paypal.svcs.types.ap;
import java.util.Map;

/**
 * This type contains the detailed warning information
 * resulting from the service operation. 
 */
public class WarningData{


	/**
	 * No Document Comments	 
	 */ 
	private Integer warningId;

	/**
	 * No Document Comments	 
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
	 


	public WarningData(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "warningId")){
			this.warningId = Integer.valueOf(map.get(prefix + "warningId"));
		}
		if(map.containsKey(prefix + "message")){
			this.message = map.get(prefix + "message");
		}
	}

}