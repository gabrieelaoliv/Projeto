package com.iftm.api.agendadecompromisso.services;
import com.iftm.api.agendadecompromisso.data.vo.UsuarioVO;
import com.iftm.api.agendadecompromisso.mapper.DozerMapper;
import com.iftm.api.agendadecompromisso.models.Agenda;
import com.iftm.api.agendadecompromisso.models.Usuario;
import com.iftm.api.agendadecompromisso.repositories.AgendaRepository;
import com.iftm.api.agendadecompromisso.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    public UsuarioVO update(UsuarioVO usuarioVO) {
        //criado através do UsuarioController

        return usuarioVO;
    }

    public List<UsuarioVO> findAll() {
        return DozerMapper.parseListObject(usuarioRepository.findAll(), UsuarioVO.class);
    }

    public UsuarioVO salvarUsuario(UsuarioVO usuarioVO) {
        Usuario usuario = DozerMapper.parseObject(usuarioVO, Usuario.class);
        Usuario dbuser = usuarioRepository.save(usuario);

        Agenda novaAgenda = new Agenda();
        novaAgenda.setUsuario(dbuser);
        agendaRepository.save(novaAgenda);
        dbuser.setAgenda(novaAgenda);
        dbuser = usuarioRepository.save(usuario);

        return DozerMapper.parseObject(dbuser, UsuarioVO.class);
    }

    public String delete(Long id) {
        return "User with id " + id + " has been deleted!";
        //criado através do deletemapping UsuarioController
    }
}
