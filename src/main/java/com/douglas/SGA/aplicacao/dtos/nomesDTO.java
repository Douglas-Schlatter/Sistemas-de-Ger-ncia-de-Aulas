/*
Tecnicas de Programação-PUCRS
Matricula: 20106324-5
Nome:Douglas Ardenghi Schlatter
Github: https://github.com/Douglas-Schlatter/Sistemas-de-Ger-ncia-de-Aulas
*/
package com.douglas.SGA.aplicacao.dtos;

import java.util.ArrayList;
import java.util.List;

public class nomesDTO {
    private List<String> nomes = new ArrayList<>();
    public List<String> getNames() {
        return nomes;
    }
    public void setNames(List<String> nomes) {
        this.nomes = nomes;
    }
    public void addName(String s)
    {
        nomes.add(s);
    }


}
