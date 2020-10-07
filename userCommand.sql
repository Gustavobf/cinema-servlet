CREATE DATABASE usersCrudCinema;
USE usersCrudCinema;

CREATE TABLE Usuario (
   idUsuario             INT               PRIMARY KEY AUTO_INCREMENT,
   login                 VARCHAR(45)       NOT NULL,
   senha                 VARCHAR(45)            NOT NULL
);

INSERT INTO Usuario VALUES      (NULL, 'gustavo' ,'123456'),
                                (NULL, 'usuario' ,'123');