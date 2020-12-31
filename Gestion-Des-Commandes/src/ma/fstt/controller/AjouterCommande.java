package ma.fstt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.CommandeDAO;
import ma.fstt.dao.LigneCommandeDAO;
import ma.fstt.dao.ProduitDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.entities.LigneCommande;

/**
 * Servlet implementation class AjouterCommande
 */
@WebServlet("/ajouterCommande")
public class AjouterCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ClientDAO clientDao = new ClientDAO();
			//String idCommande = request.getParameter("idClient");
			String idCommande = request.getParameter("idCommande");
			if(idCommande != null) {
				int id = Integer.parseInt(idCommande);
				CommandeDAO commandeDao = new CommandeDAO();
				LigneCommandeDAO lignecommandeDao = new LigneCommandeDAO();
				ProduitDAO produitDAO = new ProduitDAO();
				
				Commande commande = commandeDao.trouverById(id);
				commande.setClient(clientDao.trouverById(commande.getIdClient()));
				
				commande.setLigneCommandes(lignecommandeDao.listLigneCommande(commande));
				
				for(LigneCommande ligneCommande : commande.getLigneCommandes()) {
					ligneCommande.setProduit(produitDAO.trouverById(ligneCommande.getIdProduit()));
				}
				
				commande.calculatePrixTotal();
				
			}else {
				String idClient = request.getParameter("idClient");
				
				if(idClient != null) {

					int id = Integer.parseInt(idClient);
					
					Client client = clientDao.trouverById(id);
					request.setAttribute("client", client);
				}
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getServletContext().getRequestDispatcher("/ajouterCommande.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
