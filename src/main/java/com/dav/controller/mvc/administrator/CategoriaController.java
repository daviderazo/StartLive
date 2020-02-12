/**
 * 
 */
package com.dav.controller.mvc.administrator;

import javax.annotation.PostConstruct;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dav.model.Categoria;
import com.dav.repositorio.CategoriaRepository;

/**
 * @author Dhartel
 *
 */
@Controller
@RequestMapping("/admin/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ModelAndView getHome(
		@RequestParam(defaultValue = "all", required=false) String view_name,
		@RequestParam(defaultValue = "0", required = false ) long id,
		Pageable pageable
			) {
		ModelAndView modelAndView = new ModelAndView("administrator/categoria");
		switch (view_name) {
		case "all":
			modelAndView.addObject("categorias", repository.findAll(pageable));
			break;
		case "new":	
			modelAndView.addObject("categoria", new Categoria());
			break;
			
		case "update":
			modelAndView.addObject("categoria",this.repository.findById(id));
			break;
		}
		return modelAndView;
	}
	
	@PostMapping
	public String newAndUpdate(@ModelAttribute Categoria categoria) {
		if(categoria.getIdCategoria() > 0 ) {
			repository.update(categoria);
		} else {
			repository.save(categoria);
			
		}
		return "redirect:/admin/categoria";
	}

	
	public CategoriaRepository getRepository() {
		return repository;
	}

	public void setRepository(CategoriaRepository repository) {
		this.repository = repository;
	}


}
