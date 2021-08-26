package com.inqhome.inqhome.anuncio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inqhome.inqhome.usuario.Usuario;
import com.inqhome.inqhome.usuario.UsuarioService;

@Service
public class AnuncioService {

	@Autowired
	private AnuncioRepository anuncioRepository;
	
	@Autowired
	private UsuarioService usuarioService;

	public List<Anuncio> buscarAnuncios() {
		return anuncioRepository.findAll();
	}

	public Anuncio buscarAnuncioPeloId(Long id) {
		return anuncioRepository.findById(id).orElseThrow(() -> new RuntimeException());
	}

	public Anuncio salvarAnuncio(CriarAnuncioDTO dados) {
		Usuario usuario = usuarioService.buscarUsuarioPeloId(dados.getUsuarioId());
		
		Anuncio anuncio = new Anuncio(usuario, dados.getDescricao());
		return anuncioRepository.save(anuncio);
	}

	public void deletarAnuncioPeloId(Long id) {
		Anuncio anuncio = buscarAnuncioPeloId(id);
		anuncioRepository.delete(anuncio);
	}

	public Anuncio atualizarAnuncio(Long id, CriarAnuncioDTO dados) {
		Anuncio anuncio = buscarAnuncioPeloId(id);
		anuncio.setDescricao(dados.getDescricao());
		return anuncioRepository.save(anuncio);
	}
	
}
