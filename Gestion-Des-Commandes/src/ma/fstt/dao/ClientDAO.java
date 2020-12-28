package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.service.ClientRepository;
import ma.fstt.tools.ConnectionManager;

public class ClientDAO implements ClientRepository {
	
	protected Connection connection;
	protected Statement statement ;
	protected PreparedStatement preparedStatement ;
	protected  ResultSet resultSet ;

	
	public ClientDAO() throws ClassNotFoundException, SQLException {
		super();
		connection = ConnectionManager.getConnection() ;
	}
	

	@Override
	public Client trouverById(int id) throws SQLException  {
		// TODO Auto-generated method stub
		String sql = "select *  from client  where idClient = ?";
		
		Client client = null;
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		this.preparedStatement.setInt(1,id);
		
		this.resultSet = this.preparedStatement.executeQuery();
		
		while(this.resultSet.next()) {
			
			
			client = new Client(this.resultSet.getInt(1), this.resultSet.getString(2));
			
			break ;
			
		}
		
		return client;
	}

	@Override
	public void ajouterClient(Client client) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into client (nom) values (?)";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		this.preparedStatement.setString(1, client.getNom());
		
		this.preparedStatement.execute();
	}

	@Override
	public List<Client> listClients() throws SQLException {
		// TODO Auto-generated method stub
		List<Client> list = new ArrayList() ;
		this.statement = this.connection.createStatement();
		
		String sql = "Select * from client";
		
		this.resultSet = this.statement.executeQuery(sql);
		
		while(this.resultSet.next()) {
			
			list.add(new Client(this.resultSet.getInt(1), this.resultSet.getString(2)));
			
		}
		
		return list;
	}

	@Override
	public void updateClient(Client client) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update  client set  nom = ?  where idClient = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		this.preparedStatement.setString(1, client.getNom());
		this.preparedStatement.setInt(2, client.getId());
		
		this.preparedStatement.execute();
	}

	@Override
	public void deleteClient(Client client) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete  from client  where idClient = ?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		this.preparedStatement.setInt(1, client.getId());
		
		this.preparedStatement.execute();
	}


}
