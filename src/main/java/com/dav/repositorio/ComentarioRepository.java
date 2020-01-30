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

import com.dav.mapper.ComentarioMapper;
import com.dav.model.Categoria;
import com.dav.model.Comentario;

/**
 * @author Dhartel
 *
 */
//@Repository
public class ComentarioRepository implements ComentarioRep, BaseRepBusq<Comentario> {

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
	public boolean save(Comentario object) {
		StringBuilder sqlBuilder = new StringBuilder("insert into comentario  ( Comentrio, IdUsuarioComent, IdPost");
		Object[] arrayParametros = extractToInsert(object, sqlBuilder);
		try {
			String sql = String.format(
					sqlBuilder.toString(), arrayParametros);
			jdbcTemplate.execute(sql);
			return Boolean.TRUE;
		} catch(Exception e) {
			logger.fatal("dio error "+e);
			return Boolean.FALSE;
		}
	}

	private Object[] extractToInsert(Comentario object, StringBuilder sqlBuilder) {
		String  valorCodSup = "";
		Object [] arrayParametros;
		if(object.getRespuesta() == null) {
			sqlBuilder.append(")");
			valorCodSup = ")";
			arrayParametros = new Object[]{object.getComentario(), object.getIdUsuarioComentario(), object.getIdPost()};
		}else {
			sqlBuilder.append(", Respuesta) ");
			valorCodSup = ", '%d') ";
			arrayParametros = new Object[]{object.getComentario(), object.getIdUsuarioComentario(), object.getIdPost(), object.getRespuesta()};
		}
		sqlBuilder.append(" values ('%s', '%d', '%d'");
		
		sqlBuilder.append(valorCodSup);
		return arrayParametros;
	}
	
	@Override
	public boolean update(Comentario object) {
		if(object.getIdComentario() != null) {
			StringBuilder sqlBuilder = new StringBuilder("update comentario set Comentrio ='%s' , IdUsuarioComent ='%d', IdPost = '%d' ");
			Object[] arrayParametros = extractToModificar(object, sqlBuilder);
			
			String sql = String.format(
					sqlBuilder.toString(), arrayParametros);
			jdbcTemplate.execute(sql);
			return Boolean.TRUE;
		}
		return  Boolean.FALSE;
	}

	private Object[] extractToModificar(Comentario object, StringBuilder sqlBuilder) {
		Object [] arrayParametros;
		if(object.getRespuesta() == null) {
			arrayParametros = new Object[]{object.getComentario(), object.getIdUsuarioComentario(), object.getIdPost(),
					object.getIdComentario()};
		} else {
			sqlBuilder.append(", Respuesta='%d' ");
			arrayParametros = new Object[]{object.getComentario(), object.getIdUsuarioComentario(), object.getIdPost(), object.getRespuesta(),
					object.getIdComentario()};
		}
		sqlBuilder.append(" where IdComentario ='%d' ");
		return arrayParametros;
		
	}
			
	@Override
	public List<Comentario> findAll(Pageable pageable) {
		return jdbcTemplate.query("select * from comentario", new ComentarioMapper());
	}

	@Override
	public Comentario findById(long id) {
		Object [] parametersArray = new Object [] {id};
		return jdbcTemplate.queryForObject("select * from comentario where IdComentario =?", parametersArray, new ComentarioMapper());
	} 
	
}
