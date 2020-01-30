/**
 * 
 */
package com.dav.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dav.common.TimeConvertTypes;
import com.dav.model.UsuarioMetadata;

/**
 * @author Dhartel
 *
 */
public class UsuariometadataMapper implements RowMapper<UsuarioMetadata> {

	@Override
	public UsuarioMetadata mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsuarioMetadata usuarioMetadata = new UsuarioMetadata();
		usuarioMetadata.setClave(rs.getString("Clave"));
		usuarioMetadata.setIdUsuario(rs.getLong("IdUsuario"));
		usuarioMetadata.setIdUsuarioMetadata(rs.getLong("IdUsuarioMetadata"));
		usuarioMetadata.setTipo(rs.getString("Tipo"));
		usuarioMetadata.setValor(rs.getString("Valor"));
		usuarioMetadata.setFecha(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fecha")));
		usuarioMetadata.setEstado(rs.getBoolean("estado"));
		
		return usuarioMetadata;
	}

}
