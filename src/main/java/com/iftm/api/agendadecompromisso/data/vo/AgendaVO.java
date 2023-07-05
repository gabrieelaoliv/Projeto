package com.iftm.api.agendadecompromisso.data.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iftm.api.agendadecompromisso.models.Compromisso;
import com.iftm.api.agendadecompromisso.models.Usuario;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AgendaVO implements Serializable  {

    private Long id;
    private Usuario usuario;
    private List<Compromisso> compromissos = new ArrayList<>();

    public AgendaVO() {
    }

    public AgendaVO(Usuario usuario, List<Compromisso> compromissos) {
        this.usuario = usuario;
        this.compromissos = compromissos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //@JsonIgnore
    public Usuario getUsuario() {

        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Compromisso> getCompromissos() {
        return compromissos;
    }

    public void setCompromissos(List<Compromisso> compromissos) {
        this.compromissos = compromissos;
    }
}
