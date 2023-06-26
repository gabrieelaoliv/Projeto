package com.iftm.api.agendadecompromisso.controllers;

import com.iftm.api.agendadecompromisso.data.vo.AnotacoesVO;
import com.iftm.api.agendadecompromisso.services.AnotacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/anotacoes")

public class AnotacoesController {

    @Autowired
    private AnotacoesService anotacoesService;

    @GetMapping
    public List<AnotacoesVO> findAll() {
        return anotacoesService.findAll();
    }
}