USE music_project;

CREATE TABLE student_login(
	rel_idstudent		INT,
    login				varchar(50),
    user_password		varchar(64),
    
    CONSTRAINT fk_rel_ids FOREIGN KEY(rel_idstudent) REFERENCES student(idstudent),
    CONSTRAINT pk_rel_stu_log PRIMARY KEY(rel_idstudent, login)
);

ALTER TABLE student_login
	DROP COLUMN user_password;
    
GRANT ALL ON music_project TO "administrador"@"localhost";

CREATE TABLE telefone(
	rel_id_es		INT,
    telefone		VARCHAR(50),
    CONSTRAINT fk_te_rel_id_es FOREIGN KEY(rel_id_es) REFERENCES estudante(id_estudante)
);
    