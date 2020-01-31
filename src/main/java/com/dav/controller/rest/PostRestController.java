/**
@RestController
@RequestMapping("/api/v1/permiso")
 * 
 */
package com.dav.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dav.model.Post;
import com.dav.model.commons.RepBase;
import com.dav.repositorio.PostRepository;

/**
 * @author Dhartel
 *
 */
@RestController
@RequestMapping("/api/v1/post")
public class PostRestController {
	@Autowired
	private PostRepository repository;
	
	@PutMapping//(consumes = {MediaType.APPLICATION_JSON_VALUE})//ya lo hace la anotacion
	public ResponseEntity<RepBase> save(@RequestBody @Valid Post objeto) {
		return ResponseEntity.ok(new RepBase(repository.save(objeto)));
	}
	
	@PostMapping
	public ResponseEntity<RepBase> update(@RequestBody @Valid Post objeto) {
		return ResponseEntity.ok(new RepBase(repository.update(objeto)));
	}
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll(SpringDataWebProperties.Pageable pageable){
		return ResponseEntity.ok(repository.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable @Valid int id){
		return ResponseEntity.ok(repository.findById(id)); 
	}


}
