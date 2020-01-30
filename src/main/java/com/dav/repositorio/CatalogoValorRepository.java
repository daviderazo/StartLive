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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dav.mapper.CatalogoValorMapper;
import com.dav.model.CatalogoValor;

/**
 * @author Dhartel
 *
 */
//@Repository
public class CatalogoValorRepository implements CatalogoValorRep {
	//para ka pruebas
	private Log logger= LogFactory.getLog(getClass()); 
	@Autowired
	private DataSource dataSource;
	@PostConstruct
	public void postcontruct() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		logger.info("iniciado postc");
	}
	
	//@Autowired
	private JdbcTemplate  jdbcTemplate;

	@Override
	public boolean save(CatalogoValor object) {
		Boolean retorno = Boolean.FALSE;
		try {
			if(object.getCodigoCatalogoTipo() != null) {
				String sql = String.format(
						"insert into catalogo_valor ( NombreCatalogoValor, DescripcionCatalogo, CodigoValorCatalogo, ValorCatalogo, TipoDatoValor, Color, FontIco, CodigoCatalogoTipo) "
								+ "values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s') ",
						object.getNombreCatalogoValor(), object.getDescripcionCatalogo(), object.getCodigoValorCatalogo(),
						object.getValorCatalogo(), object.getTipoDatoValor(), object.getColor(), object.getFontIco(),
						object.getCodigoCatalogoTipo());
				jdbcTemplate.execute(sql);
				retorno = Boolean.TRUE;
			}
		}catch (DataIntegrityViolationException e) {
			logger.fatal("Esta vialando la integridadad referencial verifique la informacion que envia");
			logger.fatal(e);
		    
		} catch( Exception e) {
			logger.fatal("dio error "+e);
		}
		return retorno;
	}

	@Override
	public boolean update(CatalogoValor object) {
		if(object.getCodigoCatalogoTipo() != null) {
			String sql = String.format(
					"update catalogo_valor set NombreCatalogoValor ='%s' , DescripcionCatalogo='%s' , ValorCatalogo='%s', TipoDatoValor='%s', Color='%s', FontIco='%s'"
					+ " where CodigoCatalogoTipo ='%s' and CodigoValorCatalogo ='%s' ",
					object.getNombreCatalogoValor(), object.getDescripcionCatalogo(), object.getValorCatalogo(), object.getTipoDatoValor(), object.getColor(), object.getFontIco(),
					object.getCodigoCatalogoTipo(), object.getCodigoValorCatalogo());
				jdbcTemplate.execute(sql);
				return true;
		}
		return false;
	}

	@Override
	public List<CatalogoValor> findAll(Pageable pageable) {
		return jdbcTemplate.query("select * from catalogo_valor", new CatalogoValorMapper());
	}

	@Override
	public CatalogoValor findById(String id) {
		Object [] parametersArray = new Object [] {id};
		return jdbcTemplate.queryForObject("select * from catalogo_valor where CodigoValorCatalogo =?", parametersArray, new CatalogoValorMapper());
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
