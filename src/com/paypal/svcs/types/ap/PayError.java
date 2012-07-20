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
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private Receiver receiver;

	/**
	 * No Document Comments	  
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
	 


	public PayError(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "receiver" + ".amount")){
			String newPrefix = prefix + "receiver" + ".";
			this.receiver =  new Receiver(map, newPrefix);
		}
		if(map.containsKey(prefix + "error" + ".parameter(0)")){
			String newPrefix = prefix + "error" + ".";
			this.error =  new ErrorData(map, newPrefix);
		}
	}

}