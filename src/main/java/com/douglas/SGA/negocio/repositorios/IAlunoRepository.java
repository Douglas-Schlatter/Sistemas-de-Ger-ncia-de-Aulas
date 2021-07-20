
/*
Tecnicas de Programação-PUCRS
Matricula: 20106324-5
Nome:Douglas Ardenghi Schlatter
Github: https://github.com/Douglas-Schlatter/Sistemas-de-Ger-ncia-de-Aulas
*/
package com.douglas.SGA.negocio.repositorios;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Aluno;

public interface IAlunoRepository {
    List<Aluno> todos();
    Aluno procurar(String cpf);
    public boolean inscreve(String nome,String id);
    boolean cadastra(Aluno aluno);
}
