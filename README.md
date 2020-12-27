# AirPlanner


Para importar y que se pueda ejecutar el proyecto con Eclipse Enterprise Edition seguir las siguientes instrucciones:
1. File -> import
2. Seleccionar Git -> Proyects from Git
3. Clone URI, en URI, copiar dirección del repositorio: "direccion_repo"
4. En branch Selection dejar rama master predeterminada ->Next
5. En Local Destination, seleccionar carpeta que quieres que sea la carpeta del proyecto ->Next
6. Select a wizard to use for importing projects:
	Seleccionar Import using the New Project Wizard -> Finish
7. Select Wizard:
	Carpeta /Web/Dynamic Web Project -> Next
	Seleccionar carpeta padre del proyecto y poner nombre al proyecto (Nombrar igual que el proyecto)
8. Java
	Next
9. Web Module
	Context root: AirPlannerApp
	Content directory: WebContent
	Marcar casilla para generarl el web.xml automaticamente -> Finish

## Configuración Proyecto
	Click boton derecho proyecto:
	- Properties -> Java Build Path
	- Añadir el JDK que tengas instalado en el ordenador como librería en caso de no tener uno configurado:
		- Modulepath -> Add Library -> JRE System Library -> Next -> Workspace default JRE -> Finish
	- Añadir El Servidor Apache Tomcat v9.0 como Runtime Environmet en caso de no tener uno configurado:
		- ClassPath -> Add Library -> Server Runtime -> Apache Tomcat v 9.0 -> Finish

	


# Apache Tomcat version 9

Se necesita meter en la carpeta lib se la carpeta origen del Servidor Apache Tomcat la librerías mysql-conector.jar y javax-json.jar proporcionadas en la carpeta del proyecto en /jarAdicionalesTomcat


# Base De Datos

- Requisito: Servidor MySQL
	Para que funcione la conexión con la base de datos, hay que tener configurado un usuario: root con password: 1234

- Para la creación de la base de datos, se proporciona el fichero ./db/"creacionSchema.sql".
	Ejecutar el siguiente comando en la consola CLI de MySQL:
	
		1. source C:\ruta\al\fichero\creacionSchema.sql
	
	De esta forma se crea la base de datos vacía, requisito necesario antes de la ejecución de la aplicación.
	
- Para más información para los desarrolladores, en los ficheros ./db/"creacionTablas.sql" y ./db/"insercion.sql" se encuentran los scripts de creacion de las tablas de la base de datos que se van a ejecutar durante la ejecución de la aplicación y ejemplos del formato de inserciones en las tablas que se realizarán durante la ejecución.
- Esto se incorpora para que puedan entender como está estructurada la base de datos por dentro.






