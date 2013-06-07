package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.PaymentInfo;
import java.util.Map;

/**
 * 
 */
public class PaymentInfoList{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private List<PaymentInfo> paymentInfo = new ArrayList<PaymentInfo>();

	

	/**
	 * Default Constructor
	 */
	public PaymentInfoList (){
	}	

	/**
	 * Getter for paymentInfo
	 */
	 public List<PaymentInfo> getPaymentInfo() {
	 	return paymentInfo;
	 }
	 
	/**
	 * Setter for paymentInfo
	 */
	 public void setPaymentInfo(List<PaymentInfo> paymentInfo) {
	 	this.paymentInfo = paymentInfo;
	 }
	 


	
	public static PaymentInfoList createInstance(Map<String, String> map, String prefix, int index) {
		PaymentInfoList paymentInfoList = null;
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
			PaymentInfo paymentInfo =  PaymentInfo.createInstance(map, prefix + "paymentInfo", i);
			if (paymentInfo != null) {
				paymentInfoList = (paymentInfoList == null) ? new PaymentInfoList() : paymentInfoList;
				paymentInfoList.getPaymentInfo().add(paymentInfo);
				i++;
			} else {
				break;
			}
		}
		return paymentInfoList;
	}
 
}