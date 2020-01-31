/**
 * 
 */
package com.dav.model.commons;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Dhartel
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RepBase {
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date timestamp = new Date();
	
	private Object responce;
	
	public RepBase() {}
	
	public RepBase(Object responce) {
		this.responce = responce;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Object getResponce() {
		return responce;
	}

	public void setResponce(Object responce) {
		this.responce = responce;
	}
	
	
}
