package test;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Attribute;

public class test {
	public static Document document;
	public static Element racine;
	
	public static void initialize(String pracine) {
		document = new Document();
		racine = new Element(pracine);
		document.addContent(racine);
	}
	
	static void ajouterEtudiant(String pnom,String pprenom, String pclasse) {
		try {
		Element etudiant = new Element("etudiant");

		racine.addContent(etudiant);


		Attribute classe = new Attribute("classe", pclasse);
		etudiant.setAttribute(classe);

		Element nom = new Element("nom");
		Element prenom = new Element("prenom");
		nom.setText(pnom);
		prenom.setText(pprenom);
		
		etudiant.addContent(nom);
		etudiant.addContent(prenom);

		} catch (Exception e) {}
	}
	
	static void affiche(){
		try {
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(document, System.out);
		} catch (java.io.IOException e) {}
	}
	
	static void afficheALL() {
		List<Element> listEtudiants = racine.getChildren("etudiant");

		Iterator<Element> i = listEtudiants.iterator();
		while (i.hasNext()) {
		Element courant = (Element) i.next();
		System.out.println(courant.getChild("nom").getText());
		//System.out.println(courant.getChild("nom").getText() + "\t" + courant.getChild("prenom").getText());
		}
	}
	
	static void supprElement(String element) {
		
		List<Element> listEtudiant = racine.getChildren("etudiant");
		Iterator<Element> i = listEtudiant.iterator();
		
		while (i.hasNext()) {
			Element courant = (Element) i.next();
			if (courant.getChild(element) != null) {
				courant.removeChild(element);
				courant.setName("etudiant_modifie");
			}
		}
	}
	
	static void enregistre(String fichier) {
		try {
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(document, new FileOutputStream(fichier));
		} catch (java.io.IOException e) {}
	}
	
	static void lireFichier(String fichier) throws Exception {
		SAXBuilder sxb = new SAXBuilder();
		document = sxb.build(new File(fichier));
		racine = document.getRootElement();
	}
	
	public static void main(String[] args) {
		String file = "Exercice1.xml";
		//String file = "Exercice3.xml";

		try {
			lireFichier(file);
		}catch(Exception e) {
			initialize("personnes");
			ajouterEtudiant("SARRI", "Hamid", "LSI1");
			ajouterEtudiant("KRIMI", "Nihal", "LSI2");
			ajouterEtudiant("SALMI", "Jawad", "LSI3");
			ajouterEtudiant("RAHALI", "imad", "LSI3");
		}

		//supprElement("prenoms");
		affiche();
		//afficheALL();
		//enregistre("Exercice1.xml");
		
	}

}
