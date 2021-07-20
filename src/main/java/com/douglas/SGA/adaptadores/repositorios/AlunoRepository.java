package com.douglas.SGA.adaptadores.repositorios;

import java.util.List;

import com.douglas.SGA.negocio.entidades.Aluno;
import com.douglas.SGA.negocio.entidades.Aula;
//import com.douglas.SGA.negocio.entidades.Corredor;
import com.douglas.SGA.negocio.repositorios.IAlunoRepository;
//import com.douglas.SGA.negocio.repositorios.ICorredorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlunoRepository implements IAlunoRepository {
    private IAlunoCRUD alunoCRUD;
    private IAulaCRUD aulaCRUD;

    @Autowired
    public AlunoRepository(IAlunoCRUD alunoCRUD,IAulaCRUD aulaCRUD ) {
        this.alunoCRUD = alunoCRUD;
        this.aulaCRUD = aulaCRUD;
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

    public Aluno procurar(String cpf) {
        List<Aluno> resp = alunoCRUD.findByCpf(cpf);
        return resp.get(0);
    }

    public void removeTodos(){
        alunoCRUD.deleteAll();
    }

    public boolean cadastra(Aluno aluno){
        alunoCRUD.save(aluno);
        return true;
    }

    public boolean inscreve(String nome,String id)
    {
        //Podem ter mais de um aluno com o mesmo nome 
        //deveria ser com o cpf, se sobrar tempo farei com cpf 
        //aqui pega o primeiro aluno com esse nome
        List<Aluno> targetS = alunoCRUD.findByNome(nome);
        Aula targetC = aulaCRUD.findByid(id);
        if (targetS != null && targetC != null && targetC.getAlunos().size() < 10)
        {  
            targetS.get(0).addAula(targetC);
            alunoCRUD.save(targetS.get(0));
            aulaCRUD.save(targetC);
            return true;
        }
        return false;
        //alunoCRUD.save(aluno);
    }

}
