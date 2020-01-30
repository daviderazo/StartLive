/**
 * 
 */
package com.dav.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dav.common.TimeConvertTypes;
import com.dav.model.Post;

/**
 * @author Dhartel
 *
 */
public class PostMapper implements RowMapper<Post> {

	@Override
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
		Post post = new Post();
		post.setCategoria(rs.getLong("Categoria"));
		post.setExtracto(rs.getString("Extracto"));
		post.setFontIco(rs.getString("FontIco"));
		post.setIdPost(rs.getLong("IdPost"));
		post.setIdUsuarioPost(rs.getLong("IdUsuarioPost"));
		post.setImagenDestacada(rs.getString("ImagenDestacada"));
		post.setSlug(rs.getString("Slug"));
		post.setTipo(rs.getString("Tipo"));
		post.setTitulo(rs.getString("Titulo"));
		post.setFecha(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fecha")));
		post.setEstado(rs.getBoolean("estado"));
		
		return post;
	}

}
