/**
 * 
 */
package com.dav.model;

/**
 * @author Dhartel
 *
 */
public class Postmetadata extends ModelAuditoria {
	private Long idPostMetadata;
	private String clave;
	private String valor;
	private String tipo;
	private Long idPost;
	
	
	public Long getIdPostMetadata() {
		return idPostMetadata;
	}
	public void setIdPostMetadata(Long idPostMetadata) {
		this.idPostMetadata = idPostMetadata;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
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
	
	
	
	
	
}
