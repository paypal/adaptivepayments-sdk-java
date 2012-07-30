package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.ResponseEnvelope;
import com.paypal.svcs.types.ap.PayErrorList;
import com.paypal.svcs.types.ap.FundingPlan;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * The PayResponse contains the result of the Pay operation.
 * The payKey and execution status of the request should always
 * be provided. 
 */
public class PayResponse{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String payKey;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String paymentExecStatus;

	/**
	 * 	 
	 */ 
	private PayErrorList payErrorList;

	/**
	 * 	 
	 */ 
	private FundingPlan defaultFundingPlan;

	/**
	 * 	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public PayResponse (){
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
	 * Getter for payKey
	 */
	 public String getPayKey() {
	 	return payKey;
	 }
	 
	/**
	 * Setter for payKey
	 */
	 public void setPayKey(String payKey) {
	 	this.payKey = payKey;
	 }
	 
	/**
	 * Getter for paymentExecStatus
	 */
	 public String getPaymentExecStatus() {
	 	return paymentExecStatus;
	 }
	 
	/**
	 * Setter for paymentExecStatus
	 */
	 public void setPaymentExecStatus(String paymentExecStatus) {
	 	this.paymentExecStatus = paymentExecStatus;
	 }
	 
	/**
	 * Getter for payErrorList
	 */
	 public PayErrorList getPayErrorList() {
	 	return payErrorList;
	 }
	 
	/**
	 * Setter for payErrorList
	 */
	 public void setPayErrorList(PayErrorList payErrorList) {
	 	this.payErrorList = payErrorList;
	 }
	 
	/**
	 * Getter for defaultFundingPlan
	 */
	 public FundingPlan getDefaultFundingPlan() {
	 	return defaultFundingPlan;
	 }
	 
	/**
	 * Setter for defaultFundingPlan
	 */
	 public void setDefaultFundingPlan(FundingPlan defaultFundingPlan) {
	 	this.defaultFundingPlan = defaultFundingPlan;
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
	 


	public PayResponse(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "responseEnvelope" + ".timestamp")){
			String newPrefix = prefix + "responseEnvelope" + ".";
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		if(map.containsKey(prefix + "payKey")){
			this.payKey = map.get(prefix + "payKey");
		}
		if(map.containsKey(prefix + "paymentExecStatus")){
			this.paymentExecStatus = map.get(prefix + "paymentExecStatus");
		}
		if(map.containsKey(prefix + "payErrorList" + ".payError(0).receiver.amount")){
			String newPrefix = prefix + "payErrorList" + ".";
			this.payErrorList =  new PayErrorList(map, newPrefix);
		}
		if(map.containsKey(prefix + "defaultFundingPlan" + ".fundingPlanId")){
			String newPrefix = prefix + "defaultFundingPlan" + ".";
			this.defaultFundingPlan =  new FundingPlan(map, newPrefix);
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