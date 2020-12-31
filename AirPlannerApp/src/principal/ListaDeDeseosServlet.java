package principal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaDeDeseosServlet
 */
@WebServlet({ "/ListaDeDeseosServlet", "/html/listaDeseos" })
public class ListaDeDeseosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaDeDeseosServlet() {
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
		
		 String idVuelo = request.getParameter("OPCION");
		 ArrayList<Vuelo> vuelos = (ArrayList<Vuelo>) request.getSession().getAttribute("vuelos");
		 
		 	response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			try {
				out.println("<html>");
				out.println("<head><title>Hola mundo</title></head>");
				out.println("<body>");
				out.println("<h1>¡Hola mundo!" + idVuelo + "</h1>");
				
				for (Vuelo vuelo: vuelos) {
					
					out.println("<h4>¡Hola mundo!" + vuelo.getIdVuelo() + "</h4>");
				}
		
				
				out.println("</body></html>");
			} finally {
				out.close();
			}
	}

}
