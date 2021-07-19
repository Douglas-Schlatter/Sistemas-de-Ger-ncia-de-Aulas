package com.douglas.SGA.negocio.repositorios;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Aluno;

public interface IAlunoRepository {
    List<Aluno> todos();
    List<Aluno> procurar(String cpf);
    boolean cadastra(Aluno aluno);
}
