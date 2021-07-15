package com.comit.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comit.modelo.Producto;
import com.comit.modelo.ProductoRepository;
import com.comit.modelo.Usuario;
import com.comit.modelo.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario guardar(Usuario usuario) {
		return usuarioRepository.saveAndFlush(usuario);
	}
}
