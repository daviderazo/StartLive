/**
 * 
 */
package com.dav.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dav.common.TimeConvertTypes;
import com.dav.model.CatalogoTipo;

/**
 * @author Dhartel
 *
 */
public class CatalogoTipoMapper implements RowMapper<CatalogoTipo> {

	@Override
	public CatalogoTipo mapRow(ResultSet rs, int rowNum) throws SQLException {
		CatalogoTipo catalogoTipo = new CatalogoTipo();
		catalogoTipo.setNombreCatalogoTipo(rs.getNString("NombreCatalogoTipo"));
		catalogoTipo.setDescripcionCatalogo(rs.getString("DescripcionCatalogo"));
		catalogoTipo.setCodigoCatalogoTipo(rs.getString("CodigoCatalogoTipo"));
		catalogoTipo.setFecha(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fecha")));
		catalogoTipo.setEstado(rs.getBoolean("estado"));
		
		return catalogoTipo;
	}

}
