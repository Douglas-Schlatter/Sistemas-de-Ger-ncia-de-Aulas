
/*
Tecnicas de Programação-PUCRS
Matricula: 20106324-5
Nome:Douglas Ardenghi Schlatter
Github: https://github.com/Douglas-Schlatter/Sistemas-de-Ger-ncia-de-Aulas
*/
package com.douglas.SGA.aplicacao.servicos;

import java.util.List;
import java.util.stream.Collectors;

import com.douglas.SGA.aplicacao.dtos.nomesDTO;
import com.douglas.SGA.negocio.entidades.Aula;
import com.douglas.SGA.negocio.repositorios.IAulaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoInformarNomes {

    private IAulaRepository aulaRep;


    @Autowired
    public ServicoInformarNomes(IAulaRepository aulaRep) {
        this.aulaRep = aulaRep;
    }


    public nomesDTO inscritos(String id)
    {
        Aula aula = aulaRep.procurar(id).get(0);
        nomesDTO nomes = new nomesDTO();
        List <String> ss = aula.getAlunos().
        stream()
        .map(e-> e.getNome())
        .sorted()
        .collect(Collectors.toList());
        for (String s : ss) {
            nomes.addName(s);
        }
        return nomes;
    }
}
