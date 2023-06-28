package com.iftm.api.agendadecompromisso.repositories;
import com.iftm.api.agendadecompromisso.models.Anotacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//responsável por interagir com o banco de dados

@Repository
public interface AnotacoesRepository extends JpaRepository<Anotacoes, Long> {
}
