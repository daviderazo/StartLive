/**
 * 
 */
package com.dav.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dav.common.TimeConvertTypes;
import com.dav.model.Categoria;

/**
 * @author Dhartel
 *
 */
public class CategoriaMapper implements RowMapper<Categoria> {

	@Override
	public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categoria categoria = new Categoria();
		categoria.setCategoriaSuperior(rs.getLong("CategoriaSuperior"));
		categoria.setDescripcion(rs.getString("Descripcion"));
		categoria.setIdCategoria(rs.getLong("IdCategoria"));
		categoria.setNombre(rs.getString("Nombre"));
		categoria.setFecha(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fecha")));
		categoria.setEstado(rs.getBoolean("estado"));
		
		return categoria;
	}

}
