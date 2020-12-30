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
import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.entities.Produit;

/**
 * Servlet implementation class ListCommandes
 */
@WebServlet("/listCommandes")
public class ListCommandes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCommandes() {
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
					commande.setClient(clientDao.trouverById(commande.getId()));
				}
			}
				
			
			

				/*LigneCommandeDAO lignecommandeDao = new LigneCommandeDAO();
				Produit produit = new Produit();

				request.setAttribute("commandes", commandeDao.listCommande(client));
				*/
				request.setAttribute("commandes", commandeDao.listCommande());
			
			
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
