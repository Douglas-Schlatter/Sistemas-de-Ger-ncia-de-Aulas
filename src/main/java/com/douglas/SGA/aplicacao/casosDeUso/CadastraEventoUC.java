package com.douglas.SGA.aplicacao.casosDeUso;

import com.douglas.SGA.negocio.entidades.Evento;
import com.douglas.SGA.negocio.servicos.ServicoEvento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraEventoUC {
    private ServicoEvento servicoEvento;

    @Autowired
    public CadastraEventoUC(ServicoEvento servicoEvento) {
        this.servicoEvento = servicoEvento;
    }
    
    public void run(String cpf, Evento evento){
        servicoEvento.cadastra(cpf, evento);
    }    
}
