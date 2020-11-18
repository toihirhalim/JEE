package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class connexion {
private static Connection connection;
	
	static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/base","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
	public static List<Produit> produits() throws SQLException {
		List<Produit> produits = new ArrayList<Produit>();
		String query = "select * from produit";
		PreparedStatement pstmt = connection.prepareStatement(query); 
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Produit produit = new Produit();
			produit.setId(rs.getInt("ID_PRODUIT"));
			produit.setNom(rs.getString("NOM_PRODUIT"));
			produit.setPrix(rs.getDouble("PRIX_PRODUIT"));
			produits.add(produit);
		}
		
		return produits;
	}
	
	public static List<Produit> produits(String name) throws SQLException {

		List<Produit> produits = new ArrayList<Produit>();
		name = "%" + name + "%";
		String query = "select * from produit where NOM_PRODUIT LIKE ?";
		PreparedStatement pstmt = connection.prepareStatement(query);
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Produit produit = new Produit();
			produit.setId(rs.getInt("ID_PRODUIT"));
			produit.setNom(rs.getString("NOM_PRODUIT"));
			produit.setPrix(rs.getDouble("PRIX_PRODUIT"));
			produits.add(produit);
		}
		
		return produits;
	}
	
	public static Produit produit(int id) throws SQLException {
		String query = "select * from produit where ID_PRODUIT=?";
		PreparedStatement pstmt = connection.prepareStatement(query); 
		pstmt.setLong(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		Produit produit = null;
		
		while(rs.next()) {
			produit = new Produit();
			produit.setId(rs.getInt("ID_PRODUIT"));
			produit.setNom(rs.getString("NOM_PRODUIT"));
			produit.setPrix(rs.getDouble("PRIX_PRODUIT"));
		}
		
		return produit;
	}

}
