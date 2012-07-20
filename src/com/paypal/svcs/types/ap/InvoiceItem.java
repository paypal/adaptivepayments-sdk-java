package com.paypal.svcs.types.ap;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * Describes an individual item for an invoice. 
 */
public class InvoiceItem{


	/**
	 * No Document Comments	 
	 */ 
	private String name;

	/**
	 * No Document Comments	 
	 */ 
	private String identifier;

	/**
	 * No Document Comments	 
	 */ 
	private Double price;

	/**
	 * No Document Comments	 
	 */ 
	private Double itemPrice;

	/**
	 * No Document Comments	 
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
		if (name != null) {
			sb.append(prefix).append("name=").append(NVPUtil.encodeUrl(name));
			sb.append("&");
		}
		if (identifier != null) {
			sb.append(prefix).append("identifier=").append(NVPUtil.encodeUrl(identifier));
			sb.append("&");
		}
		if (price != null) {
			sb.append(prefix).append("price=").append(price);
			sb.append("&");
		}
		if (itemPrice != null) {
			sb.append(prefix).append("itemPrice=").append(itemPrice);
			sb.append("&");
		}
		if (itemCount != null) {
			sb.append(prefix).append("itemCount=").append(itemCount);
			sb.append("&");
		}
		return sb.toString();
	}
	public InvoiceItem(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "name")){
			this.name = map.get(prefix + "name");
		}
		if(map.containsKey(prefix + "identifier")){
			this.identifier = map.get(prefix + "identifier");
		}
		if(map.containsKey(prefix + "price")){
			this.price = Double.valueOf(map.get(prefix + "price"));
		}
		if(map.containsKey(prefix + "itemPrice")){
			this.itemPrice = Double.valueOf(map.get(prefix + "itemPrice"));
		}
		if(map.containsKey(prefix + "itemCount")){
			this.itemCount = Integer.valueOf(map.get(prefix + "itemCount"));
		}
	}

}