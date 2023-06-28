package com.iftm.api.agendadecompromisso.repositories;
import com.iftm.api.agendadecompromisso.models.Compromisso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompromissoRepository extends JpaRepository<Compromisso, Long> {
}
