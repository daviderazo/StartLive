/**
 * 
 */
package com.dav.component;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.dav.repositorio.CatalogoTipoRepository;
import com.dav.repositorio.CatalogoValorRepository;
import com.dav.repositorio.CategoriaRepository;
import com.dav.repositorio.ComentarioRepository;
import com.dav.repositorio.ContenidoRepository;
import com.dav.repositorio.GrupoPermisoRepository;
import com.dav.repositorio.GrupoRepository;
import com.dav.repositorio.IngresosistemaRepository;
import com.dav.repositorio.PermisoRepository;
import com.dav.repositorio.PostRepository;
import com.dav.repositorio.PostmetadataRepository;
import com.dav.repositorio.UsuarioMetadataRepository;
import com.dav.repositorio.UsuarioRepository;

/**
 * @author Dhartel
 *
 */
//@Configuration
//@Primary define la principal
public class TestDatabaseConfiguration {

	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/blog");
		dataSource.setUsername("dav");
		dataSource.setPassword("dav1234");
		
		return dataSource;
	}
	
	@Bean
	public CatalogoTipoRepository catalogoTipoRepository() {
		return new CatalogoTipoRepository();
	}
	
	@Bean
	public CatalogoValorRepository catalogoValorRepository() {
		return new CatalogoValorRepository();
	}
	
	@Bean
	public CategoriaRepository categoriaRepository() {
		return new CategoriaRepository();
	}
	
	@Bean
	public ComentarioRepository comentarioRepository() {
		return new  ComentarioRepository();
	}
	
	@Bean
	public ContenidoRepository contenidoRepository() {
		return new ContenidoRepository();
	}
	
	@Bean
	public GrupoPermisoRepository grupoPermisoRepository() {
		return new GrupoPermisoRepository();
	}
	
	@Bean
	public GrupoRepository grupoRepository() {
		return new GrupoRepository();
	}
	
	@Bean
	public IngresosistemaRepository ingresosistemaRepository() {
		return new IngresosistemaRepository();
	}
	
	@Bean
	public PermisoRepository permisoRepository() {
		return new PermisoRepository(); 
	}
	
	@Bean
	public PostmetadataRepository postmetadataRepository() {
		return new PostmetadataRepository();
	}
	
	@Bean
	public PostRepository postRepository() {
		return new PostRepository();
	}
	
	@Bean
	public UsuarioMetadataRepository metadataRepository() {
		return new UsuarioMetadataRepository();
	}
	
	@Bean
	public UsuarioRepository usuarioRepository() {
		return new  UsuarioRepository();
	}
}
