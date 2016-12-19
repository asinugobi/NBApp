
import java.sql.*;

/**
 * Model class for login database. 
 * @author obinnaasinugo
 *
 */
public class LoginModel {
	Connection connection;
	/**
	 * Constructor for connection 
	 */
	public LoginModel(){
		connection = SqliteConnection.Connector();
		if (connection == null ) System.exit(1);
	}
	
	/**
	 * This method is responsible for determining whether the application has 
	 * successfully connected to the appropriate database 
	 * @return
	 */
	public boolean isDbConnected(){
		try {
			// if connection is not closed, we are connected 
			return !connection.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		} 
	}
	
	/**
	 * This method will test to see if database contains user 
	 * login information (username and password)
	 * @param user
	 * @param pass
	 * @return
	 * @throws SQLException
	 */
	public boolean isLogin(String user, String pass) throws SQLException{
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null; 
		
		String query = "select * from accounts where username = ? and password = ?";
		try {
			// prepare the query 
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			
			// query is executed and saved here 
			resultSet = preparedStatement.executeQuery(); 
			
			if (resultSet.next()){
				return true; 
			}
			else
				return false; 
		}
		catch(Exception e){
			return false; 
		}
		finally{
			preparedStatement.close(); 
			resultSet.close(); 
		}
	}
	
	/**
	 * This method will return true if the username already exists and false otherwise 
	 * @param username
	 * @return true- username already exists; false otherwise 
	 * @throws SQLException
	 */
	public boolean isUsername(String username) throws SQLException{
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null; 
		
		String query = "select * from accounts where username = ?";
		try {
			// prepare the query 
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			
			// query is executed and saved here 
			resultSet = preparedStatement.executeQuery(); 
			
			if (resultSet.next()){
				return true; 
			}
			else
				return false; 
		}
		catch(Exception e){
			return false; 
		}
		finally{
			preparedStatement.close(); 
			resultSet.close(); 
		}
	}
	
	/**
	 * This method will get the username of the current user in the application. 
	 * @return username
	 * @throws SQLException
	 */
	public String getUsername() throws SQLException{
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null; 
		
		String query = "select username from current where id = 1";
		try {
			
			// prepare the query 
			preparedStatement = connection.prepareStatement(query);
			
			// query is executed and saved here 
			resultSet = preparedStatement.executeQuery(); 
			
			if (resultSet.next()){
				return resultSet.getString("username"); 
			}
			else
				return null; 
		}
		catch(Exception e){
			return null; 
		}
		finally{
			preparedStatement.close(); 
			resultSet.close(); 
		}
	}
	
	/**
	 * This method will query the database for the user's favorite team. 
	 * @param username
	 * @return favorite team 
	 * @throws SQLException
	 */
	public String getTeam(String username) throws SQLException{
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null; 
		
		String query = "select team from accounts where username = ?"; 
		try {
			// prepare the query 
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			// query is executed and saved here 
			resultSet = preparedStatement.executeQuery(); 
			// return the team; else return null if fails 
			if (resultSet.next()){
				return resultSet.getString("team"); 
			}
			else
				return null; 
		}
		catch(Exception e){
			return null; 
		}
		finally{
			preparedStatement.close();
			resultSet.close(); 
		}
	}
	
	/**
	 * This method will query the database for the user's favorite player
	 * @param username
	 * @return favorite player 
	 * @throws SQLException
	 */
	public String getPlayer(String username) throws SQLException{
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null; 
		
		String query = "select player from accounts where username = ?"; 
		try {
			// prepare the query 
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);

			// query is executed and saved here 
			resultSet = preparedStatement.executeQuery(); 
			// return the player; else return null if fails 
			if (resultSet.next()){
				return resultSet.getString("player"); 
			}
			else
				return null; 
		}
		catch(Exception e){
			return null; 
		}
		finally{
			preparedStatement.close();
			resultSet.close(); 
		}
	}
	
	/**
	 * This method will update the 'current' table in the database and store the current user 
	 * @param username
	 * @throws SQLException
	 */
	public void updateDb(String username) throws SQLException{
		PreparedStatement preparedStatement = null; 
		
		String query = "UPDATE current SET username = ? WHERE id = 1"; 
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.executeUpdate();	
		}
		catch(Exception e){
			// print trace 
			e.printStackTrace(); 
		}
		finally{
			preparedStatement.close();; 
		}
	}	
	
	/**
	 * This method is responsible for inserting a new account into the database (accounts table) 
	 * @param username - user's username 
	 * @param pwd - user's password
	 * @param team - user's favorite team 
	 * @param player - user's favorite player
	 * @throws SQLException
	 */
	public void addNewAccount(String username, String pwd, String team, String player) throws SQLException{
		PreparedStatement preparedStatement = null; 
		
		String query = "insert into accounts(id,username,password,team,player) values(0,?,?,?,?)"; 
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, pwd);
			preparedStatement.setString(3, team);
			preparedStatement.setString(4, player);
			preparedStatement.executeUpdate();	
		}
		catch(Exception e){
			// print trace 
			e.printStackTrace(); 
		}
		finally{
			preparedStatement.close();
		}
	}
}
