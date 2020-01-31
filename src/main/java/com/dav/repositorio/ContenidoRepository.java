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

import com.dav.mapper.ContenidoMapper;
import com.dav.model.Contenido;

/**
 * @author Dhartel
 *
 */
@Repository
public class ContenidoRepository implements ContenidoRep, BaseRepBusq<Contenido> {

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
	public boolean save(Contenido object) {
		try {
			String sql = String.format(
				"insert into  contenido ( Tipo, Contenido, IdPost) "
				+ "values ('%s', '%s', '%d')",
				object.getTipo(), object.getContenidoDes(), object.getIdPost());
			jdbcTemplate.execute(sql);
			return Boolean.TRUE;
		} catch(Exception e) {
			logger.fatal("dio error "+e);
			return Boolean.FALSE;
		}
	}

	@Override
	public boolean update(Contenido object) {
		if(object.getIdContenido() != null) {
			String sql = String.format(
					"update contenido set Tipo ='%s' , Contenido ='%s' , IdPost='%d'"
					+ " where IdContenido ='%d' ",
					object.getTipo(), object.getContenidoDes(), object.getIdPost(), object.getIdContenido());
				jdbcTemplate.execute(sql);
				return Boolean.TRUE;
		}
		return  Boolean.FALSE;
	}

	@Override
	public List<Contenido> findAll(Pageable pageable) {
		return jdbcTemplate.query("select * from contenido", new ContenidoMapper());
	}

	@Override
	public Contenido findById(long id) {
		Object [] parametersArray = new Object [] {id};
		return jdbcTemplate.queryForObject("select * from contenido where IdContenido =?", parametersArray, new ContenidoMapper());
	} 
	
}
