package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Connexion;

/**
 * Servlet implementation class ProfesseurServlet
 */
@WebServlet("/afficherProfesseurs")
public class ProfesseurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfesseurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getRequestURL().toString();
		url = url.substring(url.lastIndexOf("/") + 1, url.length());
		
		if(url.equals("afficherProfesseurs.do")) {
			try {
				request.setAttribute("professeurs", Connexion.getProfesseurs());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("afficheProfesseur.jsp").forward(request, response);
		}else if(url.equals("editerProfesseurs.do")) {
			
		}else if(url.equals("supprimerProfesseurs.do")) {
			
		}else {
			//response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
