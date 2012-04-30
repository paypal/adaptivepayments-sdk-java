
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.PhoneNumberType;
import java.io.UnsupportedEncodingException;
import java.util.Map;


/**
 * Receiver is the party where funds are
 * transferred to. A primary receiver receives a
 * payment directly from the sender in a chained
 * split payment. A primary receiver should not be
 * specified when making a single or parallel split
 * payment.
 */
public class Receiver {

	/**
	 *
	 * @Required
	 */
	private Double amount;
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double value) {
		this.amount = value;
	}

	/**
	 */
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String value) {
		this.email = value;
	}

	/**
	 */
	private PhoneNumberType phone;
	public PhoneNumberType getPhone() {
		return phone;
	}
	public void setPhone(PhoneNumberType value) {
		this.phone = value;
	}

	/**
	 */
	private Boolean primary;
	public Boolean getPrimary() {
		return primary;
	}
	public void setPrimary(Boolean value) {
		this.primary = value;
	}

	/**
	 */
	private String invoiceId;
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String value) {
		this.invoiceId = value;
	}

	/**
	 */
	private String paymentType;
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String value) {
		this.paymentType = value;
	}

	/**
	 */
	private String paymentSubType;
	public String getPaymentSubType() {
		return paymentSubType;
	}
	public void setPaymentSubType(String value) {
		this.paymentSubType = value;
	}


	public Receiver(Double amount) {
		this.amount = amount;
	}
	public Receiver() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( amount != null ) {
			sb.append(prefix).append("amount=").append(amount);
			sb.append('&');
		}
		if( email != null ) {
			sb.append(prefix).append("email=").append(NVPUtil.encodeUrl(email));
			sb.append('&');
		}
		if( phone != null ) {
			String newPrefix = prefix + "phone.";
			sb.append(phone.toNVPString(newPrefix));
		}
		if( primary != null ) {
			sb.append(prefix).append("primary=").append(primary);
			sb.append('&');
		}
		if( invoiceId != null ) {
			sb.append(prefix).append("invoiceId=").append(NVPUtil.encodeUrl(invoiceId));
			sb.append('&');
		}
		if( paymentType != null ) {
			sb.append(prefix).append("paymentType=").append(NVPUtil.encodeUrl(paymentType));
			sb.append('&');
		}
		if( paymentSubType != null ) {
			sb.append(prefix).append("paymentSubType=").append(NVPUtil.encodeUrl(paymentSubType));
			sb.append('&');
		}
		return sb.toString();
	}

	public Receiver(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "amount") ) {
			this.amount = Double.valueOf(map.get(prefix + "amount"));
		}
		if( map.containsKey(prefix + "email") ) {
			this.email = map.get(prefix + "email");
		}
		if( map.containsKey(prefix + "phone" + ".countryCode") ) {
			String newPrefix = prefix + "phone" + '.';
			this.phone =  new PhoneNumberType(map, newPrefix);
		}
		if( map.containsKey(prefix + "primary") ) {
			this.primary = Boolean.valueOf(map.get(prefix + "primary"));
		}
		if( map.containsKey(prefix + "invoiceId") ) {
			this.invoiceId = map.get(prefix + "invoiceId");
		}
		if( map.containsKey(prefix + "paymentType") ) {
			this.paymentType = map.get(prefix + "paymentType");
		}
		if( map.containsKey(prefix + "paymentSubType") ) {
			this.paymentSubType = map.get(prefix + "paymentSubType");
		}
	}
}
