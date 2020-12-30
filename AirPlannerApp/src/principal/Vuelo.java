package principal;

public class Vuelo {
	
	private int idVuelo;
	private String origen;
	private String destino;
	private int precio;
	private String fechaSalida;
	private String oferta;
	
	
	
	
	public Vuelo(int idVuelo, String origen, String destino, int precio, String fechaSalida, String oferta) {
		super();
		this.idVuelo = idVuelo;
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
		this.fechaSalida = fechaSalida;
		this.oferta = oferta;
	}
	
	
	
	public int getIdVuelo() {
		return idVuelo;
	}
	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getOferta() {
		return oferta;
	}
	public void setOferta(String oferta) {
		this.oferta = oferta;
	}
	
	
	
	

	
	
}