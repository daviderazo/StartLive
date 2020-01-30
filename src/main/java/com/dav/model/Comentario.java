/**
 * 
 */
package com.dav.model;

import java.util.Date;

/**
 * @author Dhartel
 *
 */
public class Comentario extends ModelAuditoria {

	private Long idComentario;
	private String comentario;
	private Long idPost;
	private Long idUsuarioComentario;
	private Long respuesta;
	public Long getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Long getIdPost() {
		return idPost;
	}
	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}
	public Long getIdUsuarioComentario() {
		return idUsuarioComentario;
	}
	public void setIdUsuarioComentario(Long idUsuarioComentario) {
		this.idUsuarioComentario = idUsuarioComentario;
	}
	public Long getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(Long respuesta) {
		this.respuesta = respuesta;
	}
	
	


}
