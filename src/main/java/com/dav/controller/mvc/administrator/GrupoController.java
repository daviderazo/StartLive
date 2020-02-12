/**
 * 
 */
package com.dav.controller.mvc.administrator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.dav.model.Grupo;
import com.dav.model.GrupoPermiso;
import com.dav.model.Permiso;
import com.dav.repositorio.GrupoPermisoRepository;
import com.dav.repositorio.GrupoRepository;
import com.dav.repositorio.PermisoRepository;

/**
 * @author Dhartel
 *
 */
@Controller
@RequestMapping("/admin/grupo")
public class GrupoController {

	@Autowired
	private GrupoRepository repository;
	
	@Autowired
	private PermisoRepository repositoryPermise;
	
	@Autowired
	private GrupoPermisoRepository repositoryGrupPerm;
	

	private List<Permiso> permisos;
	private List<GrupoPermiso> listaGrupoPermiso;
	
	@GetMapping
	public ModelAndView getHome(
		@RequestParam(defaultValue="all", required=false) String view_name,
		@RequestParam(defaultValue = "0", required=false) long id,
		Pageable pageable,
		Model model
			) {
		  ModelAndView modelAndView = new ModelAndView("administrator/grupo");
		switch (view_name) {
		case "new":	
			model.addAttribute("grupo", new Grupo());
			break;
		case "update":
			model.addAttribute("grupo", this.repository.findById(id));
			break;
			
		case "addPerm":
			addOpcionPermiso(id, pageable, model);
			
			break;
		default:
			model.addAttribute("grupos", repository.findAll(pageable));
			break;
		}	
		
		
		
		return modelAndView; 
	}


	private void addOpcionPermiso(long id, Pageable pageable, Model model) {
		GrupoPermiso gpermisos = new GrupoPermiso();
		this.permisos = new ArrayList<>(this.repositoryPermise.findAll(pageable));
		this.listaGrupoPermiso = this.repositoryGrupPerm.findById(id);
		Optional<List<GrupoPermiso>> optionalGrupoPermiso = Optional.ofNullable(listaGrupoPermiso);
		List<Permiso> permisofiltrado = null;
		List<Long> collectionPermisoAsignado = optionalGrupoPermiso.get().stream().
				filter(q -> q.getIdPermiso() != null  && Boolean.TRUE.equals(q.getEstado()))
				.map(m -> m.getIdPermiso()).collect(Collectors.toList());
		if(collectionPermisoAsignado.isEmpty()) {
			permisofiltrado = permisos;
			
		} else {
			permisofiltrado = permisos.stream().filter(p -> 
			!collectionPermisoAsignado.contains(p.getIdPermiso()))
					.collect(Collectors.toList());
		}
		gpermisos.setPermisos(permisofiltrado);
		gpermisos.setIdGrupo(id);
		Grupo grupo= this.repository.findById(id);
		gpermisos.setGrupo(grupo);
		gpermisos.setLstGrupoPermiso(listaGrupoPermiso);
		model.addAttribute("grupo", grupo);
		model.addAttribute("grupoPermiso", gpermisos);
		model.addAttribute("lstGrupPerm", listaGrupoPermiso);
	}


	@PostMapping
	public String newAndUpdate(@ModelAttribute Grupo grupo) {
		
		if(grupo.getIdGrupo() == null) {
			repository.save(grupo);
		} else {
			repository.update(grupo);
		}
		
		return "redirect:/admin/grupo"; 
	}
	
	@PostMapping(path = "/addPermiso", params="action=addPermiso")
	public RedirectView add(
			@RequestParam int idGrupo,
			@ModelAttribute GrupoPermiso grupoPermiso
		,ModelAndView model
			) {
		//modelAndView.getModel();
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/admin/grupo?view_name=addPerm&id="+idGrupo);
		Collection<Long> colSelect = grupoPermiso.getPermisos().
				stream().filter(p -> Boolean.TRUE.equals(p.getSeleccionado())
			).map(Permiso:: getIdPermiso).collect(Collectors.toList());
		colSelect.forEach(l -> {
			GrupoPermiso object = null;
			Optional<List<GrupoPermiso>> optLisGP = Optional.ofNullable(grupoPermiso.getLstGrupoPermiso());
			if(optLisGP.isPresent()){
				object = optLisGP.get().stream()
				.filter(gp -> gp != null).filter(
						gp -> gp.getIdPermiso() == l && gp.getIdGrupo() == idGrupo
				).findAny().orElse(null);
			}
			if(object == null) {
				object = new GrupoPermiso();
				object.setIdGrupo(grupoPermiso.getIdGrupo());
				object.setIdPermiso(l);
				object.setEstado(Boolean.TRUE);
				this.repositoryGrupPerm.save(object);
			
			}else {
				object.setFecha(LocalDateTime.now());
				object.setEstado(Boolean.TRUE);
				this.repositoryGrupPerm.update(object);
			}
		});
	    return redirectView;
	}
	
	@PostMapping(path = "/addPermiso", params="action=removePermiso")
	public RedirectView remove(
			@RequestParam int idGrupo,
			@ModelAttribute GrupoPermiso grupoPermiso
		,ModelAndView model
			) {
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/admin/grupo?view_name=addPerm&id="+idGrupo);
		System.out.println("dada");
		Collection<Long> colSelect = grupoPermiso.getLstGrupoPermiso().
				stream().filter(gp ->Boolean.TRUE.equals(gp.getPermiso().getSeleccionado())
			).map(GrupoPermiso:: getIdPermiso).collect(Collectors.toList());
		colSelect.forEach(l -> {
			GrupoPermiso object =new GrupoPermiso();
			object.setIdGrupo(grupoPermiso.getIdGrupo());
			object.setIdPermiso(l);
			object.setEstado(Boolean.FALSE);
			this.repositoryGrupPerm.update(object);
		});
		return redirectView;
	}
	
	
}
