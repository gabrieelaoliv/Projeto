package com.iftm.api.agendadecompromisso.controllers;

import com.iftm.api.agendadecompromisso.data.vo.CompromissoVO;
import com.iftm.api.agendadecompromisso.data.vo.UsuarioVO;
import com.iftm.api.agendadecompromisso.services.CompromissoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/compromisso")

public class CompromissoController {
    @Autowired
    private CompromissoService compromissoService;

    @GetMapping
    public List<CompromissoVO> findAll() {
        return compromissoService.findAll();
    }
    @GetMapping("/{id}")
    public CompromissoVO findById(@PathVariable("id") Long id) {
        return compromissoService.findById(id);
    }

    @PostMapping
    public CompromissoVO save (@RequestBody CompromissoVO compromissoVO) {
        return compromissoService.salvarCompromisso(compromissoVO);
    }

    @PutMapping
    public CompromissoVO update(@RequestBody CompromissoVO compromissoVO) {
        return compromissoService.update(compromissoVO);
    }

    @DeleteMapping ("/{id}")
    public String delete(@PathVariable("id") Long id) {
        return compromissoService.delete(id);
    }






}
