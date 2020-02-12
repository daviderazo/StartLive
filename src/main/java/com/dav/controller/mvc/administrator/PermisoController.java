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
import com.dav.model.Permiso;
import com.dav.repositorio.PermisoRepository;

/**
 * @author Dhartel
 *
 */
@Controller
@RequestMapping("/admin/permiso")
public class PermisoController {
	
	@Autowired
	private PermisoRepository repository;
	
	@GetMapping
	public ModelAndView getHome(
		@RequestParam(defaultValue="all", required=false) String view_name,
		@RequestParam(defaultValue = "0", required=false) long id,
		Pageable pageable
			) {
		ModelAndView modelAndView = new ModelAndView("administrator/permiso");
		switch (view_name) {
		case "new":	
			modelAndView.addObject("permiso", new Permiso());
			break;
		case "update":
			modelAndView.addObject("permiso", this.repository.findById(id));
			break;
		default:
			modelAndView.addObject("permisos", repository.findAll(pageable));
			break;
		}	
		
		
		
		return modelAndView; 
	}

	@PostMapping
	public String newAndUpdate(@ModelAttribute Permiso permiso) {
		
		if(permiso.getIdPermiso() == null) {
			repository.save(permiso);
		} else {
			repository.update(permiso);
		}
		
		return "redirect:/admin/permiso"; 
	}
	
}
