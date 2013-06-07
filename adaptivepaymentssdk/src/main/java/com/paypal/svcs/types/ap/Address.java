package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.BaseAddress;
import java.util.Map;

/**
 * 
 */
public class Address{


	/**
	 * 	 
	 */ 
	private String addresseeName;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private BaseAddress baseAddress;

	/**
	 * 	 
	 */ 
	private String addressId;

	

	/**
	 * Default Constructor
	 */
	public Address (){
	}	

	/**
	 * Getter for addresseeName
	 */
	 public String getAddresseeName() {
	 	return addresseeName;
	 }
	 
	/**
	 * Setter for addresseeName
	 */
	 public void setAddresseeName(String addresseeName) {
	 	this.addresseeName = addresseeName;
	 }
	 
	/**
	 * Getter for baseAddress
	 */
	 public BaseAddress getBaseAddress() {
	 	return baseAddress;
	 }
	 
	/**
	 * Setter for baseAddress
	 */
	 public void setBaseAddress(BaseAddress baseAddress) {
	 	this.baseAddress = baseAddress;
	 }
	 
	/**
	 * Getter for addressId
	 */
	 public String getAddressId() {
	 	return addressId;
	 }
	 
	/**
	 * Setter for addressId
	 */
	 public void setAddressId(String addressId) {
	 	this.addressId = addressId;
	 }
	 


	
	public static Address createInstance(Map<String, String> map, String prefix, int index) {
		Address address = null;
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
			
		if (map.containsKey(prefix + "addresseeName")) {
				address = (address == null) ? new Address() : address;
				address.setAddresseeName(map.get(prefix + "addresseeName"));
		}
		BaseAddress baseAddress =  BaseAddress.createInstance(map, prefix + "baseAddress", -1);
		if (baseAddress != null) {
			address = (address == null) ? new Address() : address;
			address.setBaseAddress(baseAddress);
		}
		if (map.containsKey(prefix + "addressId")) {
				address = (address == null) ? new Address() : address;
				address.setAddressId(map.get(prefix + "addressId"));
		}
		return address;
	}
 
}