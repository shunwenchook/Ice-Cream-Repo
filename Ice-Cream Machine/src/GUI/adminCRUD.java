package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import Database.DatabaseClasses;

/**
 * 
 * @author Shun Wen Chook
 *
 */
@SuppressWarnings("serial")
public class adminCRUD extends JPanel implements ActionListener {

	JTable itemTable = null;

	JButton createButton, deleteButton, logoutButton;

	Container c;

	/**
	 * Constructor for AdminCRUD
	 * @param c
	 */
	public adminCRUD(Container c) {
		this.c = c;

		JLabel headLabel = new JLabel("Welcome to the Product Database!");

		logoutButton = new JButton("Logout");
		createButton = new JButton("Create new Product");
		deleteButton = new JButton("Delete Product");

		logoutButton.addActionListener(this);
		createButton.addActionListener(this);
		deleteButton.addActionListener(this);

		JPanel topPanel = new JPanel();
		topPanel.add(headLabel);
		topPanel.add(logoutButton);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1, 2));
		bottomPanel.add(createButton);
		bottomPanel.add(deleteButton);

		add(topPanel);
		add(DatabaseClasses.getItemTable(itemTable)); // Calls getItemTable from DatabaseClasses
		add(bottomPanel, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == logoutButton) {

			JOptionPane.showMessageDialog(this, "You have successfully logged out.");

			revalidate();
			c.removeAll();
			c.add(new Login(c)); // passes Container to the Login GUI
		}

		if (e.getSource() == createButton) {

			revalidate();
			c.removeAll();
			c.add(new adminCreate(c)); // passes container to the adminCreate GUi when clicked
		}

		if (e.getSource() == deleteButton) {

			String s = (String) JOptionPane.showInputDialog(this, "Please enter the productID to delete",
					"Delete Product", JOptionPane.PLAIN_MESSAGE); // prompts user for productID input
			System.out.println(s);
			if (s != null && (s.length() > 0)) { // checks if input is not null and if it is not blank
				DatabaseClasses.deleteProduct(s); // Passes productID to deleteProduct method 

				JOptionPane.showMessageDialog(this, "Product with product ID of '" + s + "' has been deleted");

				revalidate();
				c.removeAll();
				c.add(new adminCRUD(c)); // refreshes the page

			} else {
				JOptionPane.showMessageDialog(this, "Sorry the value you have entered is not valid. Please try again.");
			}

		}

	}

}
