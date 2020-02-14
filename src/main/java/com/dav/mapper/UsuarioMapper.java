/**
 * 
 */
package com.dav.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dav.common.TimeConvertTypes;
import com.dav.model.CatalogoValor;
import com.dav.model.Grupo;
import com.dav.model.Usuario;

/**
 * @author Dhartel
 *
 */
public class UsuarioMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario  usuario = new Usuario();
		usuario.setApellido(rs.getString("Apellido"));
		usuario.setContrasena(rs.getString("Contrasena"));
		usuario.setCorreo(rs.getString("Correo"));
		usuario.setFontIco(rs.getString("FontIco"));
		usuario.setIdGrupo(rs.getLong("IdGrupo"));
		usuario.setIdUsuario(rs.getLong("IdUsuario"));
		usuario.setNombre(rs.getString("nombreUs"));
		usuario.setFecha(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fechaUs")));
		usuario.setEstado(rs.getBoolean("estadoUs"));
		usuario.setIsEncryted(rs.getString("IsEncryted"));
		usuario.setFechaExpiracion(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fechaExpiracion")));
		usuario.setCodigoTipoUsuarioSecurity(rs.getString("CodigoTipoUsuarioSecurity"));
		usuario.setValorTipoUsuarioSecurity(rs.getString("ValorTipoUsuarioSecurity"));
		usuario.setFechaModificacion(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("FechaModificacionUs")));
		
		usuario.setGrupo(new Grupo());
		usuario.getGrupo().setNombre(rs.getString("NombreGp"));
		usuario.getGrupo().setIdGrupo(rs.getLong("IdGrupo"));
		usuario.getGrupo().setEstado(rs.getBoolean("estadoGp"));
		usuario.getGrupo().setFecha(TimeConvertTypes.getLocalDateTimeOfTimestamp(rs.getTimestamp("fechaGp")));
		
		usuario.setCatValor(new CatalogoValor());
		usuario.getCatValor().setCodigoCatalogoTipo(rs.getString("CodigoTipoUsuarioSecurity"));
		usuario.getCatValor().setCodigoValorCatalogo(rs.getString("ValorTipoUsuarioSecurity"));
		usuario.getCatValor().setTipoDatoValor(rs.getString("TipoDatoValor"));
		usuario.getCatValor().setValorCatalogo(rs.getString("ValorCatalogo"));
		usuario.getCatValor().setEstado(rs.getBoolean("estadoCV"));
		usuario.getCatValor().setColor(rs.getString("Color"));
		usuario.getCatValor().setDescripcionCatalogo(rs.getString("DescripcionCatalogo"));
		usuario.getCatValor().setFontIco(rs.getString("FontIco"));
		
				
		
		return usuario;
	}

}
