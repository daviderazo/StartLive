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
import com.dav.model.CatalogoValor;
import com.dav.repositorio.CatalogoValorRepository;

/**
 * @author Dhartel
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class CatalogoValorResositoryTest implements MetodosPruebas {

private Log logger= LogFactory.getLog(getClass()); 
	
	@Autowired
	private CatalogoValorRepository catalogoValorRepository;
	
	@Test
	public void testInsert() {
		CatalogoValor catVal = new CatalogoValor();
		catVal.setCodigoCatalogoTipo("D01");
		catVal.setCodigoValorCatalogo("A001");
		catVal.setNombreCatalogoValor("Windows");
		catVal.setValorCatalogo("Windows Home");
		catVal.setTipoDatoValor("String");
		catVal.setDescripcionCatalogo("Windows Home");
		boolean result = catalogoValorRepository.save(catVal);
		
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");
	}
	@Test
	@Override
	public void testModificar() {
		CatalogoValor catVal = new CatalogoValor();
		catVal.setCodigoCatalogoTipo("D01");
		catVal.setCodigoValorCatalogo("A001");
		catVal.setNombreCatalogoValor("Windows");
		catVal.setValorCatalogo("Windows Home");
		catVal.setTipoDatoValor("String");
		catVal.setDescripcionCatalogo("Windows Home");
		boolean result = catalogoValorRepository.update(catVal);
		
		Assert.isTrue(result, "Es el valor error ");
		
	}
	@Test
	@Override
	public void buscarTodos() {
		List<CatalogoValor> list = catalogoValorRepository.findAll(null);
		logger.info(list);
	}
	@Test
	@Override
	public void buscarID() {
		CatalogoValor catVal = new CatalogoValor();
		catVal.setCodigoValorCatalogo("A001");
		CatalogoValor obj =  catalogoValorRepository.findById(catVal.getCodigoValorCatalogo());
		logger.info(obj);
	}
	
	
}
