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
	 


	
	public static GetUserLimitsResponse createInstance(Map<String, String> map, String prefix, int index) {
		GetUserLimitsResponse getUserLimitsResponse = null;
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
			
		ResponseEnvelope responseEnvelope =  ResponseEnvelope.createInstance(map, prefix + "responseEnvelope", -1);
		if (responseEnvelope != null) {
			getUserLimitsResponse = (getUserLimitsResponse == null) ? new GetUserLimitsResponse() : getUserLimitsResponse;
			getUserLimitsResponse.setResponseEnvelope(responseEnvelope);
		}
		i = 0;
		while(true) {
			UserLimit userLimit =  UserLimit.createInstance(map, prefix + "userLimit", i);
			if (userLimit != null) {
				getUserLimitsResponse = (getUserLimitsResponse == null) ? new GetUserLimitsResponse() : getUserLimitsResponse;
				getUserLimitsResponse.getUserLimit().add(userLimit);
				i++;
			} else {
				break;
			}
		}
		WarningDataList warningDataList =  WarningDataList.createInstance(map, prefix + "warningDataList", -1);
		if (warningDataList != null) {
			getUserLimitsResponse = (getUserLimitsResponse == null) ? new GetUserLimitsResponse() : getUserLimitsResponse;
			getUserLimitsResponse.setWarningDataList(warningDataList);
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				getUserLimitsResponse = (getUserLimitsResponse == null) ? new GetUserLimitsResponse() : getUserLimitsResponse;
				getUserLimitsResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return getUserLimitsResponse;
	}
 
}