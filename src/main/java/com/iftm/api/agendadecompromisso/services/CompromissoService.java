package com.iftm.api.agendadecompromisso.services;

import com.iftm.api.agendadecompromisso.controllers.CompromissoController;
import com.iftm.api.agendadecompromisso.data.vo.CompromissoVO;
import com.iftm.api.agendadecompromisso.exceptions.RequiredObjectIsNullException;
import com.iftm.api.agendadecompromisso.exceptions.ResourceNotFoundException;
import com.iftm.api.agendadecompromisso.mapper.DozerMapper;
import com.iftm.api.agendadecompromisso.models.Agenda;
import com.iftm.api.agendadecompromisso.models.Compromisso;
import com.iftm.api.agendadecompromisso.models.StatusCompromisso;
import com.iftm.api.agendadecompromisso.models.Usuario;
import com.iftm.api.agendadecompromisso.repositories.CompromissoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Service
public class CompromissoService {

    @Autowired
    private CompromissoRepository compromissoRepository;

    @Autowired
    private AgendaService agendaService;

    @Autowired
    private UsuarioService usuarioService;

    public List<CompromissoVO> findAll() {
        var compromissos =  DozerMapper.parseListObject(compromissoRepository.findAll(), CompromissoVO.class);
        compromissos.stream().forEach(comp -> {
            comp.add(linkTo(methodOn(CompromissoController.class).findById(comp.getId()))
                    .withSelfRel()
            );
        });

        return compromissos;
    }

    public CompromissoVO findById(Long id) {
        var dbcompromisso = compromissoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não há compromissos com esse ID"));
        var compromisso = DozerMapper.parseObject(dbcompromisso, CompromissoVO.class);
        compromisso.add(linkTo(methodOn(CompromissoController.class).findById(id)).withSelfRel());
        return compromisso;
    }

    public CompromissoVO salvarCompromisso(CompromissoVO compromissoVO) {
        Compromisso compromisso = DozerMapper.parseObject(compromissoVO, Compromisso.class);
        compromisso.setStatus(StatusCompromisso.A_REALIZAR);

        Agenda agenda = agendaService.findById(compromissoVO.getAgenda().getId());
        compromisso.setAgenda(agenda);
        compromisso.getAgenda().getCompromissos().add(compromisso);

        List<Long> idsUsuarios = compromisso.getConvidados().stream().map(convidado -> convidado.getId()).toList();
        List<Usuario> dbUsuarios = usuarioService.findAllById(idsUsuarios);
        compromisso.setConvidados(dbUsuarios);

        compromisso = compromissoRepository.save(compromisso);

        compromissoVO = DozerMapper.parseObject(compromisso, CompromissoVO.class);
        compromissoVO.add(linkTo(methodOn(CompromissoController.class)
                .findById(compromissoVO.getId())).withSelfRel());
        return compromissoVO;
    }

    public CompromissoVO update(CompromissoVO compromissoVO) {
        if (compromissoVO == null) throw new RequiredObjectIsNullException();

        compromissoRepository.findById(compromissoVO.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Não há registro para esse ID"));

        Compromisso compromisso = DozerMapper.parseObject(compromissoVO, Compromisso.class);

        compromisso = compromissoRepository.save(compromisso);

        compromissoVO = DozerMapper.parseObject(compromisso, CompromissoVO.class);
        compromissoVO.add(linkTo(methodOn(CompromissoController.class)
                .findById(compromissoVO.getId())).withSelfRel());
        return compromissoVO;

    }

    public String delete(Long id) {
        compromissoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Não há registro para esse ID."));

        compromissoRepository.deleteById(id);
        return "Compromisso com esse ID " + id + " foi deletado!";
    }

    public List<CompromissoVO> findByTitulo(String texto) {

        List<Compromisso> listaTitulo = compromissoRepository.findByTitulo(texto);

        var compromissos = DozerMapper.parseListObject(compromissoRepository.findByTitulo(texto), CompromissoVO.class);
        compromissos.stream().forEach(comp -> {
            comp.add(linkTo(methodOn(CompromissoController.class).findById(comp.getId()))
                    .withSelfRel());
        });
        return compromissos;
    }

}

