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
	
	public static Object  transformarVarible(String valor, String tipoVariable) {
		switch (tipoVariable.toUpperCase()) {
		case "INTEGER": 
			return Integer.valueOf(valor);
		case "FLOAT": 
			return Float.valueOf(valor);
		case "LONG": 
			return Long.valueOf(valor);
		case "DOUBLE": 
			return Double.valueOf(valor);
		case "STRING": 
			return valor;
		case "BOOLEAN": 
			return Boolean.valueOf(valor);
			
			
			
		default:
			return null;
		}
	}
}
