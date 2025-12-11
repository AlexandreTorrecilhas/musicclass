package com.orquestraagape.musica.Controles;

import com.orquestraagape.musica.modelos.Materia;
import com.orquestraagape.musica.servicos.MateriaServicos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro/materia")
public class MateriaControle {

    private final MateriaServicos materiaServicos;

    public MateriaControle(MateriaServicos materiaServicos){
        this.materiaServicos = materiaServicos;
    }

    @PostMapping
    public ResponseEntity<Materia> postNovaMateria(@RequestBody Materia novaMateria){
        Materia materia = this.materiaServicos.postNovaMateria(novaMateria);
        return ResponseEntity.status(HttpStatus.CREATED).body(materia);
    }

}
