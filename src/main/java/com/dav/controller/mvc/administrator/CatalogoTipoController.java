/**
 * 
 */
package com.dav.controller.mvc.administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dav.model.CatalogoTipo;
import com.dav.model.Categoria;
import com.dav.repositorio.CatalogoTipoRepository;

/**
 * @author Dhartel
 *
 */
@Controller
@RequestMapping("/admin/catalogoTipo")
public class CatalogoTipoController {
	
	@Autowired
	private CatalogoTipoRepository repository;
	
	@GetMapping
	public ModelAndView getHome(
		@RequestParam(defaultValue="all", required=false) String view_name,
		@RequestParam(defaultValue = "", required=false) String id,
		Pageable pageable
			) {
		ModelAndView modelAndView = new ModelAndView("administrator/catalogoTipo");
		switch (view_name) {
		case "new":	
			modelAndView.addObject("catalogoTipo", new CatalogoTipo());
			break;
			
		case "update":
			modelAndView.addObject("catalogoTipo",this.repository.findById(id));
			break;
		default:
			modelAndView.addObject("catalogosTipo", repository.findAll(pageable));
			break;
		}
		
		
		return modelAndView; 
	}
	
	@PostMapping
	public String newAndUpdate(@ModelAttribute CatalogoTipo catalogoTipo) {
		
		if(catalogoTipo.getFecha() == null) {
			repository.save(catalogoTipo);
		} else {
			repository.update(catalogoTipo);
		}
		
		return "redirect:/admin/catalogoTipo"; 
	}
	
	
}
