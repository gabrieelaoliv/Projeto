package com.iftm.api.agendadecompromisso.services;
import com.iftm.api.agendadecompromisso.data.vo.UsuarioVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    public List<UsuarioVO> findAll() {
        UsuarioVO usuarios = new UsuarioVO();

        return List.of(usuarios);//arrayList
    }
}
