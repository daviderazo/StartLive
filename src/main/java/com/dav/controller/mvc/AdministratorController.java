/**
 * 
 */
package com.dav.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Dhartel
 *
 */
@Controller
@RequestMapping("/admin")
public class AdministratorController {

	@GetMapping(path = {"/"})
	public ModelAndView getHome() {
		return new ModelAndView("administrator/admin");
	}
}
