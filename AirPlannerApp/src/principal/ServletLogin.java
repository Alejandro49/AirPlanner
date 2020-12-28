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
 * Servlet implementation class ServletLogin
 */
@WebServlet(name="ServletLogin", urlPatterns={"/html/login"})
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
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
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Usuario user = new Usuario(username, password);
		UsuarioDao dao = new UsuarioDao();
		
		if (dao.validarUsuario(user)) {
			
			HttpSession sesion = request.getSession();
			sesion.setAttribute("userName", username);
			sesion.setAttribute("rol", dao.obtenerRol(user));
			
			response.sendRedirect("dashboard_usuario.html");
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			try {
				out.println("<html><head><title>Login incorrecto </title></head><body>");
				out.println("<h1>" + "Usuario o contrase�a incorrectos "   + "</h1>");
				out.println(" <input type=\"button\" onclick=\"location.href='login.html'\"class=\"btn btn-outline-secondary\" value=\"Volver\">");
				out.println("</body></html>");
				} finally{out.close();}
		}
		
	}
	

}
