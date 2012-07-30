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
	 *@Required	 
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
	 


	public ErrorData(Map<String, String> map, String prefix) {
		int i = 0;
		if(map.containsKey(prefix + "errorId")){
			this.errorId = Integer.valueOf(map.get(prefix + "errorId"));
		}
		if(map.containsKey(prefix + "domain")){
			this.domain = map.get(prefix + "domain");
		}
		if(map.containsKey(prefix + "subdomain")){
			this.subdomain = map.get(prefix + "subdomain");
		}
		if(map.containsKey(prefix + "severity")){
			this.severity = ErrorSeverity.fromValue(map.get(prefix + "severity"));
		}
		if(map.containsKey(prefix + "category")){
			this.category = ErrorCategory.fromValue(map.get(prefix + "category"));
		}
		if(map.containsKey(prefix + "message")){
			this.message = map.get(prefix + "message");
		}
		if(map.containsKey(prefix + "exceptionId")){
			this.exceptionId = map.get(prefix + "exceptionId");
		}
		i = 0;
		while(true) {
			if(map.containsKey(prefix + "parameter" + "(" + i + ")")){
				String newPrefix = prefix + "parameter" + "(" + i + ")";
				this.parameter.add(new ErrorParameter(map, newPrefix));
			} else {
				break;
			}
			i++;
		}
	}

}