/**
 * 
 */
package com.dav.model;

import java.util.Date;

/**
 * @author Dhartel
 *
 */
public class CatalogoTipo extends ModelAuditoria {
	private String codigoCatalogoTipo;
	private String nombreCatalogoTipo;
	private String descripcionCatalogo;
	
	public String getCodigoCatalogoTipo() {
		return codigoCatalogoTipo;
	}
	public void setCodigoCatalogoTipo(String codigoCatalogoTipo) {
		this.codigoCatalogoTipo = codigoCatalogoTipo;
	}
	public String getNombreCatalogoTipo() {
		return nombreCatalogoTipo;
	}
	public void setNombreCatalogoTipo(String nombreCatalogoTipo) {
		this.nombreCatalogoTipo = nombreCatalogoTipo;
	}
	public String getDescripcionCatalogo() {
		return descripcionCatalogo;
	}
	public void setDescripcionCatalogo(String descripcionCatalogo) {
		this.descripcionCatalogo = descripcionCatalogo;
	}
	
	
	
	
	
}
