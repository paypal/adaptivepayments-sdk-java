
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.ap.Receiver;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 */
public class ReceiverList {

	/**
	 *
	 * @Required
	 */
	private List<Receiver> receiver = new ArrayList<Receiver>();
	public List<Receiver> getReceiver() {
		return receiver;
	}
	public void setReceiver(List<Receiver> value) {
		this.receiver = value;
	}


	public ReceiverList(List<Receiver> receiver) {
		this.receiver = receiver;
	}
	public ReceiverList() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( receiver != null ) {
			for(int i=0; i<receiver.size(); i++) {
				String newPrefix = prefix + "receiver" + '(' + i + ").";
				sb.append(receiver.get(i).toNVPString(newPrefix));
			}
		}
		return sb.toString();
	}

}
