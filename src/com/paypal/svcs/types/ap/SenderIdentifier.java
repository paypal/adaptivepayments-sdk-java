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
	 * No Document Comments	 
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
	public SenderIdentifier(Map<String, String> map, String prefix) {
		super(map,prefix);
		prefix = prefix.substring(0, prefix.length() - 1);
		this.useCredentials = Boolean.valueOf(map.get(prefix + "useCredentials"));
	}

}