package com.orquestraagape.musica.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "RESPONSAVEL")
public class Responsavel {
    @Id /*IT IS MANDATORY TO MARK A COLUMN AS ID*/
    @Column(name = "id_pessoa")
    private int idResponsavel;

    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @Column(name = "telefone", length = 13, nullable = false)
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId /*IT MAKES EXPLICITY THAT THE REAL VALUE TO THE PRIMARY KEY COMES FROM ITS FOREIGN KEY OBJECT*/
    @JoinColumn(name = "id_pessoa", unique = true)
    Pessoa pessoa;

    public int getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(int idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
