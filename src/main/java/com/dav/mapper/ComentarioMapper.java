/**
 * 
 */
package com.dav.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dav.common.TimeConvertTypes;
import com.dav.model.Comentario;

/**
 * @author Dhartel
 *
 */
public class ComentarioMapper implements RowMapper<Comentario>{

	@Override
	public Comentario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Comentario comentario = new Comentario();
		comentario.setComentario(rs.getString("Cometario"));
		comentario.setFecha(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fecha")));
		comentario.setIdComentario(rs.getLong("IdComentario"));
		comentario.setIdPost(rs.getLong("IdPost"));
		comentario.setIdUsuarioComentario(rs.getLong("IdUsuarioComent"));
		comentario.setRespuesta(rs.getLong("Respuesta"));
		comentario.setEstado(rs.getBoolean("estado"));
		return comentario;
	}

}
