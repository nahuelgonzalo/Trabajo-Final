package com.comit.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public List<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuario> editarId(Long id){
		return usuarioRepository.findById(id);
	}

	public void borrar(Long id) {
		usuarioRepository.deleteById(id);	
	}
}
