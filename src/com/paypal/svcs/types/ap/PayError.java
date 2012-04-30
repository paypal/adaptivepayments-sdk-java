
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.Receiver;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;


/**
 * The error that resulted from an attempt to make
 * a payment to a receiver.
 */
public class PayError {

	/**
	 *
	 * @Required
	 */
	private Receiver receiver;
	public Receiver getReceiver() {
		return receiver;
	}
	public void setReceiver(Receiver value) {
		this.receiver = value;
	}

	/**
	 *
	 * @Required
	 */
	private ErrorData error;
	public ErrorData getError() {
		return error;
	}
	public void setError(ErrorData value) {
		this.error = value;
	}


	public PayError() {
	}
	public PayError(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "receiver" + ".amount") ) {
			String newPrefix = prefix + "receiver" + '.';
			this.receiver =  new Receiver(map, newPrefix);
		}
		if( map.containsKey(prefix + "error" + ".errorId") ) {
			String newPrefix = prefix + "error" + '.';
			this.error =  new ErrorData(map, newPrefix);
		}
	}
}
