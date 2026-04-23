package com.orquestraagape.musica.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PessoaDTO {
    private String nome;
    private String cpf;
    private String telefone;
    private String dtNascimento;
    @JsonProperty("estudante")
    private boolean isEstudante;
    @JsonProperty("empregado")
    private boolean isEmpregado;
    @JsonProperty("responsavel")
    private boolean isResponsavel;
    private boolean temInstrumento;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
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

    public boolean isResponsavel() {
        return isResponsavel;
    }

    public void setResponsavel(boolean responsavel) {
        isResponsavel = responsavel;
    }
}
