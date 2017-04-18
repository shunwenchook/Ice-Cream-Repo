package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Database.DatabaseClasses;

public class adminCreate extends JPanel implements ActionListener {

	Container c;

	String[] category = { "flavour", "toppings", "cone" };

	JTextField idField, nameField, priceField, imageField;
	JComboBox<String> categoryBox;
	JButton createButton, backButton;

	public adminCreate(Container c) {
		this.c = c;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel headLabel = new JLabel("Create new product");

		JLabel idLabel = new JLabel("Product ID : ");
		JLabel nameLabel = new JLabel("Name : ");
		JLabel priceLabel = new JLabel("Price : ");
		JLabel categoryLabel = new JLabel("Category : ");
		JLabel imageLabel = new JLabel("Image Source : ");

		idField = new JTextField(20);
		nameField = new JTextField(20);
		priceField = new JTextField(20);
		categoryBox = new JComboBox<String>(category);
		imageField = new JTextField(20);

		backButton = new JButton("Back");
		createButton = new JButton("Create");

		backButton.addActionListener(this);
		createButton.addActionListener(this);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(5, 5));
		mainPanel.add(idLabel);
		mainPanel.add(idField);
		mainPanel.add(nameLabel);
		mainPanel.add(nameField);
		mainPanel.add(priceLabel);
		mainPanel.add(priceField);
		mainPanel.add(categoryLabel);
		mainPanel.add(categoryBox);
		mainPanel.add(imageLabel);
		mainPanel.add(imageField);

		JPanel bottomPanel = new JPanel();
		bottomPanel.add(backButton);
		bottomPanel.add(createButton);

		add(headLabel);
		add(mainPanel);
		add(bottomPanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == backButton) {
			revalidate();
			c.removeAll();
			c.add(new adminCRUD(c));
		}

		if (e.getSource() == createButton) {

			String s = (String) categoryBox.getSelectedItem();

			DatabaseClasses.insertProduct(idField.getText(), nameField.getText(), priceField.getText(), s,
					imageField.getText());

			JOptionPane.showMessageDialog(this, "Product #" + idField.getText() + " was created");

			revalidate();
			c.removeAll();
			c.add(new adminCRUD(c));
		}
	}

}
