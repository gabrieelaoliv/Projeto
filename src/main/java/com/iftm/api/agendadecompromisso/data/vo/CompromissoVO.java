package com.iftm.api.agendadecompromisso.data.vo;

import java.time.LocalDateTime;

public class CompromissoVO {

    private Long id;

    private String titulo, descricao, localizacao, statusCompromisso;

    private LocalDateTime dataCompromisso; //salva dia e hora

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getStatusCompromisso() {
        return statusCompromisso;
    }

    public LocalDateTime getDataCompromisso() {
        return dataCompromisso;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setStatusCompromisso(String statusCompromisso) {
        this.statusCompromisso = statusCompromisso;
    }

    public void setDataCompromisso(LocalDateTime dataCompromisso) {
        this.dataCompromisso = dataCompromisso;
    }
}
