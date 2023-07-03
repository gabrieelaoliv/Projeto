package com.iftm.api.agendadecompromisso.repositories;

import com.iftm.api.agendadecompromisso.models.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
