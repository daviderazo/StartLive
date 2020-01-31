/**
 * 
 */
package com.dav.repositorio;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dav.mapper.PostMapper;
import com.dav.model.Post;

/**
 * @author Dhartel
 *
 */
@Repository
public class PostRepository implements PostRep, BaseRepBusq<Post> {

	//para ka pruebas
	private Log logger= LogFactory.getLog(getClass()); 
	@Autowired
	private DataSource dataSource;
	@PostConstruct
	public void postcontruct() {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	//@Autowired
	private JdbcTemplate  jdbcTemplate;

	@Override
	public boolean save(Post object) {
		try {
			String sql = String.format(
				"insert into post  ( Titulo, Slug, Extracto, Categoria, ImagenDestacada, FontIco,  Tipo, IdUsuarioPost) "
				+ "values ('%s', '%s', '%s', '%d', '%s', '%s', '%s', '%d')",
				object.getTitulo(), object.getSlug(), object.getExtracto(), object.getCategoria(), object.getImagenDestacada(), object.getFontIco(), object.getTipo(), object.getIdUsuarioPost());
			jdbcTemplate.execute(sql);
			return Boolean.TRUE;
		} catch(Exception e) {
			logger.fatal("dio error "+e);
			return Boolean.FALSE;
		}
	}
	

	@Override
	public boolean update(Post object) {
		if(object.getIdPost() != null) {
			String sql = String.format(
					"update post set Titulo='%s', Slug='%s', Extracto='%s', Categoria='%d', ImagenDestacada='%s', FontIco='%s',  Tipo='%s', IdUsuarioPost='%d' "
					+ " where IdPost ='%d' ",
					object.getTitulo(), object.getSlug(), object.getExtracto(), object.getCategoria(), object.getImagenDestacada(), object.getFontIco(), object.getTipo(), object.getIdUsuarioPost(), object.getIdPost());
				jdbcTemplate.execute(sql);
				return Boolean.TRUE;
		}
		return  Boolean.FALSE;
	}

	@Override
	public List<Post> findAll(Pageable pageable) {
		return jdbcTemplate.query("select * from post", new PostMapper());
	}

	@Override
	public Post findById(long id) {
		Object [] parametersArray = new Object [] {id};
		return jdbcTemplate.queryForObject("select * from post where IdPost =?", parametersArray, new PostMapper());
	} 
	
	
}
