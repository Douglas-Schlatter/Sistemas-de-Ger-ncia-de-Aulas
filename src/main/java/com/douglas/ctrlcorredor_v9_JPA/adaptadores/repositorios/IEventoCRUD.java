package com.douglas.ctrlcorredor_v9_JPA.adaptadores.repositorios;

import java.util.List;

import com.douglas.ctrlcorredor_v9_JPA.negocio.entidades.Evento;

import org.springframework.data.repository.CrudRepository;

public interface IEventoCRUD extends CrudRepository<Evento,Integer> {
    List<Evento> findAll();
    List<Evento> findById(int id);
}