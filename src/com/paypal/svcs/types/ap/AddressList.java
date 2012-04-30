
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 */
public class AddressList {

	/**
	 *
	 * @Required
	 */
	private List<Address> address = new ArrayList<Address>();
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> value) {
		this.address = value;
	}


	public AddressList() {
	}
	public AddressList(Map<String, String> map, String prefix) {
		int i=0; 
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "address" + '(' + i + ')'+ ".addresseeName") ) {
				String newPrefix = prefix + "address" + '(' + i + ')' + '.';
				this.address.add(new Address(map, newPrefix));
			}
			else break;
			i++;
		}
	}
}
