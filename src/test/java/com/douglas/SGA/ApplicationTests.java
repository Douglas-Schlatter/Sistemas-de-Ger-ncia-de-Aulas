
/*
Tecnicas de Programação-PUCRS
Matricula: 20106324-5
Nome:Douglas Ardenghi Schlatter
Github: https://github.com/Douglas-Schlatter/Sistemas-de-Ger-ncia-de-Aulas
*/
package com.douglas.SGA;


import com.douglas.SGA.adaptadores.controllers.RequestController;
import com.douglas.SGA.aplicacao.casosDeUso.InscreverAlunoUC;
import com.douglas.SGA.negocio.entidades.Aluno;
import com.douglas.SGA.negocio.entidades.Aula;
import com.douglas.SGA.negocio.servicos.ServicoAluno;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    
    @Autowired 
    RequestController rc;

	@Test
    public void TesteEntidade(){
        Aula tAula = new Aula("A", 21, 1, 2);
        Assertions.assertEquals("A-21",tAula.getIdComposto());
        Assertions.assertEquals("A",tAula.getCodcred());
        Assertions.assertEquals(1,tAula.getDia());
        Assertions.assertEquals(2,tAula.getMes());
        Assertions.assertEquals(new ArrayList<>(),tAula.getAlunos());
    }

    @Test
    public void TesteUC(){
        rc.inscreveAluno("Douglas Schlatter", "A-21");

    }


}
