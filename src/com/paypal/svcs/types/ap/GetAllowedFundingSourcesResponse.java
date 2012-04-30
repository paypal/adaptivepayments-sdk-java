
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.FundingSource;
import com.paypal.svcs.types.common.ErrorData;
import com.paypal.svcs.types.common.ResponseEnvelope;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * The response to get the backup funding sources
 * available for a preapproval.
 */
public class GetAllowedFundingSourcesResponse {

	/**
	 *
	 * @Required
	 */
	private ResponseEnvelope responseEnvelope;
	public ResponseEnvelope getResponseEnvelope() {
		return responseEnvelope;
	}
	public void setResponseEnvelope(ResponseEnvelope value) {
		this.responseEnvelope = value;
	}

	/**
	 */
	private List<FundingSource> fundingSource = new ArrayList<FundingSource>();
	public List<FundingSource> getFundingSource() {
		return fundingSource;
	}
	public void setFundingSource(List<FundingSource> value) {
		this.fundingSource = value;
	}

	/**
	 */
	private List<ErrorData> error = new ArrayList<ErrorData>();
	public List<ErrorData> getError() {
		return error;
	}
	public void setError(List<ErrorData> value) {
		this.error = value;
	}


	public GetAllowedFundingSourcesResponse() {
	}
	public GetAllowedFundingSourcesResponse(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "responseEnvelope" + ".timestamp") ) {
			String newPrefix = prefix + "responseEnvelope" + '.';
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "fundingSource" + '(' + i + ')'+ ".lastFourOfAccountNumber") ) {
				String newPrefix = prefix + "fundingSource" + '(' + i + ')' + '.';
				this.fundingSource.add(new FundingSource(map, newPrefix));
			}
			else break;
			i++;
		}
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "error" + '(' + i + ')'+ ".errorId") ) {
				String newPrefix = prefix + "error" + '(' + i + ')' + '.';
				this.error.add(new ErrorData(map, newPrefix));
			}
			else break;
			i++;
		}
	}
}
