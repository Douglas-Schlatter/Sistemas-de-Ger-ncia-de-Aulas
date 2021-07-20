/*
Tecnicas de Programação-PUCRS
Matricula: 20106324-5
Nome:Douglas Ardenghi Schlatter
Github: https://github.com/Douglas-Schlatter/Sistemas-de-Ger-ncia-de-Aulas
*/
package com.douglas.SGA.adaptadores.repositorios;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Aula;

import org.springframework.data.repository.CrudRepository;

public interface IAulaCRUD extends CrudRepository<Aula,String> {
    List<Aula> findAll();
    Aula findByid(String idComposto);
}
