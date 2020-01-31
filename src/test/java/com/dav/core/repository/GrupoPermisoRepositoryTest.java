/**
 * 
 */
package com.dav.core.repository;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import com.dav.component.TestDatabaseConfiguration;
import com.dav.model.GrupoPermiso;
import com.dav.repositorio.GrupoPermisoRepository;

/**
 * @author Dhartel
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class GrupoPermisoRepositoryTest implements MetodosPruebas {
	private Log logger = LogFactory.getLog(getClass()); 
	@Autowired
	private GrupoPermisoRepository grupoPermisoRepository;
	@Test
	@Override
	public void testInsert() {
		GrupoPermiso obj = new GrupoPermiso();
		obj.setIdGrupo(1L);
		obj.setIdPermiso(2L);
		obj.setEstado(Boolean.TRUE);
		
		
		boolean result =  grupoPermisoRepository.save(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");
	}
	@Test
	@Override
	public void testModificar() {
		GrupoPermiso obj = new GrupoPermiso();
		obj.setIdGrupo(1L);
		obj.setIdPermiso(2L);
		obj.setEstado(Boolean.TRUE);
		boolean result =  grupoPermisoRepository.update(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");

	}
	@Test
	@Override
	public void buscarTodos() {
		List<GrupoPermiso> list = grupoPermisoRepository.findAll(null);
		logger.info(list);

	}
	@Test
	@Override
	public void buscarID() {
		GrupoPermiso obj =  grupoPermisoRepository.findById(1,2);
		logger.info(obj);

	}

}
