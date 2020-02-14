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
import org.springframework.stereotype.Repository;

import com.dav.mapper.CatalogoValorMapper;
import com.dav.model.CatalogoValor;

import lombok.Setter;

/**
 * @author Dhartel
 *
 */
@Repository
@Setter
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
		StringBuilder sentencia =new StringBuilder("select * from catalogo_valor cv ");
		sentencia.append("inner join catalogo_tipo ct on cv.CodigoCatalogoTipo = ct.CodigoCatalogoTipo");
		return jdbcTemplate.query(sentencia.toString(), new CatalogoValorMapper());
	}

	@Override
	public CatalogoValor findById(String id) {
		Object [] parametersArray = new Object [] {id};
		return jdbcTemplate.queryForObject("select * from catalogo_valor where CodigoValorCatalogo =?", parametersArray, new CatalogoValorMapper());
	}
	
	

	@Override
	public List<CatalogoValor> findByIdPadre(String id) {
		Object [] parametersArray = new Object [] {id};
		StringBuilder sentencia = new StringBuilder("select * from catalogo_valor cv ");
		sentencia.append("inner join catalogo_tipo ct on cv.CodigoCatalogoTipo = ct.CodigoCatalogoTipo");
		sentencia.append(" where cv.CodigoCatalogoTipo =?");
		return jdbcTemplate.query( sentencia.toString(), parametersArray, new CatalogoValorMapper());
	}
}
