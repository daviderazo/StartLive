/**
 * 
 */
package com.dav.model;

/**
 * @author Dhartel
 *
 */
public class Permiso extends ModelAuditoria{
	private Long idPermiso;
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
