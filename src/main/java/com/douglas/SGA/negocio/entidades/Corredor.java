package com.douglas.SGA.negocio.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "corredor")
public class Corredor {
    @Id
    private String cpf;
    private String nome;
    private int diaDn,mesDn,anoDn;
    private String genero;

    public Corredor(String cpf, String nome, int diaDn,int mesDn,int anoDn, String genero) {
        this.cpf = cpf;
        this.nome = nome;
        this.diaDn = diaDn;
        this.mesDn = mesDn;
        this.anoDn = anoDn;
        this.genero = genero;
    }

    protected Corredor() {}

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getDiaDn() {
        return diaDn;
    }

    public int getMesDn() {
        return mesDn;
    }
    public int getAnoDn() {
        return anoDn;
    }

    public String getGenero() {
        return genero;
    }

    @OneToMany(mappedBy = "corredor", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Evento> eventos = new ArrayList<>();
 
    //Constructors, getters and setters removed for brevity
 
    public void addEvento(Evento evento) {
        eventos.add(evento);
        evento.setCorredor(this);
    }
 
    public void removeEvento(Evento evento) {
        eventos.remove(evento);
        evento.setCorredor(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Corredor )) return false;
        return cpf != null && cpf.equals(((Corredor) o).getCpf());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
