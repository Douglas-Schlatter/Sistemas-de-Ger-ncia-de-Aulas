
/*
Tecnicas de Programação-PUCRS
Matricula: 20106324-5
Nome:Douglas Ardenghi Schlatter
Github: https://github.com/Douglas-Schlatter/Sistemas-de-Ger-ncia-de-Aulas
*/
package com.douglas.SGA.negocio.servicos;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Aluno;
import com.douglas.SGA.negocio.repositorios.IAlunoRepository;

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

    public Aluno procurar(String cpf){
        return alunoRep.procurar(cpf);
    }

    public boolean cadastraAluno(Aluno aluno){
        //
        // agora tenho vários alunoes
        //
        //alunoRep.removeTodos();
        return alunoRep.cadastra(aluno);
    }
    public boolean inscreve(String nome,String id){
        return alunoRep.inscreve(nome,id);
    }
}
