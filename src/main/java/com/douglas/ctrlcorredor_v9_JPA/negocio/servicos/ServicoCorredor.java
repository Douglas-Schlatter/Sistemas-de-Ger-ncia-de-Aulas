package com.douglas.ctrlcorredor_v9_JPA.negocio.servicos;

import java.util.List;

import com.douglas.ctrlcorredor_v9_JPA.negocio.entidades.Corredor;
import com.douglas.ctrlcorredor_v9_JPA.negocio.repositorios.ICorredorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoCorredor {
    public ICorredorRepository corredorRep;

    @Autowired
    public ServicoCorredor(ICorredorRepository corredorRep){
        this.corredorRep = corredorRep;
    }

    public List<Corredor> todos(){
        return corredorRep.todos();
    }

    public List<Corredor> todos(String cpf){
        return corredorRep.todos(cpf);
    }

    public void cadastraCorredor(Corredor corredor){
        //
        // agora tenho vários corredores
        //
        //corredorRep.removeTodos();
        corredorRep.cadastra(corredor);
    }
    
}
