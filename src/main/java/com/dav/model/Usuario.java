/**
 * 
 */
package com.dav.model;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * @author Dhartel
 *
 */
@SuppressWarnings("serial")
@Data
//@Getter
//@Setter
public class Usuario extends ModelAuditoria {

	private Long idUsuario;
	private String nombre;
	private String apellido;
	private String contrasena;
	private String correo;
	private String fontIco;
	private Long idGrupo;
	private String isEncryted;
	private String codigoTipoUsuarioSecurity;
	private String valorTipoUsuarioSecurity;
	private LocalDateTime fechaExpiracion;
	
	private Grupo grupo;
	private CatalogoValor catValor;
	

	
	
	
	
	
	
}
