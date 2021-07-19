package com.douglas.SGA.adaptadores.repositorios;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Evento;

import org.springframework.data.repository.CrudRepository;

public interface IEventoCRUD extends CrudRepository<Evento,Integer> {
    List<Evento> findAll();
    List<Evento> findById(int id);
}
