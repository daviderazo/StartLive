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
	private Long idPermiso;
	
	private String nombre;
	
	private Boolean seleccionado;
	
	Permiso[] permisoSelecionados;
	
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
	public Boolean getSeleccionado() {
		if(seleccionado == null) {
			seleccionado = Boolean.FALSE;
		}
		return seleccionado;
	}
	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	public Permiso[] getPermisoSelecionados() {
		return permisoSelecionados;
	}
	public void setPermisoSelecionados(Permiso[] permisoSelecionados) {
		this.permisoSelecionados = permisoSelecionados;
	}
	
	
	
}
