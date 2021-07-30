package com.comit.controladores;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comit.modelo.Producto;


@Controller
@RequestMapping
public class MainController {

	@GetMapping ("/index")
	public String index(Model model) {
		model.addAttribute("producto", new Producto());
		return "index";
	}
	@RequestMapping ("/services")
	public String service() {
		return "services";
	}
	@RequestMapping ("/testimonials")
	public String testimonials() {
		return "testimonials";
	}
	@RequestMapping ("/contact")
	public String contact() {
		return "contact";
	}
}
