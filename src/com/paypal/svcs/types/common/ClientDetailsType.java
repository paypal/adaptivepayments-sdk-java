package com.paypal.svcs.types.common;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;

/**
 * Details about the end user of the application invoking this
 * service. 
 */
public class ClientDetailsType{


	/**
	 * No Document Comments	 
	 */ 
	private String ipAddress;

	/**
	 * No Document Comments	 
	 */ 
	private String deviceId;

	/**
	 * No Document Comments	 
	 */ 
	private String applicationId;

	/**
	 * No Document Comments	 
	 */ 
	private String model;

	/**
	 * No Document Comments	 
	 */ 
	private String geoLocation;

	/**
	 * No Document Comments	 
	 */ 
	private String customerType;

	/**
	 * No Document Comments	 
	 */ 
	private String partnerName;

	/**
	 * No Document Comments	 
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
		if (ipAddress != null) {
			sb.append(prefix).append("ipAddress=").append(NVPUtil.encodeUrl(ipAddress));
			sb.append("&");
		}
		if (deviceId != null) {
			sb.append(prefix).append("deviceId=").append(NVPUtil.encodeUrl(deviceId));
			sb.append("&");
		}
		if (applicationId != null) {
			sb.append(prefix).append("applicationId=").append(NVPUtil.encodeUrl(applicationId));
			sb.append("&");
		}
		if (model != null) {
			sb.append(prefix).append("model=").append(NVPUtil.encodeUrl(model));
			sb.append("&");
		}
		if (geoLocation != null) {
			sb.append(prefix).append("geoLocation=").append(NVPUtil.encodeUrl(geoLocation));
			sb.append("&");
		}
		if (customerType != null) {
			sb.append(prefix).append("customerType=").append(NVPUtil.encodeUrl(customerType));
			sb.append("&");
		}
		if (partnerName != null) {
			sb.append(prefix).append("partnerName=").append(NVPUtil.encodeUrl(partnerName));
			sb.append("&");
		}
		if (customerId != null) {
			sb.append(prefix).append("customerId=").append(NVPUtil.encodeUrl(customerId));
			sb.append("&");
		}
		return sb.toString();
	}

}