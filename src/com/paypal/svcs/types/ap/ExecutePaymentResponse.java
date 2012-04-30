
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.PayErrorList;
import com.paypal.svcs.types.common.ErrorData;
import com.paypal.svcs.types.common.ResponseEnvelope;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * The result of a payment execution.
 */
public class ExecutePaymentResponse {

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
	private List<ErrorData> error = new ArrayList<ErrorData>();
	public List<ErrorData> getError() {
		return error;
	}
	public void setError(List<ErrorData> value) {
		this.error = value;
	}


	public ExecutePaymentResponse() {
	}
	public ExecutePaymentResponse(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "responseEnvelope" + ".timestamp") ) {
			String newPrefix = prefix + "responseEnvelope" + '.';
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		if( map.containsKey(prefix + "paymentExecStatus") ) {
			this.paymentExecStatus = map.get(prefix + "paymentExecStatus");
		}
		if( map.containsKey(prefix + "payErrorList" + ".") ) {
			String newPrefix = prefix + "payErrorList" + '.';
			this.payErrorList =  new PayErrorList(map, newPrefix);
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
