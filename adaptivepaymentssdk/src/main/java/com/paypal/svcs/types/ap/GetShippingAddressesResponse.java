package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.ResponseEnvelope;
import com.paypal.svcs.types.ap.Address;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * The response to get the shipping addresses available for a
 * payment. 
 */
public class GetShippingAddressesResponse{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

	/**
	 * 	 
	 */ 
	private Address selectedAddress;

	/**
	 * 	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public GetShippingAddressesResponse (){
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
	 * Getter for selectedAddress
	 */
	 public Address getSelectedAddress() {
	 	return selectedAddress;
	 }
	 
	/**
	 * Setter for selectedAddress
	 */
	 public void setSelectedAddress(Address selectedAddress) {
	 	this.selectedAddress = selectedAddress;
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
	 


	
	public static GetShippingAddressesResponse createInstance(Map<String, String> map, String prefix, int index) {
		GetShippingAddressesResponse getShippingAddressesResponse = null;
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
			getShippingAddressesResponse = (getShippingAddressesResponse == null) ? new GetShippingAddressesResponse() : getShippingAddressesResponse;
			getShippingAddressesResponse.setResponseEnvelope(responseEnvelope);
		}
		Address selectedAddress =  Address.createInstance(map, prefix + "selectedAddress", -1);
		if (selectedAddress != null) {
			getShippingAddressesResponse = (getShippingAddressesResponse == null) ? new GetShippingAddressesResponse() : getShippingAddressesResponse;
			getShippingAddressesResponse.setSelectedAddress(selectedAddress);
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				getShippingAddressesResponse = (getShippingAddressesResponse == null) ? new GetShippingAddressesResponse() : getShippingAddressesResponse;
				getShippingAddressesResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return getShippingAddressesResponse;
	}
 
}