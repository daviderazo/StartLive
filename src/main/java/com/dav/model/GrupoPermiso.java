/**
 * 
 */
package com.dav.model;

import java.util.List;

/**
 * @author Dhartel
 *
 */
public class GrupoPermiso extends ModelAuditoria {
	private Long idGrupo;
	private Long idPermiso;
	
	private Grupo grupo;
	private Permiso permiso;
	private List<Permiso> permisos;
	private  Object[] multiCheckboxSelectedValues;
	private List<GrupoPermiso> lstGrupoPermiso;
	
	public Long getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}
	public Long getIdPermiso() {
		return idPermiso;
	}
	public void setIdPermiso(Long idPermiso) {
		this.idPermiso = idPermiso;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public List<Permiso> getPermisos() {
		return permisos;
	}
	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}
	public Object[] getMultiCheckboxSelectedValues() {
		return multiCheckboxSelectedValues;
	}
	public void setMultiCheckboxSelectedValues(Object[] multiCheckboxSelectedValues) {
		this.multiCheckboxSelectedValues = multiCheckboxSelectedValues;
	}
	public Permiso getPermiso() {
		return permiso;
	}
	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}
	public List<GrupoPermiso> getLstGrupoPermiso() {
		return lstGrupoPermiso;
	}
	public void setLstGrupoPermiso(List<GrupoPermiso> lstGrupoPermiso) {
		this.lstGrupoPermiso = lstGrupoPermiso;
	}
	
	
}
