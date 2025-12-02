package com.orquestraagape.musica.repositorios;

import com.orquestraagape.musica.modelos.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer> {
}
