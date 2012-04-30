
/**
 * Auto generated code
 */

package com.paypal.svcs.types.ap;

import com.paypal.svcs.types.ap.WarningData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 */
public class WarningDataList {

	/**
	 *
	 * @Required
	 */
	private List<WarningData> warningData = new ArrayList<WarningData>();
	public List<WarningData> getWarningData() {
		return warningData;
	}
	public void setWarningData(List<WarningData> value) {
		this.warningData = value;
	}


	public WarningDataList() {
	}
	public WarningDataList(Map<String, String> map, String prefix) {
		int i=0; 
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "warningData" + '(' + i + ')'+ ".warningId") ) {
				String newPrefix = prefix + "warningData" + '(' + i + ')' + '.';
				this.warningData.add(new WarningData(map, newPrefix));
			}
			else break;
			i++;
		}
	}
}
