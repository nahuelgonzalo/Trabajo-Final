package com.comit.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.comit.modelo.Producto;
import com.comit.servicios.ProductoService;

@Controller
@RequestMapping
public class ProductoController {
	
	private final ProductoService productoService;
	
	

	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	@RequestMapping(value ="crearProducto" , method = RequestMethod.GET)
	public String crearProducto(Model model) {
		model.addAttribute("producto", new Producto());
		return "crearProducto";
	}
	
	@PostMapping(value = "/crear")
	public String crearProducto(@RequestParam(value = "nombre")String nombre,
			@RequestParam(value = "codigoProducto")String codigo,
			@RequestParam(value = "origen")String origen,
			Model model) {
		Producto producto = new Producto();
		producto.setNombre(nombre);
		producto.setCodigoProducto(codigo);
		producto.setOrigen(origen);
		producto = productoService.guardar(producto);
		return "redirect:/";
		
	}
}
