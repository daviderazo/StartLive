/**
 * 
 */
package com.dav.controller.error;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

import com.dav.util.ApiError;

/**
 * @author Dhartel
 *
 */
@RestControllerAdvice(basePackages = {"com.dav.controller.rest"})
public class GlobalRestErrorController {
	
	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<Object> getEmptyResultDataAccessException(EmptyResultDataAccessException ex,
			ServletWebRequest webRequest) {
		ApiError apiError = new ApiError();
		apiError.setMessage(ex.getMessage());
		apiError.setMethod(webRequest.getHttpMethod().name());
		apiError.setStatus(HttpStatus.NOT_FOUND);
		return ResponseEntity.status(apiError.getStatus()).body(apiError);
	}
}
