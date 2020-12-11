package org.lsi.entities;

import java.util.Date;

public class CompteEpargne extends Compte {
	
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
