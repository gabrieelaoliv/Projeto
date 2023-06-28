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

    @Column (name = "nome", nullable = false, length = 30)
    private String nome;

    @Column(name = "CPF", nullable = false, length = 11)
    private String cpf;

    @Column(name = "data_nasc", nullable = false, length = 100)
    private LocalDate data_nasc;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "senha", nullable = false, length = 7)
    private String senha;

    public Usuario(Long id, String nome, String cpf, LocalDate data_nasc, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.data_nasc = data_nasc;
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

    public LocalDate getData_nasc() {
        return data_nasc;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setData_nas(LocalDate data_nasc) {
        this.data_nasc = data_nasc;
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
                ", Data de nascimento='" + data_nasc + '\'' +
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
                Objects.equals(cpf, usuario.cpf) && Objects.equals(data_nasc, usuario.data_nasc)
                && Objects.equals(email, usuario.email) && Objects.equals(senha, usuario.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, data_nasc, email, senha);
    }
}