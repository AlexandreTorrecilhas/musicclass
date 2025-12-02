package com.orquestraagape.musica.servicos;

import com.orquestraagape.musica.modelos.Pessoa;
import com.orquestraagape.musica.repositorios.PessoaRepositorio;
import org.springframework.stereotype.Service;

@Service
public class PessoaServicos {

    private final PessoaRepositorio pessoaRepositorio;

    public PessoaServicos(PessoaRepositorio pessoaRepositorio){
        this.pessoaRepositorio = pessoaRepositorio;
    }

    public Pessoa postNovaPessoa(Pessoa pessoa){
        try{
            return this.pessoaRepositorio.save(pessoa);
        }catch(Exception e){
            throw(e) ;
        }
    }

}
