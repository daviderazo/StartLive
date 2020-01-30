/**
 * 
 */
package com.dav.model;

/**
 * @author Dhartel
 *
 */
public class Contenido extends ModelAuditoria {
	private Long idContenido;
	private String tipo;
	private Long idPost;
	private String contenidoDes;
	public Long getIdContenido() {
		return idContenido;
	}
	public void setIdContenido(Long idContenido) {
		this.idContenido = idContenido;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getIdPost() {
		return idPost;
	}
	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}
	public String getContenidoDes() {
		return contenidoDes;
	}
	public void setContenidoDes(String contenidoDes) {
		this.contenidoDes = contenidoDes;
	}
	
	
	
	
	
}
