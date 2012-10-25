package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * A list of ISO currency codes. 
 */
public class CurrencyCodeList{

	private static final String nameSpace="com.paypal.svcs.types.ap";
	private static final String preferredPrefix="";

	/**
	 * 	  
	 *@Required	 
	 */ 
	private List<String> currencyCode = new ArrayList<String>();

	

	/**
	 * Constructor with arguments
	 */
	public CurrencyCodeList (List<String> currencyCode){
		this.currencyCode = currencyCode;
	}	

	/**
	 * Default Constructor
	 */
	public CurrencyCodeList (){
	}	

	/**
	 * Getter for currencyCode
	 */
	 public List<String> getCurrencyCode() {
	 	return currencyCode;
	 }
	 
	/**
	 * Setter for currencyCode
	 */
	 public void setCurrencyCode(List<String> currencyCode) {
	 	this.currencyCode = currencyCode;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (currencyCode != null) {
			for(int i=0; i < currencyCode.size(); i++) {
				sb.append(prefix).append("currencyCode(").append(i).append(")=").append(NVPUtil.encodeUrl(currencyCode.get(i)));
				sb.append("&");
			}
		}
		return sb.toString();
	}

}