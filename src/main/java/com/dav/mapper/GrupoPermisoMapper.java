/**
 * 
 */
package com.dav.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dav.common.TimeConvertTypes;
import com.dav.model.GrupoPermiso;
import com.dav.model.Permiso;

/**
 * @author Dhartel
 *
 */
public class GrupoPermisoMapper implements RowMapper<GrupoPermiso> {

	@Override
	public GrupoPermiso mapRow(ResultSet rs, int rowNum) throws SQLException {
		GrupoPermiso grupoPermiso = new GrupoPermiso();
		grupoPermiso.setEstado(rs.getBoolean("EstadoGP"));
		grupoPermiso.setIdGrupo(rs.getLong("IdGrupo"));
		grupoPermiso.setIdPermiso(rs.getLong("IdPermiso"));
		grupoPermiso.setFecha(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fechaGP")));
		grupoPermiso.setEstado(rs.getBoolean("EstadoGP"));
		grupoPermiso.setPermiso(new Permiso());
		grupoPermiso.getPermiso().setIdPermiso(rs.getLong("IdPermiso"));
		grupoPermiso.getPermiso().setNombre(rs.getString("nombre"));
		grupoPermiso.getPermiso().setEstado(rs.getBoolean("EstadoP"));
		grupoPermiso.getPermiso().setFecha(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fechaP")));
		
		return grupoPermiso;
	}

}
