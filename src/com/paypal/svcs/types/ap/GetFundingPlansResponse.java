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
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

	/**
	 * No Document Comments	 
	 */ 
	private List<FundingPlan> fundingPlan = new ArrayList<FundingPlan>();

	/**
	 * No Document Comments	 
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
	 


	public GetFundingPlansResponse(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "responseEnvelope" + ".timestamp")){
			String newPrefix = prefix + "responseEnvelope" + ".";
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "fundingPlan" + "(" + i + ")" + ".fundingPlanId")){
				String newPrefix = prefix + "fundingPlan" + "(" + i + ")" + ".";
				this.fundingPlan.add(new FundingPlan(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "error" + "(" + i + ")" + ".parameter(0)")){
				String newPrefix = prefix + "error" + "(" + i + ")" + ".";
				this.error.add(new ErrorData(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
	}

}