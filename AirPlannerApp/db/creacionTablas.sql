
CREATE TABLE if not exists airplanner.usuario (
	idUsuario int not null auto_increment,
	nombre VARCHAR(30) NOT NULL,
	apellido VARCHAR(30) NOT NULL,
	userName VARCHAR(30) unique NOT NULL,
	password VARCHAR(45) NOT NULL,
	rol int default 1,
	PRIMARY KEY (idUsuario)
	);

