package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.ap.Receiver;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * The error that resulted from an attempt to make a payment to
 * a receiver. 
 */
public class PayError{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private Receiver receiver;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private ErrorData error;

	

	/**
	 * Default Constructor
	 */
	public PayError (){
	}	

	/**
	 * Getter for receiver
	 */
	 public Receiver getReceiver() {
	 	return receiver;
	 }
	 
	/**
	 * Setter for receiver
	 */
	 public void setReceiver(Receiver receiver) {
	 	this.receiver = receiver;
	 }
	 
	/**
	 * Getter for error
	 */
	 public ErrorData getError() {
	 	return error;
	 }
	 
	/**
	 * Setter for error
	 */
	 public void setError(ErrorData error) {
	 	this.error = error;
	 }
	 


	
	public static PayError createInstance(Map<String, String> map, String prefix, int index) {
		PayError payError = null;
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
			
		Receiver receiver =  Receiver.createInstance(map, prefix + "receiver", -1);
		if (receiver != null) {
			payError = (payError == null) ? new PayError() : payError;
			payError.setReceiver(receiver);
		}
		ErrorData error =  ErrorData.createInstance(map, prefix + "error", -1);
		if (error != null) {
			payError = (payError == null) ? new PayError() : payError;
			payError.setError(error);
		}
		return payError;
	}
 
}