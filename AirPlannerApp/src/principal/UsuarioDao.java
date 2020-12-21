package principal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//comentario sobre la contraseña, se está guardando en claro en la BBDD habría que pasarla como un hash o insertarla usando la funcion hash de mysql para que se almacene encriptada.
// Respuesta: Si sabes hacerlo hazlo, pero que no machaque lo que ya llevamos.
public class UsuarioDao {
	
	
		//puero 3306: puerto de escucha servidor sql
		//chatLearn: nombre de la base de datos
		private String dbUrl = "jdbc:mysql://localhost:3306/chatlearn?serverTimezone=UTC"; // por que ?servertimezone? esto se puede quitar. // Respuesta: Sin esto no funciona
		private String dbUname = "root";
		private String dbPassword = "root";
		private String dbdriver = "com.mysql.cj.jdbc.Driver"; // innecesario a partir de java 7 // haz la prueba y veras que no funciona
		
		//este metodo es innecesario a partir de java 7, ya se carga el driver automaticamente.  // haz la prueba y veras que es necesario
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
		
		public boolean insert(Usuario user) { //hay que cerrar la conexion a la BBDD
			
			cargarDriver(dbdriver); 
			Connection conn = getConnection();
			
			boolean insercionUsuario = true;
			
			String sql = "insert into chatlearn.usuario values(?,?,?,?,?,?,?,?,?)";
			
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user.getNombre());
				ps.setString(2, user.getApellido1());
				ps.setString(3, user.getApellido2());
				ps.setString(4, user.getNombreUsuario());
				ps.setString(5, user.getEmail());
				ps.setString(6, user.getNacionalidad());
				ps.setString(7, user.getDni());
				ps.setString(8, user.getTelefono());
				ps.setString(9, user.getContraseña());
				
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				insercionUsuario = false;
			}
			return insercionUsuario;
		}
		
		public boolean validarUsuario(Usuario user) { 
			cargarDriver(dbdriver); 
			Connection conn = getConnection();
			
			boolean loginUsuario = false;
			
			String sql = "select * from chatlearn.usuario where userName = ? and contrasena = ?";
			
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user.getNombreUsuario());
				ps.setString(2, user.getContraseña());
				
				ResultSet resultadoConsulta = ps.executeQuery();
				loginUsuario = resultadoConsulta.next();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
			
			return loginUsuario;
		}

}
