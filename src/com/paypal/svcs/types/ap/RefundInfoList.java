
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.RefundInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 */
public class RefundInfoList {

	/**
	 *
	 * @Required
	 */
	private List<RefundInfo> refundInfo = new ArrayList<RefundInfo>();
	public List<RefundInfo> getRefundInfo() {
		return refundInfo;
	}
	public void setRefundInfo(List<RefundInfo> value) {
		this.refundInfo = value;
	}


	public RefundInfoList() {
	}
	public RefundInfoList(Map<String, String> map, String prefix) {
		 while(true) {
		int i=0; 
			if( map.containsKey(prefix + "refundInfo" + '(' + i + ')'+ ".refundStatus") ) {
				String newPrefix = prefix + "refundInfo" + '(' + i + ')' + '.';
				this.refundInfo.add(new RefundInfo(map, newPrefix));
			}
			else break;
			i++;
		}
	}
}
