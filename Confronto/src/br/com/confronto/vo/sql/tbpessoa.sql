CREATE TABLE tbpessoa (
id int4 NOT NULL SERIAL,
nome name(200),
endereco name(300),
estado name(60),
cidade name(90),
cep name(10),
rg name(12),
cpf name(12),
pis name(30),
ctps name(30),
profissao name(200),
nacionalidade name(30),
sexo int2, PRIMARY KEY (id));