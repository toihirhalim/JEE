package ma.fstt.entities;

import java.sql.Date;

public class Commande {
	int id;
	int idClient;
	Date date;
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
	@Override
	public String toString() {
		return "Commande [id=" + id + ", idClient=" + idClient + ", date=" + date + "]";
	}
	
	
}
