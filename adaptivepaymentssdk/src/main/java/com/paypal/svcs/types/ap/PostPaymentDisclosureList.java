package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.PostPaymentDisclosure;
import java.util.Map;

/**
 * 
 */
public class PostPaymentDisclosureList{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private List<PostPaymentDisclosure> postPaymentDisclosure = new ArrayList<PostPaymentDisclosure>();

	

	/**
	 * Default Constructor
	 */
	public PostPaymentDisclosureList (){
	}	

	/**
	 * Getter for postPaymentDisclosure
	 */
	 public List<PostPaymentDisclosure> getPostPaymentDisclosure() {
	 	return postPaymentDisclosure;
	 }
	 
	/**
	 * Setter for postPaymentDisclosure
	 */
	 public void setPostPaymentDisclosure(List<PostPaymentDisclosure> postPaymentDisclosure) {
	 	this.postPaymentDisclosure = postPaymentDisclosure;
	 }
	 


	
	public static PostPaymentDisclosureList createInstance(Map<String, String> map, String prefix, int index) {
		PostPaymentDisclosureList postPaymentDisclosureList = null;
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
			PostPaymentDisclosure postPaymentDisclosure =  PostPaymentDisclosure.createInstance(map, prefix + "postPaymentDisclosure", i);
			if (postPaymentDisclosure != null) {
				postPaymentDisclosureList = (postPaymentDisclosureList == null) ? new PostPaymentDisclosureList() : postPaymentDisclosureList;
				postPaymentDisclosureList.getPostPaymentDisclosure().add(postPaymentDisclosure);
				i++;
			} else {
				break;
			}
		}
		return postPaymentDisclosureList;
	}
 
}