package bdd;

import java.util.Iterator;
import java.util.List;

import org.jdom2.Element;

public class Selection_bdd {

	public boolean dejaExist(String nom, String prenom) {
		// TODO Auto-generated method stub
		Element etudiant = getElement(nom, prenom);
		return etudiant != null;
	}
	
	public boolean dejaExist(String nom, String prenom, String password) {
		// TODO Auto-generated method stub
		Element etudiant = getElement(nom, prenom, password);
		return etudiant != null;
	}

	public String identificateur(String nom, String prenom) {
		// TODO Auto-generated method stub
		Element etudiant = getElement(nom, prenom);
		return etudiant.getAttributeValue("id");
	}
	
	public Element getElement(String nom, String prenom) {

		
		xml fichier = null;
		try {
			xml v = new xml();
			fichier = new xml(v.chemin + "/tp1.xml");
			return fichier.get_element(nom, prenom);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
public Element getElement(String nom, String prenom, String password) {

		xml fichier = null;
		try {
			xml v = new xml();
			fichier = new xml(v.chemin + "/tp1.xml");
			return fichier.get_element(nom, prenom, password);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}


}
