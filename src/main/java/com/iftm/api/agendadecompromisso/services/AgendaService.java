package com.iftm.api.agendadecompromisso.services;

import com.iftm.api.agendadecompromisso.exceptions.ResourceNotFoundException;
import com.iftm.api.agendadecompromisso.models.Agenda;
import com.iftm.api.agendadecompromisso.repositories.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public Agenda findById(Long id) {
        var dbagenda = agendaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não há agendas com esse ID"));

        return dbagenda;
    }
}

