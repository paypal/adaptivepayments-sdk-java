package com.paypal.svcs.types.ap;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.ap.WarningData;
import java.util.Map;

/**
 * No Document Comments
 */
public class WarningDataList{


	/**
	 * No Document Comments	  
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
	 


	public WarningDataList(Map<String, String> map, String prefix) {
		int i = 0;
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "warningData" + "(" + i + ")")){
				String newPrefix = prefix + "warningData" + "(" + i + ")" + ".";
				this.warningData.add(new WarningData(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
	}

}