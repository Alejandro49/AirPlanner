package principal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ComprarVueloServlet
 */
@WebServlet({ "/ComprarVueloServlet", "/html/comprarVuelo" })
public class ComprarVueloServlet extends HttpServlet {
	
	ArrayList <Vuelo> vuelos;
	int idVueloAComprar;
	Vuelo vueloComprado;
	VueloDao vueloDao = new VueloDao();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComprarVueloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		String userName = (String) sesion.getAttribute("userName");
		
		idVueloAComprar = Integer.parseInt(request.getParameter("OPCION"));
		
		vuelos = vueloDao.obtenerListaDeseos(userName);
		
		 for (Vuelo vuelo: vuelos) {
			 if (vuelo.getIdVuelo() == idVueloAComprar) {
				 vueloComprado = vuelo;
				 respuestaDeCompra(vuelo,sesion,response);
				 break;
			 }
		 }
		 
		
	}
	
	
	private void respuestaDeCompra(Vuelo vuelo, HttpSession sesion, HttpServletResponse response) throws IOException {
		
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		
		if (comprobarRolUsuario(sesion) == 1) { // Usuario normal
			
			if (vuelo.getOferta().equals("normal")) { // oferta normal, que si puede comprar el usuario normal
				
				 vueloDao.eliminarVuelo(vuelo.getIdVuelo());
				 
				try {
					out.println("<html><head><title>Vuelo comprado correctamente</title></head><body>");
					out.println("<h2>" + "Vuelo con id: " + vuelo.getIdVuelo() +  " comprado correctamente"   + "</h2>");
					out.println("<h4> Le enviaremos la factura por correo </h4>");
					out.println("<h4> Eliminado de la lista de deseos </h4>");
					out.println("<form method=\"GET\" action=\"listaDeseos\">");
					out.println("<input type=\"submit\" class=\"btn btn-outline-secondary btn-lg text-white\" value=\"Volver\">");
					out.println("</body></html>");
					} finally{out.close();}
				
			} else {  // oferta premium, que no puede comprar el usuario normal
				try {
					out.println("<html><head><title>Error de privilegios </title></head><body>");
					out.println("<h2>" + "Debes de ser Usuario <strong> Premium </strong> para poder comprar las ofertas premium"   + "</h2>");
					out.println("<form method=\"GET\" action=\"listaDeseos\">");
					out.println("<input type=\"submit\" class=\"btn btn-outline-secondary btn-lg text-white\" value=\"Volver\">");
					out.println("</body></html>");
					} finally{out.close();}
				
			}
			 
		 } else { // Usuario Premium
			 
			 vueloDao.eliminarVuelo(vuelo.getIdVuelo());
			 
			 try {
				 	out.println("<html><head><title>Vuelo comprado correctamente</title></head><body>");
					out.println("<h2>" + "Vuelo con id: " + vuelo.getIdVuelo() +  " comprado correctamente"   + "</h2>");
					out.println("<h4> Le enviaremos la factura por correo </h4>");
					out.println("<h4> Eliminado de la lista de deseos </h4>");
					out.println("<form method=\"GET\" action=\"listaDeseos\">");
					out.println("<input type=\"submit\" class=\"btn btn-outline-secondary btn-lg text-white\" value=\"Volver\">");
					out.println("</body></html>");
					} finally{out.close();}
			 
		 }
		
	}
	
	
	
	private int comprobarRolUsuario(HttpSession sesion) {
		int rol = (int) sesion.getAttribute("rol");
		
		return rol;
	}

}
