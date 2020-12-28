package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Produit;
import ma.fstt.service.ProduitRepository;
import ma.fstt.tools.ConnectionManager;

public class ProduitDAO implements ProduitRepository{

	protected Connection connection;
	protected Statement statement ;
	protected PreparedStatement preparedStatement ;
	protected  ResultSet resultSet;
	
	
	
	public ProduitDAO() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
		connection = ConnectionManager.getConnection() ;
	}

	@Override
	public Produit trouverById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select *  from produit  where idProduit = ?";
		
		Produit produit = null;
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		this.preparedStatement.setInt(1,id);
		
		this.resultSet = this.preparedStatement.executeQuery();
		
		while(this.resultSet.next()) {
			
			
			produit = new Produit(this.resultSet.getInt(1), this.resultSet.getString(2), this.resultSet.getInt(3));
			
			break ;
			
		}
		
		return produit;
	}

	@Override
	public void ajouterProduit(Produit produit) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into produit (libele, prix) values (?, ?)";
		
		this.preparedStatement = this.connection.prepareStatement(sql);

		this.preparedStatement.setString(1, produit.getLibele());
		this.preparedStatement.setInt(2, produit.getPrix());
		
		this.preparedStatement.execute();
		
	}

	@Override
	public List<Produit> listProduits() throws SQLException {
		// TODO Auto-generated method stub
		List<Produit> list = new ArrayList() ;
		this.statement = this.connection.createStatement();
		
		String sql = "Select * from produit";
		
		this.resultSet = this.statement.executeQuery(sql);
		
		while(this.resultSet.next()) {
			
			list.add(new Produit(this.resultSet.getInt(1), this.resultSet.getString(2), this.resultSet.getInt(3)));
			
		}
		
		return list;
	}

	@Override
	public void updateProduit(Produit produit) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update  produit set  libele = ?, prix = ?  where idProduit = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		this.preparedStatement.setString(1, produit.getLibele());
		this.preparedStatement.setInt(2, produit.getPrix());
		this.preparedStatement.setInt(3, produit.getId());
		
		this.preparedStatement.execute();
	}

	@Override
	public void deleteProduit(Produit produit) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete  from produit  where idProduit = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		this.preparedStatement.setInt(1, produit.getId());
		
		this.preparedStatement.execute();
	}

}
