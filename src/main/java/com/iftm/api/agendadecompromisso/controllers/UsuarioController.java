package com.iftm.api.agendadecompromisso.controllers;
import com.iftm.api.agendadecompromisso.data.vo.UsuarioVO;
import com.iftm.api.agendadecompromisso.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping ("/{id}")
    public UsuarioVO findById(@PathVariable("id") Long id) throws Exception {
        return usuarioService.findById(id);
    }

    @PostMapping
    public UsuarioVO save (@RequestBody UsuarioVO usuarioVO) {
        return usuarioService.salvarUsuario(usuarioVO);
    }

    @PutMapping ("/{id}")
    public UsuarioVO update(@RequestBody UsuarioVO usuarioVO) {
        return usuarioService.update(usuarioVO);
    }

    @DeleteMapping ("/{id}")
    public String delete(@PathVariable("id") Long id) {
        return usuarioService.delete(id);
    }



}
