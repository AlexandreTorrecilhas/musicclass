package com.orquestraagape.musica.Controles;

import com.orquestraagape.musica.exception.ResourceNotFoundException;
import com.orquestraagape.musica.modelos.Pessoa;
import com.orquestraagape.musica.repositorios.PessoaRepositorio;
import com.orquestraagape.musica.servicos.PessoaServicos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoa")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("{idPessoa}")
    public ResponseEntity<Optional<Pessoa>> getPessoaById(@PathVariable int idPessoa){

        Optional<Pessoa> pessoa = this.pessoaServicos.getPessoaById(idPessoa);

        return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }

    @PutMapping("/atualizarPessoa/{idPessoa}")
    public ResponseEntity<Optional<Pessoa>> updatePessoa(
            @PathVariable int idPessoa,
            @RequestBody Pessoa novaPessoa
    ){
        try{
            Optional<Pessoa> pessoa = this.pessoaServicos.updatePessoa(idPessoa, novaPessoa);

            return ResponseEntity.status(HttpStatus.OK).body(pessoa);

        }catch(ResourceNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/removerPessoa/{idPessoa}")
    public ResponseEntity<String> deletePessoa(@PathVariable int idPessoa){
        try{
            String mensagem = this.pessoaServicos.deletePessoa(idPessoa);
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        }catch(ResourceNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAllPessoas(){
        List<Pessoa> pessoas = this.pessoaServicos.getAllPessoas();

        if (pessoas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(pessoas);
    }
}
