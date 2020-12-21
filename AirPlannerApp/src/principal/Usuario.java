package principal;

public class Usuario {
	
	private String nombre, apellido1, apellido2, nombreUsuario, email, nacionalidad, dni, contraseña;
	private String telefono;
	
	
	public Usuario() {
		super();
	}
	
	//	Constructor de Usuario solo con username y password, utilizado en la comprobación del login.
	public Usuario(String username, String password) {
		super();
		this.nombreUsuario = username;
		this.contraseña = password;
	}
	
	public Usuario(String nombre, String apellido1, String apellido2, String nombreUsuario, String email,
			String nacionalidad, String dni, String telefono, String contraseña) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.nacionalidad = nacionalidad;
		this.dni = dni;
		this.telefono = telefono;
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	
	
	
	
}
