
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.PaymentInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 */
public class PaymentInfoList {

	/**
	 *
	 * @Required
	 */
	private List<PaymentInfo> paymentInfo = new ArrayList<PaymentInfo>();
	public List<PaymentInfo> getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(List<PaymentInfo> value) {
		this.paymentInfo = value;
	}


	public PaymentInfoList() {
	}
	public PaymentInfoList(Map<String, String> map, String prefix) {
		int i=0; 
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "paymentInfo" + '(' + i + ')'+ ".transactionId") ) {
				String newPrefix = prefix + "paymentInfo" + '(' + i + ')' + '.';
				this.paymentInfo.add(new PaymentInfo(map, newPrefix));
			}
			else break;
			i++;
		}
	}
}
