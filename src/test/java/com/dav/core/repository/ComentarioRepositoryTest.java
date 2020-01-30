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
import com.dav.repositorio.ComentarioRepository;

/**
 * @author Dhartel
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class ComentarioRepositoryTest implements MetodosPruebas {

	private Log logger = LogFactory.getLog(getClass()); 
	@Autowired
	private ComentarioRepository comentarioRepository; 
	@Test
	@Override
	public void testInsert() {
		Comentario  obj = new  Comentario();
		obj.setComentario("inivciado");
		obj.setIdPost(1L);
		obj.setIdUsuarioComentario(1L);
		obj.setRespuesta(1L);
		boolean result =  comentarioRepository.save(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");

	}
	@Test
	@Override
	public void testModificar() {
		Comentario  obj = new  Comentario();
		obj.setComentario("Inic sdas cio");
		obj.setIdPost(1L);
		obj.setIdUsuarioComentario(1L);
		obj.setIdComentario(2L);
		obj.setRespuesta(1L);
		
		boolean result =  comentarioRepository.update(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");

	}
	@Test
	@Override
	public void buscarTodos() {
		List<Comentario> list = comentarioRepository.findAll(null);
		logger.info(list);

	}
	@Test
	@Override
	public void buscarID() {
		Comentario obj =  comentarioRepository.findById(3);
			logger.info(obj);

	}

}
