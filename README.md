# AirPlanner


Para importar y que se pueda ejecutar el proyecto con IntelliJ seguir las siguientes instrucciones:
1. File -> import
2. Seleccionar Git -> Proyects from Git
3. Clone URI, en URI, copiar dirección del repositorio: "direccion_repo"
4. En branch Selection dejar rama master predeterminada ->Next
5. En Local Destination, seleccionar carpeta que quieres que sea la carpeta del proyecto ->Next
6. Select a wizard to use for importing projects:
	Seleccionar Import using the New Project Wizard
	Select Wizard:
	Carpeta /Web/Dynamic Web Project -> Next
	Seleccionar carpeta padre del proyecto y poner nombre al proyecto "AirPlanner"


# Apache Tomcat version 9

Se necesita meter en la carpeta lib se la carpeta origen del Servidor Apache Tomcat la librerías mysql-conector.jar y javax-json.jar proporcionadas en la carpeta del proyecto en /jarAdicionalesTomcat


# Base De Datos

Requisito: MySQL


Para la creación de la base de datos airplanner", se proporciona el fichero ./db/creacion.sql", para crear la base de datos ejecutar el siguiente comando en el CLI de MySQL:

		1. source C:\ruta\al\fichero\creacion.sql
		
Para insertar usuarios de prueba leemos el otro fichero de este directorio "insercion.sql" con el siguiente comando:

		2. source C:\ruta\al\fichero\insercion.sql







