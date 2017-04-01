package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import Database.DatabaseClasses;
import Database.DatabaseConnect;

public class Login extends JPanel implements ActionListener {
	// creates gui elements
	JButton cust;
	JButton admin;
	JFrame frame = new JFrame();
	JTextField custuser;
	JTextField custpass;
	JTextField adminuser;
	JTextField adminpass;
	JLabel adminLabel;
	JLabel custLabel;

	Container c;
	/*
	 * connects to database
	 */
	DatabaseConnect dbEngine = new DatabaseConnect("root", "root");

	/*
	 * launches gui
	 */
	public Login(Container c) {

		this.c = c;

		JPanel panel = new JPanel();
		cust = new JButton("Customer login");
		admin = new JButton("Admin login");
		adminLabel = new JLabel("Admin");
		custLabel = new JLabel("Customer");
		/*
		 * Creates input fields
		 */
		custpass = new JTextField("please enter your password");
		custuser = new JTextField("Please enter your username");
		adminpass = new JTextField("please enter your password");
		adminuser = new JTextField("Please enter your username");
		/*
		 * allows user input to be dealth with
		 */
		cust.addActionListener(this);
		custuser.addActionListener(this);
		custpass.addActionListener(this);

		panel.setLayout(new GridLayout(8, 1));
		panel.add(custLabel, BorderLayout.NORTH);
		panel.add(custuser, BorderLayout.NORTH);
		panel.add(custpass, BorderLayout.NORTH);
		panel.add(cust, BorderLayout.NORTH);
		panel.add(adminLabel, BorderLayout.SOUTH);
		panel.add(adminuser, BorderLayout.SOUTH);
		panel.add(adminpass, BorderLayout.SOUTH);
		panel.add(admin, BorderLayout.SOUTH);
		add(panel);

		setVisible(true);
		setSize(400, 400);
	}

	/*
	 * This deals with user input
	 */
	public void actionPerformed(ActionEvent e) {

		String uservalue = custuser.getText();
		String passvalue = custpass.getText();
		// searches database for username and password
		String correctUser = DatabaseClasses.getUser(uservalue);
		String correctPass = DatabaseClasses.getPass(passvalue);
		/*
		 * checks if username and password are valid
		 */

		if (e.getSource() == cust) {

			if (uservalue.equals(correctUser)) {
				if (passvalue.equals(correctPass)) {
					revalidate();

					c.removeAll();
					c.add(new CustomerIceCreamGUI(c));

					System.out.println("Success");
				} else {
					System.out.println("Incorrect password");
				}
			} else {
				System.out.println("Incorrect username");
			}
		}

	}

}