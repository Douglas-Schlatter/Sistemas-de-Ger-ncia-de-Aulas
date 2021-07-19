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
//(codcred da disciplina e turma) e data (dia e mês) 
// equivalente a evento
@Entity(name = "aula")
public class Aula {
    @Id
    private String idComposto;
    
    private String codcred;
    private int idturma;
    private int dia;
    private int mes;

    public String getIdComposto() {
        return idComposto;
    }

    public String getCodcred() {
        return codcred;
    }


    public void setCodcred(String codcred) {
        this.codcred = codcred;
        idComposto = codcred + "-" + idturma;
    }


    public int getIdturma() {
        return idturma;
    }


    public void setIdturma(int idturma) {
        this.idturma = idturma;
        idComposto = codcred + "-" + idturma;
    }


    public int getDia() {
        return dia;
    }


    public void setDia(int dia) {
        this.dia = dia;
    }


    public int getMes() {
        return mes;
    }


    public void setMes(int mes) {
        this.mes = mes;
    }


    public List<Aluno> getAluno() {
        return alunos;
    }


    public void setAlunos(List<Aluno> aluno) {
        this.alunos = alunos;
    }
    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removeAluno(Aluno aluno) {
        alunos.remove(aluno);
    }
    

    @ManyToMany(mappedBy = "aulas", fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private List<Aluno> alunos = new ArrayList<>();

    /*
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "aluno_cpf", nullable = false)
    private Aluno aluno;
    */


    protected Aula() {}
    
    
    /*
    @Override
    public String toString() {
        return "Evento [ano=" + ano + ", dia=" + dia + ", distancia=" + distancia + ", horas=" + horas + ", id=" + id
                + ", mes=" + mes + ", minutos=" + minutos + ", nome=" + nome + ", segundos=" + segundos + "]";
    }*/

    //TODO verificar se trará problemas comentar isso
    
    public Aula( String codcred, int idturma, int dia, int mes) {
        this.idComposto = codcred + "-" + idturma;
        
        this.codcred = codcred;
        this.idturma = idturma;
        
        this.dia = dia;
        this.mes = mes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aula )) return false;
        return idComposto == (((Aula) o).getIdComposto());
    }
    
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
