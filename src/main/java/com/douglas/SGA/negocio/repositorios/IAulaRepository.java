package com.douglas.SGA.negocio.repositorios;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Aula;

public interface IAulaRepository 
{
    List<Aula> todos();
    List<Aula> procurar(String id);
    boolean cadastra(String cpf, Aula evento);
}