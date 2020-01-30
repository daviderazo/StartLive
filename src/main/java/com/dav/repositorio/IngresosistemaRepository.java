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

import com.dav.mapper.IngresosistemaMapper;
import com.dav.model.Ingresosistema;

/**
 * @author Dhartel
 *
 */
//@Repository
public class IngresosistemaRepository implements IngresosistemaRep, BaseRepBusq<Ingresosistema> {

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
	public boolean save(Ingresosistema object) {
		try {
			String sql = String.format(
				"insert into ingreso_sistema  ( IdUsuario, IdGrupo, ValorTipoDispositovo, CodigoTipoDispositivo ) "
				+ "values ('%d', '%d', '%s', '%s')",
				object.getIdUsuario(), object.getIdGrupo(), object.getValortipoDispocitivo(), object.getCodigoTipoDispositivo());
			jdbcTemplate.execute(sql);
			return Boolean.TRUE;
		} catch(Exception e) {
			logger.fatal("dio error "+e);
			return Boolean.FALSE;
		}
	}

	@Override
	public boolean update(Ingresosistema object) {
		if(object.getIdIngresoSistema() != null) {
			String sql = String.format(
					"update ingreso_sistema set FechaSalida ='%s' , TiempoSistema ='%d' "
					+ " where IdIngresoSistema ='%d' ",
					object.getFechaSalida(), object.getTiempoSistema(), object.getIdIngresoSistema());
				jdbcTemplate.execute(sql);
				return Boolean.TRUE;
		}
		return  Boolean.FALSE;
	}

	@Override
	public List<Ingresosistema> findAll(Pageable pageable) {
		return jdbcTemplate.query("select * from ingreso_sistema", new IngresosistemaMapper());
	}

	@Override
	public Ingresosistema findById(long id) {
		Object [] parametersArray = new Object [] {id};
		return jdbcTemplate.queryForObject("select * from ingreso_sistema where IdIngresoSistema =?", parametersArray, new IngresosistemaMapper());
	} 
	
}
