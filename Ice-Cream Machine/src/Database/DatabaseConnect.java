package Database;

import java.sql.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author Shun Wen Chook
 *
 */
public class DatabaseConnect {
		
	private Connection conn;
	private String url;
	private String userName;
	private String password;
	
	/**
	 * Constructor for sqlengine which is responsible for initialising
	 * the <code>userName</code> and <code>password</code>. 
	 * No connection made at this point.
	 * 
	 * @param userName The <code>username</code> to be used to connection to the database
	 * @param password The <code>password</code> required to validate the connection
	 */
	public DatabaseConnect(String userName, String password) {
		conn = null;
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * Method to establish a database connection, reads the database URL and
	 * port number from a properties file to prevent having to recompile code.
	 * Note: most of the J/Connector methods throw exceptions. 
	 */
	public void connect() {

		InputStream is = getClass().getResourceAsStream("mySQLEngine.properties");
	    Properties p = new Properties();
	    try {
	    	p.load(is);
	        url = p.getProperty("connectionURL");
	 
	    }
	    catch (IOException e) {
	        System.err.println("error loading properties...");
	    }
		try
	      {
			//register the mySQL driver with the DriverManager
			//by creating a new instance of the jdbc Driver class
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			
			//try to connect to the database
		
			 conn = DriverManager.getConnection (url, userName, password);
		
			System.out.println ("Database connection established");
			
			
	      }
	      catch (Exception e1)
	      {
	          System.err.println ("Cannot connect to database server");
	      }
	}
	
	/**
	 * Method to close connection to a Database, always close connections when done.
	 */
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());

		}
	}
	
	public ResultSet executeQuery(String sqlStatement) throws SQLException{
		ResultSet rs = null;
		
		//A Statement is the object used for executing an SQL statement 
		//and returning the results it produces.
		try {
			Statement stmt = conn.createStatement();
			//the execute method below executes the sql query
			//if the sql query is a select query it will will
			//return true, if it is update,insert,delete it will
			//return false.
			if(stmt.execute(sqlStatement))
				//we can get the result set if it was a select query.
				rs = stmt.getResultSet();
			
		}
		catch (SQLException e) {
			throw e;
		}
		return rs;
	}
}
		
		
	