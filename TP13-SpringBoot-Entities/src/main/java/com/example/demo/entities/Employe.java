package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="employe")
public class Employe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="num_emp")
	private long codeEmploye;
	@Column(name="nom_emp",length=60,nullable=false)
	private String nomEmploye;
	private Employe employeSup;
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "t_emp_gr", 
      joinColumns = @JoinColumn(name = "num_emp", referencedColumnName = "num_emp"), 
      inverseJoinColumns = @JoinColumn(name = "num_gr", 
      referencedColumnName = "num_gr"))
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
