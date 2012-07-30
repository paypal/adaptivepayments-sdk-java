package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.ResponseEnvelope;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.UserLimit;
import com.paypal.svcs.types.ap.WarningDataList;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * A response that contains a list of remaining limits 
 */
public class GetUserLimitsResponse{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private List<UserLimit> userLimit = new ArrayList<UserLimit>();

	/**
	 * 	 
	 */ 
	private WarningDataList warningDataList;

	/**
	 * 	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public GetUserLimitsResponse (){
	}	

	/**
	 * Getter for responseEnvelope
	 */
	 public ResponseEnvelope getResponseEnvelope() {
	 	return responseEnvelope;
	 }
	 
	/**
	 * Setter for responseEnvelope
	 */
	 public void setResponseEnvelope(ResponseEnvelope responseEnvelope) {
	 	this.responseEnvelope = responseEnvelope;
	 }
	 
	/**
	 * Getter for userLimit
	 */
	 public List<UserLimit> getUserLimit() {
	 	return userLimit;
	 }
	 
	/**
	 * Setter for userLimit
	 */
	 public void setUserLimit(List<UserLimit> userLimit) {
	 	this.userLimit = userLimit;
	 }
	 
	/**
	 * Getter for warningDataList
	 */
	 public WarningDataList getWarningDataList() {
	 	return warningDataList;
	 }
	 
	/**
	 * Setter for warningDataList
	 */
	 public void setWarningDataList(WarningDataList warningDataList) {
	 	this.warningDataList = warningDataList;
	 }
	 
	/**
	 * Getter for error
	 */
	 public List<ErrorData> getError() {
	 	return error;
	 }
	 
	/**
	 * Setter for error
	 */
	 public void setError(List<ErrorData> error) {
	 	this.error = error;
	 }
	 


	public GetUserLimitsResponse(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "responseEnvelope" + ".timestamp")){
			String newPrefix = prefix + "responseEnvelope" + ".";
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "userLimit" + "(" + i + ")" + ".limitType")){
				String newPrefix = prefix + "userLimit" + "(" + i + ")" + ".";
				this.userLimit.add(new UserLimit(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
		if(map.containsKey(prefix + "warningDataList.warningData(0).warningId")){
			String newPrefix = prefix + "warningDataList" + ".";
			this.warningDataList =  new WarningDataList(map, newPrefix);
		}
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "error" + "(" + i + ")" + ".errorId")){
				String newPrefix = prefix + "error" + "(" + i + ")" + ".";
				this.error.add(new ErrorData(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
	}

}