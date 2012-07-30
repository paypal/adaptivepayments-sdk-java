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
	 


	public PaymentInfoList(Map<String, String> map, String prefix) {
		int i = 0;
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "paymentInfo" + "(" + i + ")" + ".receiver.amount")){
				String newPrefix = prefix + "paymentInfo" + "(" + i + ")" + ".";
				this.paymentInfo.add(new PaymentInfo(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
	}

}