
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.DisplayOptions;
import com.paypal.svcs.types.ap.InitiatingEntity;
import com.paypal.svcs.types.ap.ReceiverOptions;
import com.paypal.svcs.types.ap.SenderOptions;
import com.paypal.svcs.types.common.ErrorData;
import com.paypal.svcs.types.common.ResponseEnvelope;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * The response message for the GetPaymentOption
 * request
 */
public class GetPaymentOptionsResponse {

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
	private InitiatingEntity initiatingEntity;
	public InitiatingEntity getInitiatingEntity() {
		return initiatingEntity;
	}
	public void setInitiatingEntity(InitiatingEntity value) {
		this.initiatingEntity = value;
	}

	/**
	 */
	private DisplayOptions displayOptions;
	public DisplayOptions getDisplayOptions() {
		return displayOptions;
	}
	public void setDisplayOptions(DisplayOptions value) {
		this.displayOptions = value;
	}

	/**
	 */
	private String shippingAddressId;
	public String getShippingAddressId() {
		return shippingAddressId;
	}
	public void setShippingAddressId(String value) {
		this.shippingAddressId = value;
	}

	/**
	 */
	private SenderOptions senderOptions;
	public SenderOptions getSenderOptions() {
		return senderOptions;
	}
	public void setSenderOptions(SenderOptions value) {
		this.senderOptions = value;
	}

	/**
	 */
	private List<ReceiverOptions> receiverOptions = new ArrayList<ReceiverOptions>();
	public List<ReceiverOptions> getReceiverOptions() {
		return receiverOptions;
	}
	public void setReceiverOptions(List<ReceiverOptions> value) {
		this.receiverOptions = value;
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


	public GetPaymentOptionsResponse() {
	}
	public GetPaymentOptionsResponse(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "responseEnvelope" + ".timestamp") ) {
			String newPrefix = prefix + "responseEnvelope" + '.';
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		if( map.containsKey(prefix + "initiatingEntity" + ".institutionCustomer.institutionId") ) {
			String newPrefix = prefix + "initiatingEntity" + '.';
			this.initiatingEntity =  new InitiatingEntity(map, newPrefix);
		}
		if( map.containsKey(prefix + "displayOptions" + ".emailHeaderImageUrl") ) {
			String newPrefix = prefix + "displayOptions" + '.';
			this.displayOptions =  new DisplayOptions(map, newPrefix);
		}
		if( map.containsKey(prefix + "shippingAddressId") ) {
			this.shippingAddressId = map.get(prefix + "shippingAddressId");
		}
		if( map.containsKey(prefix + "senderOptions" + ".requireShippingAddressSelection") ) {
			String newPrefix = prefix + "senderOptions" + '.';
			this.senderOptions =  new SenderOptions(map, newPrefix);
		}
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "receiverOptions" + '(' + i + ')'+ ".description") ) {
				String newPrefix = prefix + "receiverOptions" + '(' + i + ')' + '.';
				this.receiverOptions.add(new ReceiverOptions(map, newPrefix));
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
