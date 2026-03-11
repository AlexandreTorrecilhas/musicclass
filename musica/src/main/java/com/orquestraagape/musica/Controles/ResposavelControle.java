package com.orquestraagape.musica.Controles;

import com.orquestraagape.musica.modelos.Responsavel;
import com.orquestraagape.musica.repositorios.ResponsavelRepositorio;
import com.orquestraagape.musica.servicos.ResponsavelServicos;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}