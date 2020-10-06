CREATE DATABASE crudCinema;
use crudCinema;

CREATE TABLE Filme (
   idFilme              INT               PRIMARY KEY AUTO_INCREMENT,
   nome                 VARCHAR(45)       NOT NULL,
   nota                 Double            NOT NULL,
   ano                  INT               NOT NULL
);

INSERT INTO Filme VALUES      (NULL, 'Vingadores 4' , 8.6 , 2019),
                              (NULL, 'John Wick 3' , 7.9 , 2019);