package principal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MiPerfilServlet
 */
@WebServlet({"/MiPerfilServlet", "/html/perfil"})
public class MiPerfilServlet extends HttpServlet {
	
	UsuarioDao usuarioDao = new UsuarioDao();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiPerfilServlet() {
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
		
		Usuario user = usuarioDao.getUsuario(userName);
		
		String tipoUsuario = null;
		
		
		if (user!=null) {
			
			if (user.getRol() == 1) {
				tipoUsuario = "Normal";
			} else {
				tipoUsuario = "Premium";
			}
			
			out.println("<!DOCTYPE html>\r\n"
					+ "<html >\r\n"
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
					+ "		<link rel=\"stylesheet\" href=\"../css/formularioRegistro.css\">\r\n"
					+ "		<title>Air Planner</title>\r\n"
					+ "	</head>\r\n"
					+ "	\r\n"
					+ "	<body class=\"main-header-2\">\r\n"
					+ "		<!-- Formulario -->\r\n"
					+ "		<div class=\"container my-5\" style=\"width:fit-content; height:fit-content;\">\r\n"
					+ "			<p> <strong> Datos del usuario: " + userName +  "</strong></p>\r\n"
					+ "<ul>\r\n"
					+ "        <li>Nombre: " + user.getNombre() +  "</li>\r\n"
					+ "        <li>Apellido: " + user.getApellido() + "</li>\r\n"
					+ "        <li>Nombre de usuario: " + userName + "</li>\r\n"
					+ "        <li> Contraseña: " + user.getPassword() + "</li>\r\n"
					+ "        <li> Tipo de usuario : " + tipoUsuario + "</li>\r\n"
					+ "      </ul>   "
					+ "				<input type=\"button\" onclick=\"location.href='volver'\"class=\"btn btn-outline-secondary\" value=\"Volver\">\r\n"
					+ "												\r\n"
					+ "			</form>  \r\n"
					+ "		</div>	\r\n"
					+ "\r\n"
					+ "		<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
					+ "		<script src=\"../js/formularioRegistro.js\"> </script> \r\n"
					+ "	</body>\r\n"
					+ "</html>");
			
		} else {
			mensajeError(response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void mensajeError(HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			out.println("<html>");
			out.println("<head><title>Air Planner </title></head>");
			out.println("<body>");
			out.println("<h2> Se ha producido un error </h2>");
			out.println(" <input type=\"button\" onclick=\"location.href='index.html'\"class=\"btn btn-outline-secondary\" value=\"Volver\">");
			out.println("</body></html>");
		} finally {
			out.close();
		}
	
}

}
