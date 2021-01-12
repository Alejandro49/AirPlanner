package principal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

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
		
		Vuelo vuelo;
		
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
			
			try {
				statementCreacion.execute("CREATE TABLE if not exists airplanner.vuelo (\r\n"
						+ "	idVuelo int not null,\r\n"
						+ "	origen VARCHAR(30) NOT NULL,\r\n"
						+ "	destino VARCHAR(30) NOT NULL,\r\n"
						+ "	precio int NOT NULL,\r\n"
						+ "	fechaSalida date NOT NULL,\r\n"
						+ "	oferta varchar(30) not null,\r\n"
						+ "	userName VARCHAR(30) NOT NULL,\r\n"
						+ "	PRIMARY KEY (idVuelo),\r\n"
						+ "	foreign key (userName) references usuario(userName) on delete cascade on update cascade\r\n"
						+ "	\r\n"
						+ " )");
				conn.close();
				tablaCreada = true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error en la creación de la tabla \"vuelo\" ");
				tablaCreada = false;
			}
		} 	
		
		//Devuelve true si se produce la correcta inserción del vuelo en la base de datos.
		public boolean insert(Vuelo vuelo) { 
			
			if (tablaCreada == false) {
				creacionTabla();
			}
			
			cargarDriver(dbdriver); 
			Connection conn = getConnection();
			
			boolean insercionVuelo = true;
			
			String sql = "insert into airplanner.vuelo(idVuelo, origen, destino, precio, fechaSalida, oferta, userName) values(?,?,?,?,?,?,?);";
			
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, vuelo.getIdVuelo());
				ps.setString(2, vuelo.getOrigen());
				ps.setString(3, vuelo.getDestino());
				ps.setInt(4, vuelo.getPrecio());
				ps.setString(5, vuelo.getFechaSalida());
				ps.setString(6, vuelo.getOferta());
				ps.setString(7, vuelo.getUserName());
				ps.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error en la insercion del vuelo");
				insercionVuelo = false;
			}
			return insercionVuelo;
		}
		
		public ArrayList<Vuelo> obtenerListaDeseos(String username) {
			ArrayList <Vuelo> vuelos = new ArrayList<Vuelo>();
			
			cargarDriver(dbdriver); 
			Connection conn = getConnection();
			
			String userNameSql = "'" + username + "'";
			
			String query = "select * from airplanner.vuelo where userName = " + userNameSql;
			
			try {
				statementConsulta = conn.createStatement();
				ResultSet rs = statementConsulta.executeQuery(query);
				while (rs.next()) {
					int idVuelo = rs.getInt("idVuelo");
					String origen = rs.getString("origen");
					String destino = rs.getString("destino");
					int precio = rs.getInt("precio");
					String fechaSalida = rs.getString("fechaSalida");
					String oferta = rs.getString("oferta");
					String userName = rs.getString("userName");
					Vuelo vuelo = new Vuelo (idVuelo, origen, destino, precio, fechaSalida, oferta, userName);
					vuelos.add(vuelo);
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return vuelos;
		}
		
		public int getIdMasAlto() {
			
			int idMasAlto = 0;
			cargarDriver(dbdriver); 
			Connection conn = getConnection();
			
			String sql = "select idVuelo from airplanner.vuelo order by idVuelo desc";
			
			try {
				statementConsulta = conn.createStatement();
				ResultSet rs = statementConsulta.executeQuery(sql);
				
				rs.next();
				idMasAlto = rs.getInt("idVuelo");
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return idMasAlto;
		}
		
		public void eliminarListaDeDeseos(String username) {
			
			cargarDriver(dbdriver); 
			Connection conn = getConnection();
			
			String userNameSql = "'" + username + "'";
			
			String query = "delete from airplanner.vuelo where userName = " + userNameSql;
			
			try {
				statementConsulta = conn.createStatement();
				statementConsulta.executeUpdate(query);
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void eliminarVuelo(int idVuelo) {
			
			cargarDriver(dbdriver); 
			Connection conn = getConnection();
			
			String query = "delete from airplanner.vuelo where idVuelo = " + idVuelo;
			
			try {
				statementConsulta = conn.createStatement();
				statementConsulta.executeUpdate(query);
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		

	
	

}
