/**
 * 
 */
package com.dav.model;

import java.util.Date;

/**
 * @author Dhartel
 *
 */
public class Post extends ModelAuditoria {
	
	private Long idPost;
	private String titulo;
	private String slug;
	private String extracto;
	private Long categoria;
	private Long idUsuarioPost;
	private String imagenDestacada;
	private String tipo;
	private String fontIco;
	
	public Long getIdPost() {
		return idPost;
	}
	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getExtracto() {
		return extracto;
	}
	public void setExtracto(String extracto) {
		this.extracto = extracto;
	}
	public Long getCategoria() {
		return categoria;
	}
	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}
	public Long getIdUsuarioPost() {
		return idUsuarioPost;
	}
	public void setIdUsuarioPost(Long idUsuarioPost) {
		this.idUsuarioPost = idUsuarioPost;
	}
	public String getImagenDestacada() {
		return imagenDestacada;
	}
	public void setImagenDestacada(String imagenDestacada) {
		this.imagenDestacada = imagenDestacada;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFontIco() {
		return fontIco;
	}
	public void setFontIco(String fontIco) {
		this.fontIco = fontIco;
	}

	
	
	
	
	
	
}
