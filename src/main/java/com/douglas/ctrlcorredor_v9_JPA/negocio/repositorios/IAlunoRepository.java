package com.douglas.ctrlcorredor_v9_JPA.negocio.repositorios;

import java.util.List;

import com.douglas.ctrlcorredor_v9_JPA.negocio.entidades.Aluno;

public interface IAlunoRepository {
    List<Aluno> todos();
    List<Aluno> procurar(String cpf);
    boolean cadastra(Aluno aluno);
}
