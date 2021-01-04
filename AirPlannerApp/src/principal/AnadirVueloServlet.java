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
 * Servlet implementation class ListaDeDeseosServlet
 */
@WebServlet({ "/AnadirVueloServlet", "/html/añadirVuelo" })
public class AnadirVueloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnadirVueloServlet() {
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
		
		 int idVueloDeseado = Integer.parseInt(request.getParameter("OPCION"));
		 Vuelo vueloAmeter = new Vuelo();
		 ArrayList<Vuelo> vuelos = (ArrayList<Vuelo>) request.getSession().getAttribute("vuelos");
		 String userName = (String) request.getSession().getAttribute("userName");
		 
		 VueloDao dao = new VueloDao();
		 boolean vueloInsertado = false;
		 
		 for (Vuelo vuelo: vuelos) {
			 if (vuelo.getIdVuelo() == idVueloDeseado) {
				 vuelo.setUserName(userName);
				 vueloInsertado = dao.insert(vuelo);
				 vueloAmeter = vuelo;
			 }
		 }
		 
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 
		 if (vueloInsertado == true) {
			 if (comprobarRolUsuario(request.getSession()) == 1) { // Usuario normal
				 
				 try {
						out.println("<html><head><title>Vuelo añadido correctamente a la lista de deseos</title></head><body>");
						out.println("<h1>" + "Vuelo añadido correctamente a la lista de deseos"   + "</h1>");
						out.println(" <input type=\"button\" onclick=\"location.href='dashboard_usuario.html'\"class=\"btn btn-outline-secondary\" value=\"Volver\">");
						out.println("</body></html>");
						} finally{out.close();}
				 
				 
				 
			 } else { // Usuario Premium
				 
				 try {
						out.println("<html><head><title>Vuelo añadido correctamente a la lista de deseos</title></head><body>");
						out.println("<h1>" + "Vuelo añadido correctamente a la lista de deseos"   + "</h1>");
						out.println(" <input type=\"button\" onclick=\"location.href='dashboard_premium.html'\"class=\"btn btn-outline-secondary\" value=\"Volver\">");
						out.println("</body></html>");
						} finally{out.close();}
				 
			 }
			 
		 } else {
				mensajeError(request,response);	
			}
		 
	}
	
	private int comprobarRolUsuario(HttpSession sesion) {
		int rol = (int) sesion.getAttribute("rol");
		
		return rol;
	}
	
	private void mensajeError(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		if (comprobarRolUsuario(request.getSession()) == 1) { // caso de usuario normal
			
			try {
				out.println("<html><head><title>Error </title></head><body>");
				out.println("<h1>" + "Error la oferta ha expirado"   + "</h1>");
				out.println(" <input type=\"button\" onclick=\"location.href='dashboard_usuario.html'\"class=\"btn btn-outline-secondary\" value=\"Volver\">");
				out.println("</body></html>");
				} finally{out.close();}
    		
    	} else { // caso de usuario premium
    		
    		try {
    			out.println("<html><head><title>Error </title></head><body>");
    			out.println("<h1>" + "Error, la oferta ha expirado"   + "</h1>");
    			out.println(" <input type=\"button\" onclick=\"location.href='dashboard_premium.html'\"class=\"btn btn-outline-secondary\" value=\"Volver\">");
    			out.println("</body></html>");
    			} finally{out.close();}

    		
    	}
	
	}

}
