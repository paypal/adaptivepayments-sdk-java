package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.InvoiceItem;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * Describes a payment for a particular receiver (merchant),
 * contains list of additional per item details. 
 */
public class InvoiceData{


	/**
	 * 	 
	 */ 
	private List<InvoiceItem> item = new ArrayList<InvoiceItem>();

	/**
	 * 	 
	 */ 
	private Double totalTax;

	/**
	 * 	 
	 */ 
	private Double totalShipping;

	

	/**
	 * Default Constructor
	 */
	public InvoiceData (){
	}	

	/**
	 * Getter for item
	 */
	 public List<InvoiceItem> getItem() {
	 	return item;
	 }
	 
	/**
	 * Setter for item
	 */
	 public void setItem(List<InvoiceItem> item) {
	 	this.item = item;
	 }
	 
	/**
	 * Getter for totalTax
	 */
	 public Double getTotalTax() {
	 	return totalTax;
	 }
	 
	/**
	 * Setter for totalTax
	 */
	 public void setTotalTax(Double totalTax) {
	 	this.totalTax = totalTax;
	 }
	 
	/**
	 * Getter for totalShipping
	 */
	 public Double getTotalShipping() {
	 	return totalShipping;
	 }
	 
	/**
	 * Setter for totalShipping
	 */
	 public void setTotalShipping(Double totalShipping) {
	 	this.totalShipping = totalShipping;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (item != null) {
			for(int i=0; i < item.size(); i++) {
				String newPrefix = prefix + "item" + "(" + i + ").";
				sb.append(item.get(i).toNVPString(newPrefix));
			}
		}
		if (totalTax != null) {
			sb.append(prefix).append("totalTax=").append(totalTax);
			sb.append("&");
		}
		if (totalShipping != null) {
			sb.append(prefix).append("totalShipping=").append(totalShipping);
			sb.append("&");
		}
		return sb.toString();
	}
	public InvoiceData(Map<String, String> map, String prefix) {
		int i = 0;
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "item" + "(" + i + ")" + ".name")){
				String newPrefix = prefix + "item" + "(" + i + ")" + ".";
				this.item.add(new InvoiceItem(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
		if(map.containsKey(prefix + "totalTax")){
			this.totalTax = Double.valueOf(map.get(prefix + "totalTax"));
		}
		if(map.containsKey(prefix + "totalShipping")){
			this.totalShipping = Double.valueOf(map.get(prefix + "totalShipping"));
		}
	}

}