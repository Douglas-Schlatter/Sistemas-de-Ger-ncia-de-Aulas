/*
Tecnicas de Programação-PUCRS
Matricula: 20106324-5
Nome:Douglas Ardenghi Schlatter
Github: https://github.com/Douglas-Schlatter/Sistemas-de-Ger-ncia-de-Aulas
*/
package com.douglas.SGA.adaptadores.repositorios;

import java.util.List;
import java.util.stream.Collectors;

import com.douglas.SGA.negocio.entidades.Aluno;
import com.douglas.SGA.negocio.entidades.Aula;
import com.douglas.SGA.negocio.repositorios.IAulaRepository;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AulaRepository implements IAulaRepository{
    //private JdbcTemplate jdbcTemplate;
    private IAulaCRUD aulaCRUD;
    private IAlunoCRUD alunoCRUD;    

    @Autowired
    //public EventoRepository(JdbcTemplate jdbcTemplate) {
    public AulaRepository(IAulaCRUD aulaCRUD,
    IAlunoCRUD alunoCRUD) {
        this.aulaCRUD = aulaCRUD;
        this.alunoCRUD = alunoCRUD;
    
        //this.jdbcTemplate = jdbcTemplate;  
        //this.jdbcTemplate.execute("DROP TABLE eventos IF EXISTS");
        //this.jdbcTemplate.execute("CREATE TABLE eventos("
        //        + "id int, nome VARCHAR(255), dia int, mes int, ano //int, distancia int, horas int, minutos int, segundos int,//PRIMARY KEY(id))");
        // Insere eventos
        //cadastra(new Evento(1,"Poa Day Run",22,5,2019,5,0,35,32));
        //cadastra(new Evento(2,"Poa Night Run",12,6,2019,5,0,31,10));
        //cadastra(new Evento(3,"Winter Day Run",9,7,2019,5,0,29,17));
        //cadastra(new Evento(4,"Summer Night Run",18,12,2019,5,0,32,25));
    }  

    public List<Aula> todos() {
        List<Aula> resp = aulaCRUD.findAll();
        return resp;
        /*
        List<Evento> resp = this.jdbcTemplate.query("SELECT * from eventos",
                (rs, rowNum) -> new Evento(rs.getInt("id"), rs.getString("nome"), rs.getInt("dia"), rs.getInt("mes"),
                        rs.getInt("ano"), rs.getInt("distancia"), rs.getInt("horas"), rs.getInt("minutos"),
                        rs.getInt("segundos")));
        return resp;
        */
    }

    public List<Aula> procurar(String idComposto) {
        return  aulaCRUD.findAll().stream().filter(e->e.getIdComposto().equals(idComposto)).collect(Collectors.toList());     
    }
    //confirmar se isso gerará loop
    public boolean cadastra(String cpf, Aula aula){
        Aluno aluno = alunoCRUD.findById(cpf).get();
        //lembrar de fazer isso no aluno tambem de adicionar em
        if (aluno != null) {
            //aula.addAluno(aluno);
            aluno.addAula(aula);
            aulaCRUD.save(aula);
            return true;
        }
        return false;
        /*
        this.jdbcTemplate.update(
            "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES (?,?,?,?,?,?,?,?,?)",
            evento.getId(), evento.getNome(), evento.getDia(), evento.getMes(), evento.getAno(),
            evento.getDistancia(), evento.getHoras(), evento.getMinutos(), evento.getSegundos());
        return true;
        */
    }
}
