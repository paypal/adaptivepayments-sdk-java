package com.paypal.svcs.types.common;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * Details about the end user of the application invoking this
 * service. 
 */
public class ClientDetailsType{


	/**
	 * 	 
	 */ 
	private String ipAddress;

	/**
	 * 	 
	 */ 
	private String deviceId;

	/**
	 * 	 
	 */ 
	private String applicationId;

	/**
	 * 	 
	 */ 
	private String model;

	/**
	 * 	 
	 */ 
	private String geoLocation;

	/**
	 * 	 
	 */ 
	private String customerType;

	/**
	 * 	 
	 */ 
	private String partnerName;

	/**
	 * 	 
	 */ 
	private String customerId;

	

	/**
	 * Default Constructor
	 */
	public ClientDetailsType (){
	}	

	/**
	 * Getter for ipAddress
	 */
	 public String getIpAddress() {
	 	return ipAddress;
	 }
	 
	/**
	 * Setter for ipAddress
	 */
	 public void setIpAddress(String ipAddress) {
	 	this.ipAddress = ipAddress;
	 }
	 
	/**
	 * Getter for deviceId
	 */
	 public String getDeviceId() {
	 	return deviceId;
	 }
	 
	/**
	 * Setter for deviceId
	 */
	 public void setDeviceId(String deviceId) {
	 	this.deviceId = deviceId;
	 }
	 
	/**
	 * Getter for applicationId
	 */
	 public String getApplicationId() {
	 	return applicationId;
	 }
	 
	/**
	 * Setter for applicationId
	 */
	 public void setApplicationId(String applicationId) {
	 	this.applicationId = applicationId;
	 }
	 
	/**
	 * Getter for model
	 */
	 public String getModel() {
	 	return model;
	 }
	 
	/**
	 * Setter for model
	 */
	 public void setModel(String model) {
	 	this.model = model;
	 }
	 
	/**
	 * Getter for geoLocation
	 */
	 public String getGeoLocation() {
	 	return geoLocation;
	 }
	 
	/**
	 * Setter for geoLocation
	 */
	 public void setGeoLocation(String geoLocation) {
	 	this.geoLocation = geoLocation;
	 }
	 
	/**
	 * Getter for customerType
	 */
	 public String getCustomerType() {
	 	return customerType;
	 }
	 
	/**
	 * Setter for customerType
	 */
	 public void setCustomerType(String customerType) {
	 	this.customerType = customerType;
	 }
	 
	/**
	 * Getter for partnerName
	 */
	 public String getPartnerName() {
	 	return partnerName;
	 }
	 
	/**
	 * Setter for partnerName
	 */
	 public void setPartnerName(String partnerName) {
	 	this.partnerName = partnerName;
	 }
	 
	/**
	 * Getter for customerId
	 */
	 public String getCustomerId() {
	 	return customerId;
	 }
	 
	/**
	 * Setter for customerId
	 */
	 public void setCustomerId(String customerId) {
	 	this.customerId = customerId;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.ipAddress != null) {
			sb.append(prefix).append("ipAddress=").append(NVPUtil.encodeUrl(this.ipAddress));
			sb.append("&");
		}
		if (this.deviceId != null) {
			sb.append(prefix).append("deviceId=").append(NVPUtil.encodeUrl(this.deviceId));
			sb.append("&");
		}
		if (this.applicationId != null) {
			sb.append(prefix).append("applicationId=").append(NVPUtil.encodeUrl(this.applicationId));
			sb.append("&");
		}
		if (this.model != null) {
			sb.append(prefix).append("model=").append(NVPUtil.encodeUrl(this.model));
			sb.append("&");
		}
		if (this.geoLocation != null) {
			sb.append(prefix).append("geoLocation=").append(NVPUtil.encodeUrl(this.geoLocation));
			sb.append("&");
		}
		if (this.customerType != null) {
			sb.append(prefix).append("customerType=").append(NVPUtil.encodeUrl(this.customerType));
			sb.append("&");
		}
		if (this.partnerName != null) {
			sb.append(prefix).append("partnerName=").append(NVPUtil.encodeUrl(this.partnerName));
			sb.append("&");
		}
		if (this.customerId != null) {
			sb.append(prefix).append("customerId=").append(NVPUtil.encodeUrl(this.customerId));
			sb.append("&");
		}
		return sb.toString();
	}

}