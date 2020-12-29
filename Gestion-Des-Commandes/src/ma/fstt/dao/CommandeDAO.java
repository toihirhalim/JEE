package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Commande;
import ma.fstt.service.CommandeRepository;
import ma.fstt.tools.ConnectionManager;

public class CommandeDAO implements CommandeRepository{
	protected Connection connection;
	protected Statement statement ;
	protected PreparedStatement preparedStatement ;
	protected  ResultSet resultSet ;
	
	public CommandeDAO() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
		connection = ConnectionManager.getConnection() ;
	}

	@Override
	public Commande trouverById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select *  from commande  where idCommande = ?";
		
		Commande commande = null;
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		this.preparedStatement.setInt(1,id);
		
		this.resultSet = this.preparedStatement.executeQuery();
		
		while(this.resultSet.next()) {
			
			
			commande = new Commande(this.resultSet.getInt(1), this.resultSet.getInt(2), this.resultSet.getDate(2));
			
			break ;
			
		}
		
		return commande;
	}

	@Override
	public void ajouterCommande(Commande commande) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into Commande (idClient, date) values (?, ?)";
		
		this.preparedStatement = this.connection.prepareStatement(sql);

		this.preparedStatement.setInt(1, commande.getIdClient());
		this.preparedStatement.setDate(2, commande.getDate());
		
		this.preparedStatement.execute();
	}

	@Override
	public List<Commande> listCommande() throws SQLException {
		// TODO Auto-generated method stub
		List<Commande> list = new ArrayList() ;
		this.statement = this.connection.createStatement();
		
		String sql = "Select * from commande";
		
		this.resultSet = this.statement.executeQuery(sql);
		
		while(this.resultSet.next()) {
			
			list.add(new Commande(this.resultSet.getInt(1), this.resultSet.getInt(2), this.resultSet.getDate(2)));
			
		}
		
		return list;
	}

	@Override
	public void updateCommande(Commande commande) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update  commande set  idClient = ?, date = ?  where idCommande = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		this.preparedStatement.setInt(1, commande.getIdClient());
		this.preparedStatement.setDate(2, commande.getDate());
		this.preparedStatement.setInt(3, commande.getId());
		
		this.preparedStatement.execute();
	}

	@Override
	public void deleteCommande(Commande commande) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete  from commande  where idCommande = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		this.preparedStatement.setInt(1, commande.getId());
		
		this.preparedStatement.execute();
	}

}
