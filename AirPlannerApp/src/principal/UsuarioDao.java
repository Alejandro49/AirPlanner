package principal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class UsuarioDao {
	
	
		//puero 3306: puerto de escucha servidor sql
		//chatLearn: nombre de la base de datos
		private String dbUrl = "jdbc:mysql://localhost:3306/airplanner?serverTimezone=UTC"; 
		private String dbUname = "root";
		private String dbPassword = "1234";
		private String dbdriver = "com.mysql.cj.jdbc.Driver"; 
		
		private Statement statementCreacion = null;
		boolean tablaCreada = false;
		
		private void cargarDriver(String dbDriver) {
			try {
				Class.forName(dbDriver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private Connection getConnection() {
			
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
			
		}
		
		private void creacionTabla() {
			
			cargarDriver(dbdriver); 
			Connection conn = getConnection();
				
			try {
				statementCreacion = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// id autoincremental. UserName Unique, rol por defecto = 1.
			try {
				statementCreacion.execute("CREATE TABLE if not exists airplanner.usuario (\r\n"
						+ "	idUsuario int not null auto_increment,\r\n"
						+ "	nombre VARCHAR(30) NOT NULL,\r\n"
						+ "	apellido VARCHAR(30) NOT NULL,\r\n"
						+ "	userName VARCHAR(30) unique NOT NULL,\r\n"
						+ "	password VARCHAR(45) NOT NULL,\r\n"
						+ "	rol int default 1,\r\n"
						+ "	PRIMARY KEY (idUsuario)\r\n"
						+ "	)");
				conn.close();
				tablaCreada = true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error en la creación de la tabla usuario");
				tablaCreada = false;
			}
		} 	
		
		// La primera vez que se llame a este método, se producirá la creación de la tabla usuario, y la inserción del usuario introducido en 
		// el formulario en esta tabla. Si la tabla ya esta creada, solo se realizará la inserción del usuario.
		// Devuelve true si se realiza la insercion del usuario en la base de datos
		public boolean insert(Usuario user) { 
			
			if (tablaCreada == false) {
				creacionTabla();
			}
			
			cargarDriver(dbdriver); 
			Connection conn = getConnection();
			
			boolean insercionUsuario = true;
			
			String sql = "insert into airplanner.usuario(nombre, apellido, userName, password) values(?,?,?,?)";
			
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user.getNombre());
				ps.setString(2, user.getApellido());
				ps.setString(3, user.getUserName());
				ps.setString(4, user.getPassword());
				ps.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error en la insercion del usuario");
				insercionUsuario = false;
			}
			return insercionUsuario;
		}
		
		// Devuelve true si los credenciales son correctos, devuelve false si los credenciales no coinciden con ningún usuario registrado
		public boolean validarUsuario(Usuario user) { 
			cargarDriver(dbdriver); 
			Connection conn = getConnection();
			
			boolean loginUsuario = false;
			
			String sql = "select * from airplanner.usuario where userName = ? and password = ?";
			
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user.getUserName());
				ps.setString(2, user.getPassword());
				
				ResultSet resultadoConsulta = ps.executeQuery();
				loginUsuario = resultadoConsulta.next();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
			
			return loginUsuario;
		}
		
		public Integer obtenerRol(Usuario user) {
			
			Integer rol = null;
			cargarDriver(dbdriver); 
			Connection conn = getConnection();
			
			String sql = "select rol from airplanner.usuario where userName = ?";
			
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user.getUserName());
				
				ResultSet resultadoConsulta = ps.executeQuery();
				rol = resultadoConsulta.getInt(1);
				conn.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
			return rol;
			
		}
		
}
