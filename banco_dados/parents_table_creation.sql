SELECT * FROM V$CONTAINERS;

ALTER SESSION SET CONTAINER = XEPDB1;

SELECT * FROM all_tables
    WHERE OWNER = 'MAESTRO_LIDER';

CREATE TABLE maestro_lider.responsavel(
    id_responsavel  NUMBER NOT NULL UNIQUE,
    cpf VARCHAR2(11) UNIQUE,
    telefone VARCHAR(13),
    CONSTRAINT fk_responsavel_id_responsavel FOREIGN KEY(id_responsavel) REFERENCES maestro_lider.pessoa(id_pessoa)
);

--GRANT REFERENCES ON [OTHER_SCHEMA].pessoa TO maestro_lider;

ALTER TABLE maestro_lider.responsavel MODIFY(cpf VARCHAR(11) NOT NULL, telefone VARCHAR(13) NOT NULL);

DESC pessoa;