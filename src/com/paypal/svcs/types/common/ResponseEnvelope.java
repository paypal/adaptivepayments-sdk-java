package com.paypal.svcs.types.common;
import com.paypal.svcs.types.common.AckCode;
import java.util.Map;

/**
 * This specifies a list of parameters with every response from
 * a service. 
 */
public class ResponseEnvelope{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private String timestamp;

	/**
	 * Application level acknowledgment code. 	  
	 *@Required	 
	 */ 
	private AckCode ack;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String correlationId;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private String build;

	

	/**
	 * Default Constructor
	 */
	public ResponseEnvelope (){
	}	

	/**
	 * Getter for timestamp
	 */
	 public String getTimestamp() {
	 	return timestamp;
	 }
	 
	/**
	 * Setter for timestamp
	 */
	 public void setTimestamp(String timestamp) {
	 	this.timestamp = timestamp;
	 }
	 
	/**
	 * Getter for ack
	 */
	 public AckCode getAck() {
	 	return ack;
	 }
	 
	/**
	 * Setter for ack
	 */
	 public void setAck(AckCode ack) {
	 	this.ack = ack;
	 }
	 
	/**
	 * Getter for correlationId
	 */
	 public String getCorrelationId() {
	 	return correlationId;
	 }
	 
	/**
	 * Setter for correlationId
	 */
	 public void setCorrelationId(String correlationId) {
	 	this.correlationId = correlationId;
	 }
	 
	/**
	 * Getter for build
	 */
	 public String getBuild() {
	 	return build;
	 }
	 
	/**
	 * Setter for build
	 */
	 public void setBuild(String build) {
	 	this.build = build;
	 }
	 


	public ResponseEnvelope(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "timestamp")){
			this.timestamp = map.get(prefix + "timestamp");
		}
		if(map.containsKey(prefix + "ack")){
			this.ack = AckCode.fromValue(map.get(prefix + "ack"));
		}
		if(map.containsKey(prefix + "correlationId")){
			this.correlationId = map.get(prefix + "correlationId");
		}
		if(map.containsKey(prefix + "build")){
			this.build = map.get(prefix + "build");
		}
	}

}