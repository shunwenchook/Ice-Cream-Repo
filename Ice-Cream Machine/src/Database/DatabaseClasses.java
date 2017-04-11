package Database;

import java.sql.ResultSet;
import java.util.Vector;

/**
 * 
 * @author Shun Wen Chook
 *
 * Contains all the Database methods
 */
public class DatabaseClasses {
	
	static DatabaseConnect dbEngine = new DatabaseConnect("root", ""); // connects to the dtabase using the username and password
	
	/**
	 * Establishes connection
	 */
	public static void init() {
		dbEngine.connect(); // calls connect method
	}
	
	/**
	 * Gets price from the database
	 * @param itemName to search for the price
	 * @return price returns price from the database
	 */
	public static double getPrice(String itemName) {
		
		double price = 0;
		
		try {
			ResultSet rs = dbEngine.executeQuery("select price from product where name = '" + itemName + "'"); // runs query from database to check for the price of the item
			while (rs.next()) { // goes through the result set
				price = rs.getDouble("price"); // gets the value from the database
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return price;
	}
	
	/**
	 * Gets image from the database
	 * @param itemName searches for the image directory using the itemName
	 * @return imageDirectory returns the image directory
	 */
	public static String getImage(String itemName) {
		
		String imageDirectory = null;
		
		try {
			ResultSet rs = dbEngine.executeQuery("select picture from product where name = '" + itemName + "'"); // runs query from database to check for the image directory
			while (rs.next()) { // goes through the result set

				imageDirectory = rs.getString("picture"); // gets the picture from the database
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return imageDirectory;
	}
	
	/**
	 * Gets the cone list from the database
	 * @return elements a vector containing the cone list
	 */
	public static Vector<String> loadConeList() {
		
		Vector<String> elements = new Vector<String>(); // creates a String type vector called elements
		
		try{
			
			ResultSet rs = dbEngine.executeQuery("select name, price from product where category = 'cone'"); // runs query on the database and checks the category for cone
			
			while (rs.next()) {
			    elements.add(rs.getString("name"));
			} 
		}
		
		catch(Exception e){
			
			e.printStackTrace();
		}
		return elements;
	}
	
	/**
	 * Gets the topping list from the database
	 * @return elements a vector containing the topping list
	 */
	public static Vector<String> loadToppingList() {

		Vector<String> elements = new Vector<String>(); // creates a String type vector called elements
		
		try{

			ResultSet rs =  dbEngine.executeQuery("select name, price from product where category = 'toppings'"); // runs query on the database and checks the category for toppings
			
			while (rs.next()) {
			    elements.add(rs.getString("name"));
			} 

		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		return elements;

	
	}
	
	/**
	 * Gets the flavour list from the database
	 * @return elements a vector containing the flavour list
	 */
	public static Vector<String> loadFlavourList() {
		
		Vector<String> elements = new Vector<String>(); // creates a String type vector called elements

		
		try{

			ResultSet rs = dbEngine.executeQuery("select name, price from product where category = 'flavour'"); // runs query on the database and checks the category for flavour
			
			while (rs.next()) {
			    elements.add(rs.getString("name"));
			} 
		}
		
		catch(Exception e){
			
			e.printStackTrace();
		}
		return elements;

	
	}
	
	public static String getUser(String user){
		String correctUser = "test1";
		try {
			ResultSet rs = dbEngine.executeQuery("select username from users where username = '" + user + "'");

			while (rs.next()) {

				correctUser = rs.getString("username");
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return correctUser;
	}
	
	public static String getPass(String user){
		String correctPass = "test2";
		
		try {
			ResultSet rs = dbEngine.executeQuery("select password from users where username = '" + user + "';");
			while (rs.next()) {

				correctPass = rs.getString("password");

			//System.out.println(pass);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
				
		return correctPass;
	}
	
	public static String getStatus(String user){
		String status = "test1";
		try {
			ResultSet rs = dbEngine.executeQuery("select status from users where username = '" + user + "'");

			while (rs.next()) {

				status = rs.getString("status");
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return status;
	}
	
}
