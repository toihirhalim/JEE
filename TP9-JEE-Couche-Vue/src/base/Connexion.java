package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Professeur;


public class Connexion {
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
	
	public static List<Professeur> getProfesseurs() throws SQLException {
		List<Professeur> profs = new ArrayList<Professeur>();
		String query = "select * from professeur";
		PreparedStatement pstmt = connection.prepareStatement(query); 
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Professeur prof = new Professeur();
			prof.setId(rs.getInt("id"));
			prof.setNom(rs.getString("nom"));
			prof.setPrenom(rs.getString("prenom"));
			prof.setAdresse(rs.getString("adresse"));
			prof.setSelect(rs.getString("selection"));
			profs.add(prof);
		}
		
		return profs;
	}
	
	public static Professeur getProfesseur(int id) throws SQLException {
		String query = "select * from professeur where id=?";
		PreparedStatement pstmt = connection.prepareStatement(query); 
		pstmt.setLong(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		Professeur prof = null;
		
		while(rs.next()) {
			prof = new Professeur();
			prof.setId(rs.getInt("id"));
			prof.setNom(rs.getString("nom"));
			prof.setPrenom(rs.getString("prenom"));
			prof.setAdresse(rs.getString("adresse"));
			prof.setSelect(rs.getString("selection"));
			break;
		}
		
		return prof;
	}
	
	public static Professeur getProfesseur(String nom, String prenom, String adresse) throws SQLException {
		String query = "select * from professeur where nom=? and prenom=? and adresse=?";
		PreparedStatement pstmt = connection.prepareStatement(query); 
		pstmt.setString(1, nom);
		pstmt.setString(2, prenom);
		pstmt.setString(3, adresse);
		
		ResultSet rs = pstmt.executeQuery();
		Professeur prof = null;
		
		while(rs.next()) {
			prof = new Professeur();
			prof.setId(rs.getInt("id"));
			prof.setNom(rs.getString("nom"));
			prof.setPrenom(rs.getString("prenom"));
			prof.setAdresse(rs.getString("adresse"));
			prof.setSelect(rs.getString("selection"));
			break;
		}
		
		return prof;
	}
	
	public static Professeur insertProfesseur(String nom, String prenom, String adresse, String select) throws SQLException {
		String query = "INSERT INTO professeur(nom, prenom, adresse, selection) VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = connection.prepareStatement(query); 
		pstmt.setString(1, nom);
		pstmt.setString(2, prenom);
		pstmt.setString(3, adresse);
		pstmt.setString(4, select);

		pstmt.executeUpdate();
		
		return getProfesseur(nom, prenom, adresse);
	}
	
	public static Professeur updateProfesseur(Professeur prof, String nom, String prenom, String adresse, String select) throws SQLException {
		String query = "UPDATE professeur SET nom=?, prenom=?, adresse=?, selection=? WHERE id=?";
		PreparedStatement pstmt = connection.prepareStatement(query); 
		pstmt.setString(1, nom);
		pstmt.setString(2, prenom); 
		pstmt.setString(3, adresse);
		pstmt.setString(4, select);
		pstmt.setLong(5, prof.getId());

		pstmt.executeUpdate();
		
		return getProfesseur(prof.getId());
	}

}
