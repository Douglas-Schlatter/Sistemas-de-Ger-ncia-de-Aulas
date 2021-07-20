/*
Tecnicas de Programação-PUCRS
Matricula: 20106324-5
Nome:Douglas Ardenghi Schlatter
Github: https://github.com/Douglas-Schlatter/Sistemas-de-Ger-ncia-de-Aulas
*/
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