package com.orquestraagape.musica.Controles;

import com.orquestraagape.musica.modelos.Pessoa;
import com.orquestraagape.musica.repositorios.PessoaRepositorio;
import com.orquestraagape.musica.servicos.PessoaServicos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaControle {

    private final PessoaServicos pessoaServicos;

    public PessoaControle(PessoaServicos pessoaServicos){
        this.pessoaServicos = pessoaServicos;
    }

    @PostMapping
    public ResponseEntity<Pessoa> postNovaPessoa(@RequestBody Pessoa novaPessoa){

        Pessoa pessoa = this.pessoaServicos.postNovaPessoa(novaPessoa);

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }
}
