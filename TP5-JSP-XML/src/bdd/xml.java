package bdd;

import java.io.FileOutputStream;
import java.util.Iterator;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class xml {

	public Element racine;
	public static Document document;
	public static Iterator j;
	public static Element courant;
	public String chemin = "C:\\Users\\\\Public\\";
	
	public xml(String chemin1) throws Exception{
		// TODO Auto-generated constructor stub
		SAXBuilder sxb = new SAXBuilder();
		document = sxb.build(chemin1);
		racine = document.getRootElement();
	}

	public xml() {
		// TODO Auto-generated constructor stub
	}

	public void add_noeud_xml(Element pere, Element fils, String texte) {
		// TODO Auto-generated method stub
		fils.setText(texte);
		pere.addContent(fils);
	}

	public void add_attribute_xml(Element pere, String id, String valeur) {
		// TODO Auto-generated method stub
		Attribute idNoeud = new Attribute(id, valeur);
		pere.setAttribute(idNoeud);
	}

	public void save(String fichier) {
		// TODO Auto-generated method stub
		try {
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(document, new FileOutputStream(fichier));
		}catch(Exception e) {
			System.out.println(e);
		}
	}
 
}
