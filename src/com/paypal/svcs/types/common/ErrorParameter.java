
/**
 * Auto generated code
 */

package com.paypal.svcs.types.common;

import java.util.Map;


/**
 */
public class ErrorParameter {

	/**
	 *
	 * @Required
	 */
	private String value;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 *
	 * @Required
	 */
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String value) {
		this.name = value;
	}


	public ErrorParameter() {
	}
	public ErrorParameter(Map<String, String> map, String prefix) {
		if( map.containsKey(prefix + "value") ) {
			this.value = map.get(prefix + "value");
		}
		if( map.containsKey(prefix + "name") ) {
			this.name = map.get(prefix + "name");
		}
	}
}
