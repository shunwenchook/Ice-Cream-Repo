package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Database.DatabaseClasses;

//Test


/**
 * @author Shun Wen Chook
 * This program contains the general GUI for the user ice cream selection.
 * the products are stored in the database.
 */
public class CustomerIceCreamGUI extends JFrame implements ActionListener, MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Creates lists for the selection
	JList <String> coneList, toppingList, flavourList;
	JLabel coneLabel, toppingLabel, flavourLabel, coneImageLabel, toppingImageLabel, flavourImageLabel, totalLabel;
	JButton confirmButton;
	
	ImageIcon coneImage, toppingImage, flavourImage;
	
	// Adds calculates total of each of the selection
	double total = 0;
	double coneTotal = 0;
	double toppingTotal = 0;
	double flavourTotal = 0;
	
	/**
	 * Constructor for Selection GUI
	 */
	public CustomerIceCreamGUI() {
		super("Customer - Pick your Ice-Cream"); // Adds to the title of the GUI
		
		// Creates the labels
		coneLabel = new JLabel("Cone");
		toppingLabel = new JLabel("Topping");
		flavourLabel = new JLabel("Flavour");
		coneImageLabel = new JLabel();
		toppingImageLabel = new JLabel();
		flavourImageLabel = new JLabel();
		
		// Initiates the JLists and takes value from the database
		coneList = new JList <String>(DatabaseClasses.loadConeList());
		toppingList = new JList <String>(DatabaseClasses.loadToppingList());
		flavourList = new JList <String>(DatabaseClasses.loadFlavourList());
		
		// Adds mouse listeners for the JLists
		coneList.addMouseListener(this);
		toppingList.addMouseListener(this);
		flavourList.addMouseListener(this);
		
		JScrollPane coneScroll = new JScrollPane(coneList);
		JScrollPane toppingScroll = new JScrollPane(toppingList);
		JScrollPane flavourScroll = new JScrollPane(flavourList);
		
		coneList.setPreferredSize(new Dimension(150, 200));
		toppingList.setPreferredSize(new Dimension(150, 200));
		flavourList.setPreferredSize(new Dimension(150, 200));
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		
		panel1.add(coneLabel);
		panel1.add(coneImageLabel);
		
		panel2.add(toppingLabel);
		panel2.add(toppingImageLabel);
		
		panel3.add(flavourLabel);
		panel3.add(flavourImageLabel);
		
		panel4.add(coneScroll);
		panel5.add(toppingScroll);
		panel6.add(flavourScroll);
		
		//creates a 2 by 3 GridLayout for the selection panel
		JPanel selectionPanel = new JPanel();
		selectionPanel.setLayout(new GridLayout(2, 3));
		
		selectionPanel.add(panel1);
		selectionPanel.add(panel2);
		selectionPanel.add(panel3);
		selectionPanel.add(panel4);
		selectionPanel.add(panel5);
		selectionPanel.add(panel6);
		
		confirmButton = new JButton("Confirm Selection");
		totalLabel = new JLabel("Total : ");
		
		confirmButton.addActionListener(this);
		
		JPanel confirmPanel = new JPanel();
		JPanel totalPanel = new JPanel();
		
		confirmPanel.add(confirmButton);
		totalPanel.add(totalLabel);
		
		// Creates a grid layout for the bottom part of the GUI
		JPanel optionPanel = new JPanel();
		optionPanel.setLayout(new GridLayout(1, 2));
		optionPanel.add(totalPanel);
		optionPanel.add(confirmPanel);

		Container c = getContentPane();
		c.add(selectionPanel);
		c.add(optionPanel, BorderLayout.SOUTH);
		
		setSize(600,600);
		setVisible(true);
	}
	
	/**
	 * Main method
	 * @param args argument
	 */
	public static void main(String[] args) {
		DatabaseClasses.init(); // starts up a Database connection
		CustomerIceCreamGUI gui = new CustomerIceCreamGUI();
	}
	
	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource()== coneList) { // checks if the coneList is clicked
	        String selectedItem = (String) coneList.getSelectedValue(); // stores the selected value into a string
	        coneLabel.setText(selectedItem);
	        coneImage = new ImageIcon(DatabaseClasses.getImage(selectedItem)); // searches the database with the selectedItem name
	        coneImageLabel.setIcon(coneImage); // sets the image to the label
	        
	        coneTotal = DatabaseClasses.getPrice(selectedItem); // passes the price to coneTotal
	        
		}

		if (e.getSource()== toppingList) {
	        String selectedItem = (String) toppingList.getSelectedValue();
	        toppingLabel.setText(selectedItem);
	        toppingImage = new ImageIcon(DatabaseClasses.getImage(selectedItem));
	        toppingImageLabel.setIcon(toppingImage);
	        
	        toppingTotal = DatabaseClasses.getPrice(selectedItem);
		}
		
        if (e.getSource()== flavourList) {
	        String selectedItem = (String) flavourList.getSelectedValue();
	        flavourLabel.setText(selectedItem);
	        flavourImage = new ImageIcon(DatabaseClasses.getImage(selectedItem));
	        flavourImageLabel.setIcon(flavourImage);
	        
	        flavourTotal = DatabaseClasses.getPrice(selectedItem);
		}

		total = coneTotal + toppingTotal + flavourTotal; // adds up the total

		totalLabel.setText("Total : " + String.format( "%.2f", total ) + " \u20ac"); // displays the Total
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirmButton) {
			System.out.println("Total passed to next GUI : " + total); // passes the total to the next GUI
		}
	}
}
