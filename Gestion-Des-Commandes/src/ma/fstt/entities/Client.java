package ma.fstt.entities;

public class Client {
	
	private int id;
	private String nom;
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + "]";
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
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
	
	
}
