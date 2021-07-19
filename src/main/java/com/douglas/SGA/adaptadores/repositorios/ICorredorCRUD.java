package com.douglas.SGA.adaptadores.repositorios;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Corredor;

import org.springframework.data.repository.CrudRepository;

public interface ICorredorCRUD extends CrudRepository<Corredor,String> {
    List<Corredor> findAll();
    List<Corredor> findByCpf(String cpf);
}
