package ma.fstt.persistance;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "panier")
public class Panier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(nullable = true)
	private int total;
	
	@OneToOne(mappedBy = "panier")
	private Client client;
	
	@OneToMany(mappedBy = "panier")
	private List<LignePanierCommande> lignePanierCommande;

	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Panier(int id, int total) {
		super();
		this.id = id;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LignePanierCommande> getLignePanierCommande() {
		return lignePanierCommande;
	}

	public void setLignePanierCommande(List<LignePanierCommande> lignePanierCommande) {
		this.lignePanierCommande = lignePanierCommande;
	}

	@Override
	public String toString() {
		return "Panier [id=" + id + ", total=" + total + "]";
	}
	
	
	

}
