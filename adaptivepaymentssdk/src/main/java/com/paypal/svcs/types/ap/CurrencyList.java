package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.common.CurrencyType;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * A list of ISO currencies. 
 */
public class CurrencyList{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private List<CurrencyType> currency = new ArrayList<CurrencyType>();

	

	/**
	 * Constructor with arguments
	 */
	public CurrencyList (List<CurrencyType> currency){
		this.currency = currency;
	}	

	/**
	 * Default Constructor
	 */
	public CurrencyList (){
	}	

	/**
	 * Getter for currency
	 */
	 public List<CurrencyType> getCurrency() {
	 	return currency;
	 }
	 
	/**
	 * Setter for currency
	 */
	 public void setCurrency(List<CurrencyType> currency) {
	 	this.currency = currency;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.currency != null) {
			for(int i=0; i < this.currency.size(); i++) {
				String newPrefix = prefix + "currency" + "(" + i + ").";
				sb.append(this.currency.get(i).toNVPString(newPrefix));
			}
		}
		return sb.toString();
	}
	
	public static CurrencyList createInstance(Map<String, String> map, String prefix, int index) {
		CurrencyList currencyList = null;
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
			
		i = 0;
		while(true) {
			CurrencyType currency =  CurrencyType.createInstance(map, prefix + "currency", i);
			if (currency != null) {
				currencyList = (currencyList == null) ? new CurrencyList() : currencyList;
				currencyList.getCurrency().add(currency);
				i++;
			} else {
				break;
			}
		}
		return currencyList;
	}
 
}