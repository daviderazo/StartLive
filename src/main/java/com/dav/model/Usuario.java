/**
 * 
 */
package com.dav.model;

/**
 * @author Dhartel
 *
 */
public class Usuario extends ModelAuditoria {

	private Long idUsuario;
	private String nombre;
	private String apellido;
	private String contrasena;
	private String correo;
	private String fontIco;
	private Long idGrupo;
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getFontIco() {
		return fontIco;
	}
	public void setFontIco(String fontIco) {
		this.fontIco = fontIco;
	}
	public Long getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}
	
	
	
}
