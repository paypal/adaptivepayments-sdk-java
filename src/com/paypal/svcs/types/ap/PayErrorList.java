
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.PayError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 */
public class PayErrorList {

	/**
	 *
	 * @Required
	 */
	private List<PayError> payError = new ArrayList<PayError>();
	public List<PayError> getPayError() {
		return payError;
	}
	public void setPayError(List<PayError> value) {
		this.payError = value;
	}


	public PayErrorList() {
	}
	public PayErrorList(Map<String, String> map, String prefix) {
		int i=0; 
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "payError" + '(' + i + ')'+ ".error.errorId") ) {
				String newPrefix = prefix + "payError" + '(' + i + ')' + '.';
				this.payError.add(new PayError(map, newPrefix));
			}
			else break;
			i++;
		}
	}
}
