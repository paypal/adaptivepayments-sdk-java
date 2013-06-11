package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * 
 */
public class ErrorList{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public ErrorList (){
	}	

	/**
	 * Getter for error
	 */
	 public List<ErrorData> getError() {
	 	return error;
	 }
	 
	/**
	 * Setter for error
	 */
	 public void setError(List<ErrorData> error) {
	 	this.error = error;
	 }
	 


	
	public static ErrorList createInstance(Map<String, String> map, String prefix, int index) {
		ErrorList errorList = null;
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
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				errorList = (errorList == null) ? new ErrorList() : errorList;
				errorList.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return errorList;
	}
 
}