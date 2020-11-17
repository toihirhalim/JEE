package servlet.user;

import java.io.IOException;
import java.sql.SQLException;

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
		 
		//response.sendRedirect("users.jsp");
		//this.getServletContext().getRequestDispatcher( "/Modifier.jsp" ).forward( request, response );
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
			//do something here
		}else if (form.equals("modifierForm")) {
			//do somethnig here
		}
		UserBean user = null;
		try {
			user = Connexion.user(login, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(user != null) {
			System.out.println("user exist: "+ user);
			response.sendRedirect("user.jsp");
		}else {
			System.out.println("user does not exist !");
			System.out.println("creating user ...");
			try {
				user = Connexion.insert(login, password);
				System.out.println("user created succesfly !");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("something went wrong !");
				e.printStackTrace();
			}
		}
	
	}
 
}
