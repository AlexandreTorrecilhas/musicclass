package com.orquestraagape.musica.repositorios;

import com.orquestraagape.musica.modelos.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer> {
}
