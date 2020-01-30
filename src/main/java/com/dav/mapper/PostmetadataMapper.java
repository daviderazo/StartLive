/**
 * 
 */
package com.dav.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dav.common.TimeConvertTypes;
import com.dav.model.Postmetadata;

/**
 * @author Dhartel
 *
 */
public class PostmetadataMapper implements RowMapper<Postmetadata> {

	@Override
	public Postmetadata mapRow(ResultSet rs, int rowNum) throws SQLException {
		Postmetadata postmetadata = new Postmetadata();
		postmetadata.setClave(rs.getString("Clave"));
		postmetadata.setIdPost(rs.getLong("IdPost"));
		postmetadata.setIdPostMetadata(rs.getLong("IdPostMetadata"));
		postmetadata.setTipo(rs.getString("Tipo"));
		postmetadata.setValor(rs.getString("Valor"));
		postmetadata.setFecha(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fecha")));
		postmetadata.setEstado(rs.getBoolean("estado"));
		
		return postmetadata;
	}

}
