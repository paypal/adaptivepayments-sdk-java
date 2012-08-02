package com.paypal.svcs.types.ap;
import com.paypal.svcs.types.common.AccountIdentifier;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * The sender identifier type contains information to identify
 * a PayPal account. 
 */
public class SenderIdentifier extends AccountIdentifier {


	/**
	 * 	 
	 */ 
	private Boolean useCredentials;

	

	/**
	 * Default Constructor
	 */
	public SenderIdentifier (){
	}	

	/**
	 * Getter for useCredentials
	 */
	 public Boolean getUseCredentials() {
	 	return useCredentials;
	 }
	 
	/**
	 * Setter for useCredentials
	 */
	 public void setUseCredentials(Boolean useCredentials) {
	 	this.useCredentials = useCredentials;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toNVPString(prefix));
		if (useCredentials != null) {
			sb.append(prefix).append("useCredentials=").append(useCredentials);
			sb.append("&");
		}
		return sb.toString();
	}
	
	public static SenderIdentifier createInstance(Map<String, String> map, String prefix, int index) {
		SenderIdentifier senderIdentifier = null;
		int i = 0;
		if(index != -1) {
				if (!prefix.isEmpty() && !prefix.endsWith(".")) {
					prefix = prefix + "(" + index + ").";
				}
		} 
		else {
			if (!prefix.isEmpty() && !prefix.endsWith(".")) {
				prefix = prefix + ".";
			}
		}
		AccountIdentifier accountIdentifier = AccountIdentifier.createInstance(map, prefix, -1);
		if (accountIdentifier != null) {
			senderIdentifier = (senderIdentifier == null) ? new SenderIdentifier() : senderIdentifier;
			senderIdentifier.setEmail(accountIdentifier.getEmail());
			senderIdentifier.setPhone(accountIdentifier.getPhone());
		}
			
		if (map.containsKey(prefix + "useCredentials")) {
				senderIdentifier = (senderIdentifier == null) ? new SenderIdentifier() : senderIdentifier;
				senderIdentifier.setUseCredentials(Boolean.valueOf(map.get(prefix + "useCredentials")));
		}
		return senderIdentifier;
	}
 
}