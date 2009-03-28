CREATE TABLE tbsexo (
id int2 NOT NULL,
sexo name(10),
PRIMARY KEY (id));

INSERT INTO public.tbsexo (id, sexo) VALUES (0, 'FEMININO');
INSERT INTO public.tbsexo (id, sexo) VALUES (1, 'MASCULINO');