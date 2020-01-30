/**
 * 
 */
package com.dav.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dav.common.TimeConvertTypes;
import com.dav.model.Contenido;

/**
 * @author Dhartel
 *
 */
public class ContenidoMapper implements RowMapper<Contenido> {

	@Override
	public Contenido mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contenido contenido = new Contenido();
		contenido.setContenidoDes(rs.getString("Contenido"));
		contenido.setIdContenido(rs.getLong("IdContenido"));
		contenido.setIdPost(rs.getLong("IdPost"));
		contenido.setTipo(rs.getString("Tipo"));
		contenido.setFecha(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fecha")));
		contenido.setEstado(rs.getBoolean("estado"));
		
		return contenido;
	}

}
