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
	 


	
	public static GetPaymentOptionsResponse createInstance(Map<String, String> map, String prefix, int index) {
		GetPaymentOptionsResponse getPaymentOptionsResponse = null;
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
			
		ResponseEnvelope responseEnvelope =  ResponseEnvelope.createInstance(map, prefix + "responseEnvelope", -1);
		if (responseEnvelope != null) {
			getPaymentOptionsResponse = (getPaymentOptionsResponse == null) ? new GetPaymentOptionsResponse() : getPaymentOptionsResponse;
			getPaymentOptionsResponse.setResponseEnvelope(responseEnvelope);
		}
		InitiatingEntity initiatingEntity =  InitiatingEntity.createInstance(map, prefix + "initiatingEntity", -1);
		if (initiatingEntity != null) {
			getPaymentOptionsResponse = (getPaymentOptionsResponse == null) ? new GetPaymentOptionsResponse() : getPaymentOptionsResponse;
			getPaymentOptionsResponse.setInitiatingEntity(initiatingEntity);
		}
		DisplayOptions displayOptions =  DisplayOptions.createInstance(map, prefix + "displayOptions", -1);
		if (displayOptions != null) {
			getPaymentOptionsResponse = (getPaymentOptionsResponse == null) ? new GetPaymentOptionsResponse() : getPaymentOptionsResponse;
			getPaymentOptionsResponse.setDisplayOptions(displayOptions);
		}
		if (map.containsKey(prefix + "shippingAddressId")) {
				getPaymentOptionsResponse = (getPaymentOptionsResponse == null) ? new GetPaymentOptionsResponse() : getPaymentOptionsResponse;
				getPaymentOptionsResponse.setShippingAddressId(map.get(prefix + "shippingAddressId"));
		}
		SenderOptions senderOptions =  SenderOptions.createInstance(map, prefix + "senderOptions", -1);
		if (senderOptions != null) {
			getPaymentOptionsResponse = (getPaymentOptionsResponse == null) ? new GetPaymentOptionsResponse() : getPaymentOptionsResponse;
			getPaymentOptionsResponse.setSenderOptions(senderOptions);
		}
		i = 0;
		while(true) {
			ReceiverOptions receiverOptions =  ReceiverOptions.createInstance(map, prefix + "receiverOptions", i);
			if (receiverOptions != null) {
				getPaymentOptionsResponse = (getPaymentOptionsResponse == null) ? new GetPaymentOptionsResponse() : getPaymentOptionsResponse;
				getPaymentOptionsResponse.getReceiverOptions().add(receiverOptions);
				i++;
			} else {
				break;
			}
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				getPaymentOptionsResponse = (getPaymentOptionsResponse == null) ? new GetPaymentOptionsResponse() : getPaymentOptionsResponse;
				getPaymentOptionsResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return getPaymentOptionsResponse;
	}
 
}