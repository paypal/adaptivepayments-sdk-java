
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.ap.DisplayOptions;
import com.paypal.svcs.types.ap.InitiatingEntity;
import com.paypal.svcs.types.ap.ReceiverOptions;
import com.paypal.svcs.types.ap.SenderOptions;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * The request to set the options of a payment
 * request.
 */
public class SetPaymentOptionsRequest {

	/**
	 *
	 * @Required
	 */
	private RequestEnvelope requestEnvelope;
	public RequestEnvelope getRequestEnvelope() {
		return requestEnvelope;
	}
	public void setRequestEnvelope(RequestEnvelope value) {
		this.requestEnvelope = value;
	}

	/**
	 *
	 * @Required
	 */
	private String payKey;
	public String getPayKey() {
		return payKey;
	}
	public void setPayKey(String value) {
		this.payKey = value;
	}

	/**
	 */
	private InitiatingEntity initiatingEntity;
	public InitiatingEntity getInitiatingEntity() {
		return initiatingEntity;
	}
	public void setInitiatingEntity(InitiatingEntity value) {
		this.initiatingEntity = value;
	}

	/**
	 */
	private DisplayOptions displayOptions;
	public DisplayOptions getDisplayOptions() {
		return displayOptions;
	}
	public void setDisplayOptions(DisplayOptions value) {
		this.displayOptions = value;
	}

	/**
	 */
	private String shippingAddressId;
	public String getShippingAddressId() {
		return shippingAddressId;
	}
	public void setShippingAddressId(String value) {
		this.shippingAddressId = value;
	}

	/**
	 */
	private SenderOptions senderOptions;
	public SenderOptions getSenderOptions() {
		return senderOptions;
	}
	public void setSenderOptions(SenderOptions value) {
		this.senderOptions = value;
	}

	/**
	 */
	private List<ReceiverOptions> receiverOptions = new ArrayList<ReceiverOptions>();
	public List<ReceiverOptions> getReceiverOptions() {
		return receiverOptions;
	}
	public void setReceiverOptions(List<ReceiverOptions> value) {
		this.receiverOptions = value;
	}


	public SetPaymentOptionsRequest(RequestEnvelope requestEnvelope, String payKey) {
		this.requestEnvelope = requestEnvelope;
		this.payKey = payKey;
	}
	public SetPaymentOptionsRequest() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( requestEnvelope != null ) {
			String newPrefix = prefix + "requestEnvelope.";
			sb.append(requestEnvelope.toNVPString(newPrefix));
		}
		if( payKey != null ) {
			sb.append(prefix).append("payKey=").append(NVPUtil.encodeUrl(payKey));
			sb.append('&');
		}
		if( initiatingEntity != null ) {
			String newPrefix = prefix + "initiatingEntity.";
			sb.append(initiatingEntity.toNVPString(newPrefix));
		}
		if( displayOptions != null ) {
			String newPrefix = prefix + "displayOptions.";
			sb.append(displayOptions.toNVPString(newPrefix));
		}
		if( shippingAddressId != null ) {
			sb.append(prefix).append("shippingAddressId=").append(NVPUtil.encodeUrl(shippingAddressId));
			sb.append('&');
		}
		if( senderOptions != null ) {
			String newPrefix = prefix + "senderOptions.";
			sb.append(senderOptions.toNVPString(newPrefix));
		}
		if( receiverOptions != null ) {
			for(int i=0; i<receiverOptions.size(); i++) {
				String newPrefix = prefix + "receiverOptions" + '(' + i + ").";
				sb.append(receiverOptions.get(i).toNVPString(newPrefix));
			}
		}
		return sb.toString();
	}

}
