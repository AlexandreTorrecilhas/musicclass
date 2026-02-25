package com.orquestraagape.musica.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "RESPONSAVEL")
public class Responsavel {
    @Id
    @Column(name = "id_responsavel")
    private int idResponsavel;

    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @Column(name = "telefone", length = 13, nullable = false)
    private String telefone;

    @OneToOne
    @JoinColumn(name = "id_pessoa", unique = true)
    Pessoa pessoa;
}
