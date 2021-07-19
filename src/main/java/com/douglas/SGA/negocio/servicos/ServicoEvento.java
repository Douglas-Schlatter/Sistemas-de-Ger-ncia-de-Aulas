package com.douglas.SGA.negocio.servicos;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Evento;
import com.douglas.SGA.negocio.repositorios.IEventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoEvento {
    private IEventoRepository eventoRep;

    @Autowired
    public ServicoEvento(IEventoRepository eventoRep){
        this.eventoRep = eventoRep;
    } 

    public List<Evento> todos(){
        return eventoRep.todos();
    }

    public List<Evento> todos(String cpf){
        return eventoRep.todos(cpf);
    }

    public void cadastra(String cpf, Evento evento){
        eventoRep.cadastra(cpf, evento);
    }
    
}
