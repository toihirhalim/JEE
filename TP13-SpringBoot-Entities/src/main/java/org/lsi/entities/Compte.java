package org.lsi.entities;

import java.util.Date;
import java.util.List;

public class Compte {
	
	private String codeCompte;
	private Date dateCreaction;
	private double solde;
	private Client client;
	private List<Operation> operations;
	
	public Compte() {
		super();
	}
	public Compte(String codeCompte, Date dateCreaction, double solde) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreaction = dateCreaction;
		this.solde = solde;
	}
	public String getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	public Date getDateCreaction() {
		return dateCreaction;
	}
	public void setDateCreaction(Date dateCreaction) {
		this.dateCreaction = dateCreaction;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	
}
