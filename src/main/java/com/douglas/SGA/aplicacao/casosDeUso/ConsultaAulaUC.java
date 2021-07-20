/*
Tecnicas de Programação-PUCRS
Matricula: 20106324-5
Nome:Douglas Ardenghi Schlatter
Github: https://github.com/Douglas-Schlatter/Sistemas-de-Ger-ncia-de-Aulas
*/
package com.douglas.SGA.aplicacao.casosDeUso;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Aula;
import com.douglas.SGA.negocio.servicos.ServicoAula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaAulaUC {
    private ServicoAula servicoAula;

    @Autowired
    public ConsultaAulaUC(ServicoAula servicoAula) {
        this.servicoAula = servicoAula;
    }
    
    public List<Aula> run(){
        return servicoAula.todos();
    }   
    
    public List<Aula> run(String cpf){
        return servicoAula.procurar(cpf);
    } 
    
}
