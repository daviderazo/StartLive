/**
 * 
 */
package com.dav.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dav.common.TimeConvertTypes;
import com.dav.model.Ingresosistema;

/**
 * @author Dhartel
 *
 */
public class IngresosistemaMapper implements RowMapper<Ingresosistema> {

	@Override
	public Ingresosistema mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ingresosistema ingresosistema = new Ingresosistema();
		ingresosistema.setCodigoTipoDispositivo(rs.getString("CodigoTipoDispositivo"));
		ingresosistema.setFechaingreso(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("FechaIngreso")));
		ingresosistema.setFechaSalida(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("FechaSalida")));
		ingresosistema.setIdGrupo(rs.getLong("IdGrupo"));
		ingresosistema.setIdIngresoSistema(rs.getLong("IdIngresoSistema"));
		ingresosistema.setIdUsuario(rs.getLong("IdUsuario"));
		ingresosistema.setTiempoSistema(rs.getLong("TiempoSistema"));
		ingresosistema.setValortipoDispocitivo(rs.getString("ValorTipoDispositovo"));
		ingresosistema.setFecha(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fecha")));
		ingresosistema.setEstado(rs.getBoolean("estado"));
		
		return ingresosistema;
	}

}
