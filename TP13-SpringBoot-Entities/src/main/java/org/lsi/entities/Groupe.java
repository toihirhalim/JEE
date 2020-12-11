package org.lsi.entities;

import java.util.List;

public class Groupe {
	
	private long codeGroupe;
	private String nomGroupe;
	private List<Employe> employes;
	
	public Groupe() {
		super();
	}
	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}
	public long getCodeGroupe() {
		return codeGroupe;
	}
	public void setCodeGroupe(long codeGroupe) {
		this.codeGroupe = codeGroupe;
	}
	public String getNomGroupe() {
		return nomGroupe;
	}
	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	public List<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	
}
