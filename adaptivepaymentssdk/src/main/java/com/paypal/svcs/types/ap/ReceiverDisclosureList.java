package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.ReceiverDisclosure;
import java.util.Map;

/**
 * 
 */
public class ReceiverDisclosureList{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private List<ReceiverDisclosure> receiverDisclosure = new ArrayList<ReceiverDisclosure>();

	

	/**
	 * Default Constructor
	 */
	public ReceiverDisclosureList (){
	}	

	/**
	 * Getter for receiverDisclosure
	 */
	 public List<ReceiverDisclosure> getReceiverDisclosure() {
	 	return receiverDisclosure;
	 }
	 
	/**
	 * Setter for receiverDisclosure
	 */
	 public void setReceiverDisclosure(List<ReceiverDisclosure> receiverDisclosure) {
	 	this.receiverDisclosure = receiverDisclosure;
	 }
	 


	
	public static ReceiverDisclosureList createInstance(Map<String, String> map, String prefix, int index) {
		ReceiverDisclosureList receiverDisclosureList = null;
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
			ReceiverDisclosure receiverDisclosure =  ReceiverDisclosure.createInstance(map, prefix + "receiverDisclosure", i);
			if (receiverDisclosure != null) {
				receiverDisclosureList = (receiverDisclosureList == null) ? new ReceiverDisclosureList() : receiverDisclosureList;
				receiverDisclosureList.getReceiverDisclosure().add(receiverDisclosure);
				i++;
			} else {
				break;
			}
		}
		return receiverDisclosureList;
	}
 
}