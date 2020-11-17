package servlet.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JavaBeans.UserBean;

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
	
	public static List<UserBean> users() throws SQLException {
		List<UserBean> users = new ArrayList<UserBean>();
		String query = "select * from user";
		PreparedStatement pstmt = connection.prepareStatement(query); 
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			UserBean user = new UserBean();
			user.setLogin(rs.getString("login"));
			user.setPassword(rs.getString("password"));
			users.add(user);
		}
		
		return users;
	}
	
	public static UserBean user(String login, String password) throws SQLException {
		String query = "select * from user where login=? and password=?";
		PreparedStatement pstmt = connection.prepareStatement(query); 
		pstmt.setString(1, login);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		UserBean user = null;
		
		while(rs.next()) {
			user = new UserBean();
			user.setLogin(rs.getString("login"));
			user.setPassword(rs.getString("password"));
		}
		
		return user;
	}
	
	public static UserBean insert (String login, String password) throws SQLException {
		String query = "insert into user values (?,?)";
		PreparedStatement pstmt = connection.prepareStatement(query); 
		pstmt.setString(1, login);
		pstmt.setString(2, password);

		pstmt.executeUpdate();
		
		UserBean user = user(login, password);
		
		return user;
	}

	public static UserBean update(String login, String password) throws SQLException {
		String query = "UPDATE user SET password=? WHERE login=?";
		PreparedStatement pstmt = connection.prepareStatement(query); 
		pstmt.setString(1, password);
		pstmt.setString(2, login);

		pstmt.executeUpdate();
		
		UserBean user = user(login, password);
		
		return user;
	}
	
}
