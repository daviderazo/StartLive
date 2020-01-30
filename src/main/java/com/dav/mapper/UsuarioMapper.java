/**
 * 
 */
package com.dav.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dav.common.TimeConvertTypes;
import com.dav.model.Usuario;

/**
 * @author Dhartel
 *
 */
public class UsuarioMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario  usuario = new Usuario();
		usuario.setApellido(rs.getString("Apellido"));
		usuario.setContrasena(rs.getString("Contrasena"));
		usuario.setCorreo(rs.getString("Correo"));
		usuario.setFontIco(rs.getString("FontIco"));
		usuario.setIdGrupo(rs.getLong("IdGrupo"));
		usuario.setIdUsuario(rs.getLong("IdUsuario"));
		usuario.setNombre(rs.getString("Nombre"));
		usuario.setFecha(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fecha")));
		usuario.setEstado(rs.getBoolean("estado"));
		
		return usuario;
	}

}
