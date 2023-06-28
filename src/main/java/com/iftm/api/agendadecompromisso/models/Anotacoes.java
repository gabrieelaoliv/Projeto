package com.iftm.api.agendadecompromisso.models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table (name="anotacoes") //nome da tabela no banco de dados

public class Anotacoes {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_anotacoes;


    //COLOQUEI A CHAVE ESTRANGEIRA, PRECISAVA??????????????????????????????????????
    @Column(name = "id_compromisso", nullable = false, length = 50)
    private String id_compromisso;

    public Anotacoes(Long id, String id_compromisso) {
        this.id_anotacoes = id;
        this.id_compromisso = id_compromisso;
    }

    public Long getId() {
        return id_anotacoes;
    }

    public String getId_compromisso() {
        return id_compromisso;
    }

    public void setId(Long id) {
        this.id_anotacoes = id;
    }

    public void setId_compromisso(String id_compromisso) {
        this.id_compromisso = id_compromisso;
    }

    @Override
    public String toString() {
        return "Anotacoes{" +
                "id=" + id_anotacoes + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Anotacoes anotacoes = (Anotacoes) o;
        return Objects.equals(id_compromisso, anotacoes.id_compromisso) &&
                Objects.equals(id_compromisso, anotacoes.id_compromisso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_anotacoes, id_compromisso);
    }
}
