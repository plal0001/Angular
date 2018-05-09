/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Pedro Luis
 * Created: 04-abr-2018
 */
/*
    ELIMINAMOS LAS TABLAS ANTERIORES
*/
DROP TABLE Entradas;
DROP TABLE  Usuarios;
DROP TABLE Conciertos;


/*
    CREAMOS LAS TABLAS
*/

CREATE TABLE Usuarios (
    usuario VARCHAR(25) NOT NULL PRIMARY KEY,
    pass VARCHAR(30),
    nombre VARCHAR(30),
    apellidos VARCHAR(50),
    correo VARCHAR(100),
    fNac VARCHAR(10),
    tlfn INTEGER,
    tipoUsuario VARCHAR(20)
);

CREATE TABLE Conciertos(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
    imagen VARCHAR(20),
    nombre VARCHAR(50),
    artista VARCHAR(50),
    precio DECIMAL(5,2),
    fecha VARCHAR(10),
    hora VARCHAR(8),
    genero VARCHAR(20)
);

CREATE TABLE Entradas(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    usuario VARCHAR(25) REFERENCES Usuarios(usuario),
    concierto INTEGER REFERENCES Conciertos(id),
    cantidad INTEGER

);

/*
datos de prueba para usuarios
*/
INSERT INTO Usuarios VALUES
('SH', 'sh', 'Stephen', 'Hawkings', 'sh@butan.es','1942-01-08' ,953665412 , 'Administrador' );
INSERT INTO Usuarios VALUES
('manu', 'manu', 'manuel', 'garcia', 'manuel@correo.es','1985-05-21' ,953693625 , 'Registrado' );
INSERT INTO Usuarios VALUES
('ana1', 'ana', 'ana', 'Martinez', 'ana@correo.es','1972-07-12' ,953698525 , 'Artista' );



/*
datos de prueba conciertos
*/
INSERT INTO Conciertos (imagen,nombre,artista,precio,fecha,hora,genero) VALUES
('concierto1.jpg','Blunk de gira','blunk',10.0,'2018-09-22','21:30','Rock');
INSERT INTO Conciertos (imagen,nombre,artista,precio,fecha,hora,genero) VALUES
('concierto2.jpg','Meus-Eum','meus',15.0,'2018-08-01','23:00','Indie');
INSERT INTO Conciertos (imagen,nombre,artista,precio,fecha,hora,genero) VALUES
('concierto3.jpg','The Bank','50penny',8.0,'2018-10-15','10:30','Rap');
INSERT INTO Conciertos (imagen,nombre,artista,precio,fecha,hora,genero) VALUES
('concierto4.jpg','A recuperar','A tu p*ta kara',150.0,'2018-07-07','9:00','Heavy metal');
INSERT INTO Conciertos (imagen,nombre,artista,precio,fecha,hora,genero) VALUES
('concierto5.jpg','01 10 11 100 Dale','Chihuahua',0.0,'2018-07-15','10:30','Otro');

/*
datos prueba entradas
*/
INSERT INTO Entradas (usuario,concierto,cantidad) VALUES ('manu',1,10);
