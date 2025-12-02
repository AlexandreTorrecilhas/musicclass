ALTER SESSION SET CONTAINER = XEPDB1;

ALTER SESSION SET CONTAINER = CDB$ROOT;

ROLLBACK;

COMMIT;

CREATE USER maestro_lider IDENTIFIED BY OrquestraAgape18;

GRANT CONNECT TO maestro_lider;

ALTER USER maestro_lider QUOTA unlimited ON users;

GRANT SELECT ANY TABLE, UPDATE ANY TABLE, INSERT ANY TABLE, DELETE ANY TABLE TO maestro_lider;

--Criando sequencia pessoas
    CREATE SEQUENCE id_pessoas
        START WITH 1
        INCREMENT BY 1
        NOMAXVALUE
        NOCYCLE
        CACHE 20;

--Criando tabelas
CREATE TABLE pessoa(
    id_pessoa INT,
    nome VARCHAR2(500) NOT NULL,
    dt_nascimento date NOT NULL,
    estudante NUMBER(1) DEFAULT 0,
    empregado NUMBER(1) DEFAULT 0,
    teminstrumentodesejado NUMBER(1) DEFAULT 0,
    email VARCHAR2(500),
    CONSTRAINT pk_pessoa_ip_pessoa PRIMARY KEY (id_pessoa),
    CONSTRAINT un_pessoa UNIQUE(nome, dt_nascimento)
);

