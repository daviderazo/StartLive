/**
 * 
 */
package com.dav.util;

import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * @author Dhartel
 *
 */
public class ApiError {
	
	private HttpStatus status;
    private String message;
    private String method;
    private List<ApiSubError> subErrors;
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public List<ApiSubError> getSubErrors() {
		return subErrors;
	}
	public void setSubErrors(List<ApiSubError> subErrors) {
		this.subErrors = subErrors;
	}
    
}
