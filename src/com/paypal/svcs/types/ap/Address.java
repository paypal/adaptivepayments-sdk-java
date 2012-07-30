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
	 


	public Address(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "addresseeName")){
			this.addresseeName = map.get(prefix + "addresseeName");
		}
		if(map.containsKey(prefix + "baseAddress" + ".line1")){
			String newPrefix = prefix + "baseAddress" + ".";
			this.baseAddress =  new BaseAddress(map, newPrefix);
		}
		if(map.containsKey(prefix + "addressId")){
			this.addressId = map.get(prefix + "addressId");
		}
	}

}