CREATE DATABASE IF NOT EXISTS concurso_db;

USE concurso_db;

CREATE TABLE IF NOT EXISTS jugador (
	id int primary key auto_increment NOT NULL,
	username VARCHAR(50) NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	apellido VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS pregunta (
	id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	pregunta VARCHAR(100) NOT NULL,
	categoria_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS respuesta (
	id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	respuesta VARCHAR(100) NOT NULL,
	correcto BIT(1) NOT NULL,
	pregunta_id int NOT NULL
);

CREATE TABLE IF NOT EXISTS categoria (
	id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	categoria VARCHAR(100) NOT NULL,
	nivel INT NOT NULL,
	puntos_id int NOT NULL
);

CREATE TABLE IF NOT EXISTS puntos (
	id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	puntos_otorgar INT NOT NULL
);

CREATE TABLE IF NOT EXISTS juegos (
	id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	jugador_id int NOT NULL,
	puntos_acumulados INT NOT NULL
);

#constraints

#JUGADOR
ALTER TABLE jugador ADD CONSTRAINT UNIQUE (username);

#PREGUNTA
ALTER TABLE pregunta ADD CONSTRAINT UNIQUE (pregunta);
ALTER TABLE pregunta ADD CONSTRAINT FK_pregunta_categoria FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIA(ID);

#RESPUESTA
ALTER TABLE respuesta ADD CONSTRAINT FK_respuesta_pregunta FOREIGN KEY (PREGUNTA_ID) REFERENCES PREGUNTA(ID);

#CATEGORIA
ALTER TABLE categoria ADD CONSTRAINT UNIQUE (categoria);
ALTER TABLE categoria ADD CONSTRAINT FK_categoria_puntos FOREIGN KEY (PUNTOS_ID) REFERENCES PUNTOS(ID);

#JUEGOS
ALTER TABLE juegos ADD CONSTRAINT FK_juegos_jugador FOREIGN KEY (JUGADOR_ID) REFERENCES JUGADOR(ID);

#datos 
#jugador
INSERT INTO jugador (username, nombre, apellido) values('jugador prueba','nombrePrueba', 'apellidoPrueba');

#puntos
INSERT INTO puntos (puntos_otorgar) values(2);
INSERT INTO puntos (puntos_otorgar) values(5);
INSERT INTO puntos (puntos_otorgar) values(8);
INSERT INTO puntos (puntos_otorgar) values(11);
INSERT INTO puntos (puntos_otorgar) values(15);

#categoria
INSERT INTO categoria (categoria, nivel, puntos_id) values('Ingles', 1, 1);
INSERT INTO categoria (categoria, nivel, puntos_id) values('Matematicas', 2, 2);
INSERT INTO categoria (categoria, nivel, puntos_id) values('Geografia', 3, 3);
INSERT INTO categoria (categoria, nivel, puntos_id) values('Historia', 4, 4);
INSERT INTO categoria (categoria, nivel, puntos_id) values('Entretenimiento', 5, 5);

#pregunta
INSERT INTO pregunta (pregunta, categoria_id) values('I am going ___ a new car.',1);
INSERT INTO pregunta (pregunta, categoria_id) values('How old are you?',1);
INSERT INTO pregunta (pregunta, categoria_id) values('Why do we ___ so much money on food?',1);
INSERT INTO pregunta (pregunta, categoria_id) values('Santa is ___ to town.',1);
INSERT INTO pregunta (pregunta, categoria_id) values('What music ___ you like five years ago?',1);

INSERT INTO pregunta (pregunta, categoria_id) values('Resuelva: 7 x 2 - 5',2);
INSERT INTO pregunta (pregunta, categoria_id) values('Resuelva: 7 - 2 * 5',2);
INSERT INTO pregunta (pregunta, categoria_id) values('Resuelva: 2 * 2 * 10',2);
INSERT INTO pregunta (pregunta, categoria_id) values('Resuelva: 10 / 5 * 10',2);
INSERT INTO pregunta (pregunta, categoria_id) values('Resuelva: 10 * 10 / 2',2);

INSERT INTO pregunta (pregunta, categoria_id) values('¿Cual es la capital de Dinamarca?',3);
INSERT INTO pregunta (pregunta, categoria_id) values('¿Cual es la capital de Costa Rica?',3);
INSERT INTO pregunta (pregunta, categoria_id) values('¿Cual es la capital de Francia?',3);
INSERT INTO pregunta (pregunta, categoria_id) values('¿Cual es la capital de Canada?',3);
INSERT INTO pregunta (pregunta, categoria_id) values('¿Cual es la capital de Japon?',3);

INSERT INTO pregunta (pregunta, categoria_id) values('¿Quien fue el ultimo zar de Rusia?',4);
INSERT INTO pregunta (pregunta, categoria_id) values('¿Que inicio la Segunda Guerra Mundial?',4);
INSERT INTO pregunta (pregunta, categoria_id) values('¿Donde nacio Adolf Hitler?',4);
INSERT INTO pregunta (pregunta, categoria_id) values('¿Quien fue el primer presidente de los Estados Unidos?',4);
INSERT INTO pregunta (pregunta, categoria_id) values('¿Donde tuvo lugar la revolucion de los misiles?',4);

INSERT INTO pregunta (pregunta, categoria_id) values('¿Cual fue la primera pelicula de Disney?',5);
INSERT INTO pregunta (pregunta, categoria_id) values('¿Cual de los actores que ha interpretado a James Bond lucho contra el Dr. No?',5);
INSERT INTO pregunta (pregunta, categoria_id) values('¿Que actriz interpreta a Wanda Maximoff en las peliculas de Marvel?',5);
INSERT INTO pregunta (pregunta, categoria_id) values('¿Cual es la pelicula mas taquillera de la historia?',5);
INSERT INTO pregunta (pregunta, categoria_id) values('¿Cual es la actriz con el mayor numero de premios Oscar recibidos?',5);

#respuesta
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('buy', 0, 1);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('to buy', 1, 1);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('to buying', 0, 1);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('will buy', 0, 1);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('I am 20 years old', 1, 2);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('I have 20 years old', 0, 2);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('I have 20 years', 0, 2);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('I have 20', 0, 2);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('purchase', 0, 3);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('buy', 0, 3);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('spend', 1, 3);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('sell', 0, 3);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('go', 0, 4);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('arrived', 0, 4);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('come', 0, 4);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('coming', 1, 4);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('did', 1, 5);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('do', 0, 5);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('have', 0, 5);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('would', 0, 5);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('10', 0, 6);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('9', 1, 6);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('8', 0, 6);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('11', 0, 6);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('-3', 1, 7);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('25', 0, 7);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('3', 0, 7);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('-4', 0, 7);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('40', 1, 8);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('4', 0, 8);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('44', 0, 8);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('14', 0, 8);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('0.2', 0, 9);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('2', 0, 9);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('12', 0, 9);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('20', 1, 9);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('10', 0, 10);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('2', 0, 10);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('50', 1, 10);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('5', 0, 10);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Copenhague', 1, 11);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Herning', 0, 11);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Odense', 0, 11);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Elsinor', 0, 11);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Cartago', 0, 12);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('San Jose', 1, 12);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Heredia', 0, 12);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Liberia', 0, 12);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Marsella', 0, 13);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Lyon', 0, 13);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Paris', 1, 13);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Toulouse', 0, 13);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Vancouver', 0, 14);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Calgary', 0, 14);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Toronto', 0, 14);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Ottawa', 1, 14);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Kanto', 0, 15);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Kioto', 0, 15);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Tokio', 1, 15);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Osaka', 0, 15);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Nicolas II', 1, 16);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Pedro I el Grande', 0, 16);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Alejandro II', 0, 16);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Teodoro II', 0, 16);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('El asesinato del archiduque Francisco Fernando', 0, 17);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('La invasion de Alemania a Polonia', 1, 17);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('La invasion de Alemania a Austria', 0, 17);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('El ataque de Japon a Pearl Harbor', 0, 17);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Rusia', 0, 18);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Alemania', 0, 18);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Austria', 1, 18);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Bulgaria', 0, 18);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Thomas Jefferson', 0, 19);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('John Adams', 0, 19);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('James Madison', 0, 19);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('George Washington', 1, 19);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Cuba', 1, 20);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Colombia', 0, 20);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Venezuela', 0, 20);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Ecuador', 0, 20);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Blancanieves y los siete enanitos', 1, 21);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Pinocho', 0, 21);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Dumbo', 0, 21);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Bambi', 0, 21);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Daniel Craig', 0, 22);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Sean Connery', 1, 22);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Pierce Brosnan', 0, 22);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Timothy Dalton', 0, 22);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Scarlett Johansson', 0, 23);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Ashley Olsen', 0, 23);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Elizabeth Olsen', 1, 23);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Florence Pugh', 0, 23);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Jurassic World', 0, 24);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Titanic', 0, 24);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Avengers: Endgame', 0, 24);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Avatar', 1, 24);

INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Meryl Streep', 0, 25);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Katharine Hepburn', 1, 25);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Ingrid Bergman', 0, 25);
INSERT INTO respuesta (respuesta,correcto,pregunta_id) values('Frances McDormand', 0, 25);