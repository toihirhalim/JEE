package ma.fstt.entities;

public class LignedeCommande {
	int id;
	int idCommande;
	int idProduit;
	int qtte;
	public LignedeCommande(int id, int idCommande, int idProduit, int qtte) {
		super();
		this.id = id;
		this.idCommande = idCommande;
		this.idProduit = idProduit;
		this.qtte = qtte;
	}
	public LignedeCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public int getQtte() {
		return qtte;
	}
	public void setQtte(int qtte) {
		this.qtte = qtte;
	}
	@Override
	public String toString() {
		return "LignedeCommande [id=" + id + ", idCommande=" + idCommande + ", idProduit=" + idProduit + ", qtte="
				+ qtte + "]";
	}
	
	
}
