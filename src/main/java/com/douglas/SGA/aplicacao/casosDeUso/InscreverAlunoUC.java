package com.douglas.SGA.aplicacao.casosDeUso;

import com.douglas.SGA.negocio.entidades.Aula;
import com.douglas.SGA.negocio.servicos.ServicoAluno;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InscreverAlunoUC {
    private ServicoAluno servicoAluno;

    @Autowired
    public InscreverAlunoUC(ServicoAluno servicoAluno) {
        this.servicoAluno = servicoAluno;
    }
    
    public boolean run(String cpf, String id){
        return servicoAluno.inscreve(cpf, id);
    }    
}