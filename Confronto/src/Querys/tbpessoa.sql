-- Table: "TBPESSOA"

-- DROP TABLE "TBPESSOA";

CREATE TABLE "TBPESSOA"
(
  "ID" serial NOT NULL,
  "NOME" character varying(200),
  "ENDERECO" character varying(300),
  "ESTADO" character varying(60),
  "CIDADE" character varying(90),
  "CEP" character varying(10),
  "RG" character varying(12),
  "CPF" character varying(12),
  "PIS" character varying(30),
  "CTPS" character varying(30),
  "PROFISSAO" character varying(200),
  "NACIONALIDADE" character varying(30),
  "SEXO" bit(1),
  CONSTRAINT "PK_PESSOA" PRIMARY KEY ("ID")
)
WITH (OIDS=FALSE);
ALTER TABLE "TBPESSOA" OWNER TO postgres;

-- Sequence: "TBPESSOA_ID_seq"

-- DROP SEQUENCE "TBPESSOA_ID_seq";

CREATE SEQUENCE "TBPESSOA_ID_seq"
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE "TBPESSOA_ID_seq" OWNER TO postgres;
