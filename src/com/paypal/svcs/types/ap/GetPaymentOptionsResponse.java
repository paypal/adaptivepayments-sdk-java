package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.ResponseEnvelope;
import com.paypal.svcs.types.ap.InitiatingEntity;
import com.paypal.svcs.types.ap.DisplayOptions;
import com.paypal.svcs.types.ap.SenderOptions;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.ReceiverOptions;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * The response message for the GetPaymentOption request 
 */
public class GetPaymentOptionsResponse{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

	/**
	 * 	 
	 */ 
	private InitiatingEntity initiatingEntity;

	/**
	 * 	 
	 */ 
	private DisplayOptions displayOptions;

	/**
	 * 	 
	 */ 
	private String shippingAddressId;

	/**
	 * 	 
	 */ 
	private SenderOptions senderOptions;

	/**
	 * 	 
	 */ 
	private List<ReceiverOptions> receiverOptions = new ArrayList<ReceiverOptions>();

	/**
	 * 	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public GetPaymentOptionsResponse (){
	}	

	/**
	 * Getter for responseEnvelope
	 */
	 public ResponseEnvelope getResponseEnvelope() {
	 	return responseEnvelope;
	 }
	 
	/**
	 * Setter for responseEnvelope
	 */
	 public void setResponseEnvelope(ResponseEnvelope responseEnvelope) {
	 	this.responseEnvelope = responseEnvelope;
	 }
	 
	/**
	 * Getter for initiatingEntity
	 */
	 public InitiatingEntity getInitiatingEntity() {
	 	return initiatingEntity;
	 }
	 
	/**
	 * Setter for initiatingEntity
	 */
	 public void setInitiatingEntity(InitiatingEntity initiatingEntity) {
	 	this.initiatingEntity = initiatingEntity;
	 }
	 
	/**
	 * Getter for displayOptions
	 */
	 public DisplayOptions getDisplayOptions() {
	 	return displayOptions;
	 }
	 
	/**
	 * Setter for displayOptions
	 */
	 public void setDisplayOptions(DisplayOptions displayOptions) {
	 	this.displayOptions = displayOptions;
	 }
	 
	/**
	 * Getter for shippingAddressId
	 */
	 public String getShippingAddressId() {
	 	return shippingAddressId;
	 }
	 
	/**
	 * Setter for shippingAddressId
	 */
	 public void setShippingAddressId(String shippingAddressId) {
	 	this.shippingAddressId = shippingAddressId;
	 }
	 
	/**
	 * Getter for senderOptions
	 */
	 public SenderOptions getSenderOptions() {
	 	return senderOptions;
	 }
	 
	/**
	 * Setter for senderOptions
	 */
	 public void setSenderOptions(SenderOptions senderOptions) {
	 	this.senderOptions = senderOptions;
	 }
	 
	/**
	 * Getter for receiverOptions
	 */
	 public List<ReceiverOptions> getReceiverOptions() {
	 	return receiverOptions;
	 }
	 
	/**
	 * Setter for receiverOptions
	 */
	 public void setReceiverOptions(List<ReceiverOptions> receiverOptions) {
	 	this.receiverOptions = receiverOptions;
	 }
	 
	/**
	 * Getter for error
	 */
	 public List<ErrorData> getError() {
	 	return error;
	 }
	 
	/**
	 * Setter for error
	 */
	 public void setError(List<ErrorData> error) {
	 	this.error = error;
	 }
	 


	public GetPaymentOptionsResponse(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "responseEnvelope" + ".timestamp")){
			String newPrefix = prefix + "responseEnvelope" + ".";
			this.responseEnvelope =  new ResponseEnvelope(map, newPrefix);
		}
		if(map.containsKey(prefix + "initiatingEntity" + ".institutionCustomer.institutionId")){
			String newPrefix = prefix + "initiatingEntity" + ".";
			this.initiatingEntity =  new InitiatingEntity(map, newPrefix);
		}
		if(map.containsKey(prefix + "displayOptions.emailHeaderImageUrl")){
			String newPrefix = prefix + "displayOptions" + ".";
			this.displayOptions =  new DisplayOptions(map, newPrefix);
		}
		if(map.containsKey(prefix + "shippingAddressId")){
			this.shippingAddressId = map.get(prefix + "shippingAddressId");
		}
		if(map.containsKey(prefix + "senderOptions.requireShippingAddressSelection")){
			String newPrefix = prefix + "senderOptions" + ".";
			this.senderOptions =  new SenderOptions(map, newPrefix);
		}
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "receiverOptions" + "(" + i + ")" + ".description")){
				String newPrefix = prefix + "receiverOptions" + "(" + i + ")" + ".";
				this.receiverOptions.add(new ReceiverOptions(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "error" + "(" + i + ")" + ".errorId")){
				String newPrefix = prefix + "error" + "(" + i + ")" + ".";
				this.error.add(new ErrorData(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
	}

}