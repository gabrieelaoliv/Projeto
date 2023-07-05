package com.iftm.api.agendadecompromisso.models;

import jakarta.persistence.*;
import org.aspectj.apache.bcel.generic.ObjectType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_compromisso")
public class Compromisso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "descricao", length = 240)
    private String descricao;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "status", nullable = false, length = 20)
    @Enumerated(value = EnumType.STRING) //Enum
    private StatusCompromisso status;

    @ManyToOne
    private Agenda agenda;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="convidados",
            joinColumns = {@JoinColumn(name = "id_compromisso")},
            inverseJoinColumns = {@JoinColumn(name = "id_usuario")})
    private List<Usuario> convidados = new ArrayList<>();

    public Compromisso(){}

    public Compromisso(String titulo, String descricao, Date data, Agenda agenda, List<Usuario> convidados) {
        this.titulo = titulo;
        this.descricao = descricao;
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

    public Date getData() {
        return data;
    }

    public StatusCompromisso getStatus() {
        return status;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public List<Usuario> getConvidados() {
        return convidados;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setStatus(StatusCompromisso status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Compromisso{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", local e data='" + data + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Compromisso compromisso = (Compromisso) o;
        return Objects.equals(id, compromisso.id) && Objects.equals(titulo, compromisso.titulo) &&
                Objects.equals(descricao, compromisso.descricao)
                && Objects.equals(data, compromisso.data) && Objects.equals(status, compromisso.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,titulo, descricao, data, status);
    }
}