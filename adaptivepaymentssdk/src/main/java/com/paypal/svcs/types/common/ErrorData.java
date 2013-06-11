package com.paypal.svcs.types.common;
import com.paypal.svcs.types.common.ErrorSeverity;
import com.paypal.svcs.types.common.ErrorCategory;
import java.util.List;
import java.util.ArrayList;
import com.paypal.svcs.types.common.ErrorParameter;
import java.util.Map;

/**
 * This type contains the detailed error information resulting
 * from the service operation. 
 */
public class ErrorData{


	/**
	 * 	 
	 */ 
	private Integer errorId;

	/**
	 * 	 
	 */ 
	private String domain;

	/**
	 * 	 
	 */ 
	private String subdomain;

	/**
	 * 	 
	 */ 
	private ErrorSeverity severity;

	/**
	 * 	 
	 */ 
	private ErrorCategory category;

	/**
	 * 	 
	 */ 
	private String message;

	/**
	 * 	 
	 */ 
	private String exceptionId;

	/**
	 * 	 
	 */ 
	private List<ErrorParameter> parameter = new ArrayList<ErrorParameter>();

	

	/**
	 * Default Constructor
	 */
	public ErrorData (){
	}	

	/**
	 * Getter for errorId
	 */
	 public Integer getErrorId() {
	 	return errorId;
	 }
	 
	/**
	 * Setter for errorId
	 */
	 public void setErrorId(Integer errorId) {
	 	this.errorId = errorId;
	 }
	 
	/**
	 * Getter for domain
	 */
	 public String getDomain() {
	 	return domain;
	 }
	 
	/**
	 * Setter for domain
	 */
	 public void setDomain(String domain) {
	 	this.domain = domain;
	 }
	 
	/**
	 * Getter for subdomain
	 */
	 public String getSubdomain() {
	 	return subdomain;
	 }
	 
	/**
	 * Setter for subdomain
	 */
	 public void setSubdomain(String subdomain) {
	 	this.subdomain = subdomain;
	 }
	 
	/**
	 * Getter for severity
	 */
	 public ErrorSeverity getSeverity() {
	 	return severity;
	 }
	 
	/**
	 * Setter for severity
	 */
	 public void setSeverity(ErrorSeverity severity) {
	 	this.severity = severity;
	 }
	 
	/**
	 * Getter for category
	 */
	 public ErrorCategory getCategory() {
	 	return category;
	 }
	 
	/**
	 * Setter for category
	 */
	 public void setCategory(ErrorCategory category) {
	 	this.category = category;
	 }
	 
	/**
	 * Getter for message
	 */
	 public String getMessage() {
	 	return message;
	 }
	 
	/**
	 * Setter for message
	 */
	 public void setMessage(String message) {
	 	this.message = message;
	 }
	 
	/**
	 * Getter for exceptionId
	 */
	 public String getExceptionId() {
	 	return exceptionId;
	 }
	 
	/**
	 * Setter for exceptionId
	 */
	 public void setExceptionId(String exceptionId) {
	 	this.exceptionId = exceptionId;
	 }
	 
	/**
	 * Getter for parameter
	 */
	 public List<ErrorParameter> getParameter() {
	 	return parameter;
	 }
	 
	/**
	 * Setter for parameter
	 */
	 public void setParameter(List<ErrorParameter> parameter) {
	 	this.parameter = parameter;
	 }
	 


	
	public static ErrorData createInstance(Map<String, String> map, String prefix, int index) {
		ErrorData errorData = null;
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
			
		if (map.containsKey(prefix + "errorId")) {
				errorData = (errorData == null) ? new ErrorData() : errorData;
				errorData.setErrorId(Integer.valueOf(map.get(prefix + "errorId")));
		}
		if (map.containsKey(prefix + "domain")) {
				errorData = (errorData == null) ? new ErrorData() : errorData;
				errorData.setDomain(map.get(prefix + "domain"));
		}
		if (map.containsKey(prefix + "subdomain")) {
				errorData = (errorData == null) ? new ErrorData() : errorData;
				errorData.setSubdomain(map.get(prefix + "subdomain"));
		}
		if (map.containsKey(prefix + "severity")) {
				errorData = (errorData == null) ? new ErrorData() : errorData;
				errorData.setSeverity(ErrorSeverity.fromValue(map.get(prefix + "severity")));
		}
		if (map.containsKey(prefix + "category")) {
				errorData = (errorData == null) ? new ErrorData() : errorData;
				errorData.setCategory(ErrorCategory.fromValue(map.get(prefix + "category")));
		}
		if (map.containsKey(prefix + "message")) {
				errorData = (errorData == null) ? new ErrorData() : errorData;
				errorData.setMessage(map.get(prefix + "message"));
		}
		if (map.containsKey(prefix + "exceptionId")) {
				errorData = (errorData == null) ? new ErrorData() : errorData;
				errorData.setExceptionId(map.get(prefix + "exceptionId"));
		}
		i = 0;
		while(true) {
			ErrorParameter parameter =  ErrorParameter.createInstance(map, prefix + "parameter", i);
			if (parameter != null) {
				errorData = (errorData == null) ? new ErrorData() : errorData;
				errorData.getParameter().add(parameter);
				i++;
			} else {
				break;
			}
		}
		return errorData;
	}
 
}