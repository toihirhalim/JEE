package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		String sql = "select *  from ligne_commande where idLigne = ?";
		
		LigneCommande ligneCommande = null;
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		this.preparedStatement.setInt(1,id);
		
		this.resultSet = this.preparedStatement.executeQuery();
		
		while(this.resultSet.next()) {
		
			ligneCommande = new LigneCommande(this.resultSet.getInt(1), this.resultSet.getInt(2), this.resultSet.getInt(3), this.resultSet.getInt(4));
			
			break ;
			
		}
		
		return ligneCommande;
	}
	@Override
	public void ajouterLigneCommande(LigneCommande ligneCommande) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into ligne_commande (idCommande, idProduit, qtte) values (?, ?, ?)";
		
		this.preparedStatement = this.connection.prepareStatement(sql);

		this.preparedStatement.setInt(1, ligneCommande.getIdCommande());
		this.preparedStatement.setInt(2, ligneCommande.getIdProduit());
		this.preparedStatement.setInt(3, ligneCommande.getQtte());
		
		this.preparedStatement.execute();
	}
	@Override
	public List<LigneCommande> listLigneCommande() throws SQLException {
		// TODO Auto-generated method stub
		List<LigneCommande> list = new ArrayList() ;
		this.statement = this.connection.createStatement();
		
		String sql = "Select * from ligne_commande";
		
		this.resultSet = this.statement.executeQuery(sql);
		
		while(this.resultSet.next()) {
			
			list.add(new LigneCommande(this.resultSet.getInt(1), this.resultSet.getInt(2), this.resultSet.getInt(3), this.resultSet.getInt(4)));
			
		}
		
		return list;
	}
	@Override
	public void updateLigneCommande(LigneCommande ligneCommande) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update  ligne_commande set  idCommande = ?, idProduit = ?, qtte =? where idLigne = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		this.preparedStatement.setInt(1, ligneCommande.getIdCommande());
		this.preparedStatement.setInt(2, ligneCommande.getIdProduit());
		this.preparedStatement.setInt(3, ligneCommande.getQtte());
		this.preparedStatement.setInt(4, ligneCommande.getId());
		
		this.preparedStatement.execute();
	}
	@Override
	public void deleteLigneCommande(LigneCommande ligneCommande) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete  from ligne_commande  where idLigne = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		this.preparedStatement.setInt(1, ligneCommande.getId());
		
		this.preparedStatement.execute();
	}
	
	
}
