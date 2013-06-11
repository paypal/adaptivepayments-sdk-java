package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.Receiver;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * 
 */
public class ReceiverList{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private List<Receiver> receiver = new ArrayList<Receiver>();

	

	/**
	 * Constructor with arguments
	 */
	public ReceiverList (List<Receiver> receiver){
		this.receiver = receiver;
	}	

	/**
	 * Default Constructor
	 */
	public ReceiverList (){
	}	

	/**
	 * Getter for receiver
	 */
	 public List<Receiver> getReceiver() {
	 	return receiver;
	 }
	 
	/**
	 * Setter for receiver
	 */
	 public void setReceiver(List<Receiver> receiver) {
	 	this.receiver = receiver;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.receiver != null) {
			for(int i=0; i < this.receiver.size(); i++) {
				String newPrefix = prefix + "receiver" + "(" + i + ").";
				sb.append(this.receiver.get(i).toNVPString(newPrefix));
			}
		}
		return sb.toString();
	}

}