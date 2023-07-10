package com.iftm.api.agendadecompromisso.services;

import com.iftm.api.agendadecompromisso.controllers.UsuarioController;
import com.iftm.api.agendadecompromisso.data.vo.UsuarioVO;
import com.iftm.api.agendadecompromisso.exceptions.RequiredObjectIsNullException;
import com.iftm.api.agendadecompromisso.exceptions.ResourceNotFoundException;
import com.iftm.api.agendadecompromisso.mapper.DozerMapper;
import com.iftm.api.agendadecompromisso.models.Agenda;
import com.iftm.api.agendadecompromisso.models.Compromisso;
import com.iftm.api.agendadecompromisso.models.Usuario;
import com.iftm.api.agendadecompromisso.repositories.AgendaRepository;
import com.iftm.api.agendadecompromisso.repositories.CompromissoRepository;
import com.iftm.api.agendadecompromisso.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private CompromissoRepository compromissoRepository;

    public UsuarioVO update(UsuarioVO usuarioVO) {
        if (usuarioVO == null) throw new RequiredObjectIsNullException();

        var dbuser = usuarioRepository.findById(usuarioVO.getId()).orElseThrow(() -> new ResourceNotFoundException("Não há registro para esse ID"));

        Usuario user = DozerMapper.parseObject(usuarioVO, Usuario.class);
        Agenda agenda = agendaRepository.findById(dbuser.getAgenda().getId()).orElseThrow(() -> new ResourceNotFoundException("Não há agenda para esse ID"));
        user.setAgenda(agenda);
        agenda.setUsuario(user);

        user = usuarioRepository.save(user);

        usuarioVO = DozerMapper.parseObject(user, UsuarioVO.class);
        return usuarioVO;
    }

   public List<UsuarioVO> findAll() {
        var users = DozerMapper.parseListObject(usuarioRepository.findAll(), UsuarioVO.class);
        users.stream().forEach(user -> {
            user.add(linkTo(methodOn(UsuarioController.class).findById(user.getId()))
                    .withSelfRel()
            );
        });

        return users;
    }

    public UsuarioVO findById(Long id) {
        var dbusuario = usuarioRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Não há registro para esse ID"));
        var user = DozerMapper.parseObject(dbusuario, UsuarioVO.class);
        user.add(linkTo(methodOn(UsuarioController.class).findById(id)).withSelfRel());
        return user;
    }

    public UsuarioVO salvarUsuario(UsuarioVO usuarioVO) {
        Usuario usuario = DozerMapper.parseObject(usuarioVO, Usuario.class);
        Usuario dbuser = usuarioRepository.save(usuario);

        Agenda novaAgenda = new Agenda();
        novaAgenda.setUsuario(dbuser);
        agendaRepository.save(novaAgenda);
        dbuser.setAgenda(novaAgenda);
        dbuser = usuarioRepository.save(usuario);

        usuarioVO = DozerMapper.parseObject(dbuser, UsuarioVO.class);
        usuarioVO.add(linkTo(methodOn(UsuarioController.class)
                .findById(usuarioVO.getId())).withSelfRel());
        return usuarioVO;
    }

    public String delete(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não há registro para esse ID."));

        List<Compromisso> listaDeCompromisso = compromissoRepository.findAllByConvidados_Id(id);

        listaDeCompromisso.forEach(compromisso -> {
            compromisso.getConvidados().remove(usuario);
        });

        compromissoRepository.saveAll(listaDeCompromisso);

        usuarioRepository.deleteById(id);
        return "Usuário com esse ID " + id + " foi deletado!";
    }

    public List<Usuario> findAllById(List<Long> idsUsuarios) {
        return usuarioRepository.findAllById(idsUsuarios);
    }
}
