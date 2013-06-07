package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.ResponseEnvelope;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.FundingPlan;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * The response to get the funding plans available for a
 * payment. 
 */
public class GetFundingPlansResponse{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

	/**
	 * 	 
	 */ 
	private List<FundingPlan> fundingPlan = new ArrayList<FundingPlan>();

	/**
	 * 	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public GetFundingPlansResponse (){
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
	 * Getter for fundingPlan
	 */
	 public List<FundingPlan> getFundingPlan() {
	 	return fundingPlan;
	 }
	 
	/**
	 * Setter for fundingPlan
	 */
	 public void setFundingPlan(List<FundingPlan> fundingPlan) {
	 	this.fundingPlan = fundingPlan;
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
	 


	
	public static GetFundingPlansResponse createInstance(Map<String, String> map, String prefix, int index) {
		GetFundingPlansResponse getFundingPlansResponse = null;
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
			getFundingPlansResponse = (getFundingPlansResponse == null) ? new GetFundingPlansResponse() : getFundingPlansResponse;
			getFundingPlansResponse.setResponseEnvelope(responseEnvelope);
		}
		i = 0;
		while(true) {
			FundingPlan fundingPlan =  FundingPlan.createInstance(map, prefix + "fundingPlan", i);
			if (fundingPlan != null) {
				getFundingPlansResponse = (getFundingPlansResponse == null) ? new GetFundingPlansResponse() : getFundingPlansResponse;
				getFundingPlansResponse.getFundingPlan().add(fundingPlan);
				i++;
			} else {
				break;
			}
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				getFundingPlansResponse = (getFundingPlansResponse == null) ? new GetFundingPlansResponse() : getFundingPlansResponse;
				getFundingPlansResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return getFundingPlansResponse;
	}
 
}