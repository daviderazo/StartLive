/**
 * 
 */
package com.dav.model.commons;

import java.io.Serializable;

/**
 * @author Dhartel
 *
 */
@SuppressWarnings("serial")
public class TrasientGrupoPermiso implements Serializable{
	private Long idGrupo;
	private Long idPermiso;
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
	
	

}
