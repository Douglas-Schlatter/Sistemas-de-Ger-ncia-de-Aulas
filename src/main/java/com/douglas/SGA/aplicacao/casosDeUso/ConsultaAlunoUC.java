package com.douglas.SGA.aplicacao.casosDeUso;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Aluno;
import com.douglas.SGA.negocio.servicos.ServicoAluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaAlunoUC {
    private ServicoAluno servicoAluno;

    @Autowired
    public ConsultaAlunoUC(ServicoAluno servicoAluno) {
        this.servicoAluno = servicoAluno;
    }
    
    public List<Aluno> run(){
        return servicoAluno.todos();
    }    

    public Aluno run(String cpf){
        return servicoAluno.procurar(cpf);
    }    
}
