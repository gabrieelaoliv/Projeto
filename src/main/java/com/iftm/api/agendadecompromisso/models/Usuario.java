package com.iftm.api.agendadecompromisso.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table (name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "CPF", nullable = false, length = 11)
    private String cpf;

    @Column(name = "dataNasc", nullable = false)
    private LocalDate dataNasc;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "senha", nullable = false, length = 7)
    private String senha;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, optional = true)
    private Agenda agenda;

    private Usuario() {}

    public Usuario(String nome, String cpf, LocalDate dataNasc, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", CPF='" + cpf + '\'' +
                ", Data de nascimento='" + dataNasc + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nome, usuario.nome) &&
                Objects.equals(cpf, usuario.cpf) && Objects.equals(dataNasc, usuario.dataNasc)
                && Objects.equals(email, usuario.email) && Objects.equals(senha, usuario.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, dataNasc, email, senha);
    }
}