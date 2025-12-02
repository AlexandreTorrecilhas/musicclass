CREATE USER "maestro"@"locahost" identified by "mudar@123";

GRANT SELECT, UPDATE, DELETE, INSERT ON musica.* TO "maestro"@"localhost";

CREATE TABLE pessoa(
    id_pessoa INT AUTO_INCREMENT,
    nome VARCHAR(500) NOT NULL,
    dt_nascimento date NOT NULL,
    estudante BOOLEAN DEFAULT 0,
    empregado BOOLEAN DEFAULT 0,
    teminstrumentodesejado BOOLEAN DEFAULT 0,
    email VARCHAR(500),
    CONSTRAINT pk_pessoa_ip_pessoa PRIMARY KEY (id_pessoa),
    CONSTRAINT un_pessoa UNIQUE(nome, dt_nascimento)
);