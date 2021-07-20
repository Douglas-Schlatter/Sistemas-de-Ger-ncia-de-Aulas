package com.douglas.SGA.adaptadores.controllers;

import java.util.List;

import com.douglas.SGA.aplicacao.casosDeUso.CadastraAlunoUC;
import com.douglas.SGA.aplicacao.casosDeUso.CadastraAulaUC;
import com.douglas.SGA.aplicacao.casosDeUso.CadastraCorredoresUC;
import com.douglas.SGA.aplicacao.casosDeUso.CadastraEventoUC;
import com.douglas.SGA.aplicacao.casosDeUso.ConsultaAlunoUC;
import com.douglas.SGA.aplicacao.casosDeUso.ConsultaCorredoresUC;
import com.douglas.SGA.aplicacao.casosDeUso.ConsultaEstatisticasUC;
import com.douglas.SGA.aplicacao.casosDeUso.ConsultaEventosUC;
import com.douglas.SGA.aplicacao.casosDeUso.ConsultaPerformanceUC;
import com.douglas.SGA.aplicacao.casosDeUso.InscreverAlunoUC;
import com.douglas.SGA.aplicacao.casosDeUso.ConsultaAulaUC;
import com.douglas.SGA.aplicacao.dtos.EstatisticasDTO;
import com.douglas.SGA.aplicacao.dtos.PerformanceDTO;
import com.douglas.SGA.negocio.entidades.Aluno;
import com.douglas.SGA.negocio.entidades.Aula;
import com.douglas.SGA.negocio.entidades.Corredor;
import com.douglas.SGA.negocio.entidades.Evento;

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
    private ConsultaCorredoresUC consultaCorredoresUC;
    private CadastraCorredoresUC cadastraCorredoresUC;
    private ConsultaEventosUC consultaEventosUC;
    private CadastraEventoUC cadastraEventoUC;
    private ConsultaEstatisticasUC consultaEstatisticasUC;
    private ConsultaPerformanceUC consultaPerformanceUC;
    private CadastraAulaUC cadastraAulaUC;
    private ConsultaAulaUC consultaAulaUC;
    private CadastraAlunoUC cadastraAlunoUC;
    private ConsultaAlunoUC consultaAlunoUC;
    private InscreverAlunoUC inscreverAlunoUC;

    @Autowired
    public RequestController(ConsultaCorredoresUC consultaCorredoresUC, CadastraCorredoresUC cadastraCorredoresUC,
            ConsultaEventosUC consultaEventosUC, CadastraEventoUC cadastraEventoUC,
            ConsultaEstatisticasUC consultaEstatisticasUC, ConsultaPerformanceUC consultaPerformanceUC,
             CadastraAulaUC cadastraAulaUC,ConsultaAulaUC consultaAulaUC,ConsultaAlunoUC consultaAlunoUC
             ,CadastraAlunoUC cadastraAlunoUC,InscreverAlunoUC inscreverAlunoUC) {
        this.consultaCorredoresUC = consultaCorredoresUC;
        this.cadastraCorredoresUC = cadastraCorredoresUC;
        this.consultaEventosUC = consultaEventosUC;
        this.cadastraEventoUC = cadastraEventoUC;
        this.consultaEstatisticasUC = consultaEstatisticasUC;
        this.consultaPerformanceUC = consultaPerformanceUC;
        this.cadastraAulaUC = cadastraAulaUC;
        this.consultaAulaUC = consultaAulaUC;
        this.cadastraAlunoUC = cadastraAlunoUC;
        this.consultaAlunoUC = consultaAlunoUC;
        this.inscreverAlunoUC = inscreverAlunoUC;
    }

    @GetMapping("/corredores")
    @CrossOrigin(origins = "*")
    public List<Corredor> consultaCorredor() {
        return consultaCorredoresUC.run();
    }

    @GetMapping("/corredor")
    @CrossOrigin(origins = "*")
    public List<Corredor> consultaCorredor(String cpf) {
        List<Corredor> res = consultaCorredoresUC.run(cpf);
        return res;
    }

    @PostMapping("/CadastraCorredor")
    @CrossOrigin(origins = "*")
    public boolean cadastraCorredor(@RequestBody final Corredor corredor) {
        cadastraCorredoresUC.run(corredor);
        return true;
    }

    @GetMapping("/todosEventos")
    @CrossOrigin(origins = "*")
    public List<Evento> consultaEventos() {
        List<Evento> result = consultaEventosUC.run();
        return result;
    }



    @GetMapping("/eventos")
    @CrossOrigin(origins = "*")
    public List<Evento> consultaEventos(String cpf) {
        List<Evento> result = consultaEventosUC.run(cpf);
        return result;
    }


    @PostMapping("/eventos") 
    // se tenho vários corredores precisamos "receber"
    // para saber de quem é o evento
    @CrossOrigin(origins = "*")
    public boolean informaEvento(String cpf,
                @RequestBody final Evento evento) {
        
        cadastraEventoUC.run(cpf, evento);



        return true;
    }


    @GetMapping("/estatisticas")
    @CrossOrigin(origins = "*")
    public EstatisticasDTO estatisticas(@RequestParam final Integer distancia) {
        return consultaEstatisticasUC.run(distancia);
    }

    @GetMapping("/aumentoPerformance")
    @CrossOrigin(origins = "*")
    public PerformanceDTO aumentoPerformance(@RequestParam final Integer distancia, @RequestParam final Integer ano) {
        return consultaPerformanceUC.run(distancia, ano);
    }
    //-------------------------------minhas consultas
    
    
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

}
