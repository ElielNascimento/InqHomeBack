package com.inqhome.inqhome.administrador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AdministradorService {
	
	@Autowired
	private AdministradorRepository administradorRepository;
	

	public List<Administrador> buscarAdministradores() {
		return administradorRepository.findAll();
	}

	public Administrador buscarAdministradorPeloId(Long id) {
		return administradorRepository.findById(id).orElseThrow(() -> new RuntimeException());
	}

	public Administrador salvarAdministrador(CriarAdministradorDTO dados) {
		
		Administrador administrador = new Administrador(dados.getLogin(),dados.getSenha(),dados.getEmail());
		return administradorRepository.save(administrador);
	}

	public void deletarAdministradorPeloId(Long id) {
		Administrador administrador = buscarAdministradorPeloId(id);
		administradorRepository.delete(administrador);
	}

	public Administrador atualizarAdministrador(Long id, CriarAdministradorDTO dados) {
		Administrador administrador = buscarAdministradorPeloId(id);
		
		administrador.setLogin(dados.getLogin());
		administrador.setEmail(dados.getEmail());
		
		return administradorRepository.save(administrador);
	}

}
