package com.douglas.ctrlcorredor_v9_JPA.adaptadores.controllers;

import java.util.List;

import com.douglas.ctrlcorredor_v9_JPA.aplicacao.casosDeUso.CadastraAulaUC;
import com.douglas.ctrlcorredor_v9_JPA.aplicacao.casosDeUso.CadastraCorredoresUC;
import com.douglas.ctrlcorredor_v9_JPA.aplicacao.casosDeUso.CadastraEventoUC;
import com.douglas.ctrlcorredor_v9_JPA.aplicacao.casosDeUso.ConsultaCorredoresUC;
import com.douglas.ctrlcorredor_v9_JPA.aplicacao.casosDeUso.ConsultaEstatisticasUC;
import com.douglas.ctrlcorredor_v9_JPA.aplicacao.casosDeUso.ConsultaEventosUC;
import com.douglas.ctrlcorredor_v9_JPA.aplicacao.casosDeUso.ConsultaPerformanceUC;
import com.douglas.ctrlcorredor_v9_JPA.aplicacao.dtos.EstatisticasDTO;
import com.douglas.ctrlcorredor_v9_JPA.aplicacao.dtos.PerformanceDTO;
import com.douglas.ctrlcorredor_v9_JPA.negocio.entidades.Aula;
import com.douglas.ctrlcorredor_v9_JPA.negocio.entidades.Corredor;
import com.douglas.ctrlcorredor_v9_JPA.negocio.entidades.Evento;

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
public class CtrlCorridasController {
    private ConsultaCorredoresUC consultaCorredoresUC;
    private CadastraCorredoresUC cadastraCorredoresUC;
    private ConsultaEventosUC consultaEventosUC;
    private CadastraEventoUC cadastraEventoUC;
    private ConsultaEstatisticasUC consultaEstatisticasUC;
    private ConsultaPerformanceUC consultaPerformanceUC;
    private CadastraAulaUC cadastraAulaUC;

    @Autowired
    public CtrlCorridasController(ConsultaCorredoresUC consultaCorredoresUC, CadastraCorredoresUC cadastraCorredoresUC,
            ConsultaEventosUC consultaEventosUC, CadastraEventoUC cadastraEventoUC,
            ConsultaEstatisticasUC consultaEstatisticasUC, ConsultaPerformanceUC consultaPerformanceUC, CadastraAulaUC cadastraAulaUC) {
        this.consultaCorredoresUC = consultaCorredoresUC;
        this.cadastraCorredoresUC = cadastraCorredoresUC;
        this.consultaEventosUC = consultaEventosUC;
        this.cadastraEventoUC = cadastraEventoUC;
        this.consultaEstatisticasUC = consultaEstatisticasUC;
        this.consultaPerformanceUC = consultaPerformanceUC;
        this.cadastraAulaUC = cadastraAulaUC;
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

    @PostMapping("/abrirAula") 
    // se tenho vários corredores precisamos "receber"
    // para saber de quem é o evento
    @CrossOrigin(origins = "*")
    public boolean informaAula(String cpf,
                @RequestBody final Aula aula) {
        
        cadastraAulaUC.run(cpf, aula);



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
}