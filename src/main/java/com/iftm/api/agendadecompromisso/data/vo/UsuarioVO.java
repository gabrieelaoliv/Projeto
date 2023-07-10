package com.iftm.api.agendadecompromisso.data.vo;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;

public class UsuarioVO extends RepresentationModel<UsuarioVO> implements Serializable {

    private Long id;
    private String nome;
    private String cpf;
    private Date dataNasc;
    private String email;
    private String senha;
    private AgendaVO agenda;

    public UsuarioVO() {
    }

    public UsuarioVO(String nome, String cpf, Date dataNasc, String email, String senha, AgendaVO agenda) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.email = email;
        this.senha = senha;
        this.agenda = agenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public AgendaVO getAgenda() {
        return agenda;
    }

    public void setAgenda(AgendaVO agenda) {
        this.agenda = agenda;
    }
}
