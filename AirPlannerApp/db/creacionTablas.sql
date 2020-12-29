
CREATE TABLE if not exists airplanner.usuario (
	idUsuario int not null auto_increment,
	nombre VARCHAR(30) NOT NULL,
	apellido VARCHAR(30) NOT NULL,
	userName VARCHAR(30) unique NOT NULL,
	password VARCHAR(45) NOT NULL,
	rol int default 1,
	PRIMARY KEY (idUsuario)
	);
	
	
	CREATE TABLE if not exists airplanner.vuelo (
	idVuelo int not null auto_increment,
	origen VARCHAR(30) NOT NULL,
	destino VARCHAR(30) NOT NULL,
	precio int NOT NULL,
	fechaSalida date NOT NULL,
	oferta varchar(30) not null,
	PRIMARY KEY (idVuelo)
	);

