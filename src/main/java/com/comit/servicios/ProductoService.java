package com.comit.servicios;

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
	
}
