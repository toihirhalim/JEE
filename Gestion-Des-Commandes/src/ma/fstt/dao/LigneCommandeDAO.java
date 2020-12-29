package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import ma.fstt.entities.LigneCommande;
import ma.fstt.service.LigneCommandeRepository;
import ma.fstt.tools.ConnectionManager;

public class LigneCommandeDAO implements LigneCommandeRepository {

	protected Connection connection;
	protected Statement statement ;
	protected PreparedStatement preparedStatement ;
	protected  ResultSet resultSet ;
	public LigneCommandeDAO() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
		connection = ConnectionManager.getConnection() ;
	}
	@Override
	public LigneCommande trouverById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void ajouterLigneCommande(LigneCommande ligneCommande) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<LigneCommande> listLigneCommande() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateLigneCommande(LigneCommande ligneCommande) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteLigneCommande(LigneCommande ligneCommande) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
}
