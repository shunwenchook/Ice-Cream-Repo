package Database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	 * 
	 * @param itemTable
	 * @return
	 */
	public static JScrollPane getItemTable (JTable itemTable) {
		//select everything from emp table
		ResultSet rs;
		ResultSetMetaData rsmd = null;
		int colCount=0;
		String [] colNames = null;
		
		//get the column names from the ResultSet metadata
		try {
			rs = dbEngine.executeQuery("select * from product");
			rsmd = rs.getMetaData();
			colCount = rsmd.getColumnCount();
	        colNames = new String[colCount];
	        for(int i=1;i<=colCount;i++) {
	        	colNames[i-1] = rsmd.getColumnName(i);
	        }
	        
	        
	        
	        //JTables have a view class and a Model class, the view class
			//handles the drawing of the JTable, the Model class handles the properties
			//and the data
			
			//Create a table model (used for controlling a JTable)
			DefaultTableModel model = new DefaultTableModel(colNames,0);
			itemTable = new JTable(model);
			
			
			String [] currentRow = new String[colCount];//array to hold the row data
			while(rs.next()) { //move the rs pointer on to the next record (starts before the 1st)
				for(int i=1;i<=colCount;i++) {
					currentRow[i-1] = rs.getString(i);

				}
				model.addRow(currentRow); //add the row to the table through the table model
				
			}
		}
		catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		}
		
		JScrollPane scrollPane = new JScrollPane(itemTable);//add the table to a scroll pane
		return scrollPane;
	}
	
	public static void insertProduct(String id, String name, String price, String category, String imageField) {
		
		try {
			dbEngine.executeQuery("insert into product values (" + id + ", '" + name + "', '" + price + "', '" + category + "', '" + imageField + "')");
		}
		catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		}
		
	}
	
	public static void deleteProduct (String productID) {
		
		try {
			dbEngine.executeQuery("delete from product where productID = '" + productID + "';"); // runs query from database to check for the image directory

		}
		catch (Exception e){
			e.printStackTrace();
		} 
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
