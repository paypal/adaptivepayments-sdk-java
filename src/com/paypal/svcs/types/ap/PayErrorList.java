package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.PayError;
import java.util.Map;

/**
 * No Document Comments
 */
public class PayErrorList{


	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private List<PayError> payError = new ArrayList<PayError>();

	

	/**
	 * Default Constructor
	 */
	public PayErrorList (){
	}	

	/**
	 * Getter for payError
	 */
	 public List<PayError> getPayError() {
	 	return payError;
	 }
	 
	/**
	 * Setter for payError
	 */
	 public void setPayError(List<PayError> payError) {
	 	this.payError = payError;
	 }
	 


	public PayErrorList(Map<String, String> map, String prefix) {
		int i = 0;
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "payError" + "(" + i + ")" + ".receiver.amount")){
				String newPrefix = prefix + "payError" + "(" + i + ")" + ".";
				this.payError.add(new PayError(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
	}

}