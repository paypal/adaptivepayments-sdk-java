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
	 * No Document Comments	  
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
		if (currency != null) {
			for(int i=0; i < currency.size(); i++) {
				String newPrefix = prefix + "currency" + "(" + i + ").";
				sb.append(currency.get(i).toNVPString(newPrefix));
			}
		}
		return sb.toString();
	}
	public CurrencyList(Map<String, String> map, String prefix) {
		int i = 0;
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "currency" + "(" + i + ")" + ".code")){
				String newPrefix = prefix + "currency" + "(" + i + ")" + ".";
				this.currency.add(new CurrencyType(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
	}

}