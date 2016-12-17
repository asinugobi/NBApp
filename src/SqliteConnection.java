import java.sql.*; 

public class SqliteConnection {

	
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
