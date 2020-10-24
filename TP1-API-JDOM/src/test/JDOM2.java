package test;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class JDOM2 {

	public static Document document;
	public static Element racine;
	
	static void lireFichier(String fichier) throws Exception {
		SAXBuilder sxb = new SAXBuilder();
		document = sxb.build(new File(fichier));
		racine = document.getRootElement();
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
	
	
	public static void main(String[] args) {
		try {
			lireFichier("Exercice1.xml");
			afficheALL();
		}catch(Exception e) {}

	}

}
