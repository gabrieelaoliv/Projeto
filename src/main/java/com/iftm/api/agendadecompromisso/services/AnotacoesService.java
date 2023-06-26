// lógica de negócio

package com.iftm.api.agendadecompromisso.services;
import com.iftm.api.agendadecompromisso.data.vo.AnotacoesVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnotacoesService {
    public List<AnotacoesVO> findAll() {
       AnotacoesVO anotacoes = new AnotacoesVO();
       // anotacoes.setId(1L);
       // anotacoes.setDescricao("Anotacoes que nao gostamos");

        return List.of(anotacoes); //arrayList
    }
}
