/*
Tecnicas de Programação-PUCRS
Matricula: 20106324-5
Nome:Douglas Ardenghi Schlatter
Github: https://github.com/Douglas-Schlatter/Sistemas-de-Ger-ncia-de-Aulas
*/
package com.douglas.SGA.adaptadores.repositorios;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Aluno;

import org.springframework.data.repository.CrudRepository;

public interface IAlunoCRUD extends CrudRepository<Aluno,String> {
    List<Aluno> findAll();
    List<Aluno> findByCpf(String cpf);
    List<Aluno> findByNome(String nome);

}