
/*
Tecnicas de Programação-PUCRS
Matricula: 20106324-5
Nome:Douglas Ardenghi Schlatter
Github: https://github.com/Douglas-Schlatter/Sistemas-de-Ger-ncia-de-Aulas
*/
package com.douglas.SGA.negocio.repositorios;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Aula;

public interface IAulaRepository 
{
    List<Aula> todos();
    List<Aula> procurar(String id);
    boolean cadastra(String cpf, Aula evento);
}