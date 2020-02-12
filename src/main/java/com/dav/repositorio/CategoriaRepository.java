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

import com.dav.mapper.CategoriaMapper;
import com.dav.model.Categoria;

/**
 * @author Dhartel
 *
 */
@Repository
public class CategoriaRepository implements CategoriaRep, BaseRepBusq<Categoria>  {

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
	public boolean save(Categoria object) {
		StringBuilder sqlBuilder = new StringBuilder("insert into categoria  ( Nombre, Descripcion");
		Object[] arrayParametros = extractToInsert(object, sqlBuilder);
		try {
			String sql = String.format(
					sqlBuilder.toString(),arrayParametros);
			jdbcTemplate.execute(sql);
			return Boolean.TRUE;
		} catch(Exception e) {
			logger.fatal("dio error "+e);
			return Boolean.FALSE;
		}
	}

	private Object[] extractToInsert(Categoria object, StringBuilder sqlBuilder) {
		String  valorCodSup = "";
		Object [] arrayParametros;
		if(object.getCategoriaSuperior() == null) {
			sqlBuilder.append(")");
			valorCodSup = ")";
			arrayParametros = new Object[]{object.getNombre(), object.getDescripcion()};
		}else {
			sqlBuilder.append(", CategoriaSuperior) ");
			valorCodSup = ", '%d') ";
			arrayParametros = new Object[]{object.getNombre(), object.getDescripcion(), object.getCategoriaSuperior()};
		}
		sqlBuilder.append(" values ('%s', '%s'");
		
		sqlBuilder.append(valorCodSup);
		return arrayParametros;
	}

	
	@Override
	public boolean update(Categoria object) {
		if(object.getIdCategoria() != null) {
			StringBuilder sqlBuilder = new StringBuilder("update categoria set Nombre ='%s' , Descripcion ='%s' ");
			Object[] arrayParametros = extractToModificar(object, sqlBuilder);
			String sql = String.format(
					sqlBuilder.toString(), arrayParametros);
				jdbcTemplate.execute(sql);
				return Boolean.TRUE;
		}
		return  Boolean.FALSE;
	}

	private Object[] extractToModificar(Categoria object, StringBuilder sqlBuilder) {
		Object [] arrayParametros;
		if(object.getCategoriaSuperior() == null) {
			arrayParametros = new Object[]{object.getNombre(), object.getDescripcion(), object.getIdCategoria()};
		}else {
			sqlBuilder.append(", CategoriaSuperior='%d' ");
			arrayParametros = new Object[]{object.getNombre(), object.getDescripcion(), object.getCategoriaSuperior(), object.getIdCategoria()};
		}
		sqlBuilder.append(" where IdCategoria ='%d' ");
		return arrayParametros;
	}
	
	@Override
	public List<Categoria> findAll(Pageable pageable) {
		return jdbcTemplate.query("select * from categoria", new CategoriaMapper());
	}

	@Override
	public Categoria findById(long id) {
		Object [] parametersArray = new Object [] {id};
		return jdbcTemplate.queryForObject("select * from categoria where IdCategoria =?", parametersArray, new CategoriaMapper());
	}

	@Override
	public boolean deleteById(int id) {
		try {
		String sql = String.format("delete from Categoria where IdCategoria='id'", id);
		jdbcTemplate.execute(sql);
		return true;
		} catch (Exception e) {
			return false;
		}
	} 
	
}
