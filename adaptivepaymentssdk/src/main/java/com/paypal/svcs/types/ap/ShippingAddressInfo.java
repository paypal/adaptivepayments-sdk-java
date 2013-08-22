package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.PhoneNumber;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * ShippingAddressInfo. 
 */
public class ShippingAddressInfo{


	/**
	 * 	 
	 */ 
	private String addresseeName;

	/**
	 * 	 
	 */ 
	private String street1;

	/**
	 * 	 
	 */ 
	private String street2;

	/**
	 * 	 
	 */ 
	private String city;

	/**
	 * 	 
	 */ 
	private String state;

	/**
	 * 	 
	 */ 
	private String zip;

	/**
	 * 	 
	 */ 
	private String country;

	/**
	 * 	 
	 */ 
	private List<PhoneNumber> phone = new ArrayList<PhoneNumber>();

	

	/**
	 * Default Constructor
	 */
	public ShippingAddressInfo (){
	}	

	/**
	 * Getter for addresseeName
	 */
	 public String getAddresseeName() {
	 	return addresseeName;
	 }
	 
	/**
	 * Setter for addresseeName
	 */
	 public void setAddresseeName(String addresseeName) {
	 	this.addresseeName = addresseeName;
	 }
	 
	/**
	 * Getter for street1
	 */
	 public String getStreet1() {
	 	return street1;
	 }
	 
	/**
	 * Setter for street1
	 */
	 public void setStreet1(String street1) {
	 	this.street1 = street1;
	 }
	 
	/**
	 * Getter for street2
	 */
	 public String getStreet2() {
	 	return street2;
	 }
	 
	/**
	 * Setter for street2
	 */
	 public void setStreet2(String street2) {
	 	this.street2 = street2;
	 }
	 
	/**
	 * Getter for city
	 */
	 public String getCity() {
	 	return city;
	 }
	 
	/**
	 * Setter for city
	 */
	 public void setCity(String city) {
	 	this.city = city;
	 }
	 
	/**
	 * Getter for state
	 */
	 public String getState() {
	 	return state;
	 }
	 
	/**
	 * Setter for state
	 */
	 public void setState(String state) {
	 	this.state = state;
	 }
	 
	/**
	 * Getter for zip
	 */
	 public String getZip() {
	 	return zip;
	 }
	 
	/**
	 * Setter for zip
	 */
	 public void setZip(String zip) {
	 	this.zip = zip;
	 }
	 
	/**
	 * Getter for country
	 */
	 public String getCountry() {
	 	return country;
	 }
	 
	/**
	 * Setter for country
	 */
	 public void setCountry(String country) {
	 	this.country = country;
	 }
	 
	/**
	 * Getter for phone
	 */
	 public List<PhoneNumber> getPhone() {
	 	return phone;
	 }
	 
	/**
	 * Setter for phone
	 */
	 public void setPhone(List<PhoneNumber> phone) {
	 	this.phone = phone;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.addresseeName != null) {
			sb.append(prefix).append("addresseeName=").append(NVPUtil.encodeUrl(this.addresseeName));
			sb.append("&");
		}
		if (this.street1 != null) {
			sb.append(prefix).append("street1=").append(NVPUtil.encodeUrl(this.street1));
			sb.append("&");
		}
		if (this.street2 != null) {
			sb.append(prefix).append("street2=").append(NVPUtil.encodeUrl(this.street2));
			sb.append("&");
		}
		if (this.city != null) {
			sb.append(prefix).append("city=").append(NVPUtil.encodeUrl(this.city));
			sb.append("&");
		}
		if (this.state != null) {
			sb.append(prefix).append("state=").append(NVPUtil.encodeUrl(this.state));
			sb.append("&");
		}
		if (this.zip != null) {
			sb.append(prefix).append("zip=").append(NVPUtil.encodeUrl(this.zip));
			sb.append("&");
		}
		if (this.country != null) {
			sb.append(prefix).append("country=").append(NVPUtil.encodeUrl(this.country));
			sb.append("&");
		}
		if (this.phone != null) {
			for(int i=0; i < this.phone.size(); i++) {
				String newPrefix = prefix + "phone" + "(" + i + ").";
				sb.append(this.phone.get(i).toNVPString(newPrefix));
			}
		}
		return sb.toString();
	}
	
	public static ShippingAddressInfo createInstance(Map<String, String> map, String prefix, int index) {
		ShippingAddressInfo shippingAddressInfo = null;
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
			
		if (map.containsKey(prefix + "addresseeName")) {
				shippingAddressInfo = (shippingAddressInfo == null) ? new ShippingAddressInfo() : shippingAddressInfo;
				shippingAddressInfo.setAddresseeName(map.get(prefix + "addresseeName"));
		}
		if (map.containsKey(prefix + "street1")) {
				shippingAddressInfo = (shippingAddressInfo == null) ? new ShippingAddressInfo() : shippingAddressInfo;
				shippingAddressInfo.setStreet1(map.get(prefix + "street1"));
		}
		if (map.containsKey(prefix + "street2")) {
				shippingAddressInfo = (shippingAddressInfo == null) ? new ShippingAddressInfo() : shippingAddressInfo;
				shippingAddressInfo.setStreet2(map.get(prefix + "street2"));
		}
		if (map.containsKey(prefix + "city")) {
				shippingAddressInfo = (shippingAddressInfo == null) ? new ShippingAddressInfo() : shippingAddressInfo;
				shippingAddressInfo.setCity(map.get(prefix + "city"));
		}
		if (map.containsKey(prefix + "state")) {
				shippingAddressInfo = (shippingAddressInfo == null) ? new ShippingAddressInfo() : shippingAddressInfo;
				shippingAddressInfo.setState(map.get(prefix + "state"));
		}
		if (map.containsKey(prefix + "zip")) {
				shippingAddressInfo = (shippingAddressInfo == null) ? new ShippingAddressInfo() : shippingAddressInfo;
				shippingAddressInfo.setZip(map.get(prefix + "zip"));
		}
		if (map.containsKey(prefix + "country")) {
				shippingAddressInfo = (shippingAddressInfo == null) ? new ShippingAddressInfo() : shippingAddressInfo;
				shippingAddressInfo.setCountry(map.get(prefix + "country"));
		}
		i = 0;
		while(true) {
			PhoneNumber phone =  PhoneNumber.createInstance(map, prefix + "phone", i);
			if (phone != null) {
				shippingAddressInfo = (shippingAddressInfo == null) ? new ShippingAddressInfo() : shippingAddressInfo;
				shippingAddressInfo.getPhone().add(phone);
				i++;
			} else {
				break;
			}
		}
		return shippingAddressInfo;
	}
 
}