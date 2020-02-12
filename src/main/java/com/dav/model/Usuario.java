/**
 * 
 */
package com.dav.model;

import lombok.Data;

/**
 * @author Dhartel
 *
 */
@Data

public class Usuario extends ModelAuditoria {

	private Long idUsuario;
	private String nombre;
	private String apellido;
	private String contrasena;
	private String correo;
	private String fontIco;
	private Long idGrupo;
	
	private Grupo grupo;
	
	
	
	
	
	
}
