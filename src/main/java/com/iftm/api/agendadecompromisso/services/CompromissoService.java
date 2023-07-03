package com.iftm.api.agendadecompromisso.services;
import com.iftm.api.agendadecompromisso.data.vo.CompromissoVO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompromissoService {
    public List<CompromissoVO> findAll() {

        CompromissoVO compromisso = new  CompromissoVO();

        return List.of(compromisso);

    }

}