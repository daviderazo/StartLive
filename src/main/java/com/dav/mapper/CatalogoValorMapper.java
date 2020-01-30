/**
 * 
 */
package com.dav.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dav.common.TimeConvertTypes;
import com.dav.model.CatalogoValor;

/**
 * @author Dhartel
 *
 */
public class CatalogoValorMapper implements RowMapper<CatalogoValor> {

	@Override
	public CatalogoValor mapRow(ResultSet rs, int rowNum) throws SQLException {
		CatalogoValor catalogoValor = new CatalogoValor();
		catalogoValor.setCodigoCatalogoTipo(rs.getString("CodigoCatalogoTipo"));
		catalogoValor.setCodigoValorCatalogo(rs.getString("CodigoValorCatalogo"));
		catalogoValor.setColor(rs.getString("Color"));
		catalogoValor.setDescripcionCatalogo(rs.getString("DescripcionCatalogo"));
		catalogoValor.setFontIco(rs.getString("FontIco"));
		catalogoValor.setNombreCatalogoValor(rs.getString("NombreCatalogoValor"));
		catalogoValor.setTipoDatoValor(rs.getString("TipoDatoValor"));
		catalogoValor.setValorCatalogo(rs.getString("ValorCatalogo"));
		catalogoValor.setFecha(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fecha")));
		catalogoValor.setEstado(rs.getBoolean("estado"));
		
		return catalogoValor;
	}

}
