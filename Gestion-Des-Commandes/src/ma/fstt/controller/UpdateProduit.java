package ma.fstt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ProduitDAO;
import ma.fstt.entities.Produit;

/**
 * Servlet implementation class UpdateProduit
 */
@WebServlet("/updateProduit")
public class UpdateProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduit() {
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
			
			request.setAttribute("produit", produitDao.trouverById(id));
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getServletContext().getRequestDispatcher("/updateProduit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ProduitDAO produitDAO = new ProduitDAO();
			

			int id = Integer.parseInt(request.getParameter("id"));
			String libele = request.getParameter("libele");
			int prix = Integer.parseInt(request.getParameter("prix"));
			prix = prix > 0 ? prix : 0;
			
			Produit produit = new Produit(id, libele, prix);
			
			produitDAO.updateProduit(produit);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("produits");
	}

}
