package principal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VueloDao {

	//puero 3306: puerto de escucha servidor sql
	//airplanner: nombre de la base de datos
		private String dbUrl = "jdbc:mysql://localhost:3306/airplanner?serverTimezone=UTC"; 
		private String dbUname = "root";
		private String dbPassword = "1234";
		private String dbdriver = "com.mysql.cj.jdbc.Driver"; 
		
		private Statement statementConsulta = null;
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
				statementCreacion.execute("CREATE TABLE if not exists airplanner.vuelo (\r\n"
						+ "	idVuelo int not null auto_increment,\r\n"
						+ "	origen VARCHAR(30) NOT NULL,\r\n"
						+ "	destino VARCHAR(30) NOT NULL,\r\n"
						+ "	precio int NOT NULL,\r\n"
						+ "	fechaSalida date NOT NULL,\r\n"
						+ "	oferta varchar(30) not null,\r\n"
						+ "	PRIMARY KEY (idVuelo)\r\n"
						+ "	)");
				conn.close();
				tablaCreada = true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error en la creación de la tabla usuario");
				tablaCreada = false;
			}
		} 	
		
		
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

	
	

}
