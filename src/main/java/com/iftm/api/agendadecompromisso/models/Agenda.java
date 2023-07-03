package com.iftm.api.agendadecompromisso.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "agenda")
public class Agenda {

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

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Compromisso> getCompromissos() {
        return compromissos;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}