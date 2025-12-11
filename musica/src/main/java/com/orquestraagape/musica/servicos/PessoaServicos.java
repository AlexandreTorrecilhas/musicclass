package com.orquestraagape.musica.servicos;

import com.orquestraagape.musica.exception.ResourceNotFoundException;
import com.orquestraagape.musica.modelos.Pessoa;
import com.orquestraagape.musica.repositorios.PessoaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            System.out.println("Mensagem: " + e);
            throw(e) ;
        }
    }

    public Optional<Pessoa> getPessoaById (int idPessoa){

        return this.pessoaRepositorio.findById(idPessoa);

    }

    public Optional<Pessoa> updatePessoa(int idPessoa, Pessoa pessoaAtualizada){

        this.pessoaRepositorio.findById(idPessoa).map(pessoaAtual ->{
            pessoaAtual.setEmail(pessoaAtualizada.getEmail());
            return this.pessoaRepositorio.save(pessoaAtual);
        }).orElseThrow(() -> new ResourceNotFoundException("Esse cadastro não existe"));
        return Optional.empty();
    }

    public String deletePessoa(int idPessoa){
        this.pessoaRepositorio.findById(idPessoa).map(
                pessoaAtual -> {
                    this.pessoaRepositorio.deleteById(pessoaAtual.getIdPessoa());
                    return ("Pessoa: " + pessoaAtual.getIdPessoa() + " " + pessoaAtual.getNome() + " foi removida");
                }
        ).orElseThrow(() -> new ResourceNotFoundException("Esse cadastro não existe"));
        return "";
    }

    public List<Pessoa> getAllPessoas() {
        return pessoaRepositorio.findAll();
    }

}
