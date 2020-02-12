/**
 * 
 */
package com.dav.common;

import com.dav.model.ModelAuditoria;

/**
 * @author Dhartel
 *
 */
public class UtilVariables {
	private static UtilVariables instancia;
	
	private static UtilVariables getInstancia() {
		if(instancia == null) {
			instancia = new UtilVariables();
		}
		return instancia;
	}
	
	public static <T> String valorString( T object) {
		return ((ModelAuditoria) object).getEstado()?"1":"0";
	}
}
