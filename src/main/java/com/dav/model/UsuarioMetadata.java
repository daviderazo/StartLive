/**
 * 
 */
package com.dav.model;

import java.util.Date;

/**
 * @author Dhartel
 *
 */
public class UsuarioMetadata extends ModelAuditoria{
	private Long idUsuarioMetadata;
	private Long idUsuario;
	private String clave;
	private String valor;
	
	private String tipo;
	

	public Long getIdUsuarioMetadata() {
		return idUsuarioMetadata;
	}

	public void setIdUsuarioMetadata(Long idUsuarioMetadata) {
		this.idUsuarioMetadata = idUsuarioMetadata;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	
	
}
