package ma.fstt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.LigneCommandeDAO;
import ma.fstt.dao.ProduitDAO;
import ma.fstt.entities.Produit;

/**
 * Servlet implementation class DeleteProduit
 */
@WebServlet("/deleteProduit")
public class DeleteProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ProduitDAO produitDao = new ProduitDAO();
			int id = Integer.parseInt(request.getParameter("id"));
			
			Produit produit = produitDao.trouverById(id);
			
			if(produit != null) {
				LigneCommandeDAO ligneCommandeDao = new LigneCommandeDAO();
				
				ligneCommandeDao.deleteLigneCommande(produit);
				
				produitDao.deleteProduit(produit);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("produits");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
