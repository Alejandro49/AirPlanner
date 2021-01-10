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
@WebServlet({ "/ListaDeseosServlet", "/html/listaDeseos" })
public class ListaDeseosServlet extends HttpServlet {
	
	ArrayList <Vuelo> vuelos;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaDeseosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("");
		out.println("<head>");
		out.println("<title> Lista de deseos </title>");
		out.println("<meta name=\"GENERATOR\" " +
		"content=\"Microsoft FrontPage 3.0\">");
		out.println("</head>");
		out.println("");
		out.println("<body>");
		out.println("");
		out.println("<H2 align=\"center\"> Lista de deseos </H2>");
		out.println("<H4 align=\"center\"> Seleccione el vuelo que desea comprar </H4>");
		out.println("<div align=\"center\"><center>");
		out.println("<form method=\"POST\" action=\"comprarVuelo\">");
		out.println("");
		out.println("<table border=\"1\" width=\"70%\">");
		
		out.println("<tr>");
		out.println("<td width=\"16%\" bgcolor=\"#808080\">"+
		"<font color=\"#FFFFFF\"> Id Vuelo </font></td>");
		out.println("<td width=\"16%\" bgcolor=\"#808080\">"+
		"<font color=\"#FFFFFF\"> Origen </font></td>");
		out.println("<td width=\"16%\" bgcolor=\"#808080\">"+
		"<font color=\"#FFFFFF\"> Destino </font></td>");
		out.println("<td width=\"16%\" bgcolor=\"#808080\">"+
		"<font color=\"#FFFFFF\"> Precio (€) </font></td>");
		out.println("<td width=\"16%\" bgcolor=\"#808080\">"+
		"<font color=\"#FFFFFF\"> fechaSalida </font></td>");
		out.println("<td width=\"16%\" bgcolor=\"#808080\">"+
		"<font color=\"#FFFFFF\"> Tipo de Oferta </font></td>");
		out.println("</tr>");
		
		
		HttpSession sesion = request.getSession();
		String userName = (String) sesion.getAttribute("userName");
		
		VueloDao dao = new VueloDao();
		vuelos = dao.obtenerListaDeseos(userName);
		
		for (Vuelo vuelo: vuelos) {
			
			out.println("<tr>");
			out.println("<td width=\"14%\"><input type=\"radio\" value=" + vuelo.getIdVuelo() + " checked name=\"OPCION\">"+vuelo.getIdVuelo() + "</input></td>");
			out.println("<td width=\"14%\">"+vuelo.getOrigen()+"</td>");
			out.println("<td width=\"14%\">"+vuelo.getDestino()+"</td>");
			out.println("<td width=\"14%\">"+vuelo.getPrecio()+"</td>");
			out.println("<td width=\"14%\">"+vuelo.getFechaSalida()+"</td>");
			out.println("<td width=\"14%\">"+vuelo.getOferta()+"</td>");
			out.println("</tr>");
			
			
		}
		
		if (comprobarRolUsuario(request.getSession()) == 1) { // Usuario normal
			 
			 try {
				 	out.println("</table>");
     				out.println("<input type=\"submit\" class=\"btn btn-primary\" value=\"Comprar vuelo\" name=\"BotonEnviar\">");
     				out.println(" <input type=\"button\" onclick=\"location.href='dashboard_usuario.html'\" class=\"btn btn-primary text-white\" value=\"Volver\">");
     				out.println("</form>");
					} finally{out.close();}
			 
			 
			 
		 } else { // Usuario Premium
			 
			 try {
				 	out.println("</table>");
				 	out.println("<input type=\"submit\" class=\"btn btn-primary\" value=\"Añadir a la lista de deseos\" name=\"BotonEnviar\">");
				 	out.println(" <input type=\"button\" onclick=\"location.href='dashboard_premium.html'\" class=\"btn btn-primary text-white\" value=\"Volver\">");
				 	out.println("</form>");;
					} finally{out.close();}
			 
		 }
		
		out.println("</body></html>");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private int comprobarRolUsuario(HttpSession sesion) {
		int rol = (int) sesion.getAttribute("rol");
		
		return rol;
	}

}
