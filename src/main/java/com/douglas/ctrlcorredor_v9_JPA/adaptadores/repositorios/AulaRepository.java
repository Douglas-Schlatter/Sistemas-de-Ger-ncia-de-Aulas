package com.douglas.ctrlcorredor_v9_JPA.adaptadores.repositorios;

import java.util.List;
import java.util.stream.Collectors;

import com.douglas.ctrlcorredor_v9_JPA.negocio.entidades.Corredor;
import com.douglas.ctrlcorredor_v9_JPA.negocio.entidades.Evento;
import com.douglas.ctrlcorredor_v9_JPA.negocio.repositorios.IEventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AulaRepository implements IEventoRepository{
    //private JdbcTemplate jdbcTemplate;
    private IEventoCRUD eventoCRUD;
    private ICorredorCRUD corredorCRUD;    

    @Autowired
    //public EventoRepository(JdbcTemplate jdbcTemplate) {
    public EventoRepository(IEventoCRUD eventoCRUD,
    ICorredorCRUD corredorCRUD) {
        this.eventoCRUD = eventoCRUD;
        this.corredorCRUD = corredorCRUD;
    
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

    public List<Evento> todos() {
        List<Evento> resp = eventoCRUD.findAll();
        return resp;
        /*
        List<Evento> resp = this.jdbcTemplate.query("SELECT * from eventos",
                (rs, rowNum) -> new Evento(rs.getInt("id"), rs.getString("nome"), rs.getInt("dia"), rs.getInt("mes"),
                        rs.getInt("ano"), rs.getInt("distancia"), rs.getInt("horas"), rs.getInt("minutos"),
                        rs.getInt("segundos")));
        return resp;
        */
    }

    public List<Evento> todos(String cpf) {
        return  eventoCRUD.findAll().stream().filter(e->e.getCorredorId().equals(cpf)).collect(Collectors.toList());     
    }

    public boolean cadastra(String cpf, Evento evento){
        Corredor corredor = corredorCRUD.findById(cpf).get();
        if (corredor != null) {
            evento.setCorredor(corredor);
            eventoCRUD.save(evento);
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
