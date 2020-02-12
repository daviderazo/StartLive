/**
 * 
 */
package com.dav.controller.mvc.administrator;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.dav.model.Usuario;
import com.dav.repositorio.GrupoRepository;
import com.dav.repositorio.UsuarioRepository;

/**
 * @author Dhartel
 *
 */
@Controller
@RequestMapping("/admin/usuario")
public class UsuarioController {
	
	public UsuarioController() {
		super();
		setIconosFontAwesome();
	}


	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private GrupoRepository repositoryGp;
	
	private List<String> iconosFontAwesome;
	
	@GetMapping
	public ModelAndView getHome(@RequestParam(defaultValue="all", required=false) String view_name,
			@RequestParam(defaultValue = "0", required=false) int id,
			Pageable pageable,
			@ModelAttribute String font
				) {
		ModelAndView modelAndView = new ModelAndView("administrator/usuario");
		switch (view_name) {
		case "new":
			Usuario newUsuario = new Usuario();;
			if(!font.equals("")) {
				newUsuario.setFontIco(font); 
			}
			modelAndView.addObject("usuario", newUsuario);
			modelAndView.addObject("grupos", repositoryGp.findAll(pageable));
			modelAndView.addObject("icons",iconosFontAwesome);
			break;
			
		case "update":
			modelAndView.addObject("usuario",this.repository.findById(id));
			modelAndView.addObject("grupos", repositoryGp.findAll(pageable));
			modelAndView.addObject("icons",iconosFontAwesome);
			break;
		default:
			modelAndView.addObject("usuarios", repository.findAll(pageable));
			break;
		}
		
		
		
		return modelAndView;
	}
	
	@PostMapping
	//(path = "/newupdate", params ="action=newupdate")
	public String newAndUpdate(@ModelAttribute Usuario usuario) {
		
		if(usuario.getFecha() == null) {
			repository.save(usuario);
		} else {
			repository.update(usuario);
		}
		
		return "redirect:/admin/usuario"; 
	}
	
	
	@PostMapping(path="/font")
	public RedirectView selectFontAweSome(@RequestParam String font, @ModelAttribute Usuario user,ModelAndView model) {
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/admin/usuario?view_name=new");
//		RedirectAttributes attributes = RedirectAttributes.class.newInstance();
//		attributes.addAttribute("font", font);
		
//		Properties attributes = Properties.class.;
//		redirectView.setAttributes(attributes);
		
		
		
		return redirectView;
	}
	
	private List<String> setIconosFontAwesome() {
		this.iconosFontAwesome = new ArrayList<>();
		iconosFontAwesome.add("fas fa-baby");
		iconosFontAwesome.add("fas fa-paw");
		iconosFontAwesome.add("fas fa-chess-queen");
		iconosFontAwesome.add("fas fa-hat-cowboy");
		iconosFontAwesome.add("fas fa-theater-masks");
		iconosFontAwesome.add("far fa-eye");
		iconosFontAwesome.add("fas fa-key");
		
		return iconosFontAwesome;
		
		
	}
	
}
