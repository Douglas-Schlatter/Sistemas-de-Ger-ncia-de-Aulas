
/*
Tecnicas de Programação-PUCRS
Matricula: 20106324-5
Nome:Douglas Ardenghi Schlatter
Github: https://github.com/Douglas-Schlatter/Sistemas-de-Ger-ncia-de-Aulas
*/
package com.douglas.SGA.aplicacao.servicos;

import java.util.List;
import java.util.stream.Collectors;
import com.douglas.SGA.aplicacao.dtos.totalDTO;
import com.douglas.SGA.negocio.entidades.Aluno;
import com.douglas.SGA.negocio.entidades.Aula;
import com.douglas.SGA.negocio.repositorios.IAulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoInformarTotal {

    private IAulaRepository aulaRep;


    @Autowired
    public ServicoInformarTotal(IAulaRepository aulaRep) {
        this.aulaRep = aulaRep;
    }


    public totalDTO totalIns(String codcred)
    {
        int count = 0;
        totalDTO dto = new totalDTO();
        List<Aula>targets =aulaRep.todos()
        .stream()
        .filter(e->e.getCodcred().equals(codcred))
        .collect(Collectors.toList());
        for (Aula aula : targets) {
            for (Aluno aluno : aula.getAlunos()) 
            {
                count++;
            }
            
        }
        dto.setTotal(count);
        return dto;
    }
}
