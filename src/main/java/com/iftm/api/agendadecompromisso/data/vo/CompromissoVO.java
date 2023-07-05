package com.iftm.api.agendadecompromisso.data.vo;

import java.io.Serializable;
import java.util.Date;

public class CompromissoVO implements Serializable {

    private Long id;

    private String titulo, descricao, statusCompromisso;

    private Date dataCompromisso; //salva dia e hora

    public CompromissoVO(String titulo, String descricao, String statusCompromisso, Date dataCompromisso) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.statusCompromisso = statusCompromisso;
        this.dataCompromisso = dataCompromisso;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

     public String getStatusCompromisso() {
        return statusCompromisso;
    }

    public Date getDataCompromisso() {
        return dataCompromisso;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatusCompromisso(String statusCompromisso) {
        this.statusCompromisso = statusCompromisso;    }

    public void setDataCompromisso(Date dataCompromisso) {
        this.dataCompromisso = dataCompromisso;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
