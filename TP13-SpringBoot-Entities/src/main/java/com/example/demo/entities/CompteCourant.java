package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
@Table(name="compte")
public class CompteCourant extends Compte {
	@Column(name="dec")
	private double decouvert;

	public CompteCourant() {
		super();
	}
	public CompteCourant(String codeCompte, Date dateCreaction, double solde, double decouvert) {
		super(codeCompte, dateCreaction, solde);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
}
