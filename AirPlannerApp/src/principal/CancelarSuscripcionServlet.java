package principal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/html/cancelarSuscripcion")
public class CancelarSuscripcionServlet extends HttpServlet {
	
	UsuarioDao usuarioDao = new UsuarioDao();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelarSuscripcionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession sesion = request.getSession();
		String userName = (String) sesion.getAttribute("userName");
		
		
		if (usuarioDao.cancelarSuscripcion(userName)) {
			
			sesion.setAttribute("rol", 1);
			
			out.println("<html lang = \"es\">\r\n"
					+ "\r\n"
					+ "	<head>\r\n"
					+ "		<!-- Required meta tags -->\r\n"
					+ "		<meta charset = \"UTF-8\">\r\n"
					+ "		<meta name = \"viewport\" content = \"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n"
					+ "	\r\n"
					+ "		<!-- BOOTSTRAP CSS -->\r\n"
					+ "		<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\" \r\n"
					+ "		integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">\r\n"
					+ "		\r\n"
					+ "		<!-- CUSTOM CSS -->\r\n"
					+ "		<link rel=\"stylesheet\" href=\"../css/dashboard.css\">\r\n"
					+ "		<title>Air Planner</title>\r\n"
					+ "	</head>\r\n"
					+ "	\r\n"
					+ "	\r\n"
					+ "	<body class=\"main-header\">\r\n"
					+ "		<!-- Configuración Navbar -->\r\n"
					+ "		<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n"
					+ "			<div class=\"container\">\r\n"
					+ "				<a class=\"navbar-brand\">\r\n"
					+ "					<img src=\"../img/logo.png\" style=\"width: 30%;\"> </img>\r\n"
					+ "				</a>\r\n"
					+ "				<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
					+ "					<span class=\"navbar-toggler-icon\"></span>\r\n"
					+ "				</button>\r\n"
					+ "				<div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n"
					+ "					<ul class=\"navbar-nav ml-auto\">\r\n"
					+ "						<li class=\"nav-item\">\r\n"
					+ "							<a class=\"nav-link\" href=\"dashboard_usuario.html\">Inicio</a>\r\n"
					+ "						</li>\r\n"
					+ "						<li class=\"nav-item\">\r\n"
					+ "							<a class=\"nav-link\" href=\"dashboard_usuario.html\">Mi Perfil</a>\r\n"
					+ "						</li>\r\n"
					+ "						<li class=\"nav-item\">\r\n"
					+ "							<a class=\"nav-link\" href=\"buscarVuelos.html\">Visualización recomendaciones</a>\r\n"
					+ "						</li>\r\n"
					+ "						<li class=\"nav-item\">\r\n"
					+ "							<form method=\"GET\" action=\"listaDeseos\">\r\n"
					+ "							<input type=\"submit\" class=\"btn btn-outline-secondary btn-lg text-white\" value=\"Lista de deseos\">\r\n"
					+ "							<!-- <a class=\"nav-link\" href=\"#\">Lista de deseos</a> -->\r\n"
					+ "							</form>\r\n"
					+ "						</li>\r\n"
					+ "						<li class=\"nav-item\">\r\n"
					+ "							<a class=\"nav-link\" href=\"configuracion_usuario.html\">Configuración</a>\r\n"
					+ "						</li>\r\n"
					+ "						<li class=\"nav-item\">\r\n"
					+ "							<a class=\"nav-link\" href=\"logout_usuario.html\">Logout</a>\r\n"
					+ "						</li>\r\n"
					+ "					</ul>\r\n"
					+ "				</div>\r\n"
					+ "			</div>\r\n"
					+ "		</nav>\r\n"
					+ "\r\n"
					+ "		<div>\r\n"
					+ "			<h4> Has cancelado la suscripción </h4>\r\n"
					+ "			<p> Ya no se le cobrará la suscripción anual </p>\r\n"
					+ "         <p> Haga click en continuar </p> "
					+ "			<a class=\"btn btn-outline-secondary btn-lg text-white\" href=\"dashboard_usuario.html\">Continuar</a>\r\n"
					+ "			\r\n"
					+ "		</div>\r\n"
					+ "		<!--BOOTSTRAP JAVASCRIPT + JQuery --> \r\n"
					+ "		<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" \r\n"
					+ "		integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n"
					+ "		<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"\r\n"
					+ "		integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n"
					+ "		<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js\"\r\n"
					+ "		integrity=\"sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s\" crossorigin=\"anonymous\"></script>\r\n"
					+ "	</body>\r\n"
					+ "	\r\n"
					+ "	\r\n"
					+ "	\r\n"
					+ "</html>\r\n"
					+ "		\r\n"
					+ "");
			
		} else {
			mensajeError(response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void mensajeError(HttpServletResponse response) throws IOException {
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			try {
				out.println("<html>");
				out.println("<head><title>Air Planner </title></head>");
				out.println("<body>");
				out.println("<h2> Se ha producido un error </h2>");
				out.println(" <input type=\"button\" onclick=\"location.href='configuracion_usuario.html'\"class=\"btn btn-outline-secondary\" value=\"Volver\">");
				out.println("</body></html>");
			} finally {
				out.close();
			}
		
	}
	
}
