package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaBeans.UserBean;

/**
 * Servlet implementation class TraiterLoginServlet
 */
@WebServlet("/TraiterLoginServlet")
public class TraiterLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraiterLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String form = request.getParameter("formName");
		
		if(form.equals("loginForm")) {
			UserBean user = null;
			
			try {
				user = Connexion.user(login, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(user != null) {
				System.out.println("user exist: ");
				request.setAttribute("login", user.getLogin());
				request.setAttribute("password", user.getPassword());
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/users.jsp");
				dispatcher.forward(request, response);
				//response.sendRedirect("user.jsp");
			}else {
				System.out.println("user does not exist !");
				System.out.println("creating user ...");
				try {
					user = Connexion.insert(login, password);
					System.out.println("user created succesfly !");
					
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.println("<HTML>");
					out.println("<HEAD><TITLE> Titre </TITLE></HEAD>");
					out.println("<BODY>");
					out.println("<p>Cet utilisateur n existe pas</p>");
					out.println("<p>utilisateur bien enregistre</p>");
					out.println("<a href=\"index.jsp\">Acceuil</a>");
					out.println("</BODY>"); out.println("</HTML>");
					out.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("something went wrong !");
					e.printStackTrace();
				}
			}
		}else if (form.equals("ModifierForm")) {
			try {
				UserBean user = Connexion.update(login, password);
				
				if(user != null) {
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.println("<HTML>");
					out.println("<HEAD><TITLE> Titre </TITLE></HEAD>");
					out.println("<BODY>");
					out.println("<p>Modification bien reussi</p>");
					out.println("<a href=\"index.jsp\">Acceuil</a>");
					out.println("</BODY>"); out.println("</HTML>");
					out.close();
				}else {
					doGet(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			doGet(request, response);
		}
		
		
	
	}
 
}
