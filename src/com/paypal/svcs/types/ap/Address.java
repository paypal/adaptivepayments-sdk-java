
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.common.BaseAddress;
import java.util.Map;


/**
 */
public class Address {

	/**
	 */
	private String addresseeName;
	public String getAddresseeName() {
		return addresseeName;
	}
	public void setAddresseeName(String value) {
		this.addresseeName = value;
	}

	/**
	 *
	 * @Required
	 */
	private BaseAddress baseAddress;
	public BaseAddress getBaseAddress() {
		return baseAddress;
	}
	public void setBaseAddress(BaseAddress value) {
		this.baseAddress = value;
	}

	/**
	 */
	private String addressId;
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String value) {
		this.addressId = value;
	}


	public Address() {
	}
	public Address(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "addresseeName") ) {
			this.addresseeName = map.get(prefix + "addresseeName");
		}
		if( map.containsKey(prefix + "baseAddress" + ".line1") ) {
			String newPrefix = prefix + "baseAddress" + '.';
			this.baseAddress =  new BaseAddress(map, newPrefix);
		}
		if( map.containsKey(prefix + "addressId") ) {
			this.addressId = map.get(prefix + "addressId");
		}
	}
}
