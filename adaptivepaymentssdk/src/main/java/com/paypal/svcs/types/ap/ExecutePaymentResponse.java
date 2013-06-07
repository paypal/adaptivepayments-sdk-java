package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.ResponseEnvelope;
import com.paypal.svcs.types.ap.PayErrorList;
import com.paypal.svcs.types.ap.PostPaymentDisclosureList;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * The result of a payment execution. 
 */
public class ExecutePaymentResponse{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

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
	private PostPaymentDisclosureList postPaymentDisclosureList;

	/**
	 * 	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public ExecutePaymentResponse (){
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
	 * Getter for postPaymentDisclosureList
	 */
	 public PostPaymentDisclosureList getPostPaymentDisclosureList() {
	 	return postPaymentDisclosureList;
	 }
	 
	/**
	 * Setter for postPaymentDisclosureList
	 */
	 public void setPostPaymentDisclosureList(PostPaymentDisclosureList postPaymentDisclosureList) {
	 	this.postPaymentDisclosureList = postPaymentDisclosureList;
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
	 


	
	public static ExecutePaymentResponse createInstance(Map<String, String> map, String prefix, int index) {
		ExecutePaymentResponse executePaymentResponse = null;
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
			executePaymentResponse = (executePaymentResponse == null) ? new ExecutePaymentResponse() : executePaymentResponse;
			executePaymentResponse.setResponseEnvelope(responseEnvelope);
		}
		if (map.containsKey(prefix + "paymentExecStatus")) {
				executePaymentResponse = (executePaymentResponse == null) ? new ExecutePaymentResponse() : executePaymentResponse;
				executePaymentResponse.setPaymentExecStatus(map.get(prefix + "paymentExecStatus"));
		}
		PayErrorList payErrorList =  PayErrorList.createInstance(map, prefix + "payErrorList", -1);
		if (payErrorList != null) {
			executePaymentResponse = (executePaymentResponse == null) ? new ExecutePaymentResponse() : executePaymentResponse;
			executePaymentResponse.setPayErrorList(payErrorList);
		}
		PostPaymentDisclosureList postPaymentDisclosureList =  PostPaymentDisclosureList.createInstance(map, prefix + "postPaymentDisclosureList", -1);
		if (postPaymentDisclosureList != null) {
			executePaymentResponse = (executePaymentResponse == null) ? new ExecutePaymentResponse() : executePaymentResponse;
			executePaymentResponse.setPostPaymentDisclosureList(postPaymentDisclosureList);
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				executePaymentResponse = (executePaymentResponse == null) ? new ExecutePaymentResponse() : executePaymentResponse;
				executePaymentResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return executePaymentResponse;
	}
 
}