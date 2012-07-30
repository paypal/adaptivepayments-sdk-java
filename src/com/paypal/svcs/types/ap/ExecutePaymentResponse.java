package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.ResponseEnvelope;
import com.paypal.svcs.types.ap.PayErrorList;
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
	 


	public ExecutePaymentResponse(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "responseEnvelope" + ".timestamp")){
			String newPrefix = prefix + "responseEnvelope" + ".";
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		if(map.containsKey(prefix + "paymentExecStatus")){
			this.paymentExecStatus = map.get(prefix + "paymentExecStatus");
		}
		if(map.containsKey(prefix + "payErrorList" + ".payError(0).receiver.amount")){
			String newPrefix = prefix + "payErrorList" + ".";
			this.payErrorList =  new PayErrorList(map, newPrefix);
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