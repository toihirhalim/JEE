package ma.fstt.persistance;

import java.util.Date;
import java.util.List;

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
@Table(name = "commande")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(nullable = true)
	private Date date;
	
	@ManyToOne
    @JoinColumn(name="client_id")
	private Client client;
	
	@OneToMany(mappedBy = "commande")
	List<LignePanierCommande> lignePanierCommandes;
	
	
	public Commande(int id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<LignePanierCommande> getLignePanierCommandes() {
		return lignePanierCommandes;
	}
	public void setLignePanierCommandes(List<LignePanierCommande> lignePanierCommandes) {
		this.lignePanierCommandes = lignePanierCommandes;
	}
	@Override
	public String toString() {
		return "Commande [id=" + id + ", date=" + date + "]";
	}
	
	
}
