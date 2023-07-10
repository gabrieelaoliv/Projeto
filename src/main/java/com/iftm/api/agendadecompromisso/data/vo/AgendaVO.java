package com.iftm.api.agendadecompromisso.data.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AgendaVO extends RepresentationModel<AgendaVO> implements Serializable {

    private Long id;
    private UsuarioVO usuario;
    private List<CompromissoVO> compromissos = new ArrayList<>();

    public AgendaVO() {
    }

    public AgendaVO(UsuarioVO usuario, List<CompromissoVO> compromissos) {
        this.usuario = usuario;
        this.compromissos = compromissos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    @JsonIgnore
    public List<CompromissoVO> getCompromissos() {
        return compromissos;
    }

    public void setCompromissos(List<CompromissoVO> compromissos) {
        this.compromissos = compromissos;
    }
}
