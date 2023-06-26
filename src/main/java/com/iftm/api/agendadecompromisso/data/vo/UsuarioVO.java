package com.iftm.api.agendadecompromisso.data.vo;

import java.time.LocalDate;

public class UsuarioVO {
    private String nome, email, senha, cpf;

    private LocalDate data;

    private Long id;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getData() {
        return data;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
