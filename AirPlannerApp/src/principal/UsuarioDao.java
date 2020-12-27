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
		
		private Statement statement = null;
		
		
		public void cargarDriver(String dbDriver) {
			try {
				Class.forName(dbDriver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public Connection getConnection() {
			
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn;
			
		}
		
		// Devuelve true si se realiza la insercion del usuario en la base de datos
		public boolean insert(Usuario user) { 
			
			cargarDriver(dbdriver); 
			Connection conn = getConnection();
			
			boolean insercionUsuario = true;
			
			try {
				statement = conn.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				insercionUsuario = false;

			}
			try {
				statement.execute("CREATE TABLE IF NOT EXISTS usuario (nombre varchar(100), apellido varchar(100), userName varchar(100), "
						+ "password varchar(100), rol tinyint)");
			} catch (Exception e) {
				System.out.println(e);
				insercionUsuario = false;

			}
			// Ultimo valor indica rol = 1 (usuario normal)
			String sql = "insert into airplanner.usuario values(?,?,?,?,1)";
			
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user.getNombre());
				ps.setString(2, user.getApellido());
				ps.setString(3, user.getUserName());
				ps.setString(4, user.getPassword());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
