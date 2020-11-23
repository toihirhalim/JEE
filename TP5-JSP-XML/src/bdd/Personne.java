package bdd;

public class Personne {

	private String nom;
	private String prenom;
	private String adresse;
	private String password;
	
	public Personne() {
		
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString() {
		return "Personne: [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", password="
				+ password + "]";
	}
	public boolean enregistrer() {
		Selection_bdd s = new Selection_bdd();
		if(s.dejaExist(nom, prenom)) {
			return false;
		}else {
			Insersion_bdd f = new Insersion_bdd();
			f.ajouterEtudiant(nom, prenom, adresse, password);
			return true;
		}
	}
	
	public String identificateur() {
		Selection_bdd s = new Selection_bdd();
		String a = s.identificateur(nom, prenom);
		return a;
	}
}
