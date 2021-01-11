package principal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet({ "/LogoutServlet", "/html/logout" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
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
		
		
		String logout = request.getParameter("OPCION");

        if(logout.equals("no")){
        	if (comprobarRolUsuario(request.getSession()) == 1) {
        		response.sendRedirect("dashboard_usuario.html");
        	}
        	if (comprobarRolUsuario(request.getSession()) == 2) {
        		response.sendRedirect("dashboard_premium.html");
        	}
            
        }

        if(logout.equals("si")){
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("userName")) {
                        cookie.setMaxAge(0);
                    }
                }
            }
            
            HttpSession sesion = request.getSession(false);
            String userName = (String) sesion.getAttribute("userName");
            
            
            if (comprobarRolUsuario(sesion) == 1) { // en caso de ser usuario normal, se borra la lista de deseos al salir.
            	VueloDao dao = new VueloDao();
            	dao.eliminarListaDeDeseos(userName);
        	}
        	
           
            sesion.invalidate();
            response.sendRedirect("../index.html");

        }

	}
	
	private int comprobarRolUsuario(HttpSession sesion) {
		int rol = (int) sesion.getAttribute("rol");
		
		return rol;
	}
	

}
