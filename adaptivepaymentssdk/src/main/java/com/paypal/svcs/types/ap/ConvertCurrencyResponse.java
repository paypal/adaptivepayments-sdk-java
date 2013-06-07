package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.ResponseEnvelope;
import com.paypal.svcs.types.ap.CurrencyConversionTable;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * A response that contains a table of estimated converted
 * currencies based on the Convert Currency Request. 
 */
public class ConvertCurrencyResponse{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private CurrencyConversionTable estimatedAmountTable;

	/**
	 * 	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public ConvertCurrencyResponse (){
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
	 * Getter for estimatedAmountTable
	 */
	 public CurrencyConversionTable getEstimatedAmountTable() {
	 	return estimatedAmountTable;
	 }
	 
	/**
	 * Setter for estimatedAmountTable
	 */
	 public void setEstimatedAmountTable(CurrencyConversionTable estimatedAmountTable) {
	 	this.estimatedAmountTable = estimatedAmountTable;
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
	 


	
	public static ConvertCurrencyResponse createInstance(Map<String, String> map, String prefix, int index) {
		ConvertCurrencyResponse convertCurrencyResponse = null;
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
			convertCurrencyResponse = (convertCurrencyResponse == null) ? new ConvertCurrencyResponse() : convertCurrencyResponse;
			convertCurrencyResponse.setResponseEnvelope(responseEnvelope);
		}
		CurrencyConversionTable estimatedAmountTable =  CurrencyConversionTable.createInstance(map, prefix + "estimatedAmountTable", -1);
		if (estimatedAmountTable != null) {
			convertCurrencyResponse = (convertCurrencyResponse == null) ? new ConvertCurrencyResponse() : convertCurrencyResponse;
			convertCurrencyResponse.setEstimatedAmountTable(estimatedAmountTable);
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				convertCurrencyResponse = (convertCurrencyResponse == null) ? new ConvertCurrencyResponse() : convertCurrencyResponse;
				convertCurrencyResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return convertCurrencyResponse;
	}
 
}