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

import com.dav.mapper.GrupoMapper;
import com.dav.model.Grupo;

/**
 * @author Dhartel
 *
 */
@Repository
public class GrupoRepository implements GrupoRep, BaseRepBusq<Grupo> {

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
	public boolean save(Grupo object) {
		try {
			String sql = String.format(
				"insert into  grupo ( Nombre) "
				+ "values ('%s')",
				object.getNombre());
			jdbcTemplate.execute(sql);
			return Boolean.TRUE;
		} catch(Exception e) {
			logger.fatal("dio error "+e);
			return Boolean.FALSE;
		}
	}

	@Override
	public boolean update(Grupo object) {
		if(object.getIdGrupo() != null) {
			String sql = String.format(
					"update grupo set Nombre ='%s'  "
					+ " where IdGrupo ='%d' ",
					object.getNombre(), object.getIdGrupo());
				jdbcTemplate.execute(sql);
				return Boolean.TRUE;
		}
		return  Boolean.FALSE;
	}

	@Override
	public List<Grupo> findAll(Pageable pageable) {
		return jdbcTemplate.query("select * from grupo", new GrupoMapper());
	}

	@Override
	public Grupo findById(long id) {
		Object [] parametersArray = new Object [] {id};
		return jdbcTemplate.queryForObject("select * from grupo where IdGrupo =?", parametersArray, new GrupoMapper());
	}
	
}
