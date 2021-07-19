package com.douglas.ctrlcorredor_v9_JPA.negocio.repositorios;

import java.util.List;

import com.douglas.ctrlcorredor_v9_JPA.negocio.entidades.Corredor;

public interface ICorredorRepository {
    List<Corredor> todos();
    List<Corredor> todos(String cpf);
    void removeTodos();
    boolean cadastra(Corredor corredor);
}
