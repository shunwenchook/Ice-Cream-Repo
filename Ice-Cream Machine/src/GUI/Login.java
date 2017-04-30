package GUI;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Arrays;

import javax.swing.*;

import Database.DatabaseClasses;
import Database.DatabaseConnect;


/**
 * 
 * @author Darren Darcy
 *
 */
public class Login extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	// creates gui elements
	JButton cust;
	JFrame frame = new JFrame();
	JTextField custuser;
	JPasswordField custpass;
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

		JLabel titleLabel = new JLabel("Welcome to the Ice Cream Vending Machine!", SwingConstants.CENTER);

		titleLabel.setFont(new Font("Serif", Font.PLAIN, 30));

		cust = new JButton("Login");
		cust.setAlignmentX(Component.CENTER_ALIGNMENT);

		custLabel = new JLabel("Please Login", SwingConstants.CENTER);

		JLabel userLabel = new JLabel("Username: ");
		JLabel passLabel = new JLabel("Password: ");
		/*
		 * Creates input fields
		 */
		custuser = new JTextField("Please enter your username");
		custpass = new JPasswordField("Please enter your password");

		// adds listeners when the text area is clicked to remove texts
		custuser.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				JTextField source = (JTextField) e.getComponent();
				source.setText("");
				source.removeFocusListener(this);
			}
		});

		custpass.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				JTextField source = (JTextField) e.getComponent();
				source.setText("");
				source.removeFocusListener(this);
			}
		});

		/*
		 * allows user input to be dealt with
		 */
		cust.addActionListener(this);

		JPanel panel1 = new JPanel();

		panel1.add(userLabel);
		panel1.add(custuser);

		JPanel panel2 = new JPanel();
		panel2.add(passLabel);
		panel2.add(custpass);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		topPanel.add(titleLabel);
		topPanel.add(custLabel);

		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
		middlePanel.add(panel1);
		middlePanel.add(panel2);
		middlePanel.add(cust);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(topPanel);
		add(middlePanel);

	}

	/*
	 * This deals with user input
	 */
	public void actionPerformed(ActionEvent e) {

		String uservalue = custuser.getText();

		// searches database for username and password
		String correctUser = DatabaseClasses.getUser(uservalue);
		String correctPass = DatabaseClasses.getPass(uservalue);

		// checks if username and password are valid

		if (e.getSource() == cust) {

			// checks username
			if (uservalue.equals(correctUser)) {
				// checks password
				if (Arrays.equals(correctPass.toCharArray(), custpass.getPassword())) {
					// checks the category of user
					if (DatabaseClasses.getStatus(uservalue).equals("admin")) {
						System.out.println("Is Admin");

						revalidate();
						c.removeAll();
						c.add(new adminCRUD(c)); // passes container to Admin CRUD GUI
					} else if (DatabaseClasses.getStatus(uservalue).equals("customer")) {
						System.out.println("Is Customer");

						revalidate();
						c.removeAll();
						c.add(new CustomerIceCreamGUI(c)); // passes container to the customer selection GUI

						System.out.println("Success");

					}

				} else {

					JOptionPane.showMessageDialog(this, "Incorrect username or password. Please try again.");

					System.out.println("Incorrect password");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Incorrect username or password. Please try again.");

				System.out.println("Incorrect username");
			}
		}

	}

}
