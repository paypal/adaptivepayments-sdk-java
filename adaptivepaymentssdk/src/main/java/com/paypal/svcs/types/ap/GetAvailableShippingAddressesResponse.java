package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.ResponseEnvelope;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.Address;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * The response to get the shipping addresses available for a
 * payment. 
 */
public class GetAvailableShippingAddressesResponse{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

	/**
	 * 	 
	 */ 
	private List<Address> availableAddress = new ArrayList<Address>();

	/**
	 * 	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public GetAvailableShippingAddressesResponse (){
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
	 * Getter for availableAddress
	 */
	 public List<Address> getAvailableAddress() {
	 	return availableAddress;
	 }
	 
	/**
	 * Setter for availableAddress
	 */
	 public void setAvailableAddress(List<Address> availableAddress) {
	 	this.availableAddress = availableAddress;
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
	 


	
	public static GetAvailableShippingAddressesResponse createInstance(Map<String, String> map, String prefix, int index) {
		GetAvailableShippingAddressesResponse getAvailableShippingAddressesResponse = null;
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
			getAvailableShippingAddressesResponse = (getAvailableShippingAddressesResponse == null) ? new GetAvailableShippingAddressesResponse() : getAvailableShippingAddressesResponse;
			getAvailableShippingAddressesResponse.setResponseEnvelope(responseEnvelope);
		}
		i = 0;
		while(true) {
			Address availableAddress =  Address.createInstance(map, prefix + "availableAddress", i);
			if (availableAddress != null) {
				getAvailableShippingAddressesResponse = (getAvailableShippingAddressesResponse == null) ? new GetAvailableShippingAddressesResponse() : getAvailableShippingAddressesResponse;
				getAvailableShippingAddressesResponse.getAvailableAddress().add(availableAddress);
				i++;
			} else {
				break;
			}
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				getAvailableShippingAddressesResponse = (getAvailableShippingAddressesResponse == null) ? new GetAvailableShippingAddressesResponse() : getAvailableShippingAddressesResponse;
				getAvailableShippingAddressesResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return getAvailableShippingAddressesResponse;
	}
 
}