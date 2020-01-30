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

import com.dav.mapper.UsuariometadataMapper;
import com.dav.model.UsuarioMetadata;

/**
 * @author Dhartel
 *
 */
//@Repository
public class UsuarioMetadataRepository implements UsuarioMetadataRep, BaseRepBusq<UsuarioMetadata> {

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
	public boolean save(UsuarioMetadata object) {
		try {
			String sql = String.format(
				"insert into  usuario_metadata ( Clave, Valor, Tipo, IdUsuario) "
				+ "values ('%s', '%s', '%s', '%d')",
				object.getClave(), object.getValor(), object.getTipo(), object.getIdUsuario());
			jdbcTemplate.execute(sql);
			return Boolean.TRUE;
		} catch(Exception e) {
			logger.fatal("dio error "+e);
			return Boolean.FALSE;
		}
	}

	@Override
	public boolean update(UsuarioMetadata object) {
		if(object.getIdUsuarioMetadata() != null) {
			String sql = String.format(
					"update usuario_metadata set Clave ='%s' , Valor ='%s', Tipo ='%s', IdUsuario='%d' "
					+ " where IdUsuarioMetadata ='%d' ",
					object.getClave(), object.getValor(), object.getTipo(), object.getIdUsuario(), object.getIdUsuarioMetadata() );
				jdbcTemplate.execute(sql);
				return Boolean.TRUE;
		}
		return  Boolean.FALSE;
	}

	@Override
	public List<UsuarioMetadata> findAll(Pageable pageable) {
		return jdbcTemplate.query("select * from usuario_metadata", new UsuariometadataMapper());
	}

	@Override
	public UsuarioMetadata findById(long id) {
		Object [] parametersArray = new Object [] {id};
		return jdbcTemplate.queryForObject("select * from usuario_metadata where IdUsuarioMetadata =?", parametersArray, new UsuariometadataMapper());
	} 
	
}
