
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.core.NVPUtil;
import com.paypal.svcs.types.common.AccountIdentifier;
import com.paypal.svcs.types.common.RequestEnvelope;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * The request to get the remaining limits for a
 * user
 */
public class GetUserLimitsRequest {

	/**
	 *
	 * @Required
	 */
	private RequestEnvelope requestEnvelope;
	public RequestEnvelope getRequestEnvelope() {
		return requestEnvelope;
	}
	public void setRequestEnvelope(RequestEnvelope value) {
		this.requestEnvelope = value;
	}

	/**
	 * The account identifier for the user
	 *
	 * @Required
	 */
	private AccountIdentifier user;
	public AccountIdentifier getUser() {
		return user;
	}
	public void setUser(AccountIdentifier value) {
		this.user = value;
	}

	/**
	 *
	 * @Required
	 */
	private String country;
	public String getCountry() {
		return country;
	}
	public void setCountry(String value) {
		this.country = value;
	}

	/**
	 *
	 * @Required
	 */
	private String currencyCode;
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String value) {
		this.currencyCode = value;
	}

	/**
	 * List of limit types
	 *
	 * @Required
	 */
	private List<String> limitType = new ArrayList<String>();
	public List<String> getLimitType() {
		return limitType;
	}
	public void setLimitType(List<String> value) {
		this.limitType = value;
	}


	public GetUserLimitsRequest(RequestEnvelope requestEnvelope, AccountIdentifier user, String country, String currencyCode, List<String> limitType) {
		this.requestEnvelope = requestEnvelope;
		this.user = user;
		this.country = country;
		this.currencyCode = currencyCode;
		this.limitType = limitType;
	}
	public GetUserLimitsRequest() {
	}

	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( requestEnvelope != null ) {
			String newPrefix = prefix + "requestEnvelope.";
			sb.append(requestEnvelope.toNVPString(newPrefix));
		}
		if( user != null ) {
			String newPrefix = prefix + "user.";
			sb.append(user.toNVPString(newPrefix));
		}
		if( country != null ) {
			sb.append(prefix).append("country=").append(NVPUtil.encodeUrl(country));
			sb.append('&');
		}
		if( currencyCode != null ) {
			sb.append(prefix).append("currencyCode=").append(NVPUtil.encodeUrl(currencyCode));
			sb.append('&');
		}
		if( limitType != null ) {
			for(int i=0; i<limitType.size(); i++) {
				sb.append(prefix).append("limitType(").append(i).append(")=").append(NVPUtil.encodeUrl(limitType.get(i)));
				sb.append('&');
			}
		}
		return sb.toString();
	}

}
