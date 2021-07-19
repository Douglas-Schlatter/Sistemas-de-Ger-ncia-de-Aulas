package com.douglas.SGA.negocio.repositorios;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Corredor;

public interface ICorredorRepository {
    List<Corredor> todos();
    List<Corredor> todos(String cpf);
    void removeTodos();
    boolean cadastra(Corredor corredor);
}
