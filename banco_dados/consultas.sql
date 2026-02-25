USE music_project;

SET AUTOCOMMIT = 0;

SHOW DATABASES;

SELECT * FROM mysql.user;

ALTER TABLE mysql.user
ADD COLUMN senha	VARCHAR(255) NOT NULL
AFTER authentication_string;

ALTER TABLE mysql.user DROP COLUMN senha;

GRANT ALL ON music_project.* TO "administrador"@"localhost";

UPDATE mysql.user
	SET authentication_string = "mudar@123";

SELECT user, authentication_string FROM mysql.user
	WHERE user = "administrador";

SHOW GRANTS FOR "administrador"@"localhost";

CREATE TABLE estudante(
	/*String nome, Date dataNascimento, String instrumentoDesejado, String telefone ,String email*/
    situacao				boolean default true,
    id_estudante			int	auto_increment,
    nome					varchar(300) NOT NULL,
    dtnasc					date not null,
    instrumento				varchar(50) default "Não escolheu",
    email					varchar(200) not null,
    constraint pk_es_id_es primary key(id_estudante)
);

CREATE TABLE telefone(
	rel_id_es		int,
    num_tel			varchar(15) not null,
    constraint fk_te_rel_id_es FOREIGN KEY(rel_id_es) REFERENCES estudante(id_estudante)
);

/*Para evitar o cadastro de alunos com informações iguais,
*adicionaremos um unique constraint baseado no nome e
*data de nascimento.
*/

delete from estudante;

set SQL_SAFE_UPDATEs = 0;

alter table estudante
	add constraint un_es_no_dt UNIQUE(nome, dtnasc);
    
SELECT e.nome, e.instrumento, tel.num_tel 
		FROM estudante as e
        INNER JOIN telefone as tel
        ON e.id_estudante = tel.rel_id_es;
        
USE alura;
