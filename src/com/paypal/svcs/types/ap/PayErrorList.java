
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
		for(int i=0; i<10; i++) {
			if( map.containsKey(prefix + "payError" + '(' + i + ')'+ ".error(0).errorId") ) {
				String newPrefix = prefix + "payError" + '(' + i + ')' + '.';
				this.payError.add(new PayError(map, newPrefix));
			}
		}
	}
}
