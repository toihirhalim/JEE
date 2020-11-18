package metier;

public class Produit {
	int Id;
	String Nom;
	double Prix;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public double getPrix() {
		return Prix;
	}

	public void setPrix(double prix) {
		Prix = prix;
	}

	public String toString() {
		return "Produit [Id=" + Id + ", Nom=" + Nom + ", Prix=" + Prix + "]";
	}
	
	public String [] toArray() {
		String prix = "" + Prix;
		String id = "" + Id;
		String [] arr = {id, Nom, prix};
		
		return arr;
	}

}
