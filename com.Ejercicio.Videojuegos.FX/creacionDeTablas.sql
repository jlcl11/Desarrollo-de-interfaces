create database bd_jogos;
use bd_jogos;


CREATE TABLE juego(
id int primary key auto_increment,
nombre VARCHAR(30) NOT NULL,
precio INT NOT NULL,
consola VARCHAR(30) NOT NULL,
pegi INT NOT NULL
);

INSERT INTO juego(nombre,precio,consola,pegi) VALUES('el del ron',12,'w',12);

delete from juego where id=1;