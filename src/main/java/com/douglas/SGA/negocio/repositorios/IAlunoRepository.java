package com.douglas.SGA.negocio.repositorios;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Aluno;

public interface IAlunoRepository {
    List<Aluno> todos();
    Aluno procurar(String cpf);
    public boolean inscreve(String nome,String id);
    boolean cadastra(Aluno aluno);
}
