package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.ResponseEnvelope;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.FundingSource;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * The response to get the backup funding sources available for
 * a preapproval. 
 */
public class GetAllowedFundingSourcesResponse{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

	/**
	 * 	 
	 */ 
	private List<FundingSource> fundingSource = new ArrayList<FundingSource>();

	/**
	 * 	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public GetAllowedFundingSourcesResponse (){
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
	 * Getter for fundingSource
	 */
	 public List<FundingSource> getFundingSource() {
	 	return fundingSource;
	 }
	 
	/**
	 * Setter for fundingSource
	 */
	 public void setFundingSource(List<FundingSource> fundingSource) {
	 	this.fundingSource = fundingSource;
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
	 


	
	public static GetAllowedFundingSourcesResponse createInstance(Map<String, String> map, String prefix, int index) {
		GetAllowedFundingSourcesResponse getAllowedFundingSourcesResponse = null;
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
			getAllowedFundingSourcesResponse = (getAllowedFundingSourcesResponse == null) ? new GetAllowedFundingSourcesResponse() : getAllowedFundingSourcesResponse;
			getAllowedFundingSourcesResponse.setResponseEnvelope(responseEnvelope);
		}
		i = 0;
		while(true) {
			FundingSource fundingSource =  FundingSource.createInstance(map, prefix + "fundingSource", i);
			if (fundingSource != null) {
				getAllowedFundingSourcesResponse = (getAllowedFundingSourcesResponse == null) ? new GetAllowedFundingSourcesResponse() : getAllowedFundingSourcesResponse;
				getAllowedFundingSourcesResponse.getFundingSource().add(fundingSource);
				i++;
			} else {
				break;
			}
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				getAllowedFundingSourcesResponse = (getAllowedFundingSourcesResponse == null) ? new GetAllowedFundingSourcesResponse() : getAllowedFundingSourcesResponse;
				getAllowedFundingSourcesResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return getAllowedFundingSourcesResponse;
	}
 
}