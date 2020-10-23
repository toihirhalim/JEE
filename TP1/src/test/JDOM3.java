package test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDOM3 {
	public static Document document;
	public static Element racine;
	
	static void lireFichier(String fichier) throws Exception {
		SAXBuilder sxb = new SAXBuilder();
		document = sxb.build(new File(fichier));
		racine = document.getRootElement();
	}
	static void supprElement(String element) {
		
		List listEtudiant = racine.getChildren("etudiant");
		Iterator i = listEtudiant.iterator();
		
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
	static void affiche(){
		try {
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(document, System.out);
		} catch (java.io.IOException e) {}
	}
	
	
	public static void main(String[] args) {
		try {
			lireFichier("Exercice2.xml");
			affiche();
			supprElement("prenoms");
			affiche();
			enregistre("Exercice3.xml");
		}catch(Exception e) {}
		
	}

}
