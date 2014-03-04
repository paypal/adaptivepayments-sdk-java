package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.ResponseEnvelope;
import com.paypal.svcs.types.ap.Status;
import com.paypal.svcs.types.ap.SenderDisclosure;
import com.paypal.svcs.types.ap.ReceiverDisclosureList;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.common.ErrorData;
import java.util.Map;

/**
 * GetPrePaymentDisclosureResponse contains the information
 * related to PrePayment disclosure. status : indicates the
 * status of response. If Status = RTR then it means that this
 * is RTR transaction. If Status = NON_RTR then it means that
 * this is non RTR transaction. If Status =
 * MISSING_RECEIVER_COUNTRY_INFORMATION then it means the
 * Receiver country information is not found in PayPal
 * database. So merchant has to call the API again with same
 * set of parameter along with Receiver country code.This is
 * useful in case of Unilateral scenario. where receiver is not
 * holding paypal account. This is currently a place holder to
 * support backward compatibility since first name and last
 * name are mandated too. feePayer:Indicates who has agreed to
 * Pay a Fee for the RTR transaction. Merchant can use this
 * information to decide who actually has to pay the fee .
 * senderDisclosure : This Variable Holds the disclosure
 * related to sender. receiverDisclosureList : This list
 * contains the disclosure information related to receivers.
 * Merchant can just parse the details what ever is avaliable
 * in the response and display the same to user. 
 */
public class GetPrePaymentDisclosureResponse{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private ResponseEnvelope responseEnvelope;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private Status status;

	/**
	 * 	 
	 */ 
	private String feesPayer;

	/**
	 * 	 
	 */ 
	private SenderDisclosure senderDisclosure;

	/**
	 * 	 
	 */ 
	private ReceiverDisclosureList receiverDisclosureList;

	/**
	 * 	 
	 */ 
	private String disclaimer;

	/**
	 * 	 
	 */ 
	private List<ErrorData> error = new ArrayList<ErrorData>();

	

	/**
	 * Default Constructor
	 */
	public GetPrePaymentDisclosureResponse (){
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
	 * Getter for status
	 */
	 public Status getStatus() {
	 	return status;
	 }
	 
	/**
	 * Setter for status
	 */
	 public void setStatus(Status status) {
	 	this.status = status;
	 }
	 
	/**
	 * Getter for feesPayer
	 */
	 public String getFeesPayer() {
	 	return feesPayer;
	 }
	 
	/**
	 * Setter for feesPayer
	 */
	 public void setFeesPayer(String feesPayer) {
	 	this.feesPayer = feesPayer;
	 }
	 
	/**
	 * Getter for senderDisclosure
	 */
	 public SenderDisclosure getSenderDisclosure() {
	 	return senderDisclosure;
	 }
	 
	/**
	 * Setter for senderDisclosure
	 */
	 public void setSenderDisclosure(SenderDisclosure senderDisclosure) {
	 	this.senderDisclosure = senderDisclosure;
	 }
	 
	/**
	 * Getter for receiverDisclosureList
	 */
	 public ReceiverDisclosureList getReceiverDisclosureList() {
	 	return receiverDisclosureList;
	 }
	 
	/**
	 * Setter for receiverDisclosureList
	 */
	 public void setReceiverDisclosureList(ReceiverDisclosureList receiverDisclosureList) {
	 	this.receiverDisclosureList = receiverDisclosureList;
	 }
	 
	/**
	 * Getter for disclaimer
	 */
	 public String getDisclaimer() {
	 	return disclaimer;
	 }
	 
	/**
	 * Setter for disclaimer
	 */
	 public void setDisclaimer(String disclaimer) {
	 	this.disclaimer = disclaimer;
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
	 


	
	public static GetPrePaymentDisclosureResponse createInstance(Map<String, String> map, String prefix, int index) {
		GetPrePaymentDisclosureResponse getPrePaymentDisclosureResponse = null;
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
			getPrePaymentDisclosureResponse = (getPrePaymentDisclosureResponse == null) ? new GetPrePaymentDisclosureResponse() : getPrePaymentDisclosureResponse;
			getPrePaymentDisclosureResponse.setResponseEnvelope(responseEnvelope);
		}
		if (map.containsKey(prefix + "status")) {
				getPrePaymentDisclosureResponse = (getPrePaymentDisclosureResponse == null) ? new GetPrePaymentDisclosureResponse() : getPrePaymentDisclosureResponse;
				getPrePaymentDisclosureResponse.setStatus(Status.fromValue(map.get(prefix + "status")));
		}
		if (map.containsKey(prefix + "feesPayer")) {
				getPrePaymentDisclosureResponse = (getPrePaymentDisclosureResponse == null) ? new GetPrePaymentDisclosureResponse() : getPrePaymentDisclosureResponse;
				getPrePaymentDisclosureResponse.setFeesPayer(map.get(prefix + "feesPayer"));
		}
		SenderDisclosure senderDisclosure =  SenderDisclosure.createInstance(map, prefix + "senderDisclosure", -1);
		if (senderDisclosure != null) {
			getPrePaymentDisclosureResponse = (getPrePaymentDisclosureResponse == null) ? new GetPrePaymentDisclosureResponse() : getPrePaymentDisclosureResponse;
			getPrePaymentDisclosureResponse.setSenderDisclosure(senderDisclosure);
		}
		ReceiverDisclosureList receiverDisclosureList =  ReceiverDisclosureList.createInstance(map, prefix + "receiverDisclosureList", -1);
		if (receiverDisclosureList != null) {
			getPrePaymentDisclosureResponse = (getPrePaymentDisclosureResponse == null) ? new GetPrePaymentDisclosureResponse() : getPrePaymentDisclosureResponse;
			getPrePaymentDisclosureResponse.setReceiverDisclosureList(receiverDisclosureList);
		}
		if (map.containsKey(prefix + "disclaimer")) {
				getPrePaymentDisclosureResponse = (getPrePaymentDisclosureResponse == null) ? new GetPrePaymentDisclosureResponse() : getPrePaymentDisclosureResponse;
				getPrePaymentDisclosureResponse.setDisclaimer(map.get(prefix + "disclaimer"));
		}
		i = 0;
		while(true) {
			ErrorData error =  ErrorData.createInstance(map, prefix + "error", i);
			if (error != null) {
				getPrePaymentDisclosureResponse = (getPrePaymentDisclosureResponse == null) ? new GetPrePaymentDisclosureResponse() : getPrePaymentDisclosureResponse;
				getPrePaymentDisclosureResponse.getError().add(error);
				i++;
			} else {
				break;
			}
		}
		return getPrePaymentDisclosureResponse;
	}
 
}