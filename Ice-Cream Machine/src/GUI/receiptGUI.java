package GUI;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Container;

@SuppressWarnings("serial")
public class receiptGUI extends JPanel implements ActionListener {

	Container c;
	double total, change;
	String cone, topping, flavour;
	JButton logoutButton;

	/**
	 * Create the application.
	 */
	public receiptGUI(Container c, double change, double total, String cone, String topping, String flavour) {

		this.c = c;
		this.total = total;
		this.change = change;
		this.cone = cone;
		this.topping = topping;
		this.flavour = flavour;

		setLayout(new GridLayout(2, 1));

		JPanel topPanel = new JPanel();
		add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new BorderLayout(0, 0));

		JPanel bannerPanel = new JPanel();
		bannerPanel.setBackground(new Color(0, 51, 255));
		logoutButton = new JButton("Logout");
		logoutButton.addActionListener(this);
		bannerPanel.add(logoutButton);

		topPanel.add(bannerPanel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Thanks for your support");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		bannerPanel.add(lblNewLabel);

		JPanel panel = new JPanel();
		topPanel.add(panel, BorderLayout.CENTER);

		JLabel lblNewLabel_1 = new JLabel("Ice-Cream :");
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 24));
		panel.add(lblNewLabel_1);

		JTextArea textArea = new JTextArea();
		textArea.setText(flavour);
		textArea.setEditable(false);
		textArea.setColumns(5);
		panel.add(textArea);

		JPanel panel_2 = new JPanel();
		topPanel.add(panel_2, BorderLayout.SOUTH);

		JLabel lblNewLabel_3 = new JLabel("Toppings :");
		lblNewLabel_3.setFont(new Font("Serif", Font.PLAIN, 24));
		panel_2.add(lblNewLabel_3);

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setText(topping);
		textArea_2.setEditable(false);
		textArea_2.setColumns(5);
		panel_2.add(textArea_2);

		JPanel midPanel = new JPanel();
		add(midPanel);
		midPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		midPanel.add(panel_1, BorderLayout.NORTH);

		JLabel lblNewLabel_2 = new JLabel("Cone :");
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 24));
		panel_1.add(lblNewLabel_2);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText(cone);
		textArea_1.setEditable(false);
		textArea_1.setColumns(5);
		panel_1.add(textArea_1);

		JPanel panel_3 = new JPanel();
		midPanel.add(panel_3, BorderLayout.CENTER);

		JLabel lblNewLabel_4 = new JLabel("Total :");
		lblNewLabel_4.setFont(new Font("Serif", Font.PLAIN, 24));
		panel_3.add(lblNewLabel_4);

		JTextArea textArea_3 = new JTextArea();
		textArea_3.setText("\u20ac" + Double.toString(total));
		textArea_3.setColumns(5);
		textArea_3.setEditable(false);
		panel_3.add(textArea_3);

		JLabel lblNewLabel_5 = new JLabel("Change :");
		lblNewLabel_5.setFont(new Font("Serif", Font.PLAIN, 24));
		panel_3.add(lblNewLabel_5);

		JTextArea textArea_4 = new JTextArea();
		textArea_4.setText("\u20ac" + Double.toString(Math.abs(change)));
		textArea_4.setColumns(5);
		textArea_4.setEditable(false);
		panel_3.add(textArea_4);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 51, 255));
		midPanel.add(panel_4, BorderLayout.SOUTH);

		JLabel lblmay = new JLabel("16-May-2017");
		lblmay.setFont(new Font("Serif", Font.PLAIN, 24));
		lblmay.setForeground(new Color(255, 255, 255));
		panel_4.add(lblmay);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "You have successfully logged out.");

		revalidate();
		c.removeAll();
		c.add(new Login(c));
	}

}
