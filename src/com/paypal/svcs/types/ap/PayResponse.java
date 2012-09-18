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
	 


	
	public static PayResponse createInstance(Map<String, String> map, String prefix, int index) {
		PayResponse payResponse = null;
		int i = 0;
		if (index != -1) {
				if (!prefix.isEmpty() && !prefix.endsWith(".")) {
					prefix = prefix + "(" + index + ").";
				}
		} else {
			if (!prefix.isEmpty() && !prefix.endsWith(".")) {
				prefix = prefix + ".";
			}
		}
			
		ResponseEnvelope responseEnvelope =  ResponseEnvelope.createInstance(map, prefix + "responseEnvelope", -1);
		if (responseEnvelope != null) {
			payResponse = (payResponse == null) ? new PayResponse() : payResponse;
			payResponse.setResponseEnvelope(responseEnvelope);
		}
		if (map.containsKey(prefix + "payKey")) {
				payResponse = (payResponse == null) ? new PayResponse() : payResponse;
				payResponse.setPayKey(map.get(prefix + "payKey"));
		}
		if (map.containsKey(prefix + "paymentExecStatus")) {
				payResponse = (payResponse == null) ? new PayResponse() : payResponse;
				payResponse.setPaymentExecStatus(map.get(prefix + "paymentExecStatus"));
		}
		PayErrorList payErrorList =  PayErrorList.createInstance(map, prefix + "payErrorList", -1);
		if (payErrorList != null) {
			payResponse = (payResponse == null) ? new PayResponse() : payResponse;
			payResponse.setPayErrorList(payErrorList);
		}
		FundingPlan defaultFundingPlan =  FundingPlan.createInstance(map, prefix + "defaultFundingPlan", -1);
		if (defaultFundingPlan != null) {
			payResponse = (payResponse == null) ? new PayResponse() : payResponse;
			payResponse.setDefaultFundingPlan(defaultFundingPlan);
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				payResponse = (payResponse == null) ? new PayResponse() : payResponse;
				payResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return payResponse;
	}
 
}