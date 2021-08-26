package com.inqhome.inqhome.anuncio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inqhome.inqhome.usuario.Usuario;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

}
