package com.orquestraagape.musica.modelos;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "materias",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"descricao"})
        }
)
public class Materia {

    public Materia(){}

    @Id
    @Column(name = "id_materia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMateria;

    @Column(name = "descricao", length = 200)
    private String descricao;

    @ManyToMany(mappedBy = "materias")
    private Set<Ciclo> ciclo;

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
