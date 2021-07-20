package com.douglas.SGA.aplicacao.casosDeUso;

import com.douglas.SGA.negocio.entidades.Aluno;
import com.douglas.SGA.negocio.servicos.ServicoAluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraAlunoUC {
    private ServicoAluno servicoAluno;

    @Autowired
    public CadastraAlunoUC(ServicoAluno servicoAluno) {
        this.servicoAluno = servicoAluno;
    }
    
    public void run(Aluno aluno){
        servicoAluno.cadastraAluno(aluno);
    }    
}
