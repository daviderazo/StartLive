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

import com.dav.common.TimeConvertTypes;
import com.dav.common.UtilVariables;
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
	
	private final StringBuilder query = new StringBuilder("select u.IdUsuario, u.Nombre as nombreUs, u.Apellido, u.Contrasena, ")
	.append("u.Correo, u.FontIco, u.FontIco, u.fecha as fechaUs, u.estado as estadoUs, g.estado as estadoGp, ")
	.append(" u.IdGrupo, g.fecha as fechaGp, g.Nombre as NombreGp,  ")
	.append(" u.IsEncryted, u.fechaModificacion as FechaModificacionUs, u.fechaExpiracion, u.ValorTipoUsuarioSecurity, u.CodigoTipoUsuarioSecurity, ")
	.append(" cv.ValorCatalogo, cv.TipoDatoValor, cv.NombreCatalogoValor, cv.DescripcionCatalogo, cv.Color, cv.FontIco, cv.estado as estadoCV")
	.append(" from usuario u  inner join grupo g on u.IdGrupo = g.IdGrupo ")
	.append(" inner join catalogo_valor cv on u.ValorTipoUsuarioSecurity = cv.CodigoValorCatalogo and u.CodigoTipoUsuarioSecurity = cv.CodigoCatalogoTipo");
	
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
					"insert into usuario  ( Nombre, Apellido, Contrasena, Correo, FontIco, IdGrupo, estado, fechaExpiracion, ValorTipoUsuarioSecurity, CodigoTipoUsuarioSecurity, IsEncryted) "
							+ "values ('%s', '%s', '%s', '%s', '%s', '%d',  '%s', '%s','%s','%s', '%s')",
					object.getNombre(), object.getApellido(), object.getContrasena(), object.getCorreo(),
					object.getFontIco(), object.getIdGrupo(), UtilVariables.valorString(object),
					TimeConvertTypes.dateStringFormat(object.getFechaExpiracion()),
					object.getValorTipoUsuarioSecurity(), object.getCodigoTipoUsuarioSecurity(),
					object.getIsEncryted());
			jdbcTemplate.execute(sql);
			return Boolean.TRUE;
		} catch (Exception e) {
			logger.fatal("dio error " + e);
			return Boolean.FALSE;
		}
	}

	@Override
	public boolean update(Usuario object) {
		if (object.getIdUsuario() != null) {
			String sql = String.format(
					"update usuario set Nombre='%s', Apellido='%s', Contrasena='%s', Correo='%s', FontIco='%s', IdGrupo ='%d', estado='%s', fechaExpiracion='%s', fechaModificacion='%s', ValorTipoUsuarioSecurity='%s', CodigoTipoUsuarioSecurity='%s', IsEncryted='%s'  "
							+ " where IdUsuario ='%d' ",
					object.getNombre(), object.getApellido(), object.getContrasena(), object.getCorreo(),
					object.getFontIco(), object.getIdGrupo(), UtilVariables.valorString(object),
					TimeConvertTypes.dateStringFormat(object.getFechaModificacion()),
					TimeConvertTypes.dateStringFormat(object.getFechaExpiracion()),
					object.getValorTipoUsuarioSecurity(), object.getCodigoTipoUsuarioSecurity(), object.getIsEncryted(),
					object.getIdUsuario());
			jdbcTemplate.execute(sql);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public List<Usuario> findAll(Pageable pageable) {
		String sqlquery = query.toString();
		
		
		return jdbcTemplate.query(sqlquery, new UsuarioMapper());
	}

	@Override
	public Usuario findById(long id) {
		Object [] parametersArray = new Object [] {id};
		String sqlquery = query.toString() + " where u.IdUsuario =? ";
		return jdbcTemplate.queryForObject(sqlquery, parametersArray, new UsuarioMapper());
	}

	@Override
	public Usuario findByNombre(String nombre) {
		Object [] parametersArray = new Object [] {nombre};
		String sqlquery = query.toString() + " where u.Nombre =? ";
		return jdbcTemplate.queryForObject(sqlquery, parametersArray, new UsuarioMapper());
		
	} 
	
}
