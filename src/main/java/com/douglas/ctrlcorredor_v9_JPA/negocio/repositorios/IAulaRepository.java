package com.douglas.ctrlcorredor_v9_JPA.negocio.repositorios;

import java.util.List;

import com.douglas.ctrlcorredor_v9_JPA.negocio.entidades.Aula;

public interface IAulaRepository 
{
    List<Aula> todos();
    List<Aula> procurar(String cpf);
    boolean cadastra(String cpf, Aula evento);
}