package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.Address;
import java.util.Map;

/**
 * No Document Comments
 */
public class AddressList{


	/**
	 * No Document Comments	  
	 *@Required	 
	 */ 
	private List<Address> address = new ArrayList<Address>();

	

	/**
	 * Default Constructor
	 */
	public AddressList (){
	}	

	/**
	 * Getter for address
	 */
	 public List<Address> getAddress() {
	 	return address;
	 }
	 
	/**
	 * Setter for address
	 */
	 public void setAddress(List<Address> address) {
	 	this.address = address;
	 }
	 


	public AddressList(Map<String, String> map, String prefix) {
		int i = 0;
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "address" + "(" + i + ")" + ".baseAddress.line1")){
				String newPrefix = prefix + "address" + "(" + i + ")" + ".";
				this.address.add(new Address(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
	}

}