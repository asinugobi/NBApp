import java.sql.*; 

/**
 * This class is responsible for setting up the database. 
 * @author obinnaasinugo
 */
public class SqliteConnection {
	/**
	 * Connect the database
	 * @return connection to database 
	 */
	public static Connection Connector(){
		try{
			Class.forName("org.sqlite.JDBC"); 
			Connection conn = DriverManager.getConnection("jdbc:sqlite:NBApp.sqlite"); 
			return conn; 
		}
		catch(Exception e){
			System.out.println(e); // print out the exception thrown
			return null; 
		}
	}
}
