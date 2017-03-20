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

public class CustomerIceCreamGUI extends JFrame implements ActionListener, MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JList <String> coneList, toppingList, flavourList;
	JLabel coneLabel, toppingLabel, flavourLabel, coneImageLabel, toppingImageLabel, flavourImageLabel, totalLabel;
	JButton confirmButton;
	
	ImageIcon coneImage, toppingImage, flavourImage;
		
	double total = 0;
	
	double coneTotal = 0;
	double toppingTotal = 0;
	double flavourTotal = 0;
	
	/**
	 * 
	 */
	public CustomerIceCreamGUI() {
		super("Customer - Pick your Ice-Cream");



		coneLabel = new JLabel("Cone");
		toppingLabel = new JLabel("Topping");
		flavourLabel = new JLabel("Flavour");
		coneImageLabel = new JLabel();
		toppingImageLabel = new JLabel();
		flavourImageLabel = new JLabel();

		//coneImage = new ImageIcon("resources/classic_cone.png");  //this generates an image file
		//coneImageLabel.setIcon(coneImage);

		//toppingImage = new ImageIcon("resources/vanila.jpg");  //this generates an image file
		//toppingImageLabel.setIcon(toppingImage);
		
		//flavourImage = new ImageIcon("resources/chocolate_chip.jpg");  //this generates an image file
		//flavourImageLabel.setIcon(flavourImage);

		//String[] coneArray = {"Classic", "Cup", "Chocolate", "Large"};
		//String[] toppingArray = {"Chocolate Chip", "Marshmellow", "Sugar Sprinkles"};
		//String[] flavourArray = {"Chocolate", "Vanila", "Cookies and Cream", "Mint Chocolate", "Strawberry"};
		
		coneList = new JList <String>(DatabaseClasses.loadConeList());
		toppingList = new JList <String>(DatabaseClasses.loadToppingList());
		flavourList = new JList <String>(DatabaseClasses.loadFlavourList());
		
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

		JPanel selectionPanel = new JPanel();
		selectionPanel.setLayout(new GridLayout(2, 3));
		
		selectionPanel.add(panel1);
		selectionPanel.add(panel2);
		selectionPanel.add(panel3);
		selectionPanel.add(panel4);
		selectionPanel.add(panel5);
		selectionPanel.add(panel6);

		/*
		selectionPanel.add(coneLabel);
		selectionPanel.add(toppingLabel);
		selectionPanel.add(flavourLabel);
		selectionPanel.add(coneList);
		selectionPanel.add(toppingList);
		selectionPanel.add(flavourList);
		*/
		
		confirmButton = new JButton("Confirm Selection");
		totalLabel = new JLabel("Total : ");
		
		confirmButton.addActionListener(this);
		
		JPanel confirmPanel = new JPanel();
		JPanel totalPanel = new JPanel();
		
		confirmPanel.add(confirmButton);
		totalPanel.add(totalLabel);
		
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
	
	public static void main(String[] args) {
		DatabaseClasses.init();
		CustomerIceCreamGUI gui = new CustomerIceCreamGUI();
	}
	
	/**
	public void init() {
		dbEngine.connect();
	}
	**/
	
	

	@Override
	public void mouseClicked(MouseEvent e) {

		
		if (e.getSource()== coneList) {
	        String selectedItem = (String) coneList.getSelectedValue();
	        coneLabel.setText(selectedItem);
	        coneImage = new ImageIcon(DatabaseClasses.getImage(selectedItem));
	        coneImageLabel.setIcon(coneImage);
	        
	        coneTotal = DatabaseClasses.getPrice(selectedItem);
	        
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

		total = coneTotal + toppingTotal + flavourTotal;

		totalLabel.setText("Total : " + String.format( "%.2f", total ) + " \u20ac");
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
		// TODO Auto-generated method stub
		if (e.getSource() == confirmButton) {
			System.out.println("Total passed to next GUI : " + total);
		}
	}
}
