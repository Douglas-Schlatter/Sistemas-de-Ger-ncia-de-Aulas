package com.douglas.SGA.aplicacao.servicos;

import java.util.List;
import java.util.stream.Collectors;

import com.douglas.SGA.aplicacao.dtos.EstatisticasDTO;
import com.douglas.SGA.aplicacao.dtos.PerformanceDTO;
import com.douglas.SGA.aplicacao.dtos.nomesDTO;
import com.douglas.SGA.negocio.entidades.Aula;
import com.douglas.SGA.negocio.repositorios.IAlunoRepository;
import com.douglas.SGA.negocio.repositorios.IAulaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoInformar {

    private IAlunoRepository alunoRep;
    private IAulaRepository aulaRep;



    public ServicoInformar(IAlunoRepository alunoRep, IAulaRepository aulaRep) {
        this.alunoRep = alunoRep;
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


    /*
    public EstatisticasDTO calculaEstatisticas(int distancia){
        return calculoEstatistica.calculaEstatisticas(distancia);
    }

    public PerformanceDTO calculaAumentoPerformance(int distancia,int ano){
        List<Evento> eventos = eventoRep
                        .todos()
                        .stream()
                        .filter(e->e.getAno() == ano)
                        .collect(Collectors.toList());
        int indiceMaiorDif = 0;
        double maiorDif = -1.0;
        for(int i=0;i<eventos.size()-1;i++){
            Evento e1 = eventos.get(i);
            Evento e2 = eventos.get(i+1);
            double tempo1  = e1.getHoras()*60*60 + e1.getMinutos()*60.0 + e1.getSegundos();
            double tempo2  = e2.getHoras()*60*60 + e2.getMinutos()*60.0 + e2.getSegundos();
            if ((tempo1-tempo2)>maiorDif){
                maiorDif = tempo1-tempo2;
                indiceMaiorDif = i;
            }
        }         
        return new PerformanceDTO(eventos.get(indiceMaiorDif).getNome(),
                                  eventos.get(indiceMaiorDif+1).getNome(),
                                  maiorDif);
    }
    */
}
