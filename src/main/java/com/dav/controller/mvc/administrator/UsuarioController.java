/**
 * 
 */
package com.dav.controller.mvc.administrator;

import java.util.ArrayList;
import java.util.List;

import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
			Pageable pageable, @ModelAttribute("usuario") Usuario usuario, 
			@RequestParam(defaultValue="false", required=false) Boolean useUsuario
			
				) {
		Usuario usuarioAux;
		ModelAndView modelAndView = new ModelAndView("administrator/usuario");
		switch (view_name) {
		case "new":
			
			if(Boolean.TRUE.equals(useUsuario)) {
				usuarioAux = usuario;
			} else {
				usuarioAux = new Usuario();
			}
			modelAndView.addObject("usuario", usuarioAux);
			modelAndView.addObject("grupos", repositoryGp.findAll(pageable));
			modelAndView.addObject("icons",iconosFontAwesome);
			modelAndView.addObject("view_name","new");
			break;
			
		case "update":
			if(Boolean.TRUE.equals(useUsuario)) {
				usuarioAux = usuario;
			} else {
				usuarioAux = this.repository.findById(id);
			}
			modelAndView.addObject("usuario",usuarioAux);
			modelAndView.addObject("grupos", repositoryGp.findAll(pageable));
			modelAndView.addObject("icons",iconosFontAwesome);
			modelAndView.addObject("view_name","update");
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
			usuario.setEstado(Boolean.TRUE);
			repository.save(usuario);
		} else {
			repository.update(usuario);
		}
		
		return "redirect:/admin/usuario"; 
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
