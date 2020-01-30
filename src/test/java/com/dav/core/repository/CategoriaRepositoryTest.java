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
import com.dav.model.Categoria;
import com.dav.repositorio.CategoriaRepository;

/**
 * @author Dhartel
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class CategoriaRepositoryTest implements MetodosPruebas {
	
	private Log logger= LogFactory.getLog(getClass()); 
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Test
	@Override
	public void testInsert() {
		//extractedFirtsInsert();
		extractedSegundoNivelInsert();
	}
	private void extractedFirtsInsert() {
		Categoria obj = new Categoria();
		obj.setNombre("Deportes");
		obj.setDescripcion("Deportes s");
		boolean result =categoriaRepository.save(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");
	}
	
	private void extractedSegundoNivelInsert() {
		Categoria obj = new Categoria();
		obj.setNombre("Belleza");
		obj.setDescripcion("belleza uno");
		obj.setCategoriaSuperior(1L);
		boolean result =categoriaRepository.save(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");
	}
	
	@Test
	@Override
	public void testModificar() {
		Categoria obj = new Categoria();
//		primerModificacion(obj);
		segundaModificacion(obj);
		boolean result =categoriaRepository.update(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");

	}
	
	private void primerModificacion(Categoria obj) {
		obj.setNombre("Deportes extremos");
		obj.setDescripcion("Deportes sortf");
		obj.setIdCategoria(4L);
	}
	
	private void segundaModificacion(Categoria obj) {
		obj.setNombre("higiene");
		obj.setDescripcion("higiene");
		obj.setCategoriaSuperior(2L);
		obj.setIdCategoria(3L);
	}
	@Test
	@Override
	public void buscarTodos() {
		List<Categoria> list = categoriaRepository.findAll(null);
		logger.info(list);
	}
	@Test
	@Override
	public void buscarID() {
		Categoria obj =  categoriaRepository.findById(3);
		logger.info(obj);

	}

}
