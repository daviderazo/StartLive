/**
 * 
 */
package com.dav.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dav.common.TimeConvertTypes;
import com.dav.model.GrupoPermiso;

/**
 * @author Dhartel
 *
 */
public class GrupoPermisoMapper implements RowMapper<GrupoPermiso> {

	@Override
	public GrupoPermiso mapRow(ResultSet rs, int rowNum) throws SQLException {
		GrupoPermiso grupoPermiso = new GrupoPermiso();
		grupoPermiso.setEstado(rs.getBoolean("estado"));
		grupoPermiso.setIdGrupo(rs.getLong("IdGrupo"));
		grupoPermiso.setIdPermiso(rs.getLong("IdPermiso"));
		grupoPermiso.setFecha(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fecha")));
		grupoPermiso.setEstado(rs.getBoolean("estado"));
		
		return grupoPermiso;
	}

}
