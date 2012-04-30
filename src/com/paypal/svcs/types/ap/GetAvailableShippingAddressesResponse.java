
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.Address;
import com.paypal.svcs.types.common.ErrorData;
import com.paypal.svcs.types.common.ResponseEnvelope;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * The response to get the shipping addresses
 * available for a payment.
 */
public class GetAvailableShippingAddressesResponse {

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
	private List<Address> availableAddress = new ArrayList<Address>();
	public List<Address> getAvailableAddress() {
		return availableAddress;
	}
	public void setAvailableAddress(List<Address> value) {
		this.availableAddress = value;
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


	public GetAvailableShippingAddressesResponse() {
	}
	public GetAvailableShippingAddressesResponse(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "responseEnvelope" + ".timestamp") ) {
			String newPrefix = prefix + "responseEnvelope" + '.';
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "availableAddress" + '(' + i + ')'+ ".addresseeName") ) {
				String newPrefix = prefix + "availableAddress" + '(' + i + ')' + '.';
				this.availableAddress.add(new Address(map, newPrefix));
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
