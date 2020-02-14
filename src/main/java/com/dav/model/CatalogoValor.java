/**
 * 
 */
package com.dav.model;

import lombok.Data;

/**
 * @author Dhartel
 *
 */
@Data
public class CatalogoValor extends ModelAuditoria {
	private String codigoValorCatalogo;
	private String codigoCatalogoTipo;
	private String valorCatalogo;
	private String tipoDatoValor;
	private String nombreCatalogoValor;
	private String descripcionCatalogo;
	private String color;
	private String fontIco;
	
	private CatalogoTipo catalogoTipo;
	
	
	
	
	
	
}
