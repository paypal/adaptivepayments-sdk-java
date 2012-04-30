
/**
 * Auto generated code
 */

package com.paypal.svcs.types.common;

import com.paypal.svcs.types.common.AckCode;
import java.util.Map;


/**
 * This specifies a list of parameters with every
 * response from a service.
 */
public class ResponseEnvelope {

	/**
	 *
	 * @Required
	 */
	private String timestamp;
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String value) {
		this.timestamp = value;
	}

	/**
	 * Application level acknowledgment code.
	 *
	 * @Required
	 */
	private AckCode ack;
	public AckCode getAck() {
		return ack;
	}
	public void setAck(AckCode value) {
		this.ack = value;
	}

	/**
	 *
	 * @Required
	 */
	private String correlationId;
	public String getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(String value) {
		this.correlationId = value;
	}

	/**
	 *
	 * @Required
	 */
	private String build;
	public String getBuild() {
		return build;
	}
	public void setBuild(String value) {
		this.build = value;
	}


	public ResponseEnvelope() {
	}
	public ResponseEnvelope(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "timestamp") ) {
			this.timestamp = map.get(prefix + "timestamp");
		}
		if( map.containsKey(prefix + "ack") ) {
			this.ack = AckCode.fromValue( map.get(prefix + "ack") );
		}
		if( map.containsKey(prefix + "correlationId") ) {
			this.correlationId = map.get(prefix + "correlationId");
		}
		if( map.containsKey(prefix + "build") ) {
			this.build = map.get(prefix + "build");
		}
	}
}
