/**
 * 
 */
package com.dav.model;

import java.util.Date;

/**
 * @author Dhartel
 *
 */
public class Categoria extends ModelAuditoria {
	private Long idCategoria;
	private String nombre;
	private String descripcion;
	private Long  categoriaSuperior;
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getCategoriaSuperior() {
		return categoriaSuperior;
	}
	public void setCategoriaSuperior(Long categoriaSuperior) {
		this.categoriaSuperior = categoriaSuperior;
	}
	
	
		

}
