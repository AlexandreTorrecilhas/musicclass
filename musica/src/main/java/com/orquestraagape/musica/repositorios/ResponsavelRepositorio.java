package com.orquestraagape.musica.repositorios;

import com.orquestraagape.musica.modelos.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResponsavelRepositorio extends JpaRepository<Responsavel, Integer> {
    List<Responsavel> findByPessoaNomeContaining(String nome);
}
