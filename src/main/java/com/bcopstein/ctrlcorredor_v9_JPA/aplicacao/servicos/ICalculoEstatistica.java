package com.bcopstein.ctrlcorredor_v9_JPA.aplicacao.servicos;

import com.bcopstein.ctrlcorredor_v9_JPA.aplicacao.dtos.EstatisticasDTO;

public interface ICalculoEstatistica {
    EstatisticasDTO calculaEstatisticas(int distancia);
}
