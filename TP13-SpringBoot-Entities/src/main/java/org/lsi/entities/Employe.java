package org.lsi.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employe")
public class Employe {
	private long codeEmploye;
	private String nomEmploye;
	private Employe employeSup;
	private List<Groupe> groups;
	
	public Employe() {
		super();
	}
	public Employe(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	public long getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	public String getNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	public Employe getEmployeSup() {
		return employeSup;
	}
	public void setEmployeSup(Employe employeSup) {
		this.employeSup = employeSup;
	}
	public List<Groupe> getGroups() {
		return groups;
	}
	public void setGroups(List<Groupe> groups) {
		this.groups = groups;
	}
	
}
