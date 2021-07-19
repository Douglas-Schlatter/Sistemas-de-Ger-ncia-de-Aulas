package com.douglas.SGA.aplicacao.servicos;

import com.douglas.SGA.aplicacao.dtos.EstatisticasDTO;

public interface ICalculoEstatistica {
    EstatisticasDTO calculaEstatisticas(int distancia);
}
