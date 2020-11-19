package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.connexion;

/**
 * Servlet implementation class ControlleurServlet
 */
@WebServlet("/ControlleurServlet")
public class ControlleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlleurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("ProduitsView.jsp");
		this.getServletContext().getRequestDispatcher("/ProduitsView.jsp").forward(request, response);
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String post = request.getParameter("formName");
		
		if(post.equals("ProduitResearch")) {
			try {
				String nom = request.getParameter("nom");
				request.setAttribute("produits", connexion.produits(nom));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("ProduitsView.jsp").forward(request, response);
		}else {
			doGet(request, response);
		}
		
	}

}
