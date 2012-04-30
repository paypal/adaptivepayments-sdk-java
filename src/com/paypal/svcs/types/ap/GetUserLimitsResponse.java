
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.UserLimit;
import com.paypal.svcs.types.ap.WarningDataList;
import com.paypal.svcs.types.common.ErrorData;
import com.paypal.svcs.types.common.ResponseEnvelope;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * A response that contains a list of remaining
 * limits
 */
public class GetUserLimitsResponse {

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
	 *
	 * @Required
	 */
	private List<UserLimit> userLimit = new ArrayList<UserLimit>();
	public List<UserLimit> getUserLimit() {
		return userLimit;
	}
	public void setUserLimit(List<UserLimit> value) {
		this.userLimit = value;
	}

	/**
	 */
	private WarningDataList warningDataList;
	public WarningDataList getWarningDataList() {
		return warningDataList;
	}
	public void setWarningDataList(WarningDataList value) {
		this.warningDataList = value;
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


	public GetUserLimitsResponse() {
	}
	public GetUserLimitsResponse(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "responseEnvelope" + ".timestamp") ) {
			String newPrefix = prefix + "responseEnvelope" + '.';
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "userLimit" + '(' + i + ')'+ ".limitType") ) {
				String newPrefix = prefix + "userLimit" + '(' + i + ')' + '.';
				this.userLimit.add(new UserLimit(map, newPrefix));
			}
			else break;
			i++;
		}
		if( map.containsKey(prefix + "warningDataList" + ".warningData(0).warningId") ) {
			String newPrefix = prefix + "warningDataList" + '.';
			this.warningDataList =  new WarningDataList(map, newPrefix);
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
