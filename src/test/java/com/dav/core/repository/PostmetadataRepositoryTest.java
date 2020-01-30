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
import com.dav.model.Postmetadata;
import com.dav.repositorio.PostmetadataRepository;

/**
 * @author Dhartel
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class PostmetadataRepositoryTest implements MetodosPruebas {
	private Log logger = LogFactory.getLog(getClass()); 
	@Autowired
	private PostmetadataRepository postmetadataRepository;
	@Test
	@Override
	public void testInsert() {
		Postmetadata   obj = new   Postmetadata(); 
		obj.setClave("inicio");
		obj.setIdPost(1L);
		obj.setTipo("ilustracion");
		obj.setValor("comienzo");
		
		boolean result =  postmetadataRepository.save(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");
	}
	@Test
	@Override
	public void testModificar() {
		Postmetadata   obj = new   Postmetadata(); 
		obj.setClave("inicio");
		obj.setIdPost(1L);
		obj.setTipo("ilustracion");
		obj.setValor("comienzo");
		obj.setIdPostMetadata(1L);
		boolean result =  postmetadataRepository.update(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");

	}
	@Test
	@Override
	public void buscarTodos() {
		List<Postmetadata> list = postmetadataRepository.findAll(null);
		logger.info(list);

	}
	@Test
	@Override
	public void buscarID() {
		Postmetadata obj =  postmetadataRepository.findById(1);
		logger.info(obj);

	}

}
