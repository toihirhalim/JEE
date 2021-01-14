package ma.fstt.persistance;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ligne_pannier_commande")
public class LignePanierCommande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
    @JoinColumn(name="commande_id")
	private Commande commande;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produit_id", referencedColumnName = "id")
	private Produit produit;
	
	@ManyToOne
    @JoinColumn(name="panier_id")
	private Panier panier;
	
	@Column(nullable = false)
	private int qtte;

	public LignePanierCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LignePanierCommande(int id, int qtte) {
		super();
		this.id = id;
		this.qtte = qtte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public int getQtte() {
		return qtte;
	}

	public void setQtte(int qtte) {
		this.qtte = qtte;
	}

	@Override
	public String toString() {
		return "LignePanierCommande [id=" + id + ", qtte=" + qtte + "]";
	}
	
	

}
