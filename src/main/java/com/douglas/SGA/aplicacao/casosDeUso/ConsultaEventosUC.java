package com.douglas.SGA.aplicacao.casosDeUso;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Evento;
import com.douglas.SGA.negocio.servicos.ServicoEvento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaEventosUC {
    private ServicoEvento servicoEvento;

    @Autowired
    public ConsultaEventosUC(ServicoEvento servicoEvento) {
        this.servicoEvento = servicoEvento;
    }
    
    public List<Evento> run(){
        return servicoEvento.todos();
    }   
    
    public List<Evento> run(String cpf){
        return servicoEvento.todos(cpf);
    } 
    
}
