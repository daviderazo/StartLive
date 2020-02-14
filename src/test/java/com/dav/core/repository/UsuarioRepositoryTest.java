package com.dav.core.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import com.dav.common.EnumEncrytedValues;
import com.dav.common.TimeConvertTypes;
import com.dav.component.SecurityConfiguration;
import com.dav.component.TestDatabaseConfiguration;
import com.dav.model.Usuario;
import com.dav.repositorio.UsuarioRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {TestDatabaseConfiguration.class, SecurityConfiguration.class})
public class UsuarioRepositoryTest implements MetodosPruebas {

	private Log logger = LogFactory.getLog(getClass()); 
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private BCryptPasswordEncoder byCrytEncode;
	
	@Test
	@Override
	public void testInsert() {
		Usuario  obj = new Usuario();
		obj.setApellido("Erazo");
		obj.setContrasena(byCrytEncode.encode("1234del@ABC.com"));
		obj.setIsEncryted(EnumEncrytedValues.ENCRYPTED.getValor());
		obj.setCorreo("ali@abc.com");
		obj.setIdGrupo(1L);
		obj.setNombre("Christian");
		obj.setEstado(Boolean.TRUE);
		obj.setValorTipoUsuarioSecurity("SPT02");
		obj.setCodigoTipoUsuarioSecurity("US02");
		LocalDateTime timeNow = LocalDateTime.now();
		obj.setFechaExpiracion(TimeConvertTypes.aumentarFecha(timeNow, 2592000L));
		
		logger.info("tamano: "+ obj.getContrasena().length());
		boolean result =  usuarioRepository.save(obj);
		Assert.isTrue(result, "Es el valor error ");
		
		logger.info("aca");
	}
	@Test
	@Override
	public void testModificar() {
		Usuario  obj = new Usuario();
		obj.setApellido("Erazo Pazmino");
		obj.setContrasena(byCrytEncode.encode("1234"));
		obj.setCorreo("ali@abc.com");
		obj.setIdGrupo(1L);
		obj.setNombre("Christian");
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
