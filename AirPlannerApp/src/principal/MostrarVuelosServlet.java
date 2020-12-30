package principal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarVuelosServlet
 */
@WebServlet({ "/MostrarVuelosServlet", "/html/buscarVuelos" })
public class MostrarVuelosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	ArrayList<Vuelo> vuelos;    
	
	
    
    @Override
	public void init() throws ServletException {
    	
		super.init();
	}





	public MostrarVuelosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (datosCorrectos(request)) {
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("");
			out.println("<head>");
			out.println("<title> Busqueda de vuelos </title>");
			out.println("<meta name=\"GENERATOR\" " +
			"content=\"Microsoft FrontPage 3.0\">");
			out.println("</head>");
			out.println("");
			out.println("<body>");
			out.println("");
			out.println("<H2 align=\"center\"> Mejores recomendaciones de vuelos con los datos introducidos </H2>");
			out.println("<div align=\"center\"><center>");
			out.println("");
			out.println("<table border=\"1\" width=\"70%\">");
			
			out.println("<tr>");
			out.println("<td width=\"14%\" bgcolor=\"#808080\">"+
			"<font color=\"#FFFFFF\"> Link </font></td>");
			out.println("<td width=\"14%\" bgcolor=\"#808080\">"+
			"<font color=\"#FFFFFF\"> Id Vuelo </font></td>");
			out.println("<td width=\"14%\" bgcolor=\"#808080\">"+
			"<font color=\"#FFFFFF\"> Origen </font></td>");
			out.println("<td width=\"14%\" bgcolor=\"#808080\">"+
			"<font color=\"#FFFFFF\"> Destino </font></td>");
			out.println("<td width=\"14%\" bgcolor=\"#808080\">"+
			"<font color=\"#FFFFFF\"> Precio (€) </font></td>");
			out.println("<td width=\"14%\" bgcolor=\"#808080\">"+
			"<font color=\"#FFFFFF\"> fechaSalida </font></td>");
			out.println("<td width=\"14%\" bgcolor=\"#808080\">"+
			"<font color=\"#FFFFFF\"> Tipo de Oferta </font></td>");
			out.println("</tr>");
			
			//Datos de los vuelos por filas
			
			vuelos = generarVuelos(request);
			for (Vuelo vuelo: vuelos) {
				out.println("<tr>");
				out.println("<td width=\"14%\">"+"<a href=\"https://video-6553-dwmdqw.twil.io/index.html\">Link</a> </td>");
				out.println("<td width=\"14%\">"+vuelo.getIdVuelo()+"</td>");
				out.println("<td width=\"14%\">"+vuelo.getOrigen()+"</td>");
				out.println("<td width=\"14%\">"+vuelo.getDestino()+"</td>");
				out.println("<td width=\"14%\">"+vuelo.getPrecio()+"</td>");
				out.println("<td width=\"14%\">"+vuelo.getFechaSalida()+"</td>");
				out.println("<td width=\"14%\">"+vuelo.getOferta()+"</td>");
				out.println("</tr>");
			}
			
		} else {
			
			mensajeError(response);
				
		}
			
	}
	
	private boolean datosCorrectos(HttpServletRequest req) {
		
		String origen = req.getParameter("origen");
		String destino = req.getParameter("destino");
		String precio = req.getParameter("precios");
		String fechaSalida = req.getParameter("fechaSalida");
		
		if (origen.equals("") || destino.equals("") || precio.equals("") || fechaSalida.equals("")) {	
			return false;
			
		} else {	
			return true;
		}
		
	}
	
	private void mensajeError(HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			out.println("<html>");
			out.println("<head><title>Air Planner </title></head>");
			out.println("<body>");
			out.println("<h2> Error, rellene todos los campos por favor </h2>");
			out.println(" <input type=\"button\" onclick=\"location.href='buscarVuelos.html'\"class=\"btn btn-outline-secondary\" value=\"Volver\">");
			out.println("</body></html>");
		} finally {
			out.close();
		}
		
	}
	
	
	private ArrayList<Vuelo> generarVuelos(HttpServletRequest request) {
		
		String origen = request.getParameter("origen");
		String destino = request.getParameter("destino");
		String rangoPrecios = request.getParameter("precios");
		
		String fechaSalida = request.getParameter("fechaSalida");
		
		int limiteSuperior = (int)(Math.random()*(15-7+1)+7);  //número aleatorio entre 15 y 7
		
		ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
		
		for (int i = 1; i < limiteSuperior; i++) {
			
			Vuelo vuelo = new Vuelo(i, origen, destino, calcularPrecio(rangoPrecios), fechaSalida, tipoDeOferta());
			vuelos.add(vuelo);
		}
		
		
		return vuelos;
		
	}
	
	private String tipoDeOferta() {
		String oferta;
		Random numAleatorio = new Random();
		// Genera un boolean de forma aleatoria
		boolean premium = numAleatorio.nextBoolean();

		if (premium) {
		    oferta = "premium";
		} else {
		    oferta = "normal";
		}
		
		return oferta;
		
	}
	
	private int calcularPrecio(String rangoPrecios) {
		
		int precio = 0;
		
		// int numero = (int)(Math.random()*(X-Y+1)+Y; donde X limite superior e Y limite inferior
		if (rangoPrecios.equals("precioBajo")) {
			precio = (int)(Math.random()*(50-10+1)+10);  // Numero aleatorio entre 50 y 10
		}
		if (rangoPrecios.equals("precioMedio")) {
			precio = (int)(Math.random()*(100-51+1)+51);  // Numero aleatorio entre 100 y 51
		}
		if (rangoPrecios.equals("precioAlto")) {
			precio = (int)(Math.random()*(700-101+1)+101);  // Numero aleatorio entre 700 y 101
		}

		return precio;
		
	}
	

}
