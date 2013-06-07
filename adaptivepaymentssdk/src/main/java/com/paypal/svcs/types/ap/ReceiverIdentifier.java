package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.AccountIdentifier;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * The sender identifier type contains information to identify
 * a PayPal account. 
 */
public class ReceiverIdentifier extends AccountIdentifier {


	

	/**
	 * Default Constructor
	 */
	public ReceiverIdentifier (){
	}	



	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toNVPString(prefix));
		return sb.toString();
	}
	
	public static ReceiverIdentifier createInstance(Map<String, String> map, String prefix, int index) {
		ReceiverIdentifier receiverIdentifier = null;
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
		AccountIdentifier accountIdentifier = AccountIdentifier.createInstance(map, prefix, -1);
		if (accountIdentifier != null) {
			receiverIdentifier = (receiverIdentifier == null) ? new ReceiverIdentifier() : receiverIdentifier;
			receiverIdentifier.setEmail(accountIdentifier.getEmail());
			receiverIdentifier.setPhone(accountIdentifier.getPhone());
			receiverIdentifier.setAccountId(accountIdentifier.getAccountId());
		}
			
		return receiverIdentifier;
	}
 
}