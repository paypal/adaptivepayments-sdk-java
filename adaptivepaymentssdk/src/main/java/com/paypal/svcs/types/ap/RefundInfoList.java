package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.RefundInfo;
import java.util.Map;

/**
 * 
 */
public class RefundInfoList{


	/**
	 * 	  
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
	 


	
	public static RefundInfoList createInstance(Map<String, String> map, String prefix, int index) {
		RefundInfoList refundInfoList = null;
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
			RefundInfo refundInfo =  RefundInfo.createInstance(map, prefix + "refundInfo", i);
			if (refundInfo != null) {
				refundInfoList = (refundInfoList == null) ? new RefundInfoList() : refundInfoList;
				refundInfoList.getRefundInfo().add(refundInfo);
				i++;
			} else {
				break;
			}
		}
		return refundInfoList;
	}
 
}