package com.comit.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comit.modelo.Producto;
import com.comit.modelo.ProductoRepository;

@Service
public class ProductoService {
	
	private final ProductoRepository productoRepository;
	
	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	public Producto guardar(Producto producto) {
		return productoRepository.saveAndFlush(producto);
	}
	
	public List<Producto> getProductos(){
		return productoRepository.findAll();
	}
	
	public Optional<Producto> editarId(Long id){
		return productoRepository.findById(id);
	}

	public void borrar(Long id) {
		productoRepository.deleteById(id);	
	}
}
