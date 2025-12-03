package com.orquestraagape.musica.repositorios;

import com.orquestraagape.musica.modelos.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepositorio extends JpaRepository<Materia, Integer> {
}
