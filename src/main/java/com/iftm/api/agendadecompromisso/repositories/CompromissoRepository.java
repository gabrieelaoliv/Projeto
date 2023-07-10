package com.iftm.api.agendadecompromisso.repositories;

import com.iftm.api.agendadecompromisso.models.Compromisso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompromissoRepository extends JpaRepository<Compromisso, Long> {

  //@Query ("SELECT c from Compromisso c WHERE c.convidados.id IN (:id)")
    List<Compromisso> findAllByConvidados_Id(Long id);

    @Query("SELECT c FROM Compromisso c WHERE c.titulo LIKE %:titulo% ")
    List<Compromisso> findByTitulo(@Param("titulo") String texto);




}
