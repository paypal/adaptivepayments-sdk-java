
/**
 * Auto generated code
 */

package com.paypal.svcs.types.common;

import com.paypal.core.NVPUtil;
import java.io.UnsupportedEncodingException;


/**
 * Details about the end user of the application
 * invoking this service.
 */
public class ClientDetailsType {

	/**
	 */
	private String ipAddress;
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String value) {
		this.ipAddress = value;
	}

	/**
	 */
	private String deviceId;
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String value) {
		this.deviceId = value;
	}

	/**
	 */
	private String applicationId;
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String value) {
		this.applicationId = value;
	}

	/**
	 */
	private String model;
	public String getModel() {
		return model;
	}
	public void setModel(String value) {
		this.model = value;
	}

	/**
	 */
	private String geoLocation;
	public String getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(String value) {
		this.geoLocation = value;
	}

	/**
	 */
	private String customerType;
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String value) {
		this.customerType = value;
	}

	/**
	 */
	private String partnerName;
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String value) {
		this.partnerName = value;
	}

	/**
	 */
	private String customerId;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String value) {
		this.customerId = value;
	}



	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}

	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if( ipAddress != null ) {
			sb.append(prefix).append("ipAddress=").append(NVPUtil.encodeUrl(ipAddress));
			sb.append('&');
		}
		if( deviceId != null ) {
			sb.append(prefix).append("deviceId=").append(NVPUtil.encodeUrl(deviceId));
			sb.append('&');
		}
		if( applicationId != null ) {
			sb.append(prefix).append("applicationId=").append(NVPUtil.encodeUrl(applicationId));
			sb.append('&');
		}
		if( model != null ) {
			sb.append(prefix).append("model=").append(NVPUtil.encodeUrl(model));
			sb.append('&');
		}
		if( geoLocation != null ) {
			sb.append(prefix).append("geoLocation=").append(NVPUtil.encodeUrl(geoLocation));
			sb.append('&');
		}
		if( customerType != null ) {
			sb.append(prefix).append("customerType=").append(NVPUtil.encodeUrl(customerType));
			sb.append('&');
		}
		if( partnerName != null ) {
			sb.append(prefix).append("partnerName=").append(NVPUtil.encodeUrl(partnerName));
			sb.append('&');
		}
		if( customerId != null ) {
			sb.append(prefix).append("customerId=").append(NVPUtil.encodeUrl(customerId));
			sb.append('&');
		}
		return sb.toString();
	}

}
