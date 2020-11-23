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
			
			Element racine = fichier.racine;
			List<Element> listEtudiant = racine.getChildren("etudiant");
			Iterator<Element> i = listEtudiant.iterator();
			
			while (i.hasNext()) {
				Element courant = (Element) i.next();
				if (courant.getChild("nom").equals(nom) && courant.getChild("prenom").equals(prenom)){
					return courant;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}


}
