package com.inqhome.inqhome.anuncio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inqhome.inqhome.anuncio.CriarAnuncioDTO;
import com.inqhome.inqhome.anuncio.Anuncio;
import com.inqhome.inqhome.anuncio.AnuncioService;

@RestController
@RequestMapping("/api/anuncio")
public class AnuncioResource {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private AnuncioService anuncioService;

	@GetMapping
	public List<Anuncio> buscarTodos() {
		return anuncioService.buscarAnuncios();
	}

	@GetMapping("/{id}")
	public Anuncio buscarPeloId(@PathVariable Long id) {
		return anuncioService.buscarAnuncioPeloId(id);
	}

	@PostMapping
	public Anuncio salvarAnuncio(@RequestBody CriarAnuncioDTO anuncio) {
		return anuncioService.salvarAnuncio(anuncio);
	}

	@DeleteMapping("/{id}")
	public void deletarPeloid(@PathVariable Long id) {
		anuncioService.deletarAnuncioPeloId(id);
	}

	@PutMapping("/{id}")
	public Anuncio atualizarAnuncio(@PathVariable Long id, CriarAnuncioDTO anuncio) {
		return anuncioService.atualizarAnuncio(id, anuncio);
	}

}
