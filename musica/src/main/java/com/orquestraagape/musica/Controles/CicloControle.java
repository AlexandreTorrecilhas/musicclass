package com.orquestraagape.musica.Controles;

import com.orquestraagape.musica.modelos.Ciclo;
import com.orquestraagape.musica.servicos.CicloServicos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cadastro/ciclo")
public class CicloControle {

    private final CicloServicos cicloServicos;

    public CicloControle(CicloServicos cicloServicos){
        this.cicloServicos = cicloServicos;
    }

    @PostMapping
    public ResponseEntity<Ciclo> postNovoCiclo(@RequestBody Ciclo novoCiclo){
        Ciclo cicloRegistrado = this.cicloServicos.postNovoCiclo(novoCiclo);
        return ResponseEntity.status(HttpStatus.CREATED).body(cicloRegistrado);
    }

}
