package com.douglas.SGA.adaptadores.controllers;

import java.util.List;

import com.douglas.SGA.aplicacao.casosDeUso.CadastraAlunoUC;
import com.douglas.SGA.aplicacao.casosDeUso.CadastraAulaUC;
import com.douglas.SGA.aplicacao.casosDeUso.ConsultaAlunoUC;
import com.douglas.SGA.aplicacao.casosDeUso.InformarNomesUC;
import com.douglas.SGA.aplicacao.casosDeUso.InformarTotalUC;
import com.douglas.SGA.aplicacao.casosDeUso.InscreverAlunoUC;
import com.douglas.SGA.aplicacao.casosDeUso.ConsultaAulaUC;
import com.douglas.SGA.aplicacao.dtos.nomesDTO;
import com.douglas.SGA.aplicacao.dtos.totalDTO;
import com.douglas.SGA.negocio.entidades.Aluno;
import com.douglas.SGA.negocio.entidades.Aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RequestController {
    private CadastraAulaUC cadastraAulaUC;
    private ConsultaAulaUC consultaAulaUC;
    private CadastraAlunoUC cadastraAlunoUC;
    private ConsultaAlunoUC consultaAlunoUC;
    private InscreverAlunoUC inscreverAlunoUC;
    private InformarNomesUC informarNomesUC;
    private InformarTotalUC informarTotalUC;
    @Autowired
    public RequestController(CadastraAulaUC cadastraAulaUC,
             ConsultaAulaUC consultaAulaUC,CadastraAlunoUC cadastraAlunoUC,
            ConsultaAlunoUC consultaAlunoUC, InscreverAlunoUC inscreverAlunoUC,
             InformarNomesUC informarNomesUC,InformarTotalUC informarTotalUC) {
        this.cadastraAulaUC = cadastraAulaUC;
        this.consultaAulaUC = consultaAulaUC;
        this.cadastraAlunoUC = cadastraAlunoUC;
        this.consultaAlunoUC = consultaAlunoUC;
        this.inscreverAlunoUC = inscreverAlunoUC;
        this.informarNomesUC = informarNomesUC;
        this.informarTotalUC = informarTotalUC;
    }

    
    
    @GetMapping("/todasAulas")
    @CrossOrigin(origins = "*")
    public List<Aula> consultaAulas() {
        List<Aula> result = consultaAulaUC.run();
        return result;
    }

    @GetMapping("/procuraAula")
    @CrossOrigin(origins = "*")
    public List<Aula> procurarAulas(String id) {
        List<Aula> result = consultaAulaUC.run(id);
        return result;
    }

    @PostMapping("/abrirAula") 
    @CrossOrigin(origins = "*")
    public boolean abrirAula(String cpf,
                @RequestBody final Aula aula) {
        
        cadastraAulaUC.run(cpf, aula);
        return true;
    }

    @GetMapping("/todosAlunos")
    @CrossOrigin(origins = "*")
    public List<Aluno> consultaAlunos() {
        List<Aluno> result = consultaAlunoUC.run();
        return result;
    }

    @GetMapping("/procuraAluno")
    @CrossOrigin(origins = "*")
    public Aluno procuraAluno(String cpf) {
        Aluno result = consultaAlunoUC.run(cpf);
        return result;
    }

    @PostMapping("/cadastraAluno") 
    @CrossOrigin(origins = "*")
    public boolean cadastraAluno(@RequestBody final Aluno aluno) {
        return cadastraAlunoUC.run(aluno);
    }

    @PostMapping("/inscreveAluno") 
    @CrossOrigin(origins = "*")
    public boolean inscreveAluno(String nome, String id) {
        return inscreverAlunoUC.run(nome,id);
    }

    @GetMapping("/alunosInscritos") 
    @CrossOrigin(origins = "*")
    public nomesDTO alunosInscritos(String id) {
        return informarNomesUC.run(id);
    }

    @GetMapping("/totalDisc") 
    @CrossOrigin(origins = "*")
    public totalDTO totalDisc(String codcred) {
        
        return informarTotalUC.run(codcred);
    }

}
