
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.FundingPlan;
import com.paypal.svcs.types.ap.PayErrorList;
import com.paypal.svcs.types.common.ErrorData;
import com.paypal.svcs.types.common.ResponseEnvelope;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * The PayResponse contains the result of the Pay
 * operation. The payKey and execution status of
 * the request should always be provided.
 */
public class PayResponse {

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
	private String payKey;
	public String getPayKey() {
		return payKey;
	}
	public void setPayKey(String value) {
		this.payKey = value;
	}

	/**
	 *
	 * @Required
	 */
	private String paymentExecStatus;
	public String getPaymentExecStatus() {
		return paymentExecStatus;
	}
	public void setPaymentExecStatus(String value) {
		this.paymentExecStatus = value;
	}

	/**
	 */
	private PayErrorList payErrorList;
	public PayErrorList getPayErrorList() {
		return payErrorList;
	}
	public void setPayErrorList(PayErrorList value) {
		this.payErrorList = value;
	}

	/**
	 */
	private FundingPlan defaultFundingPlan;
	public FundingPlan getDefaultFundingPlan() {
		return defaultFundingPlan;
	}
	public void setDefaultFundingPlan(FundingPlan value) {
		this.defaultFundingPlan = value;
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


	public PayResponse() {
	}
	public PayResponse(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "responseEnvelope" + ".timestamp") ) {
			String newPrefix = prefix + "responseEnvelope" + '.';
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		if( map.containsKey(prefix + "payKey") ) {
			this.payKey = map.get(prefix + "payKey");
		}
		if( map.containsKey(prefix + "paymentExecStatus") ) {
			this.paymentExecStatus = map.get(prefix + "paymentExecStatus");
		}
		if( map.containsKey(prefix + "payErrorList" + ".") ) {
			String newPrefix = prefix + "payErrorList" + '.';
			this.payErrorList =  new PayErrorList(map, newPrefix);
		}
		if( map.containsKey(prefix + "defaultFundingPlan" + ".fundingPlanId") ) {
			String newPrefix = prefix + "defaultFundingPlan" + '.';
			this.defaultFundingPlan =  new FundingPlan(map, newPrefix);
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
