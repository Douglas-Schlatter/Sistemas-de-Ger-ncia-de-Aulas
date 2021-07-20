package com.douglas.SGA.aplicacao.casosDeUso;

import com.douglas.SGA.aplicacao.dtos.totalDTO;
import com.douglas.SGA.aplicacao.servicos.ServicoInformarTotal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InformarTotalUC {
    private ServicoInformarTotal servicoInformar;

    @Autowired
    public InformarTotalUC(ServicoInformarTotal servicoInformar) {
        this.servicoInformar = servicoInformar;
    }

    public totalDTO run(String codcred)
    {
        return servicoInformar.totalIns(codcred);
    }    
}