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
public class JDOM1 {
	public static Document document;
	public static Element racine;
	
	static void initialize(String pracine) {
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
	static void enregistre(String fichier) {
		try {
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(document, new FileOutputStream(fichier));
		} catch (java.io.IOException e) {}
	}
	
	
	static void affiche(){
		try {
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(document, System.out);
		} catch (java.io.IOException e) {}
	}
	
	public static void main(String[] args) {

		initialize("personnes");
		
		ajouterEtudiant("SARRI", "Hamid", "LSI1");
		ajouterEtudiant("KRIMI", "Nihal", "LSI2");
		ajouterEtudiant("SALMI", "Jawad", "LSI3");
		ajouterEtudiant("RAHALI", "imad", "LSI3");
		
		affiche();
		enregistre("Exercice1.xml");
	}

}
