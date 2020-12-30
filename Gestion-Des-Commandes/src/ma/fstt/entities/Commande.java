package ma.fstt.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Commande {
	private int id;
	private int idClient;
	private Date date;
	
	// entity relationships
	private Client client;
	private List<LigneCommande> ligneCommandes;
	private int prixTotal = 0;
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commande(int id, int idClient, Date date) {
		super();
		this.id = id;
		this.idClient = idClient;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}
	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}
	
	public int getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(int prixTotal) {
		this.prixTotal = prixTotal;
	}
	
	public void calculatePrixTotal() {
		int prix = 0;
		
		for(LigneCommande ligneCommande: ligneCommandes) {
			
			prix += ligneCommande.getProduit().getPrix() + ligneCommande.getQtte();
		}
		this.prixTotal = prix;
	}
	@Override
	public String toString() {
		return "Commande [id=" + id + ", idClient=" + idClient + ", date=" + date + "]";
	}
	
	
}
