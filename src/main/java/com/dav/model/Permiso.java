/**
 * 
 */
package com.dav.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author Dhartel
 *
 */
public class Permiso extends ModelAuditoria{
	@NotNull
	private Long idPermiso;
	
	@Max(message="el erroro maximo es de 50", value = 50)
	private String nombre;
	
	
	public Long getIdPermiso() {
		return idPermiso;
	}
	public void setIdPermiso(Long idPermiso) {
		this.idPermiso = idPermiso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
