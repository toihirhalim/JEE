package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="groupe")
public class Groupe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="num_gr")
	private long codeGroupe;
	@Column(name="nom_gr",length=60,nullable=false)
	private String nomGroupe;
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "emp_gr", 
      joinColumns = @JoinColumn(name = "num_emp"), 
      inverseJoinColumns = @JoinColumn(name = "num_gr"))
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
