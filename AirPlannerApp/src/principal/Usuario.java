package principal;

public class Usuario {
	
	private String nombre, apellido, userName, password;
	int rol;
	
	
	public Usuario() {
		super();
	}
	
	//	Constructor de Usuario solo con username y password, utilizado en la comprobación del login.
	public Usuario(String username, String password) {
		super();
		this.userName = username;
		this.password = password;
	}
	
	
	// rol de usuario por defecto = 1
	public Usuario(String nombre, String apellido, String userName, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.userName = userName;
		this.password = password;
		this.rol = 1;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}