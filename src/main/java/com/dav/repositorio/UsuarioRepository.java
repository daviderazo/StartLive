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

import com.dav.mapper.UsuarioMapper;
import com.dav.model.Usuario;

/**
 * @author Dhartel
 *
 */
@Repository
public class UsuarioRepository implements UsuarioRep, BaseRepBusq<Usuario> {

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
	public boolean save(Usuario object) {
		try {
			String sql = String.format(
				"insert into usuario  ( Nombre, Apellido, Contrasena, Correo, FontIco, IdGrupo) "
				+ "values ('%s', '%s', '%s', '%s', '%s', '%d')",
				object.getNombre(), object.getApellido(),  object.getContrasena(),  object.getCorreo(),  object.getFontIco(),  object.getIdGrupo());
			jdbcTemplate.execute(sql);
			return Boolean.TRUE;
		} catch(Exception e) {
			logger.fatal("dio error "+e);
			return Boolean.FALSE;
		}
	}

	@Override
	public boolean update(Usuario object) {
		if(object.getIdUsuario() != null) {
			String sql = String.format(
					"update usuario set Nombre='%s', Apellido='%s', Contrasena='%s', Correo='%s', FontIco='%s', IdGrupo ='%d'  "
					+ " where IdUsuario ='%d' ",
					object.getNombre(), object.getApellido(),  object.getContrasena(),  object.getCorreo(),  object.getFontIco(),  object.getIdGrupo(), object.getIdUsuario());
				jdbcTemplate.execute(sql);
				return Boolean.TRUE;
		}
		return  Boolean.FALSE;
	}

	@Override
	public List<Usuario> findAll(Pageable pageable) {
		return jdbcTemplate.query("select * from usuario", new UsuarioMapper());
	}

	@Override
	public Usuario findById(long id) {
		Object [] parametersArray = new Object [] {id};
		return jdbcTemplate.queryForObject("select * from usuario where IdUsuario =?", parametersArray, new UsuarioMapper());
	} 
	
}
