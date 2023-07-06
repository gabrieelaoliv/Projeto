package com.iftm.api.agendadecompromisso.services;

import com.iftm.api.agendadecompromisso.data.vo.CompromissoVO;
import com.iftm.api.agendadecompromisso.data.vo.UsuarioVO;
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


@Service
public class CompromissoService {

    @Autowired
    private CompromissoRepository compromissoRepository;

    @Autowired
    private AgendaService agendaService;

    @Autowired
    private UsuarioService usuarioService;

    public List<CompromissoVO> findAll() {
        return DozerMapper.parseListObject(compromissoRepository.findAll(), CompromissoVO.class);
    }

    public CompromissoVO findById(Long id) {
        var dbcompromisso = compromissoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não há compromissos com esse ID"));
        return DozerMapper.parseObject(dbcompromisso, CompromissoVO.class);
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

        return DozerMapper.parseObject(compromisso, CompromissoVO.class);
    }

    public CompromissoVO update(CompromissoVO compromissoVO) {
        if (compromissoVO == null) throw new RequiredObjectIsNullException();

        compromissoRepository.findById(compromissoVO.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Não há registro para esse ID"));

        Compromisso compromisso = DozerMapper.parseObject(compromissoVO, Compromisso.class);

        //fazer a consulta no banco para verificarse a agenda existe

        compromisso = compromissoRepository.save(compromisso);

        compromissoVO = DozerMapper.parseObject(compromisso, CompromissoVO.class);
        return compromissoVO;
    }

    public String delete(Long id) {
        compromissoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Não há registro para esse ID."));

        compromissoRepository.deleteById(id);
        return "Usuário com esse ID " + id + " foi deletado!";
    }
}
