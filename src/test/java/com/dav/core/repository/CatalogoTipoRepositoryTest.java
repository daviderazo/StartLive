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
import com.dav.model.CatalogoTipo;
import com.dav.repositorio.CatalogoTipoRepository;

/**
 * @author Dhartel
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class CatalogoTipoRepositoryTest implements MetodosPruebas {
	private Log logger= LogFactory.getLog(getClass()); 
	
	@Autowired
	private CatalogoTipoRepository catalogoTipoRepository;
	
	@Test
	public void testInsert() {
		CatalogoTipo catatipo = new CatalogoTipo();
		catatipo.setNombreCatalogoTipo("Android");
		catatipo.setDescripcionCatalogo("Dispositivo Android");
		catatipo.setCodigoCatalogoTipo("D01");
		
		boolean result = catalogoTipoRepository.save(catatipo);
		
		Assert.isTrue(result, "Es el valor error ");
		
	
	}
	
	@Test
	public void testModificar() {
		CatalogoTipo catatipo = new CatalogoTipo();
		catatipo.setNombreCatalogoTipo("Celulares");
		catatipo.setDescripcionCatalogo("Dispositivos Celular");
		catatipo.setCodigoCatalogoTipo("D01");
		
		boolean result = catalogoTipoRepository.update(catatipo);
		
		Assert.isTrue(result, "Es el valor error ");
		
	
	}
	
	@Test
	public void buscarTodos( ) {
		List<CatalogoTipo> listCata = catalogoTipoRepository.findAll(null);
		logger.info(listCata);
		
	}
	
	@Test
	public void buscarID( ) {
		CatalogoTipo catatipo = new CatalogoTipo();
		catatipo.setCodigoCatalogoTipo("D02");
		
		CatalogoTipo cata = catalogoTipoRepository.findById(catatipo.getCodigoCatalogoTipo());
		logger.info(cata.getNombreCatalogoTipo());
		
	}
}
