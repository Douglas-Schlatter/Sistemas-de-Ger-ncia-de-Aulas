package com.douglas.SGA.negocio.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "aluno")
public class Aluno  {
    @Id
    private String cpf;
    private String nome;
    private int diaDn,mesDn,anoDn;
    private String genero;

    public Aluno(String cpf, String nome, int diaDn,int mesDn,int anoDn, String genero) {
        this.cpf = cpf;
        this.nome = nome;
        this.diaDn = diaDn;
        this.mesDn = mesDn;
        this.anoDn = anoDn;
        this.genero = genero;
    }

    protected Aluno() {}

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


    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Aula> aulas = new ArrayList<>();
    
    //Constructors, getters and setters removed for brevity

    //TODO se sobrar tempo retirar o aluno da aula
    public void removeAula(Aula aula) {
        aulas.remove(aula);
        aula.removeAluno(this);
        //aula.setCorredor(null);
    }
    public void addAula(Aula aula) {
        aulas.add(aula);
        aula.addAluno(this);
        //aula.setCorredor(null);
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
