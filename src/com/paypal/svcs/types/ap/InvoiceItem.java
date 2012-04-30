
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import java.io.UnsupportedEncodingException;
import java.util.Map;


/**
 * Describes an individual item for an invoice.
 */
public class InvoiceItem {

	/**
	 */
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String value) {
		this.name = value;
	}

	/**
	 */
	private String identifier;
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String value) {
		this.identifier = value;
	}

	/**
	 */
	private Double price;
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double value) {
		this.price = value;
	}

	/**
	 */
	private Double itemPrice;
	public Double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double value) {
		this.itemPrice = value;
	}

	/**
	 */
	private Integer itemCount;
	public Integer getItemCount() {
		return itemCount;
	}
	public void setItemCount(Integer value) {
		this.itemCount = value;
	}


	public InvoiceItem() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( name != null ) {
			sb.append(prefix).append("name=").append(NVPUtil.encodeUrl(name));
			sb.append('&');
		}
		if( identifier != null ) {
			sb.append(prefix).append("identifier=").append(NVPUtil.encodeUrl(identifier));
			sb.append('&');
		}
		if( price != null ) {
			sb.append(prefix).append("price=").append(price);
			sb.append('&');
		}
		if( itemPrice != null ) {
			sb.append(prefix).append("itemPrice=").append(itemPrice);
			sb.append('&');
		}
		if( itemCount != null ) {
			sb.append(prefix).append("itemCount=").append(itemCount);
			sb.append('&');
		}
		return sb.toString();
	}

	public InvoiceItem(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "name") ) {
			this.name = map.get(prefix + "name");
		}
		if( map.containsKey(prefix + "identifier") ) {
			this.identifier = map.get(prefix + "identifier");
		}
		if( map.containsKey(prefix + "price") ) {
			this.price = Double.valueOf(map.get(prefix + "price"));
		}
		if( map.containsKey(prefix + "itemPrice") ) {
			this.itemPrice = Double.valueOf(map.get(prefix + "itemPrice"));
		}
		if( map.containsKey(prefix + "itemCount") ) {
			this.itemCount = Integer.valueOf(map.get(prefix + "itemCount"));
		}
	}
}
