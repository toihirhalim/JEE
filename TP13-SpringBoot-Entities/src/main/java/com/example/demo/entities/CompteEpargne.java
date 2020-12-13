package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
@Table(name="compte")
public class CompteEpargne extends Compte {
	@Column(name="taux")
	private double taux;
	
	public CompteEpargne() {
		super();
	}
	public CompteEpargne(String codeCompte, Date dateCreaction, double solde, double taux) {
		super(codeCompte, dateCreaction, solde);
		this.taux = taux;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	
}
