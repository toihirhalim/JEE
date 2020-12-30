package ma.fstt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
 * Servlet implementation class Commandes
 */
@WebServlet("/commandes")
public class Commandes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commandes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Commande> commandes = null;
		try {
			ClientDAO clientDao = new ClientDAO();
			CommandeDAO commandeDao = new CommandeDAO();
			
			String idClient = request.getParameter("idClient");
			
			if(idClient != null) {
				int id = Integer.parseInt(idClient);
				
				Client client = clientDao.trouverById(id);
				 
				commandes = commandeDao.listCommande(client);
				
				for(Commande commande : commandes) {
					commande.setClient(client);
				}
				
			}else {
				commandes = commandeDao.listCommande();

				for(Commande commande : commandes) {
					commande.setClient(clientDao.trouverById(commande.getIdClient()));
				}
			}
				
			LigneCommandeDAO lignecommandeDao = new LigneCommandeDAO();
			ProduitDAO produitDAO = new ProduitDAO();
			
			for(Commande commande : commandes) {
				commande.setLigneCommandes(lignecommandeDao.listLigneCommande(commande));
				
				for(LigneCommande ligneCommande : commande.getLigneCommandes()) {
					ligneCommande.setProduit(produitDAO.trouverById(ligneCommande.getIdProduit()));
				}
				
				commande.calculatePrixTotal();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("commandes", commandes);
		request.getServletContext().getRequestDispatcher("/commandes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
