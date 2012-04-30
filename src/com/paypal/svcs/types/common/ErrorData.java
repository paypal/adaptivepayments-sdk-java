
/**
 * Auto generated code
 */

package com.paypal.svcs.types.common;

import com.paypal.svcs.types.common.ErrorCategory;
import com.paypal.svcs.types.common.ErrorParameter;
import com.paypal.svcs.types.common.ErrorSeverity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * This type contains the detailed error
 * information resulting from the service
 * operation.
 */
public class ErrorData {

	/**
	 */
	private Integer errorId;
	public Integer getErrorId() {
		return errorId;
	}
	public void setErrorId(Integer value) {
		this.errorId = value;
	}

	/**
	 */
	private String domain;
	public String getDomain() {
		return domain;
	}
	public void setDomain(String value) {
		this.domain = value;
	}

	/**
	 */
	private String subdomain;
	public String getSubdomain() {
		return subdomain;
	}
	public void setSubdomain(String value) {
		this.subdomain = value;
	}

	/**
	 */
	private ErrorSeverity severity;
	public ErrorSeverity getSeverity() {
		return severity;
	}
	public void setSeverity(ErrorSeverity value) {
		this.severity = value;
	}

	/**
	 */
	private ErrorCategory category;
	public ErrorCategory getCategory() {
		return category;
	}
	public void setCategory(ErrorCategory value) {
		this.category = value;
	}

	/**
	 */
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String value) {
		this.message = value;
	}

	/**
	 */
	private String exceptionId;
	public String getExceptionId() {
		return exceptionId;
	}
	public void setExceptionId(String value) {
		this.exceptionId = value;
	}

	/**
	 */
	private List<ErrorParameter> parameter = new ArrayList<ErrorParameter>();
	public List<ErrorParameter> getParameter() {
		return parameter;
	}
	public void setParameter(List<ErrorParameter> value) {
		this.parameter = value;
	}


	public ErrorData() {
	}
	public ErrorData(Map<String, String> map, String prefix) {
		int i=0; 
		if( map.containsKey(prefix + "errorId") ) {
			this.errorId = Integer.valueOf(map.get(prefix + "errorId"));
		}
		if( map.containsKey(prefix + "domain") ) {
			this.domain = map.get(prefix + "domain");
		}
		if( map.containsKey(prefix + "subdomain") ) {
			this.subdomain = map.get(prefix + "subdomain");
		}
		if( map.containsKey(prefix + "severity") ) {
			this.severity = ErrorSeverity.fromValue( map.get(prefix + "severity") );
		}
		if( map.containsKey(prefix + "category") ) {
			this.category = ErrorCategory.fromValue( map.get(prefix + "category") );
		}
		if( map.containsKey(prefix + "message") ) {
			this.message = map.get(prefix + "message");
		}
		if( map.containsKey(prefix + "exceptionId") ) {
			this.exceptionId = map.get(prefix + "exceptionId");
		}
		 i=0; 
		 while(true) {
			if( map.containsKey(prefix + "parameter" + '(' + i + ')'+ ".name") ) {
				String newPrefix = prefix + "parameter" + '(' + i + ')' + '.';
				this.parameter.add(new ErrorParameter(map, newPrefix));
			}
			else break;
			i++;
		}
	}
}
