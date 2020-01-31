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

import com.dav.mapper.PostmetadataMapper;
import com.dav.model.Postmetadata;

/**
 * @author Dhartel
 *
 */
@Repository
public class PostmetadataRepository implements PostmetadataRep, BaseRepBusq<Postmetadata> {
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
	public boolean save(Postmetadata object) {
		try {
			String sql = String.format(
				"insert into post_metadata  ( Clave, Valor, Tipo, IdPost) "
				+ "values ('%s', '%s', '%s', '%d' )",
				object.getClave(), object.getValor(), object.getTipo(), object.getIdPost());
			jdbcTemplate.execute(sql);
			return Boolean.TRUE;
		} catch(Exception e) {
			logger.fatal("dio error "+e);
			return Boolean.FALSE;
		}
	}

	@Override
	public boolean update(Postmetadata object) {
		if(object.getIdPostMetadata() != null) {
			String sql = String.format(
					"update post_metadata set Clave ='%s' , Valor ='%s', Tipo ='%s',  IdPost ='%d'"
					+ " where IdPostMetadata ='%d' ",
					object.getClave(), object.getValor(), object.getTipo(), object.getIdPost(), object.getIdPostMetadata());
				jdbcTemplate.execute(sql);
				return Boolean.TRUE;
		}
		return  Boolean.FALSE;
	}

	@Override
	public List<Postmetadata> findAll(Pageable pageable) {
		return jdbcTemplate.query("select * from post_metadata", new PostmetadataMapper());
	}

	@Override
	public Postmetadata findById(long id) {
		Object [] parametersArray = new Object [] {id};
		return jdbcTemplate.queryForObject("select * from post_metadata where IdPostMetadata =?", parametersArray, new PostmetadataMapper());
	} 
	
}
