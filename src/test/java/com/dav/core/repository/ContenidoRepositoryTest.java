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
import com.dav.model.Comentario;
import com.dav.model.Contenido;
import com.dav.repositorio.ContenidoRepository;

/**
 * @author Dhartel
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class ContenidoRepositoryTest implements MetodosPruebas {

	private Log logger = LogFactory.getLog(getClass()); 
	@Autowired
	private ContenidoRepository contenidoRepository;
	
	@Test
	@Override
	public void testInsert() {
		Contenido obj = new Contenido();
		obj.setContenidoDes("idilios de amor");
		obj.setIdPost(1L);
		obj.setTipo("amor");
		boolean result =  contenidoRepository.save(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");

	}
	@Test
	@Override
	public void testModificar() {
		Contenido obj = new Contenido();
		obj.setContenidoDes("idilios de amores");
		obj.setIdPost(1L);
		obj.setTipo("amores");
		obj.setIdContenido(1L);
		boolean result =  contenidoRepository.update(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");

	}
	@Test
	@Override
	public void buscarTodos() {
		List<Contenido> list = contenidoRepository.findAll(null);
		logger.info(list);

	}
	@Test
	@Override
	public void buscarID() {
		Contenido obj =  contenidoRepository.findById(1);
		logger.info(obj);

	}

}
