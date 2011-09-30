
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.ap.CurrencyCodeList;
import com.paypal.svcs.types.ap.CurrencyList;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;


/**
 * A request to convert one or more currencies into
 * their estimated values in other currencies.
 */
public class ConvertCurrencyRequest {

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
	private CurrencyList baseAmountList;
	public CurrencyList getBaseAmountList() {
		return baseAmountList;
	}
	public void setBaseAmountList(CurrencyList value) {
		this.baseAmountList = value;
	}

	/**
	 *
	 * @Required
	 */
	private CurrencyCodeList convertToCurrencyList;
	public CurrencyCodeList getConvertToCurrencyList() {
		return convertToCurrencyList;
	}
	public void setConvertToCurrencyList(CurrencyCodeList value) {
		this.convertToCurrencyList = value;
	}

	/**
	 * The two-character ISO country code where
	 * fx suppposed to happen
	 */
	private String countryCode;
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String value) {
		this.countryCode = value;
	}

	/**
	 */
	private String conversionType;
	public String getConversionType() {
		return conversionType;
	}
	public void setConversionType(String value) {
		this.conversionType = value;
	}


	public ConvertCurrencyRequest(RequestEnvelope requestEnvelope, CurrencyList baseAmountList, CurrencyCodeList convertToCurrencyList) {
		this.requestEnvelope = requestEnvelope;
		this.baseAmountList = baseAmountList;
		this.convertToCurrencyList = convertToCurrencyList;
	}
	public ConvertCurrencyRequest() {
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
		if( baseAmountList != null ) {
			String newPrefix = prefix + "baseAmountList.";
			sb.append(baseAmountList.toNVPString(newPrefix));
		}
		if( convertToCurrencyList != null ) {
			String newPrefix = prefix + "convertToCurrencyList.";
			sb.append(convertToCurrencyList.toNVPString(newPrefix));
		}
		if( countryCode != null ) {
			sb.append(prefix).append("countryCode=").append(NVPUtil.encodeUrl(countryCode));
			sb.append('&');
		}
		if( conversionType != null ) {
			sb.append(prefix).append("conversionType=").append(NVPUtil.encodeUrl(conversionType));
			sb.append('&');
		}
		return sb.toString();
	}

}
