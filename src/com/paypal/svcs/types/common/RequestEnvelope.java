
/**
 * Auto generated code
 */

package com.paypal.svcs.types.common;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.DetailLevelCode;
import java.io.UnsupportedEncodingException;


/**
 * This specifies the list of parameters with every
 * request to the service.
 */
public class RequestEnvelope {

	/**
	 * This specifies the required detail level
	 * that is needed by a client application
	 * pertaining to a particular data
	 * component (e.g., Item, Transaction,
	 * etc.). The detail level is specified in
	 * the DetailLevelCodeType which has all
	 * the enumerated values of the detail
	 * level for each component.
	 */
	private DetailLevelCode detailLevel;
	public DetailLevelCode getDetailLevel() {
		return detailLevel;
	}
	public void setDetailLevel(DetailLevelCode value) {
		this.detailLevel = value;
	}

	/**
	 * This should be the standard RFC 3066
	 * language identification tag, e.g.,
	 * en_US.
	 *
	 * @Required
	 */
	private String errorLanguage;
	public String getErrorLanguage() {
		return errorLanguage;
	}
	public void setErrorLanguage(String value) {
		this.errorLanguage = value;
	}


	public RequestEnvelope(String errorLanguage) {
		this.errorLanguage = errorLanguage;
	}
	public RequestEnvelope() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( detailLevel != null ) {
			sb.append(prefix).append("detailLevel=").append(detailLevel.getValue());
			sb.append('&');
		}
		if( errorLanguage != null ) {
			sb.append(prefix).append("errorLanguage=").append(NVPUtil.encodeUrl(errorLanguage));
			sb.append('&');
		}
		return sb.toString();
	}

}
