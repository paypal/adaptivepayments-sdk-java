package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.PayError;
import java.util.Map;

/**
 * 
 */
public class PayErrorList{


	/**
	 * 	  
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
	 


	
	public static PayErrorList createInstance(Map<String, String> map, String prefix, int index) {
		PayErrorList payErrorList = null;
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
			
		i = 0;
		while(true) {
			PayError payError =  PayError.createInstance(map, prefix + "payError", i);
			if (payError != null) {
				payErrorList = (payErrorList == null) ? new PayErrorList() : payErrorList;
				payErrorList.getPayError().add(payError);
				i++;
			} else {
				break;
			}
		}
		return payErrorList;
	}
 
}