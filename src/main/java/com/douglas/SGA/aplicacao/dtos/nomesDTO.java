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
