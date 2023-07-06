package com.iftm.api.agendadecompromisso.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "tb_agenda")
public class Agenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToMany(mappedBy = "agenda", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Compromisso> compromissos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    // @JsonIgnore
    public Usuario getUsuario() {
        return usuario;
    }

    public List<Compromisso> getCompromissos() {
        return compromissos;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCompromissos(List<Compromisso> compromissos) {
        this.compromissos = compromissos;
    }
}