package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.RequestEnvelope;
import com.paypal.svcs.types.ap.CurrencyList;
import com.paypal.svcs.types.ap.CurrencyCodeList;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * A request to convert one or more currencies into their
 * estimated values in other currencies. 
 */
public class ConvertCurrencyRequest{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private RequestEnvelope requestEnvelope;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private CurrencyList baseAmountList;

	/**
	 * 	  
	 *@Required	 
	 */ 
	private CurrencyCodeList convertToCurrencyList;

	/**
	 * The two-character ISO country code where fx suppposed to
	 * happen 	 
	 */ 
	private String countryCode;

	/**
	 * 	 
	 */ 
	private String conversionType;

	

	/**
	 * Constructor with arguments
	 */
	public ConvertCurrencyRequest (RequestEnvelope requestEnvelope, CurrencyList baseAmountList, CurrencyCodeList convertToCurrencyList){
		this.requestEnvelope = requestEnvelope;
		this.baseAmountList = baseAmountList;
		this.convertToCurrencyList = convertToCurrencyList;
	}	

	/**
	 * Default Constructor
	 */
	public ConvertCurrencyRequest (){
	}	

	/**
	 * Getter for requestEnvelope
	 */
	 public RequestEnvelope getRequestEnvelope() {
	 	return requestEnvelope;
	 }
	 
	/**
	 * Setter for requestEnvelope
	 */
	 public void setRequestEnvelope(RequestEnvelope requestEnvelope) {
	 	this.requestEnvelope = requestEnvelope;
	 }
	 
	/**
	 * Getter for baseAmountList
	 */
	 public CurrencyList getBaseAmountList() {
	 	return baseAmountList;
	 }
	 
	/**
	 * Setter for baseAmountList
	 */
	 public void setBaseAmountList(CurrencyList baseAmountList) {
	 	this.baseAmountList = baseAmountList;
	 }
	 
	/**
	 * Getter for convertToCurrencyList
	 */
	 public CurrencyCodeList getConvertToCurrencyList() {
	 	return convertToCurrencyList;
	 }
	 
	/**
	 * Setter for convertToCurrencyList
	 */
	 public void setConvertToCurrencyList(CurrencyCodeList convertToCurrencyList) {
	 	this.convertToCurrencyList = convertToCurrencyList;
	 }
	 
	/**
	 * Getter for countryCode
	 */
	 public String getCountryCode() {
	 	return countryCode;
	 }
	 
	/**
	 * Setter for countryCode
	 */
	 public void setCountryCode(String countryCode) {
	 	this.countryCode = countryCode;
	 }
	 
	/**
	 * Getter for conversionType
	 */
	 public String getConversionType() {
	 	return conversionType;
	 }
	 
	/**
	 * Setter for conversionType
	 */
	 public void setConversionType(String conversionType) {
	 	this.conversionType = conversionType;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.requestEnvelope != null) {
			String newPrefix = prefix + "requestEnvelope.";
			sb.append(this.requestEnvelope.toNVPString(newPrefix));
		}
		if (this.baseAmountList != null) {
			String newPrefix = prefix + "baseAmountList.";
			sb.append(this.baseAmountList.toNVPString(newPrefix));
		}
		if (this.convertToCurrencyList != null) {
			String newPrefix = prefix + "convertToCurrencyList.";
			sb.append(this.convertToCurrencyList.toNVPString(newPrefix));
		}
		if (this.countryCode != null) {
			sb.append(prefix).append("countryCode=").append(NVPUtil.encodeUrl(this.countryCode));
			sb.append("&");
		}
		if (this.conversionType != null) {
			sb.append(prefix).append("conversionType=").append(NVPUtil.encodeUrl(this.conversionType));
			sb.append("&");
		}
		return sb.toString();
	}

}