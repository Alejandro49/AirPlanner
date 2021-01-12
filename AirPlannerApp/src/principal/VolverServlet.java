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
@WebServlet({ "/VolverServlet", "/html/volver" })
public class VolverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getSession().getAttribute("rol") != null) {
    		
    		if (comprobarRolUsuario(request.getSession()) == 1) { // usuario normal
        		response.sendRedirect("dashboard_usuario.html");
        		
        	} 
    		if (comprobarRolUsuario(request.getSession()) == 2) { // usuario premium
        		response.sendRedirect("dashboard_premium.html");
    		}
    		
    	} else {
    		response.sendRedirect("dashboard_invitado.html");
    	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String volver = request.getParameter("OPCION");

        if(volver.equals("no")){
        	
        	response.sendRedirect("buscarVuelos.html");
        }

        if(volver.equals("si")){
        	if (request.getSession().getAttribute("rol") != null) {
        		
        		if (comprobarRolUsuario(request.getSession()) == 1) { // usuario normal
            		response.sendRedirect("dashboard_usuario.html");
            		
            	} 
        		if (comprobarRolUsuario(request.getSession()) == 2) { // usuario premium
            		response.sendRedirect("dashboard_premium.html");
        		}
        		
        	} else {
        		response.sendRedirect("dashboard_invitado.html");
        	}
        } 
         
	}
	
	private int comprobarRolUsuario(HttpSession sesion) {
		int rol = (int) sesion.getAttribute("rol");
		
		return rol;
	}
	

}
