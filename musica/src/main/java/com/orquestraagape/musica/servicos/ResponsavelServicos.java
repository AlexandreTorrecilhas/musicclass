package com.orquestraagape.musica.servicos;

import com.orquestraagape.musica.exception.ResourceNotFoundException;
import com.orquestraagape.musica.modelos.Pessoa;
import com.orquestraagape.musica.modelos.Responsavel;
import com.orquestraagape.musica.repositorios.ResponsavelRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Responsavel getResponsabelById(int idResponsavel){
        return this.responsavelRepositorio.findById(idResponsavel).orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado"));
    }

    public Responsavel updateResponsavel(Responsavel responsavelAtualizado){
        return this.responsavelRepositorio.findById(responsavelAtualizado.getIdResponsavel())
                .map((responsavelAtual) ->{
                    responsavelAtual.setCpf(responsavelAtualizado.getCpf());
                    responsavelAtual.setTelefone(responsavelAtual.getTelefone());
                    responsavelAtual.setPessoa(responsavelAtualizado.getPessoa());
                    return this.responsavelRepositorio.save(responsavelAtual);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Responsável não encontrado"));
        }

    public String deleteResponsavel(int idResponsavel){
        Responsavel responsavelDeletado = this.responsavelRepositorio.findById(idResponsavel)
                .orElseThrow(() -> new ResourceNotFoundException("Esse registro já foi removido"));

        this.responsavelRepositorio.deleteById(idResponsavel);

        return "Responavel ID: " + responsavelDeletado.getPessoa().getIdPessoa() + " Nome: "
                    + responsavelDeletado.getPessoa().getNome() + " foi deletado";
    }

    public List<Responsavel> findByPessoaNome(String nome){
        return this.responsavelRepositorio.findByPessoaNomeContaining(nome);
    }
}