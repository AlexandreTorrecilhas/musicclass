package com.orquestraagape.musica.modelos;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "PESSOA",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"nome, dt_nascimento"})
        }
)
public class Pessoa {

    public Pessoa(){}

    @Column(name = "id_pessoa")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPessoa;

    @Column(name = "nome", length = 500, nullable = false)
    private String nome;

    @Column(name = "dt_nascimento")
    private Date dtNascimento;

    @Column(name = "estudante")
    private boolean isEstudante;

    @Column(name = "empregado")
    private boolean isEmpregado;

    @Column(name = "teminstrumentodesejado")
    private boolean temInstrumento;

    @Column(name = "email", length = 500)
    private String email;

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public boolean isEstudante() {
        return isEstudante;
    }

    public void setEstudante(boolean estudante) {
        isEstudante = estudante;
    }

    public boolean isEmpregado() {
        return isEmpregado;
    }

    public void setEmpregado(boolean empregado) {
        isEmpregado = empregado;
    }

    public boolean isTemInstrumento() {
        return temInstrumento;
    }

    public void setTemInstrumento(boolean temInstrumento) {
        this.temInstrumento = temInstrumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
