package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;

/**
 * 
 * @author Conor Walsh
 *
 */

@SuppressWarnings("serial")
public class paymentGUI extends JPanel implements ActionListener {

	double startingTotal;
	double total;

	String cone, topping, flavour;

	JPanel topPanel;
	JPanel bottomPanel;

	JPanel coinDisplay;
	JPanel displayPanel;
	JPanel bannerPanel;
	JLabel displayText;
	JTextField displayTotal;
	JButton[] coinButtons = new JButton[8];

	Container c;

	/**
	 * Constructor for paymentGUI panel takes in values from Selection GUI
	 * @param c Container to build panel
	 * @param total Total amount needed for customer to pay
	 * @param cone Cone selected by user
	 * @param topping Topping selected by user
	 * @param flavour Flavour selected by user
	 */
	public paymentGUI(Container c, double total, String cone, String topping, String flavour) {
		this.c = c;
		this.total = total;
		this.cone = cone;
		this.topping = topping;
		this.flavour = flavour;

		startingTotal = total;

		JButton[] coinButtons = new JButton[8];

		coinButtons[0] = new JButton("5 Cent");
		coinButtons[0].addActionListener(this);

		coinButtons[1] = new JButton("10 Cent");
		coinButtons[1].addActionListener(this);

		coinButtons[2] = new JButton("20 Cent");
		coinButtons[2].addActionListener(this);

		coinButtons[3] = new JButton("50 Cent");
		coinButtons[3].addActionListener(this);

		coinButtons[4] = new JButton("1 Euro");
		coinButtons[4].addActionListener(this);

		coinButtons[5] = new JButton("2 Euro");
		coinButtons[5].addActionListener(this);

		coinButtons[6] = new JButton("5 Euro");
		coinButtons[6].addActionListener(this);

		coinButtons[7] = new JButton("10 Euro");
		coinButtons[7].addActionListener(this);

		topPanel = new JPanel(new BorderLayout());
		JLabel selectPayment = new JLabel("Please select Entered payment");
		selectPayment.setHorizontalAlignment(javax.swing.JLabel.CENTER);

		topPanel.add(selectPayment, BorderLayout.PAGE_START);

		coinDisplay = new JPanel();
		coinDisplay.setLayout(new GridLayout(4, 4));
		for (int i = 0; i < coinButtons.length; i++) {
			coinButtons[i].setPreferredSize(new Dimension(100, 50));
			coinDisplay.add(coinButtons[i]);
			topPanel.add(coinDisplay, BorderLayout.CENTER);

			add(topPanel);
		}

		displayText = new JLabel("Your Total is $ ");

		// TextField that displays total amount needed for payment
		displayTotal = new JTextField(8);
		displayTotal.setEditable(false);
		String.valueOf(total);
		displayTotal.setText(String.valueOf(total));

		displayPanel = new JPanel();
		displayPanel.setPreferredSize(new Dimension(200, 50));
		displayPanel.setBorder(new LineBorder(Color.GRAY));
		displayPanel.add(displayText);
		displayPanel.add(displayTotal);

		topPanel.add(displayPanel, BorderLayout.PAGE_END);

		setSize(600, 600);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("5 Cent")) {

			double addFive = total - 0.05;
			total = addFive;

			String.valueOf(total);
			displayTotal.setText(String.valueOf(total));

		} else if (e.getActionCommand().equals("10 Cent")) {

			double addTen = total - 0.10;
			total = addTen;

			String.valueOf(total);
			displayTotal.setText(String.valueOf(total));

		} else if (e.getActionCommand().equals("20 Cent")) {

			double addTwenty = total - 0.20;
			total = addTwenty;

			String.valueOf(total);
			displayTotal.setText(String.valueOf(total));

		} else if (e.getActionCommand().equals("50 Cent")) {

			double addFifty = total - 0.50;
			total = addFifty;

			String.valueOf(total);
			displayTotal.setText(String.valueOf(total));

		} else if (e.getActionCommand().equals("1 Euro")) {

			double addOneEuro = total - 1.00;
			total = addOneEuro;

			String.valueOf(total);
			displayTotal.setText(String.valueOf(total));

		} else if (e.getActionCommand().equals("2 Euro")) {

			double addTwoEuro = total - 2.00;
			total = addTwoEuro;

			String.valueOf(total);
			displayTotal.setText(String.valueOf(total));

		} else if (e.getActionCommand().equals("5 Euro")) {

			double addFiveEuro = total - 5.00;
			total = addFiveEuro;

			String.valueOf(total);
			displayTotal.setText(String.valueOf(total));

		} else if (e.getActionCommand().equals("10 Euro")) {

			double addTenEuro = total - 10.00;
			total = addTenEuro;

			String.valueOf(total);
			displayTotal.setText(String.valueOf(total));

		}

		if (total <= 0) {

			JOptionPane.showMessageDialog(this, "Payment complete. Your change is: \u20ac" + Math.abs(total));

			revalidate();
			c.removeAll();
			c.add(new receiptGUI(c, total, startingTotal, cone, topping, flavour));
		}

	}

}
