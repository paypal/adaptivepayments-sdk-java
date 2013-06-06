package com.paypal.svcs.types.ap;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * Describes an individual item for an invoice. 
 */
public class InvoiceItem{


	/**
	 * 	 
	 */ 
	private String name;

	/**
	 * 	 
	 */ 
	private String identifier;

	/**
	 * 	 
	 */ 
	private Double price;

	/**
	 * 	 
	 */ 
	private Double itemPrice;

	/**
	 * 	 
	 */ 
	private Integer itemCount;

	

	/**
	 * Default Constructor
	 */
	public InvoiceItem (){
	}	

	/**
	 * Getter for name
	 */
	 public String getName() {
	 	return name;
	 }
	 
	/**
	 * Setter for name
	 */
	 public void setName(String name) {
	 	this.name = name;
	 }
	 
	/**
	 * Getter for identifier
	 */
	 public String getIdentifier() {
	 	return identifier;
	 }
	 
	/**
	 * Setter for identifier
	 */
	 public void setIdentifier(String identifier) {
	 	this.identifier = identifier;
	 }
	 
	/**
	 * Getter for price
	 */
	 public Double getPrice() {
	 	return price;
	 }
	 
	/**
	 * Setter for price
	 */
	 public void setPrice(Double price) {
	 	this.price = price;
	 }
	 
	/**
	 * Getter for itemPrice
	 */
	 public Double getItemPrice() {
	 	return itemPrice;
	 }
	 
	/**
	 * Setter for itemPrice
	 */
	 public void setItemPrice(Double itemPrice) {
	 	this.itemPrice = itemPrice;
	 }
	 
	/**
	 * Getter for itemCount
	 */
	 public Integer getItemCount() {
	 	return itemCount;
	 }
	 
	/**
	 * Setter for itemCount
	 */
	 public void setItemCount(Integer itemCount) {
	 	this.itemCount = itemCount;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.name != null) {
			sb.append(prefix).append("name=").append(NVPUtil.encodeUrl(this.name));
			sb.append("&");
		}
		if (this.identifier != null) {
			sb.append(prefix).append("identifier=").append(NVPUtil.encodeUrl(this.identifier));
			sb.append("&");
		}
		if (this.price != null) {
			sb.append(prefix).append("price=").append(this.price);
			sb.append("&");
		}
		if (this.itemPrice != null) {
			sb.append(prefix).append("itemPrice=").append(this.itemPrice);
			sb.append("&");
		}
		if (this.itemCount != null) {
			sb.append(prefix).append("itemCount=").append(this.itemCount);
			sb.append("&");
		}
		return sb.toString();
	}
	
	public static InvoiceItem createInstance(Map<String, String> map, String prefix, int index) {
		InvoiceItem invoiceItem = null;
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
			
		if (map.containsKey(prefix + "name")) {
				invoiceItem = (invoiceItem == null) ? new InvoiceItem() : invoiceItem;
				invoiceItem.setName(map.get(prefix + "name"));
		}
		if (map.containsKey(prefix + "identifier")) {
				invoiceItem = (invoiceItem == null) ? new InvoiceItem() : invoiceItem;
				invoiceItem.setIdentifier(map.get(prefix + "identifier"));
		}
		if (map.containsKey(prefix + "price")) {
				invoiceItem = (invoiceItem == null) ? new InvoiceItem() : invoiceItem;
				invoiceItem.setPrice(Double.valueOf(map.get(prefix + "price")));
		}
		if (map.containsKey(prefix + "itemPrice")) {
				invoiceItem = (invoiceItem == null) ? new InvoiceItem() : invoiceItem;
				invoiceItem.setItemPrice(Double.valueOf(map.get(prefix + "itemPrice")));
		}
		if (map.containsKey(prefix + "itemCount")) {
				invoiceItem = (invoiceItem == null) ? new InvoiceItem() : invoiceItem;
				invoiceItem.setItemCount(Integer.valueOf(map.get(prefix + "itemCount")));
		}
		return invoiceItem;
	}
 
}