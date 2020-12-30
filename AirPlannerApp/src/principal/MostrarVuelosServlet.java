package principal;

import java.io.IOException;
import java.io.PrintWriter;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarVuelosServlet() {
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
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String origen = request.getParameter("origen");
		String destino = request.getParameter("destino");
		String precio = request.getParameter("precios");
		String fechaSalida = request.getParameter("fechaSalida");
		
		try {
			out.println("<html>");
			out.println("<head><title>Hola mundo</title></head>");
			out.println("<body>");
			out.println("<h1>¡Hola mundo!    " + origen + "</h1>");
			out.println("<h1>¡Hola mundo!    " + destino + "</h1>");
			out.println("<h1>¡Hola mundo!    " + precio + "</h1>");
			out.println("<h1>¡Hola mundo!    " + fechaSalida + "</h1>");
			out.println("</body></html>");
		} finally {
			out.close();
		}
		
	}

}
