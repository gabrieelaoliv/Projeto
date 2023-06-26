package com.iftm.api.agendadecompromisso.controllers;
import com.iftm.api.agendadecompromisso.data.vo.UsuarioVO;
import com.iftm.api.agendadecompromisso.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioVO> findAll() {
        return usuarioService.findAll();
    }
}
