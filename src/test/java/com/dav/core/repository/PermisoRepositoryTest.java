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
import com.dav.model.Permiso;
import com.dav.repositorio.PermisoRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class PermisoRepositoryTest implements MetodosPruebas {
	private Log logger = LogFactory.getLog(getClass()); 
	@Autowired
	private PermisoRepository permisoRepository;
	@Test
	@Override
	public void testInsert() {
		Permiso  obj = new Permiso();
		obj.setNombre("Operativo");
		boolean result =  permisoRepository.save(obj);
		Assert.isTrue(result, "Es el valor error ");
		obj = new Permiso();
		obj.setNombre("Administrativo");
		result =  permisoRepository.save(obj);
		Assert.isTrue(result, "Es el valor error ");
		obj = new Permiso();
		obj.setNombre("Usuario");
		result =  permisoRepository.save(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");
	}
	@Test
	@Override
	public void testModificar() {
		Permiso  obj = new Permiso();
		obj.setNombre("patos");
		obj.setIdPermiso(2L);
		boolean result =  permisoRepository.update(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");

	}
	@Test
	@Override
	public void buscarTodos() {
		List<Permiso> list = permisoRepository.findAll(null);
		logger.info(list);

	}
	@Test
	@Override
	public void buscarID() {
		Permiso obj =  permisoRepository.findById(3);
		logger.info(obj);

	}

}
