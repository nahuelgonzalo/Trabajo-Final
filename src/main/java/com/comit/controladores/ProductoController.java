package com.comit.controladores;

import java.io.OutputStream;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

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

import com.comit.GenerarCodigoDeBarra;
import com.comit.modelo.Producto;
import com.comit.servicios.ProductoService;

@Controller
@RequestMapping
public class ProductoController {
	
	private final ProductoService productoService;

	
	
	
	@Autowired
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	@RequestMapping(value ="crearProducto" , method = RequestMethod.GET)
	public String crearProducto(Model model) {
		model.addAttribute("producto", new Producto());
		return "crearProducto";
	}
	
	@PostMapping(value = "/guardar")
	public String guardarProducto(@RequestParam(value = "nombre")String nombre,
			@RequestParam(value = "codigoProducto")String codigo,
			@RequestParam(value = "origen")String origen,
			Model model) {
		Producto producto = new Producto();
		producto.setNombre(nombre);
		producto.setCodigoProducto(codigo);
		producto.setOrigen(origen);
		producto = productoService.guardar(producto);
		return "redirect:mostrarListas";
		
	}
	
	@GetMapping(value = "mostrarListas")
	public String productos(Model model) {
		model.addAttribute("productos", productoService.getProductos());
		return "mostrarListas";
	}
	
	@RequestMapping(value = "barcode/{id}", method = RequestMethod.GET)
	public void barcode(
			@PathVariable("id") String id,
			HttpServletResponse response) throws Exception{
			response.setContentType("image/png");
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(GenerarCodigoDeBarra.getBarCodeImage(id, 200, 200));
			outputStream.flush();
			outputStream.close();			
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Optional<Producto> producto = productoService.editarId(id);
		if(producto.isPresent())
			model.addAttribute("producto",producto.get());
		return "editarProducto";
	}
	
	@PostMapping(value = "actualizar")
	public String actualizarProducto(
			@ModelAttribute("producto") Producto producto,
			Model model) {
		
		producto = productoService.guardar(producto);
		model.addAttribute("producto", producto);
		return "redirect:mostrarListas";
		
	}
	
	
	
	@GetMapping("/eliminar/{id}")
	public String borrar(@PathVariable Long id, Model model) {
		productoService.borrar(id);
		return "mostrarListas";
	}
	
}
