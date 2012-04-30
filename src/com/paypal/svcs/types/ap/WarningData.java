
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import java.util.Map;


/**
 * This type contains the detailed warning
 * information resulting from the service
 * operation.
 */
public class WarningData {

	/**
	 */
	private Integer warningId;
	public Integer getWarningId() {
		return warningId;
	}
	public void setWarningId(Integer value) {
		this.warningId = value;
	}

	/**
	 */
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String value) {
		this.message = value;
	}


	public WarningData() {
	}
	public WarningData(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "warningId") ) {
			this.warningId = Integer.valueOf(map.get(prefix + "warningId"));
		}
		if( map.containsKey(prefix + "message") ) {
			this.message = map.get(prefix + "message");
		}
	}
}
