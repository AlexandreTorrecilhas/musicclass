package com.orquestraagape.musica.servicos;

import com.orquestraagape.musica.modelos.Pessoa;
import com.orquestraagape.musica.modelos.Responsavel;
import com.orquestraagape.musica.repositorios.ResponsavelRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsavelServicos {

    @Autowired
    private final ResponsavelRepositorio responsavelRepositorio;

    public ResponsavelServicos (ResponsavelRepositorio responsavelRepositorio){
        this.responsavelRepositorio = responsavelRepositorio;
    }

    @Transactional /*More than one step is required*/
    public Responsavel postNovoResponsavel (Responsavel responsavel){

        Pessoa p = responsavel.getPessoa(); /*Creating the Pessoa object*/
        responsavel.setPessoa(p); /*Bounding to the current object that will be stored in the database*/

        return this.responsavelRepositorio.save(responsavel);
    }
}