package com.iftm.api.agendadecompromisso.data.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iftm.api.agendadecompromisso.models.StatusCompromisso;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompromissoVO extends RepresentationModel<CompromissoVO>  implements Serializable {

    private Long id;

    private String titulo, descricao;

    private StatusCompromisso status;

    private Date data; //salva dia e hora

    private List<UsuarioVO> convidados = new ArrayList<>();

    private AgendaVO agenda;
    public CompromissoVO() {}


    public CompromissoVO(String titulo, StatusCompromisso status, Date data, AgendaVO agenda, List<UsuarioVO> convidados) {
        this.titulo = titulo;
        this.status = status;
        this.data = data;
        this.agenda = agenda;
        this.convidados = convidados;
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

    public StatusCompromisso getStatus() {
        return status;
    }

    public Date getData() {
        return data;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(StatusCompromisso status) {
        this.status = status;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AgendaVO getAgenda() {
        return agenda;
    }

    public void setAgenda(AgendaVO agenda) {
        this.agenda = agenda;
    }

    public List<UsuarioVO> getConvidados() {
        return convidados;
    }

    public void setConvidados(List<UsuarioVO> convidados) {
        this.convidados = convidados;
    }

}