package ma.fstt.persistance;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produit")
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="libele",length=60,nullable=false)
	private String libele;
	
	@Column(nullable = false)
	private int prix;

	@ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="cathegorie_id")
	private Cathegorie cathegorie;
	
	@OneToMany(mappedBy = "produit")
	private List<LignePanierCommande> lignePanierCommandes;
	
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
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

	public Cathegorie getCathegorie() {
		return cathegorie;
	}

	public void setCathegorie(Cathegorie cathegorie) {
		this.cathegorie = cathegorie;
	}

	public List<LignePanierCommande> getLignePanierCommandes() {
		return lignePanierCommandes;
	}

	public void setLignePanierCommandes(List<LignePanierCommande> lignePanierCommandes) {
		this.lignePanierCommandes = lignePanierCommandes;
	}

	
}
