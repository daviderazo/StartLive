/**
 * 
 */
package com.dav.component;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author Dhartel
 *
 */
@Configuration
public class DataBaseConfiguration {

	@Autowired
    private Environment env;
	
	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		
		return dataSource;
	}
	
//	@Bean
//	public CatalogoTipoRepository catalogoTipoRepository() {
//		return new CatalogoTipoRepository();
//	}
//	
//	@Bean
//	public CatalogoValorRepository catalogoValorRepository() {
//		return new CatalogoValorRepository();
//	}
//	
//	@Bean
//	public CategoriaRepository categoriaRepository() {
//		return new CategoriaRepository();
//	}
//	
//	@Bean
//	public ComentarioRepository comentarioRepository() {
//		return new  ComentarioRepository();
//	}
//	
//	@Bean
//	public ContenidoRepository contenidoRepository() {
//		return new ContenidoRepository();
//	}
//	
//	@Bean
//	public GrupoPermisoRepository grupoPermisoRepository() {
//		return new GrupoPermisoRepository();
//	}
//	
//	@Bean
//	public GrupoRepository grupoRepository() {
//		return new GrupoRepository();
//	}
//	
//	@Bean
//	public IngresosistemaRepository ingresosistemaRepository() {
//		return new IngresosistemaRepository();
//	}
//	
//	@Bean
//	public PermisoRepository permisoRepository() {
//		return new PermisoRepository(); 
//	}
//	
//	@Bean
//	public PostmetadataRepository postmetadataRepository() {
//		return new PostmetadataRepository();
//	}
//	
//	@Bean
//	public PostRepository postRepository() {
//		return new PostRepository();
//	}
//	
//	@Bean
//	public UsuarioMetadataRepository metadataRepository() {
//		return new UsuarioMetadataRepository();
//	}
//	
//	@Bean
//	public UsuarioRepository usuarioRepository() {
//		return new  UsuarioRepository();
//	}
}
