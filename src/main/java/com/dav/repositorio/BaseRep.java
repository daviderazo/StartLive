/**
 * 
 */
package com.dav.repositorio;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;


/**
 * @author Dhartel
 *
 */

public interface BaseRep<T> {
	
	boolean save(T object) throws Exception; 
	
	boolean update(T object) throws Exception;
	
	List<T> findAll(Pageable pageable) throws Exception;
	
	
}
