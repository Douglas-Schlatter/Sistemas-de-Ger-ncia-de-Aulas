INSERT INTO corredor (cpf,nome,dia_dn,mes_dn,ano_dn,genero) VALUES (1003245612, 'Edison Sulivan', 25,3,1994,'masculino');
INSERT INTO corredor (cpf,nome,dia_dn,mes_dn,ano_dn,genero) VALUES (123456789, 'Jane Doe', 10,3,2001,'feminino');

INSERT INTO aluno (cpf,nome,dia_dn,mes_dn,ano_dn,genero) VALUES (1000000000, 'Douglas Schlatter', 10,3,2001,'masculino');


INSERT INTO aula (id,codcred,idturma,dia,mes) VALUES ('A-21','A',21,2,4);

INSERT INTO evento (id,nome,dia,mes,ano,distancia,horas,minutos,segundos, corredor_cpf) VALUES (10,'POA Night Run',14,2,2019,5,0,35,17,1003245612);
INSERT INTO evento (id,nome,dia,mes,ano,distancia,horas,minutos,segundos, corredor_cpf) VALUES (20,'POA Day Run',19,3,2019,5,0,32,43,1003245612);
INSERT INTO evento (id,nome,dia,mes,ano,distancia,horas,minutos,segundos,corredor_cpf) VALUES (25,'Winter Day Run',25,7,2019,5,0,28,3,1003245612);
INSERT INTO evento (id,nome,dia,mes,ano,distancia,horas,minutos,segundos,corredor_cpf) VALUES (12,'Spring Nigth Run',30,9,2019,5,0,29,32,1003245612);
INSERT INTO evento (id,nome,dia,mes,ano,distancia,horas,minutos,segundos, corredor_cpf) VALUES ( 8,'Summer Day Run',4,12,2019,5,0,26,18, 1003245612);
INSERT INTO evento (id,nome,dia,mes,ano,distancia,horas,minutos,segundos,corredor_cpf) VALUES (17,'Spring Nigth Run',30,9,2019,5,0,31,03,123456789);
INSERT INTO evento (id,nome,dia,mes,ano,distancia,horas,minutos,segundos, corredor_cpf) VALUES ( 18,'Summer Day Run',4,12,2019,5,0,29,18, 123456789);