package com.comit.controladores;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class MainController {

	@RequestMapping ("/index")
	public String index() {
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
