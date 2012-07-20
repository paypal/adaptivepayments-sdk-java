package com.paypal.svcs.types.ap;
import java.io.UnsupportedEncodingException;
import com.paypal.core.NVPUtil;
import java.util.Map;

/**
 * FundingTypeInfo represents one allowed funding type. 
 */
public class FundingTypeInfo{


	/**
	 * No Document Comments	  
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
		if (fundingType != null) {
			sb.append(prefix).append("fundingType=").append(NVPUtil.encodeUrl(fundingType));
			sb.append("&");
		}
		return sb.toString();
	}
	public FundingTypeInfo(Map<String, String> map, String prefix) {
		prefix = prefix.substring(0, prefix.length() - 1);
		this.fundingType = map.get(prefix + "fundingType");
	}

}