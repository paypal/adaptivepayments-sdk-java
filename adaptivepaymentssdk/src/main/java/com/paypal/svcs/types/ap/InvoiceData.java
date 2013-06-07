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
		if (this.item != null) {
			for(int i=0; i < this.item.size(); i++) {
				String newPrefix = prefix + "item" + "(" + i + ").";
				sb.append(this.item.get(i).toNVPString(newPrefix));
			}
		}
		if (this.totalTax != null) {
			sb.append(prefix).append("totalTax=").append(this.totalTax);
			sb.append("&");
		}
		if (this.totalShipping != null) {
			sb.append(prefix).append("totalShipping=").append(this.totalShipping);
			sb.append("&");
		}
		return sb.toString();
	}
	
	public static InvoiceData createInstance(Map<String, String> map, String prefix, int index) {
		InvoiceData invoiceData = null;
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
			InvoiceItem item =  InvoiceItem.createInstance(map, prefix + "item", i);
			if (item != null) {
				invoiceData = (invoiceData == null) ? new InvoiceData() : invoiceData;
				invoiceData.getItem().add(item);
				i++;
			} else {
				break;
			}
		}
		if (map.containsKey(prefix + "totalTax")) {
				invoiceData = (invoiceData == null) ? new InvoiceData() : invoiceData;
				invoiceData.setTotalTax(Double.valueOf(map.get(prefix + "totalTax")));
		}
		if (map.containsKey(prefix + "totalShipping")) {
				invoiceData = (invoiceData == null) ? new InvoiceData() : invoiceData;
				invoiceData.setTotalShipping(Double.valueOf(map.get(prefix + "totalShipping")));
		}
		return invoiceData;
	}
 
}