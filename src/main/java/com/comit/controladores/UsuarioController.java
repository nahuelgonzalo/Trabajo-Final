package com.comit.controladores;


import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.comit.modelo.Usuario;

import com.comit.servicios.UsuarioService;

@Controller
@RequestMapping
public class UsuarioController{
	
	private final UsuarioService usuarioService;
	
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@RequestMapping(value ="crearUsuario" , method = RequestMethod.GET)
	public String crearUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "crearUsuario";
	}
	
	@PostMapping(value = "/guardarUsua")
	public String guardarUsuario(@RequestParam(value = "nombre")String nombre,
			@RequestParam(value = "contrasenia")String contrasenia,
			Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setContrasenia(contrasenia);
		usuario = usuarioService.guardar(usuario);
		return "redirect:/mostrarListaUsuarios";
		
	}
	
	@GetMapping(value = "mostrarListaUsuarios")
	public String usuarios(Model model) {
		model.addAttribute("usuarios", usuarioService.getUsuarios());
		return "mostrarListaUsuarios";
	}
	
	
	
	@GetMapping("/editarUsua/{id}")
	public String editarUsuario(@PathVariable("id") Long id, Model model) {
		Optional<Usuario> usuario = usuarioService.editarId(id);
		if(usuario.isPresent())
			model.addAttribute("usuario",usuario.get());
		return "editarUsuario";
	}
	
	@PostMapping(value = "actualizarUsua")
	public String actualizarUsuario(
			@ModelAttribute("usuario") Usuario usuario,
			Model model) {
		
		usuario = usuarioService.guardar(usuario);
		model.addAttribute("usuario", usuario);
		return "redirect:mostrarListaUsuarios";
		
	}
	

	@GetMapping("/eliminarUsuario/{id}")
	public String borrarUsuario(@PathVariable Long id, Model model) {
		usuarioService.borrar(id);
		return "mostrarListaUsuarios";
	}
	
	
}
