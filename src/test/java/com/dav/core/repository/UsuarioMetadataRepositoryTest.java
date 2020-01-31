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
import com.dav.model.UsuarioMetadata;
import com.dav.repositorio.UsuarioMetadataRepository;

/**
 * @author Dhartel
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class UsuarioMetadataRepositoryTest implements MetodosPruebas {

	private Log logger = LogFactory.getLog(getClass()); 
	@Autowired
	private  UsuarioMetadataRepository usuarioMetadataRepository;
	@Test
	@Override
	public void testInsert() {
		UsuarioMetadata   obj = new  UsuarioMetadata();
		obj.setClave("valor");
		obj.setIdUsuario(1L);
		obj.setTipo("corazon");
		obj.setValor("ilusion");
		boolean result =  usuarioMetadataRepository.save(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");

	}
	@Test
	@Override
	public void testModificar() {
		UsuarioMetadata   obj = new  UsuarioMetadata();
		obj.setClave("valor adelante");
		obj.setIdUsuario(1L);
		obj.setTipo("corazon aa");
		obj.setValor("ilusion");
		obj.setIdUsuarioMetadata(1L);
		boolean result =  usuarioMetadataRepository.update(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");

	}
	@Test
	@Override
	public void buscarTodos() {
		 
		List<UsuarioMetadata> list = usuarioMetadataRepository.findAll(null);
		logger.info(list);
	}
	@Test
	@Override
	public void buscarID() {
		UsuarioMetadata obj =  usuarioMetadataRepository.findById(1);
		logger.info(obj);

	}

}
