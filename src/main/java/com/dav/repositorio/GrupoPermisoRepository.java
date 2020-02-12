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

import com.dav.common.UtilVariables;
import com.dav.mapper.GrupoPermisoMapper;
import com.dav.model.GrupoPermiso;

/**
 * @author Dhartel
 *
 */
@Repository
public class GrupoPermisoRepository implements GrupoPermisoRep {
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
	public boolean save(GrupoPermiso object) {
		try {
			String sql = String.format(
				"insert into  grupo_permiso ( IdGrupo, IdPermiso, estado) "
				+ "values ('%d', '%d', '%s')",
				object.getIdGrupo(), object.getIdPermiso(), UtilVariables.valorString(object));
			jdbcTemplate.execute(sql);
			return Boolean.TRUE;
		} catch(Exception e) {
			logger.fatal("dio error "+e);
			return Boolean.FALSE;
		}
	}

	

	@Override
	public boolean update(GrupoPermiso object) {
		try {
			if(object.getIdGrupo() != null && object.getIdPermiso() != null) {
				String sql = String.format(
						"update grupo_permiso set estado ='%s'  "
						+ " where IdGrupo ='%d'and IdPermiso='%d'  ",
						UtilVariables.valorString(object), object.getIdGrupo(), object.getIdPermiso());
					jdbcTemplate.execute(sql);
					return Boolean.TRUE;
			}
		}catch(Exception e) {
			logger.fatal("dio error "+e);
		}
		return  Boolean.FALSE;
	}

	@Override
	public List<GrupoPermiso> findAll(Pageable pageable) {
		return jdbcTemplate.query("select * from grupo_permiso", new GrupoPermisoMapper());
	}

	@Override
	public GrupoPermiso findById(long... id ) {
		Object [] parametersArray = new Object [] {id[0], id[1]};
		return jdbcTemplate.queryForObject("select gp.IdGrupo, gp.IdPermiso, gp.estado as EstadoGP, gp.fecha as fechaGP, p.nombre, p.fecha as fechaP, p.estado as EstadoP  from grupo_permiso where gp.IdGrupo =? and gp.IdPermiso=?", parametersArray, new GrupoPermisoMapper());
	}
	@Override
	public List<GrupoPermiso> findById(long  id ) {
		Object [] parametersArray = new Object [] {id};
		StringBuilder query = new StringBuilder("select gp.IdGrupo, gp.IdPermiso, gp.estado as EstadoGP, gp.fecha as fechaGP, p.nombre, p.fecha as fechaP, p.estado as EstadoP from grupo_permiso gp ");
		query.append(" inner join permiso p on gp.idpermiso = p.idpermiso where gp.IdGrupo =? ");
		
		return jdbcTemplate.query(query.toString(), parametersArray, new GrupoPermisoMapper());
	}
}
