package Database;

import java.sql.ResultSet;
import java.util.Vector;

public class DatabaseClasses {
	
	static DatabaseConnect dbEngine = new DatabaseConnect("root", ""); //database engine
	
	public static void init() {
		dbEngine.connect();
	}

	public static double getPrice(String itemName) {
		
		double price = 0;
		
		try {
			ResultSet rs = dbEngine.executeQuery("select price from product where name = '" + itemName + "'");
			while (rs.next()) {

			price = rs.getDouble("price");

			System.out.println(price);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return price;
	}
	
	public static String getImage(String itemName) {
		
		String imageDirectory = null;
		
		try {
			ResultSet rs = dbEngine.executeQuery("select picture from product where name = '" + itemName + "'");
			while (rs.next()) {

			imageDirectory = rs.getString("picture");

			System.out.println(imageDirectory);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		return imageDirectory;
	}
	
	public static Vector<String> loadConeList() {
		
		Vector<String> elements = new Vector<String>();

		
		try{
			
			ResultSet rs = dbEngine.executeQuery("select name, price from product where category = 'cone'");
			
			while (rs.next()) {
			    // or whatever is appropriate
			    elements.add(rs.getString("name"));
			} 
		}
		
		catch(Exception e){
			
			e.printStackTrace();
		}
		return elements;
	}
	
	public static Vector<String> loadToppingList() {

		
		Vector<String> elements = new Vector<String>();

		
		try{

			
			ResultSet rs =  dbEngine.executeQuery("select name, price from product where category = 'toppings'");
			
			while (rs.next()) {
			    // or whatever is appropriate
			    elements.add(rs.getString("name"));
			} 

		}
		
		catch(Exception e){
			
			e.printStackTrace();
		}
		return elements;

	
	}
	
	public static Vector<String> loadFlavourList() {
		
		Vector<String> elements = new Vector<String>();

		
		try{

			ResultSet rs = dbEngine.executeQuery("select name, price from product where category = 'flavour'");
			
			while (rs.next()) {
			    // or whatever is appropriate
			    elements.add(rs.getString("name")); // + "  " + rs.getString("price") + "\u20ac"
			} 
		}
		
		catch(Exception e){
			
			e.printStackTrace();
		}
		return elements;

	
	}

	
}
