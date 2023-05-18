package mipk;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginAuthenticator
 */
public class LoginAuthenticator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String usuvalido = "returN";
	private String pwdvalida = "1357";
       
	private String usulvl1 = "pepe";
	private String passlvl1 = "1357";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAuthenticator() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		beanDB db = new beanDB();
		// En la variable session se guardará el identificador de la session
		HttpSession session = request.getSession();
		// Solicita los parametros de contraseña y usuario al navegador
		String usuario=request.getParameter("usuario");
		String pass=request.getParameter("pass");
		if (usuario == null) usuario="";
		if (pass == null) pass="";
		boolean ok=false;
		
		// Administrador
		if(usuario.equals(usuvalido) && pass.equals(pwdvalida)) {
			// Pone atributos a la session del administrador.
			session.setAttribute("attributo2",usuario);
			session.setAttribute("attributo1","2");
			ok=true;
		}
		// Usuario
		else if(usuario.equals(usulvl1) && pass.equals(passlvl1)) {
			// Pone atributos a la session del usuario.
			session.setAttribute("attributo2",usuario);
			session.setAttribute("attributo1","1");
			ok=true;
		}
		
		if (ok) response.sendRedirect("bienvenido.jsp");
		else response.sendRedirect("index.jsp");

	}


}
