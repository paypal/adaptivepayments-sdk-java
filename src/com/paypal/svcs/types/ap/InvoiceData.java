
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.ap.InvoiceItem;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Describes a payment for a particular receiver
 * (merchant), contains list of additional per item
 * details.
 */
public class InvoiceData {

	/**
	 */
	private List<InvoiceItem> item = new ArrayList<InvoiceItem>();
	public List<InvoiceItem> getItem() {
		return item;
	}
	public void setItem(List<InvoiceItem> value) {
		this.item = value;
	}

	/**
	 */
	private Double totalTax;
	public Double getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(Double value) {
		this.totalTax = value;
	}

	/**
	 */
	private Double totalShipping;
	public Double getTotalShipping() {
		return totalShipping;
	}
	public void setTotalShipping(Double value) {
		this.totalShipping = value;
	}


	public InvoiceData() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( item != null ) {
			for(int i=0; i<item.size(); i++) {
				String newPrefix = prefix + "item" + '(' + i + ").";
				sb.append(item.get(i).toNVPString(newPrefix));
			}
		}
		if( totalTax != null ) {
			sb.append(prefix).append("totalTax=").append(totalTax);
			sb.append('&');
		}
		if( totalShipping != null ) {
			sb.append(prefix).append("totalShipping=").append(totalShipping);
			sb.append('&');
		}
		return sb.toString();
	}

	public InvoiceData(Map<String, String> map, String prefix) {
		int i=0; 
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "item" + '(' + i + ')'+ ".name") ) {
				String newPrefix = prefix + "item" + '(' + i + ')' + '.';
				this.item.add(new InvoiceItem(map, newPrefix));
			}
			else break;
			i++;
		}
		if( map.containsKey(prefix + "totalTax") ) {
			this.totalTax = Double.valueOf(map.get(prefix + "totalTax"));
		}
		if( map.containsKey(prefix + "totalShipping") ) {
			this.totalShipping = Double.valueOf(map.get(prefix + "totalShipping"));
		}
	}
}
