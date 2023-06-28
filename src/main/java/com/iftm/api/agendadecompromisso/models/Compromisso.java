package com.iftm.api.agendadecompromisso.models;

import jakarta.persistence.*;
import org.aspectj.apache.bcel.generic.ObjectType;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "compromisso")
public class Compromisso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "descricao", nullable = false, length = 500)
    private String descricao;

    @Column(name = "localizao", nullable = false, length = 100)
    private String localizacao;

    @Column(name = "data", nullable = false, length = 100)
    private LocalDateTime data;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    public Compromisso(Long id, String titulo, String descricao, String localizacao, LocalDateTime data, String status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.data = data;
        this.status = status;
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

    public String getLocalizacao() {
        return localizacao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getStatus() {
        return status;
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

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Compromisso{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", localizao='" + localizacao + '\'' +
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
                Objects.equals(descricao, compromisso.descricao) && Objects.equals(localizacao, compromisso.localizacao)
                && Objects.equals(data, compromisso.data) && Objects.equals(status, compromisso.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,titulo, descricao, localizacao, data, status);
    }
}