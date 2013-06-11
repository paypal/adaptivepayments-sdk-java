package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.WarningData;
import java.util.Map;

/**
 * 
 */
public class WarningDataList{


	/**
	 * 	  
	 *@Required	 
	 */ 
	private List<WarningData> warningData = new ArrayList<WarningData>();

	

	/**
	 * Default Constructor
	 */
	public WarningDataList (){
	}	

	/**
	 * Getter for warningData
	 */
	 public List<WarningData> getWarningData() {
	 	return warningData;
	 }
	 
	/**
	 * Setter for warningData
	 */
	 public void setWarningData(List<WarningData> warningData) {
	 	this.warningData = warningData;
	 }
	 


	
	public static WarningDataList createInstance(Map<String, String> map, String prefix, int index) {
		WarningDataList warningDataList = null;
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
			
		i = 0;
		while(true) {
			WarningData warningData =  WarningData.createInstance(map, prefix + "warningData", i);
			if (warningData != null) {
				warningDataList = (warningDataList == null) ? new WarningDataList() : warningDataList;
				warningDataList.getWarningData().add(warningData);
				i++;
			} else {
				break;
			}
		}
		return warningDataList;
	}
 
}