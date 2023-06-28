package com.iftm.api.agendadecompromisso.repositories;
import com.iftm.api.agendadecompromisso.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
