package org.lsi.entities;

import java.util.List;

public class Client {
	private long codeClient;
	private String nomClient;
	private List<Compte> comptes;
	
	public Client() {
		super();
	}
	public Client(String nomClient) {
		this.nomClient = nomClient;
	}
	public long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(long codeClient) {
		this.codeClient = codeClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
}
