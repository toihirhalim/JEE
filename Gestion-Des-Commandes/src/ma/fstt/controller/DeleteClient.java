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
import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;

/**
 * Servlet implementation class DeleteClient
 */
@WebServlet("/deleteClient")
public class DeleteClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteClient() {
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
			int id = Integer.parseInt(request.getParameter("id"));
			
			Client client = clientDao.trouverById(id);
			
			if(client != null) {
				CommandeDAO commandeDAO = new CommandeDAO();
				LigneCommandeDAO ligneCommandeDAO = new LigneCommandeDAO();
				
				for(Commande commande : commandeDAO.listCommande(client)) {
					ligneCommandeDAO.deleteLigneCommande(commande);
					commandeDAO.deleteCommande(commande);
				}
				
				clientDao.deleteClient(client);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("clients");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
