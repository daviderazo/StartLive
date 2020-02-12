/**
 * 
 */
package com.dav.controller.mvc.administrator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Dhartel
 *
 */
@Controller
@RequestMapping("/admin/publicar")
public class PostController {
	@GetMapping
	public ModelAndView getHome() {
		return new ModelAndView("administrator/publicar");
	}
}
