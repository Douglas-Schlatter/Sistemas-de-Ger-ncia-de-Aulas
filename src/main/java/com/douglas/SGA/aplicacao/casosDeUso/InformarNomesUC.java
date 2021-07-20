package com.douglas.SGA.aplicacao.casosDeUso;

import com.douglas.SGA.aplicacao.dtos.nomesDTO;
import com.douglas.SGA.aplicacao.servicos.ServicoInformarNomes;
import com.douglas.SGA.negocio.entidades.Aula;
import com.douglas.SGA.negocio.servicos.ServicoAluno;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InformarNomesUC {
    private ServicoInformarNomes servicoInformar;

    @Autowired
    public InformarNomesUC(ServicoInformarNomes servicoInformar) {
        this.servicoInformar = servicoInformar;
    }

    public nomesDTO run(String id)
    {
        return servicoInformar.inscritos(id);
    }    
}