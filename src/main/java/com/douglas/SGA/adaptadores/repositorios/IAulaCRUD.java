package com.douglas.SGA.adaptadores.repositorios;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Aula;

import org.springframework.data.repository.CrudRepository;

public interface IAulaCRUD extends CrudRepository<Aula,String> {
    List<Aula> findAll();
    List<Aula> findByIdComposto(String idComposto);
}
