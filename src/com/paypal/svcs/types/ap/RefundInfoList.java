package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.RefundInfo;
import java.util.Map;

/**
 * No Document Comments
 */
public class RefundInfoList{


	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private List<RefundInfo> refundInfo = new ArrayList<RefundInfo>();

	

	/**
	 * Default Constructor
	 */
	public RefundInfoList (){
	}	

	/**
	 * Getter for refundInfo
	 */
	 public List<RefundInfo> getRefundInfo() {
	 	return refundInfo;
	 }
	 
	/**
	 * Setter for refundInfo
	 */
	 public void setRefundInfo(List<RefundInfo> refundInfo) {
	 	this.refundInfo = refundInfo;
	 }
	 


	public RefundInfoList(Map<String, String> map, String prefix) {
		int i = 0;
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "refundInfo" + "(" + i + ")" + ".receiver.amount")){
				String newPrefix = prefix + "refundInfo" + "(" + i + ")" + ".";
				this.refundInfo.add(new RefundInfo(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
	}

}