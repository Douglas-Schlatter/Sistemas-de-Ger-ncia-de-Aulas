package com.douglas.SGA.adaptadores.repositorios;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Aluno;

import org.springframework.data.repository.CrudRepository;

public interface IAlunoCRUD extends CrudRepository<Aluno,String> {
    List<Aluno> findAll();
    List<Aluno> findByCpf(String cpf);
}