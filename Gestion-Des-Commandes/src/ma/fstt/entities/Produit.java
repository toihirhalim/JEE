package ma.fstt.entities;

public class Produit {
	private int id;
	private String libele;
	private int prix;
	
	
	public Produit() {
		super();
	}


	public Produit(int id, String libele, int prix) {
		super();
		this.id = id;
		this.libele = libele;
		this.prix = prix;
	}


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


	@Override
	public String toString() {
		return "Produit [id=" + id + ", libele=" + libele + ", prix=" + prix + "]";
	}
	
}
