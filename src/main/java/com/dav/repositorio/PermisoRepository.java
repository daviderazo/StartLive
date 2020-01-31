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

import com.dav.mapper.PermisoMapper;
import com.dav.model.Permiso;

/**
 * @author Dhartel
 *
 */
@Repository
public class PermisoRepository implements PermisoRep, BaseRepBusq<Permiso> {

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
	public boolean save(Permiso object) {
		try {
			String sql = String.format(
				"insert into  permiso	 ( Nombre) "
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
	public boolean update(Permiso object) {
		if(object.getIdPermiso()!= null) {
			String sql = String.format(
					"update permiso set Nombre ='%s'  "
					+ " where IdPermiso ='%d' ",
					object.getNombre(), object.getIdPermiso());
				jdbcTemplate.execute(sql);
				return Boolean.TRUE;
		}
		return  Boolean.FALSE;
	}

	@Override
	public List<Permiso> findAll(Pageable pageable) {
		return jdbcTemplate.query("select * from permiso", new PermisoMapper());
	}

	@Override
	public Permiso findById(long id) {
		Object [] parametersArray = new Object [] {id};
		return jdbcTemplate.queryForObject("select * from permiso where IdPermiso =?", parametersArray, new PermisoMapper());
	} 
	
	public void deleteAll() {
		jdbcTemplate.execute("delete from permiso");
	}
	
	public boolean deleteById(int id) {
		try {
			String sql = String.format("delete from permiso where IdPermiso = '%d' ", id);
			jdbcTemplate.execute(sql);
			return Boolean.TRUE;
		}catch(Exception e) {
			return Boolean.FALSE; 
		}
	}
}
