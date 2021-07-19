package com.douglas.ctrlcorredor_v9_JPA.aplicacao.casosDeUso;

import com.douglas.ctrlcorredor_v9_JPA.negocio.entidades.Aula;
import com.douglas.ctrlcorredor_v9_JPA.negocio.servicos.ServicoAula;
//import com.douglas.ctrlcorredor_v9_JPA.negocio.servicos.ServicoEvento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraAulaUC {
    private ServicoAula servicoAula;

    @Autowired
    public CadastraAulaUC(ServicoAula servicoAula) {
        this.servicoAula = servicoAula;
    }
    
    public void run(String cpf, Aula aula){
        servicoAula.cadastra(cpf, aula);
    }    
}
