package metier;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class connexion {
	public static Document document;
	public static Element racine;
	public static String file = "TP.xml";
	public static String pracine = "etudiants";
	
	
	static {
		String file ="TP.xml";
		try {
			lireFichier();
		}catch(Exception e) {
			initialize();
			enregistre();
		}
	}
	

	public static void initialize() {
		document = new Document();
		racine = new Element(pracine);
		document.addContent(racine);
	}
	
	static void enregistre() {
		try {
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(document, new FileOutputStream(file));
		} catch (java.io.IOException e) {}
	}
	
	static void lireFichier() throws Exception {
		SAXBuilder sxb = new SAXBuilder();
		document = sxb.build(new File(file));
		racine = document.getRootElement();
	}

	public static Etudiant addEtudiant(int Eid, String Enom, String Eprenom, String Eadresse, String Epassword) {
		if(Enom != "" && Eprenom != "" && Epassword !="") {
			try {
				Element etudiant = new Element("etudiant");

				racine.addContent(etudiant);
				
				Attribute id = new Attribute("id", "" + Eid);
				etudiant.setAttribute(id);

				Element nom = new Element("nom");
				Element prenom = new Element("prenom");
				nom.setText(Enom);
				prenom.setText(Eprenom);
				
				etudiant.addContent(nom);
				etudiant.addContent(prenom);
				
				enregistre();
				return new Etudiant(Eid, Enom, Eprenom, Eadresse, Epassword);
				
				} catch (Exception e) {
					return null;
				}
		}else {
			return null;
		}
	}
	
	public static Etudiant getEtudiant(String Enom, String Eprenom, String Epassword) {
		
		List<Element> listEtudiant = racine.getChildren("etudiant");
		Iterator<Element> i = listEtudiant.iterator();
		
		while (i.hasNext()) {
			Element courant = (Element) i.next();
			
			int id;
			try {
				id = Integer.parseInt(courant.getChild("nom").getText());
			}catch (Exception e) {
				id = -1;
			}
			 
			String nom = courant.getChild("nom").getText();
			String prenom = courant.getChild("prenom").getText();
			String adresse = courant.getChild("adresse").getText();
			String password = courant.getChild("password").getText();
			
			if (nom.equals(Enom) && prenom.equals(Eprenom) && password.equals(Epassword)) {
				return new Etudiant(id, nom, prenom, adresse, password);
			}
		}
		return null;
	}

}
