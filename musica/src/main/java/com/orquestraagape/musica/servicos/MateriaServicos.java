package com.orquestraagape.musica.servicos;

import com.orquestraagape.musica.modelos.Materia;
import com.orquestraagape.musica.repositorios.MateriaRepositorio;
import org.springframework.stereotype.Service;

@Service
public class MateriaServicos {

    private final MateriaRepositorio materiaRepositorio;

    public MateriaServicos(MateriaRepositorio materiaRepositorio){
        this.materiaRepositorio = materiaRepositorio;
    }

    public Materia postNovaMateria(Materia novaMateira){
        Materia materiaCadastrada = this.materiaRepositorio.save(novaMateira);
        return materiaCadastrada;
    }

}
