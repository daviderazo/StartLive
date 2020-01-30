/**
 * 
 */
package com.dav.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dav.common.TimeConvertTypes;
import com.dav.model.Grupo;

/**
 * @author Dhartel
 *
 */
public class GrupoMapper implements RowMapper<Grupo> {

	@Override
	public Grupo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Grupo grupo = new Grupo();
		grupo.setIdGrupo(rs.getLong("IdGrupo"));
		grupo.setNombre(rs.getString("Nombre"));
		grupo.setFecha(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fecha")));
		grupo.setEstado(rs.getBoolean("estado"));
		
		return grupo;
	}

}
