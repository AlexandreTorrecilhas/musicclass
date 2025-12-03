CREATE USER "maestro"@"locahost" identified by "mudar@123";

GRANT SELECT, UPDATE, DELETE, INSERT ON musica.* TO "maestro"@"localhost";


/*Tabela pessoa*/
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

ALTER TABLE pessoa
	ADD COLUMN ativo BOOLEAN DEFAULT FALSE;

SELECT * FROM pessoa;

/*tabela materias*/
CREATE TABLE materias(
	id_materia INT AUTO_INCREMENT,
    descricao VARCHAR(200) NOT NULL,
    CONSTRAINT pk_materias_id_materia PRIMARY KEY(id_materia),
    CONSTRAINT un_materia_descricao UNIQUE(descricao)
);

/*Tabela ciclo*/
CREATE TABLE ciclo(
	id_ciclo INT AUTO_INCREMENT,
    descricao	VARCHAR(200) NOT NULL,
    CONSTRAINT pk_ciclo_id_ciclo PRIMARY KEY(id_ciclo),
    CONSTRAINT un_ciclo_descricao UNIQUE(descricao)
);

/*tabela ciclo_tem_materia*/
CREATE TABLE ciclo_tem_materia(
	id_ciclo INT,
    id_materia INT,
    CONSTRAINT fk_ciclo_tem_materia_id_ciclo FOREIGN KEY(id_ciclo) REFERENCES ciclo(id_ciclo),
    CONSTRAINT fk_ciclo_tem_materia_id_materia FOREIGN KEY(id_materia) REFERENCES materias(id_materia)
);

DROP TABLE ESTUDANTE;

/*tabela estudante*/
CREATE TABLE estudante(
	id_pessoa INT,
    id_ciclo INT,
    CONSTRAINT fk_estudante_id_pessoa FOREIGN KEY(id_pessoa) REFERENCES pessoa(id_pessoa),
    CONSTRAINT fk_estudante_id_ciclo FOREIGN KEY(id_ciclo) REFERENCES ciclo(id_ciclo)
);

SHOW TABLES;