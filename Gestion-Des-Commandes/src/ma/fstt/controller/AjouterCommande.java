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
import ma.fstt.entities.Produit;

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

				System.out.println(commande);
				commande.setClient(clientDao.trouverById(commande.getIdClient()));
				
				commande.setLigneCommandes(lignecommandeDao.listLigneCommande(commande));
				
				for(LigneCommande ligneCommande : commande.getLigneCommandes()) {
					ligneCommande.setProduit(produitDAO.trouverById(ligneCommande.getIdProduit()));
				}
				
				commande.calculatePrixTotal();
				request.setAttribute("commande", commande);
				
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
		String id = request.getParameter("idCommande");
		try {
			int idProduit  = Integer.parseInt(request.getParameter("idProduit"));
			int qtte  = Integer.parseInt(request.getParameter("qtte"));
			ProduitDAO produitDAO = new ProduitDAO();
			Produit produit = produitDAO.trouverById(idProduit);
			
			if(produit != null) {
				CommandeDAO commandeDao = new CommandeDAO();
				LigneCommandeDAO ligneCommandeDAO = new LigneCommandeDAO();
				int idCommand = Integer.parseInt(id);
				Commande commande = commandeDao.trouverById(idCommand);
				LigneCommande ligneCommande;
				
				if(commande == null) {
					ClientDAO clientDao = new ClientDAO();
					int idClient  = Integer.parseInt(request.getParameter("idProduit"));
					Client client = clientDao.trouverById(idClient);
					
					if(client != null) {
						commande = new Commande(0, client.getId(), null);
						
						commandeDao.ajouterCommande(commande);
						
						commande = commandeDao.lastCommande();
						
						id =  "" + commande.getId();
						
						ligneCommande = new LigneCommande(0, commande.getId(), produit.getId(), qtte);
						ligneCommandeDAO.ajouterLigneCommande(ligneCommande);
					}
				}else {
					
					ligneCommande = ligneCommandeDAO.trouver(commande, produit);
					
					if(ligneCommande != null) {
						ligneCommande.setQtte(ligneCommande.getQtte() + qtte);
						
						ligneCommandeDAO.updateLigneCommande(ligneCommande);
					}else {
						ligneCommande = new LigneCommande(0, commande.getId(), produit.getId(), qtte);
						ligneCommandeDAO.ajouterLigneCommande(ligneCommande);
					}
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("ajouterCommande?idCommande=" + id);
	}

}
