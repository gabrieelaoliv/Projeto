package com.iftm.api.agendadecompromisso.controllers;

import com.iftm.api.agendadecompromisso.data.vo.CompromissoVO;
import com.iftm.api.agendadecompromisso.services.CompromissoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
