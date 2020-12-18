package org.lsi.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="operation")
public class Operation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="num_op")
	private long numeroOperation;
	@Column(name="creation_date")
	private Date dateOperation;
	@Column(name="solde")
	private double montant;
	@ManyToOne
    @JoinColumn(name="nom_cpte")
	private Compte compte;
	@ManyToOne
    @JoinColumn(name="num_emp")
	private Employe employe;
	
	public Operation() {
		super();
	}
	public Operation(Date dateOperation, double montant) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
	}
	public long getNumeroOperation() {
		return numeroOperation;
	}
	public void setNumeroOperation(long numeroOperation) {
		this.numeroOperation = numeroOperation;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
}
