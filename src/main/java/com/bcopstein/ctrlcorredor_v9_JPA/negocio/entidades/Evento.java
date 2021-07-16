package com.bcopstein.ctrlcorredor_v9_JPA.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name = "evento")
public class Evento {
    @Id
    private int id;
    private String nome;
    // Data do evento
    private int dia;
    private int mes;
    private int ano;
    // Distancia percorrida
    private int distancia; // metros
    // Tempo que o corredor levou para percorrer a distancia
    private int horas;
    private int minutos;
    private int segundos;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "corredor_cpf", nullable = false)
    private Corredor corredor;

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }
    public String getCorredorId() {
        return corredor.getCpf();
    }
    
    public Evento(int id,String nome, int dia, int mes, int ano, int distancia, int horas, int minutos, int segundos) {
        this.id = id;
        this.nome = nome;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.distancia = distancia;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    protected Evento() {}

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int getDistancia() {
        return distancia;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    @Override
    public String toString() {
        return "Evento [ano=" + ano + ", dia=" + dia + ", distancia=" + distancia + ", horas=" + horas + ", id=" + id
                + ", mes=" + mes + ", minutos=" + minutos + ", nome=" + nome + ", segundos=" + segundos + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evento )) return false;
        return id == (((Evento) o).getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
