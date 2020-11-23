package bdd;

import java.util.Random;

import org.jdom2.Element;

public class Insersion_bdd {
	public Insersion_bdd() {}
	
	public void ajouterEtudiant(String Nom, String Prenom, String Adresse, String Password) {
		xml fichier = null;
		try {
			xml v = new xml();
			fichier = new xml(v.chemin + "/tp1.xml");
			

			Random rd = new Random();
			String Id = "" + rd.nextInt(10000);
			
			Element etudiant = new Element("etudiant");
			
			fichier.add_noeud_xml(fichier.racine, etudiant, "");
			
			fichier.add_attribute_xml(etudiant, "id", Id);
			
			Element nom = new Element("nom");
			fichier.add_noeud_xml(etudiant, nom, Nom);
			
			Element prenom = new Element("prenom");
			fichier.add_noeud_xml(etudiant, prenom, Prenom);
			
			Element adresse = new Element("adresse");
			fichier.add_noeud_xml(etudiant, adresse, Adresse);
			
			Element password = new Element("password");
			fichier.add_noeud_xml(etudiant, password, Password);
			
			fichier.save(v.chemin + "/tp1.xml");
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
