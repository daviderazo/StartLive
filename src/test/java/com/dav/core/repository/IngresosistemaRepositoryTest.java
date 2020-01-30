/**
 * 
 */
package com.dav.core.repository;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
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
import com.dav.model.Ingresosistema;
import com.dav.repositorio.IngresosistemaRepository;

/**
 * @author Dhartel
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class IngresosistemaRepositoryTest implements MetodosPruebas {
	private Log logger = LogFactory.getLog(getClass()); 
	@Autowired
	private IngresosistemaRepository ingresosistemaRepository;
	@Test
	@Override
	public void testInsert() {
		Ingresosistema obj = new Ingresosistema();
		obj.setCodigoTipoDispositivo("D01");
		obj.setIdGrupo(1L);
		obj.setIdUsuario(1L);
		obj.setValortipoDispocitivo("A001");
		boolean result =  ingresosistemaRepository.save(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");

	}
	@Test
	@Override
	public void testModificar() {
		Ingresosistema obj = new Ingresosistema();
		obj.setCodigoTipoDispositivo("D01");
		obj.setIdGrupo(1L);
		obj.setIdUsuario(1L);
		obj.setValortipoDispocitivo("A001");
		
		obj.setFechaSalida(LocalDateTime.now());
		LocalDateTime fechaInicio = LocalDateTime.of(2020,  1,29, 11,15,00);
		Instant intaninicio = fechaInicio.atZone(ZoneId.systemDefault()).toInstant();
		Long duracionsistema = Duration.between(intaninicio, Instant.now()).toMillis();
		obj.setTiempoSistema(duracionsistema);
		
		boolean result =  ingresosistemaRepository.update(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");

	}
	@Test
	@Override
	public void buscarTodos() {
		List<Ingresosistema> list = ingresosistemaRepository.findAll(null);
		logger.info(list);

	}
	@Test
	@Override
	public void buscarID() {
		Ingresosistema obj =  ingresosistemaRepository.findById(1);
		logger.info(obj);
		boolean actualizar = false;
		if(actualizar) {
			buscandoActualizando(obj);
		}
	}
	private void buscandoActualizando(Ingresosistema obj) {
		obj.setFechaSalida(LocalDateTime.now());
		
		Instant intaninicio = obj.getFechaingreso().atZone(ZoneId.systemDefault()).toInstant();
		Long duracionsistema = Duration.between(intaninicio, Instant.now()).toMillis();
		obj.setTiempoSistema(duracionsistema);
		logger.info(duracionsistema);
		
		boolean result =  ingresosistemaRepository.update(obj);
		Assert.isTrue(result, "Es el valor error ");
		logger.info("aca");
	}

}
