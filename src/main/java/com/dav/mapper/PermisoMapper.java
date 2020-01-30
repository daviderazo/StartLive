/**
 * 
 */
package com.dav.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dav.common.TimeConvertTypes;
import com.dav.model.Permiso;

/**
 * @author Dhartel
 *
 */
public class PermisoMapper implements RowMapper<Permiso> {

	@Override
	public Permiso mapRow(ResultSet rs, int rowNum) throws SQLException {
		Permiso permiso = new Permiso();
		permiso.setIdPermiso(rs.getLong("IdPermiso"));
		permiso.setNombre(rs.getString("Nombre"));
		permiso.setFecha(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fecha")));
		permiso.setEstado(rs.getBoolean("estado"));
		
		return permiso;
	}

}
