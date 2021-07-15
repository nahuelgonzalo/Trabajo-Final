package com.comit.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.comit.modelo.Producto;
import com.comit.modelo.Usuario;
import com.comit.servicios.ProductoService;
import com.comit.servicios.UsuarioService;

@Controller
@RequestMapping
public class UsuarioController{
	
	private final UsuarioService usuarioService;
	
	

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@RequestMapping(value ="crearUsuario" , method = RequestMethod.GET)
	public String crearUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "crearUsuario";
	}
	
	@PostMapping(value = "/crearUsua")
	public String crearUsuario(@RequestParam(value = "nombre")String nombre,
			@RequestParam(value = "contraseña")String contraseña,
			Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setContraseña(contraseña);
		usuario = usuarioService.guardar(usuario);
		return "redirect:/";
		
	}
}
