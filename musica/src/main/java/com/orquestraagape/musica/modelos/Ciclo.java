package com.orquestraagape.musica.modelos;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "ciclo",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"descricao"})
        }
)
public class Ciclo {

    public Ciclo(){}

    @Id
    @Column(name = "id_ciclo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCiclo;

    @Column(name = "descricao", length = 200, nullable = false)
    private String descricao;

    @ManyToMany
    @JoinTable(
            name = "ciclo_tem_materia",
            joinColumns = @JoinColumn(name = "id_ciclo"),
            inverseJoinColumns = @JoinColumn(name = "id_materia")
    )
    private Set<Materia> materias;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
    }
}
