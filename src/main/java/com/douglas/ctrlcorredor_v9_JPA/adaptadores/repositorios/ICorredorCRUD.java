package com.douglas.ctrlcorredor_v9_JPA.adaptadores.repositorios;

import java.util.List;

import com.douglas.ctrlcorredor_v9_JPA.negocio.entidades.Corredor;

import org.springframework.data.repository.CrudRepository;

public interface ICorredorCRUD extends CrudRepository<Corredor,String> {
    List<Corredor> findAll();
    List<Corredor> findByCpf(String cpf);
}
