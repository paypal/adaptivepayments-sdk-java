
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.ap.InvoiceData;
import com.paypal.svcs.types.ap.ReceiverIdentifier;
import java.io.UnsupportedEncodingException;
import java.util.Map;


/**
 * Options that apply to the receiver of a payment,
 * allows setting additional details for payment
 * using invoice.
 */
public class ReceiverOptions {

	/**
	 */
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 */
	private String customId;
	public String getCustomId() {
		return customId;
	}
	public void setCustomId(String value) {
		this.customId = value;
	}

	/**
	 */
	private InvoiceData invoiceData;
	public InvoiceData getInvoiceData() {
		return invoiceData;
	}
	public void setInvoiceData(InvoiceData value) {
		this.invoiceData = value;
	}

	/**
	 *
	 * @Required
	 */
	private ReceiverIdentifier receiver;
	public ReceiverIdentifier getReceiver() {
		return receiver;
	}
	public void setReceiver(ReceiverIdentifier value) {
		this.receiver = value;
	}

	/**
	 */
	private String referrerCode;
	public String getReferrerCode() {
		return referrerCode;
	}
	public void setReferrerCode(String value) {
		this.referrerCode = value;
	}


	public ReceiverOptions(ReceiverIdentifier receiver) {
		this.receiver = receiver;
	}
	public ReceiverOptions() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( description != null ) {
			sb.append(prefix).append("description=").append(NVPUtil.encodeUrl(description));
			sb.append('&');
		}
		if( customId != null ) {
			sb.append(prefix).append("customId=").append(NVPUtil.encodeUrl(customId));
			sb.append('&');
		}
		if( invoiceData != null ) {
			String newPrefix = prefix + "invoiceData.";
			sb.append(invoiceData.toNVPString(newPrefix));
		}
		if( receiver != null ) {
			String newPrefix = prefix + "receiver.";
			sb.append(receiver.toNVPString(newPrefix));
		}
		if( referrerCode != null ) {
			sb.append(prefix).append("referrerCode=").append(NVPUtil.encodeUrl(referrerCode));
			sb.append('&');
		}
		return sb.toString();
	}

	public ReceiverOptions(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "description") ) {
			this.description = map.get(prefix + "description");
		}
		if( map.containsKey(prefix + "customId") ) {
			this.customId = map.get(prefix + "customId");
		}
		if( map.containsKey(prefix + "invoiceData" + ".totalTax") ) {
			String newPrefix = prefix + "invoiceData" + '.';
			this.invoiceData =  new InvoiceData(map, newPrefix);
		}
		if( map.containsKey(prefix + "receiver" + ".") ) {
			String newPrefix = prefix + "receiver" + '.';
			this.receiver =  new ReceiverIdentifier(map, newPrefix);
		}
		if( map.containsKey(prefix + "referrerCode") ) {
			this.referrerCode = map.get(prefix + "referrerCode");
		}
	}
}
