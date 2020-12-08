package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.Connexion;
import beans.Professeur;

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
		
		Professeur prof = null;
		try {
			String Id = request.getParameter("id");
			int id = Integer.parseInt(Id);
			prof = Connexion.getProfesseur(id);
		}catch(Exception e) {}
		
		if(url.equals("afficherProfesseurs.do")) {
			try {
				List<Professeur> profs = Connexion.getProfesseurs();
				
				request.setAttribute("professeurs", profs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			request.getRequestDispatcher("afficheProfesseur.jsp").forward(request, response);
		}else if(url.equals("editerProfesseurs.do")) {
			try {
				HttpSession session = request.getSession();
				
				if(prof != null) {
					session.setAttribute("professeur", Connexion.getProfesseur(prof.getId()));
				}else {
					session.invalidate();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.getServletContext().getRequestDispatcher("/editProfesseur.jsp").forward(request, response);
		}else if(url.equals("supprimerProfesseurs.do")) {
			try {
				Connexion.deleteProfesseur(prof);
				request.setAttribute("professeurs", Connexion.getProfesseurs());
			}catch(Exception e) {}
			request.getRequestDispatcher("afficheProfesseur.jsp").forward(request, response);
		}else {
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String select = request.getParameter("select");
		HttpSession session = request.getSession();
		Professeur prof = (Professeur) session.getAttribute("professeur");
		
		try {
			if(prof != null) {
				prof = Connexion.getProfesseur(nom, prenom, adresse);
			}
		
			if(prof != null) {
				Connexion.updateProfesseur(prof, nom, prenom, adresse, select);
			}else {
				Connexion.insertProfesseur(nom, prenom, adresse, select);
			}
		}catch(Exception e) {}
		
		response.sendRedirect("afficherProfesseurs.do");
		
		
	}

}
