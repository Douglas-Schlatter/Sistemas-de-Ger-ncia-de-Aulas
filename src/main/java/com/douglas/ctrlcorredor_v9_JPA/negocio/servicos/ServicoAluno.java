package com.douglas.ctrlcorredor_v9_JPA.negocio.servicos;

import java.util.List;

import com.douglas.ctrlcorredor_v9_JPA.negocio.entidades.Aluno;
import com.douglas.ctrlcorredor_v9_JPA.negocio.repositorios.IAlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoAluno {
    public IAlunoRepository alunoRep;

    @Autowired
    public ServicoAluno(IAlunoRepository alunoRep){
        this.alunoRep = alunoRep;
    }

    public List<Aluno> todos(){
        return alunoRep.todos();
    }

    public List<Aluno> procurar(String cpf){
        return alunoRep.procurar(cpf);
    }

    public void cadastraAluno(Aluno aluno){
        //
        // agora tenho vários alunoes
        //
        //alunoRep.removeTodos();
        alunoRep.cadastra(aluno);
    }
    
}
