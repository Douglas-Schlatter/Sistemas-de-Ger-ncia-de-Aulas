

Tecnicas de Programação-PUCRS
Matricula: 20106324-5
Nome:Douglas Ardenghi Schlatter
Github: https://github.com/Douglas-Schlatter/Sistemas-de-Ger-ncia-de-Aulas

*Por favor lembre-se de alterar a versão do java equivalente a sua maquina
                *no pom antes de executar a aplicação*

Testes podem ser executados com mvn test

Apos executar a api com mvn spring-boot:run será de interesse os seguintes comandos:

Para Cadastrar aula presencial digite localhost:8080/api/abrirAula?cpf=2 
na aba POST no Postman junto a um body em json com:

{
        "codcred": "A",
        "idturma": 23,
        "dia": 2,
        "mes": 4,
        "alunos": [
            {
                "cpf": "1",
                "nome": "Douglas Schlatter",
                "diaDn": 10,
                "mesDn": 3,
                "anoDn": 2001,
                "genero": "masculino"
            }
        ],
        "idComposto": "A-22"
    }

Para Inscrever um aluno em uma atividade presencial digite 
localhost:8080/api/inscreveAluno?nome=Morgana&id=A-21 na aba POST no Postman

Para Informar o nome dos alunos inscritos para uma atividade presencial
 digite localhost:8080/api/alunosInscritos?id=A-21 na aba GET no Postman

Para Informar o número total de inscritos em todas as atividades previstas 
para uma determinada disciplina digite:
 localhost:8080/api/totalDisc?codcred=A na aba GET no Postman



Para Listar os dados de todas as atividades cadastradas digite:
localhost:8080/api/todasAulas na aba GET no Postman

Mais comandos estão a disposição podem ser encontrados classe RequestController.java


Qualquer duvida deixo meu e-mail de contato:
Douglas.Schlatter01@edu.pucrs.br

