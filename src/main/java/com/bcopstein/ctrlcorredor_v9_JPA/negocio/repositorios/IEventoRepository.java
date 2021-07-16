package com.bcopstein.ctrlcorredor_v9_JPA.negocio.repositorios;

import java.util.List;

import com.bcopstein.ctrlcorredor_v9_JPA.negocio.entidades.Evento;

public interface IEventoRepository {
    List<Evento> todos();
    List<Evento> todos(String cpf);
    boolean cadastra(String cpf, Evento evento);
}
