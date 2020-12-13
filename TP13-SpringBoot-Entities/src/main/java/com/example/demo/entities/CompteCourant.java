package com.example.demo.entities;

import java.util.Date;

public class CompteCourant extends Compte {
	
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
