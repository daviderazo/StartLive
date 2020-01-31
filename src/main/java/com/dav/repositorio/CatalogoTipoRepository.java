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

import com.dav.mapper.CatalogoTipoMapper;
import com.dav.model.CatalogoTipo;

/**
 * @author Dhartel
 *
 */
@Repository
public class CatalogoTipoRepository implements CatalogoTipoRep 
{
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
	public boolean save(CatalogoTipo cataTipo) {
		try {
			String sql = String.format(
				"insert into catalogo_tipo (CodigoCatalogoTipo,  NombreCatalogoTipo, DescripcionCatalogo) "
				+ "values ('%s','%s', '%s')",
				cataTipo.getCodigoCatalogoTipo(), cataTipo.getNombreCatalogoTipo(), cataTipo.getDescripcionCatalogo());
			jdbcTemplate.execute(sql);
			
			return Boolean.TRUE;
		} catch(Exception e) {
			logger.fatal("dio error "+e);
			return Boolean.FALSE;
		}
		
	}

	@Override
	public boolean update(CatalogoTipo cataTipo) {
		if(cataTipo.getCodigoCatalogoTipo() != null) {
			String sql = String.format(
					"update catalogo_tipo set NombreCatalogoTipo ='%s' , DescripcionCatalogo ='%s' "
					+ " where CodigoCatalogoTipo ='%s' ",
					cataTipo.getNombreCatalogoTipo(), cataTipo.getDescripcionCatalogo(), cataTipo.getCodigoCatalogoTipo());
				jdbcTemplate.execute(sql);
				return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public List<CatalogoTipo> findAll(Pageable pageable) {
		
		return jdbcTemplate.query("select * from catalogo_tipo", new CatalogoTipoMapper());
	}

	@Override
	public CatalogoTipo findById(String id) {
		Object [] parametersArray = new Object [] {id};
		return jdbcTemplate.queryForObject("select * from catalogo_tipo where CodigoCatalogoTipo =?", parametersArray, new CatalogoTipoMapper());
	}


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

		
	
}
