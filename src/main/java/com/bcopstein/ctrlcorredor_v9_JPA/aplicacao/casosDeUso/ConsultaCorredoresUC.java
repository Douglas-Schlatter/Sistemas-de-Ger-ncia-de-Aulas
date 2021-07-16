package com.bcopstein.ctrlcorredor_v9_JPA.aplicacao.casosDeUso;

import java.util.List;

import com.bcopstein.ctrlcorredor_v9_JPA.negocio.entidades.Corredor;
import com.bcopstein.ctrlcorredor_v9_JPA.negocio.servicos.ServicoCorredor;

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
