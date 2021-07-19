package com.douglas.SGA.negocio.repositorios;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Evento;

public interface IEventoRepository {
    List<Evento> todos();
    List<Evento> todos(String cpf);
    boolean cadastra(String cpf, Evento evento);
}
