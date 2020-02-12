/**
 * 
 */
package com.dav.controller.mvc.administrator;

import java.util.List;

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
import com.dav.model.CatalogoValor;
import com.dav.repositorio.CatalogoTipoRepository;
import com.dav.repositorio.CatalogoValorRepository;

/**
 * @author Dhartel
 *
 */
@Controller
@RequestMapping("/admin/catalogoValor")
public class CatalogoValorController {
	
	@Autowired
	private CatalogoValorRepository repository;
	
	@Autowired
	private CatalogoTipoRepository cTrepository;
	
	@GetMapping
	public ModelAndView getHome(
			@RequestParam(defaultValue = "all", required = false) String view_name,
			@RequestParam(defaultValue = "", required = false) String id, 
			Pageable pageable
			) {
		ModelAndView modelAndView = new ModelAndView("administrator/catalogoValor");
		List<CatalogoTipo> catstipo = null;
		switch(view_name) {
			case "new": modelAndView.addObject("catalogoValue", new CatalogoValor());
			catstipo = cTrepository.findAll(pageable);
						modelAndView.addObject("catsTipo", catstipo);
						modelAndView.addObject("update", Boolean.FALSE);
					break;
			case "update": 
				modelAndView.addObject("catalogoValue",this.repository.findById(id));
				catstipo = cTrepository.findAll(pageable);
				modelAndView.addObject("catsTipo", catstipo);
						   modelAndView.addObject("update", Boolean.TRUE);
						   break;
			default: modelAndView.addObject("catalogosValues", repository.findAll(pageable));
			break;
			}
		
		
		return modelAndView;
	}
	
	@PostMapping
	public String newAndUpdate(@ModelAttribute CatalogoValor catalogoValor) {
		if(catalogoValor.getFecha() == null) {
			repository.save(catalogoValor);
		} else {
			repository.update(catalogoValor);
		}
		
		return "redirect:/admin/catalogoValor";
	}
	
	
	
	
	
	
	
	
}
