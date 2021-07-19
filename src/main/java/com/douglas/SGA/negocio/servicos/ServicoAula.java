package com.douglas.SGA.negocio.servicos;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Aula;
import com.douglas.SGA.negocio.repositorios.IAulaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoAula {
    private IAulaRepository aulaRep;

    @Autowired
    public ServicoAula(IAulaRepository aulaRep){
        this.aulaRep = aulaRep;
    } 

    public List<Aula> todos(){
        return aulaRep.todos();
    }

    public List<Aula> procurar(String cpf){
        return aulaRep.procurar(cpf);
    }

    public void cadastra(String cpf, Aula aula){
        aulaRep.cadastra(cpf, aula);
    }
    
}
