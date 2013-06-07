package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.ResponseEnvelope;
import com.paypal.svcs.types.ap.RefundInfoList;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * The result of a Refund request. 
 */
public class RefundResponse{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String currencyCode;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private RefundInfoList refundInfoList;

	/**
	 * 	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public RefundResponse (){
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
	 * Getter for currencyCode
	 */
	 public String getCurrencyCode() {
	 	return currencyCode;
	 }
	 
	/**
	 * Setter for currencyCode
	 */
	 public void setCurrencyCode(String currencyCode) {
	 	this.currencyCode = currencyCode;
	 }
	 
	/**
	 * Getter for refundInfoList
	 */
	 public RefundInfoList getRefundInfoList() {
	 	return refundInfoList;
	 }
	 
	/**
	 * Setter for refundInfoList
	 */
	 public void setRefundInfoList(RefundInfoList refundInfoList) {
	 	this.refundInfoList = refundInfoList;
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
	 


	
	public static RefundResponse createInstance(Map<String, String> map, String prefix, int index) {
		RefundResponse refundResponse = null;
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
			refundResponse = (refundResponse == null) ? new RefundResponse() : refundResponse;
			refundResponse.setResponseEnvelope(responseEnvelope);
		}
		if (map.containsKey(prefix + "currencyCode")) {
				refundResponse = (refundResponse == null) ? new RefundResponse() : refundResponse;
				refundResponse.setCurrencyCode(map.get(prefix + "currencyCode"));
		}
		RefundInfoList refundInfoList =  RefundInfoList.createInstance(map, prefix + "refundInfoList", -1);
		if (refundInfoList != null) {
			refundResponse = (refundResponse == null) ? new RefundResponse() : refundResponse;
			refundResponse.setRefundInfoList(refundInfoList);
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				refundResponse = (refundResponse == null) ? new RefundResponse() : refundResponse;
				refundResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return refundResponse;
	}
 
}