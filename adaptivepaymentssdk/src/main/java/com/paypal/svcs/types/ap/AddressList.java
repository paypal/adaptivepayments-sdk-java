package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.Address;
import java.util.Map;

/**
 * 
 */
public class AddressList{


	/**
	 * 	  
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
	 


	
	public static AddressList createInstance(Map<String, String> map, String prefix, int index) {
		AddressList addressList = null;
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
			Address address =  Address.createInstance(map, prefix + "address", i);
			if (address != null) {
				addressList = (addressList == null) ? new AddressList() : addressList;
				addressList.getAddress().add(address);
				i++;
			} else {
				break;
			}
		}
		return addressList;
	}
 
}