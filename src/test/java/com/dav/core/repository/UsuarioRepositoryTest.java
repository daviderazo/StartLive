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
import com.dav.model.Usuario;
import com.dav.repositorio.UsuarioRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class UsuarioRepositoryTest implements MetodosPruebas {

	private Log logger = LogFactory.getLog(getClass()); 
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Test
	@Override
	public void testInsert() {
		Usuario  obj = new Usuario();
		obj.setApellido("Erazo");
		obj.setContrasena("1234");
		obj.setCorreo("ali@abc.com");
		obj.setIdGrupo(1L);
		obj.setNombre("David");
		
		boolean result =  usuarioRepository.save(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");
	}
	@Test
	@Override
	public void testModificar() {
		Usuario  obj = new Usuario();
		obj.setApellido("Erazo Pazmino");
		obj.setContrasena("1234");
		obj.setCorreo("ali@abc.com");
		obj.setIdGrupo(1L);
		obj.setNombre("David Ricardo");
		obj.setIdUsuario(1L);
		boolean result =  usuarioRepository.update(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");

	}
@Test
	@Override
	public void buscarTodos() {
		List<Usuario> list = usuarioRepository.findAll(null);
		logger.info(list);
	}
	@Test
	@Override
	public void buscarID() {
		Usuario obj =  usuarioRepository.findById(1);
		logger.info(obj);

	}

}
