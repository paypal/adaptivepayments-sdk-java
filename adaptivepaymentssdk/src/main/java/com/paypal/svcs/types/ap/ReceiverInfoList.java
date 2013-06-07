package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.ReceiverInfo;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * 
 */
public class ReceiverInfoList{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private List<ReceiverInfo> receiverInfo = new ArrayList<ReceiverInfo>();

	

	/**
	 * Constructor with arguments
	 */
	public ReceiverInfoList (List<ReceiverInfo> receiverInfo){
		this.receiverInfo = receiverInfo;
	}	

	/**
	 * Default Constructor
	 */
	public ReceiverInfoList (){
	}	

	/**
	 * Getter for receiverInfo
	 */
	 public List<ReceiverInfo> getReceiverInfo() {
	 	return receiverInfo;
	 }
	 
	/**
	 * Setter for receiverInfo
	 */
	 public void setReceiverInfo(List<ReceiverInfo> receiverInfo) {
	 	this.receiverInfo = receiverInfo;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.receiverInfo != null) {
			for(int i=0; i < this.receiverInfo.size(); i++) {
				String newPrefix = prefix + "receiverInfo" + "(" + i + ").";
				sb.append(this.receiverInfo.get(i).toNVPString(newPrefix));
			}
		}
		return sb.toString();
	}

}