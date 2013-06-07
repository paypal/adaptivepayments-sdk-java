package com.paypal.svcs.types.ap;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * FundingTypeInfo represents one allowed funding type. 
 */
public class FundingTypeInfo{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private String fundingType;

	

	/**
	 * Constructor with arguments
	 */
	public FundingTypeInfo (String fundingType){
		this.fundingType = fundingType;
	}	

	/**
	 * Default Constructor
	 */
	public FundingTypeInfo (){
	}	

	/**
	 * Getter for fundingType
	 */
	 public String getFundingType() {
	 	return fundingType;
	 }
	 
	/**
	 * Setter for fundingType
	 */
	 public void setFundingType(String fundingType) {
	 	this.fundingType = fundingType;
	 }
	 


	public String toNVPString() throws UnsupportedEncodingException {
		return toNVPString("");
	}
	
	public String toNVPString(String prefix) throws UnsupportedEncodingException {
		StringBuilder sb = new StringBuilder();
		if (this.fundingType != null) {
			sb.append(prefix).append("fundingType=").append(NVPUtil.encodeUrl(this.fundingType));
			sb.append("&");
		}
		return sb.toString();
	}
	
	public static FundingTypeInfo createInstance(Map<String, String> map, String prefix, int index) {
		FundingTypeInfo fundingTypeInfo = null;
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
			
		if (map.containsKey(prefix + "fundingType")) {
				fundingTypeInfo = (fundingTypeInfo == null) ? new FundingTypeInfo() : fundingTypeInfo;
				fundingTypeInfo.setFundingType(map.get(prefix + "fundingType"));
		}
		return fundingTypeInfo;
	}
 
}