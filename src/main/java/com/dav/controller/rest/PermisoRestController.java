/**
 * 
 */
package com.dav.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dav.model.Permiso;
import com.dav.model.commons.RepBase;
import com.dav.repositorio.PermisoRepository;

/**
 * @author Dhartel
 *
 */

@RestController
@RequestMapping("/api/v1/permiso")
public class PermisoRestController {
	@Autowired
	private PermisoRepository repository;
	
	@PutMapping//(consumes = {MediaType.APPLICATION_JSON_VALUE})//ya lo hace la anotacion
	@CacheEvict(value="permisos", allEntries = true)
	public ResponseEntity<RepBase> save(@RequestBody @Valid Permiso objeto) {
		return ResponseEntity.ok(new RepBase(repository.save(objeto)));
	}
	
	@PostMapping
	@CacheEvict(value="permisos", allEntries = true)
	public ResponseEntity<RepBase> update(@RequestBody @Valid Permiso objeto) {
		return ResponseEntity.ok(new RepBase(repository.update(objeto)));
	}
	
	@GetMapping
	@Cacheable(value="permisos")
	public ResponseEntity<List<Permiso>> findAll(SpringDataWebProperties.Pageable pageable){
		return ResponseEntity.ok(repository.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	@Cacheable(value="permisos")
	public ResponseEntity<Permiso> findById(@PathVariable @Valid int id){
		return ResponseEntity.ok(repository.findById(id)); 
	}
	
	@DeleteMapping("/{id}")
	@CacheEvict(value="permisos", allEntries = true)
	public ResponseEntity<RepBase> delete(@PathVariable @Valid int id){
		return ResponseEntity.ok(new RepBase(repository.deleteById(id)));
	}
	
}
