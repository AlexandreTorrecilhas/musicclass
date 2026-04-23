package com.orquestraagape.musica.Controles;

import com.orquestraagape.musica.modelos.Responsavel;
import com.orquestraagape.musica.repositorios.ResponsavelRepositorio;
import com.orquestraagape.musica.servicos.ResponsavelServicos;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/responsavel")
public class ResposavelControle {


    private final ResponsavelServicos responsavelServicos;

    public ResposavelControle(ResponsavelServicos responsavelServicos){
        this.responsavelServicos = responsavelServicos;
    }

    @PostMapping
    public ResponseEntity<Responsavel> postNovoResponsavel(@RequestBody Responsavel novoResponsavel){
        Responsavel responsavel = this.responsavelServicos.postNovoResponsavel(novoResponsavel);

        return ResponseEntity.status(HttpStatus.CREATED).body(responsavel);
    }

    @GetMapping("/consultaResponsavel/{idResponsavel}")
    public ResponseEntity<Responsavel> getResponsavelById(@PathVariable int idResponsavel){
        Responsavel responsavel = this.responsavelServicos.getResponsabelById(idResponsavel);

        return ResponseEntity.status(HttpStatus.OK).body(responsavel);
    }

    @GetMapping
    public ResponseEntity<List<Responsavel>> getResponsavelByPessoaNome(@RequestParam String nome){
        List<Responsavel> resultado = this.responsavelServicos.findByPessoaNome(nome);
        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }
}