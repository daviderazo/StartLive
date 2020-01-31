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
import com.dav.model.Post;
import com.dav.repositorio.PostRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class PostRepositoryTest implements MetodosPruebas {
	private Log logger = LogFactory.getLog(getClass()); 
	@Autowired
	private PostRepository postRepository;
	@Test
	@Override
	public void testInsert() {
		Post  obj = new Post();
		obj.setTitulo("dara");
		obj.setCategoria(2L);
		obj.setExtracto("desdes");
		obj.setIdUsuarioPost(1L);
		obj.setTipo("desdesd");
		obj.setFontIco("fon");
		
		boolean result =  postRepository.save(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");
	}
	@Test
	@Override
	public void testModificar() {
		Post  obj = new Post();
		obj.setTitulo("dara");
		obj.setCategoria(2L);
		obj.setExtracto("desdes");
		obj.setIdUsuarioPost(1L);
		obj.setTipo("desdesd");
		obj.setFontIco("fon font-f");
		obj.setIdPost(1L);
		boolean result =  postRepository.update(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");

	}
	@Test
	@Override
	public void buscarTodos() {
		List<Post>  list = postRepository.findAll(null);
		logger.info(list);

	}
	@Test
	@Override
	public void buscarID() {
		Post  obj =  postRepository.findById(1);
		logger.info(obj);

	}

}
