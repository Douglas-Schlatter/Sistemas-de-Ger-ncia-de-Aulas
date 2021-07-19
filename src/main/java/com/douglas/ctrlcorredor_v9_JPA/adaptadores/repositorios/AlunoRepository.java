package com.douglas.ctrlcorredor_v9_JPA.adaptadores.repositorios;

import java.util.List;

import com.douglas.ctrlcorredor_v9_JPA.negocio.entidades.Corredor;
import com.douglas.ctrlcorredor_v9_JPA.negocio.repositorios.ICorredorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlunoRepository implements IAlunoRepository {
    private IAlunoCRUD alunoCRUD;

    @Autowired
    public AlunoRepository(IAlunoCRUD alunoCRUD) {
        this.alunoCRUD = alunoCRUD;
/*
        this.jdbcTemplate.execute("DROP TABLE corredores IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE corredores("
                + "cpf VARCHAR(255), nome VARCHAR(255), genero VARCHAR(255), diaDn int, mesDn int, anoDn int, PRIMARY KEY(cpf))");

        cadastra(new Corredor("10001287","Luiz",22,5,1987,"masculino"));    
*/
    }
    
    public List<Corredor> todos() {
        return alunoCRUD.findAll();

    }

    public List<Corredor> procurar(String cpf) {
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