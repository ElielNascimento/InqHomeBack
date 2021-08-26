package com.inqhome.inqhome.usuario;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> buscarUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarUsuarioPeloId(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException());
	}

	public Usuario salvarUsuario(CriarUsuarioDTO dados) {
		Usuario usuario = new Usuario(dados.getNome(), dados.getSenha(), dados.getEmail());
		return usuarioRepository.save(usuario);
	}

	public void deletarUsuarioPeloId(Long id) {
		Usuario usuario = buscarUsuarioPeloId(id);
		usuarioRepository.delete(usuario);
	}

	public Usuario atualizarUsuario(Long id, CriarUsuarioDTO dados) {
		Usuario usuario = buscarUsuarioPeloId(id);
		usuario.setNome(dados.getNome());
		usuario.setEmail(dados.getEmail());
		return usuarioRepository.save(usuario);
	}
}
