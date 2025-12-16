package com.orquestraagape.musica.servicos;

import com.orquestraagape.musica.exception.ResourceNotFoundException;
import com.orquestraagape.musica.modelos.Ciclo;
import com.orquestraagape.musica.repositorios.CicloRepositorio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CicloServicos {

    private final CicloRepositorio cicloRepositorio;

    public CicloServicos(CicloRepositorio cicloRepositorio){
        this.cicloRepositorio = cicloRepositorio;
    }

    public Ciclo postNovoCiclo(Ciclo ciclo){
        Ciclo cicloCadastrado = this.cicloRepositorio.save(ciclo);
        return cicloCadastrado;
    }

    public Optional<Ciclo> getCicloById(int idCiclo){
        this.cicloRepositorio.findById(idCiclo).orElseThrow(() -> new ResourceNotFoundException("Esse ciclo não existe"));
        return Optional.empty();
    }

}
