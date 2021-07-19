package com.douglas.SGA.aplicacao.casosDeUso;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Corredor;
import com.douglas.SGA.negocio.servicos.ServicoCorredor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaCorredoresUC {
    private ServicoCorredor servicoCorredor;

    @Autowired
    public ConsultaCorredoresUC(ServicoCorredor servicoCorredor) {
        this.servicoCorredor = servicoCorredor;
    }
    
    public List<Corredor> run(){
        return servicoCorredor.todos();
    }    

    public List<Corredor> run(String cpf){
        return servicoCorredor.todos(cpf);
    }  
}
