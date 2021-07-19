package com.douglas.SGA.adaptadores.repositorios;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Corredor;
import com.douglas.SGA.negocio.repositorios.ICorredorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CorredorRepository implements ICorredorRepository {
    private ICorredorCRUD corredorCRUD;

    @Autowired
    public CorredorRepository(ICorredorCRUD corredorCRUD) {
        this.corredorCRUD = corredorCRUD;
/*
        this.jdbcTemplate.execute("DROP TABLE corredores IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE corredores("
                + "cpf VARCHAR(255), nome VARCHAR(255), genero VARCHAR(255), diaDn int, mesDn int, anoDn int, PRIMARY KEY(cpf))");

        cadastra(new Corredor("10001287","Luiz",22,5,1987,"masculino"));    
*/
    }
    
    public List<Corredor> todos() {
        return corredorCRUD.findAll();

    }

    public List<Corredor> todos(String cpf) {
        List<Corredor> resp = corredorCRUD.findByCpf(cpf);
        return resp;
    }

    public void removeTodos(){
        corredorCRUD.deleteAll();
    }

    public boolean cadastra(Corredor corredor){
        corredorCRUD.save(corredor);
        return true;
    }
}
