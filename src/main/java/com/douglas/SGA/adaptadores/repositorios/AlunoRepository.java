package com.douglas.SGA.adaptadores.repositorios;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Aluno;
import com.douglas.SGA.negocio.entidades.Corredor;
import com.douglas.SGA.negocio.repositorios.IAlunoRepository;
import com.douglas.SGA.negocio.repositorios.ICorredorRepository;

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
    
    public List<Aluno> todos() {
        return alunoCRUD.findAll();

    }

    public List<Aluno> procurar(String cpf) {
        List<Aluno> resp = alunoCRUD.findByCpf(cpf);
        return resp;
    }

    public void removeTodos(){
        alunoCRUD.deleteAll();
    }

    public boolean cadastra(Aluno aluno){
        alunoCRUD.save(aluno);
        return true;
    }
}
