package ma.fstt.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import ma.fstt.persistance.DatabaseOperations;


@ManagedBean(name = "ProduitBean")
public class ProduitBean {
	private int id;
	private String libele;
	private int prix;
	
	private String cathegorie;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibele() {
		return libele;
	}
	public void setLibele(String libele) {
		this.libele = libele;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	
	public String getCathegorie() {
		return cathegorie;
	}
	
	public void setCathegorie(String cathegorie) {
		this.cathegorie = cathegorie;
	}
	public String Save(ProduitBean bean) {
		
		return DatabaseOperations.creerProduit(bean.getLibele(), bean.getPrix(), bean.getCathegorie());
		
	}
	
	
	public List listEudiant() {
		
		
		
		return DatabaseOperations.getAllProduits() ;
		
	}
	
	

}
