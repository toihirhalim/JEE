package ma.fstt.bean;

import javax.faces.bean.ManagedBean;

import ma.fstt.persistance.DatabaseOperations;

@ManagedBean(name = "internauteBean")
public class Internaute {
	private int id;
	private String nom;
	private String adresse;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	public String Save(Internaute bean) {
		
		return DatabaseOperations.creerClient(bean.getNom(), bean.getAdresse());
		
	}
	
	

}
