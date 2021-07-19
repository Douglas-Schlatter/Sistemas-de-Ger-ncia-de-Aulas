package com.douglas.ctrlcorredor_v9_JPA.adaptadores.repositorios;

import java.util.List;

import com.douglas.ctrlcorredor_v9_JPA.negocio.entidades.Aula;

import org.springframework.data.repository.CrudRepository;

public interface IAulaCRUD extends CrudRepository<Aula,String> {
    List<Aula> findAll();
    List<Aula> findByString(String idComposto);
}